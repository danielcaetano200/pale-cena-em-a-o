// =========================
// ELEMENTOS DO SITE
// =========================

const loginPage =
    document.getElementById("loginPage");

const registerPage =
    document.getElementById("registerPage");

const app =
    document.getElementById("app");

const loginForm =
    document.getElementById("loginForm");

const registerForm =
    document.getElementById("registerForm");

const showRegister =
    document.getElementById("showRegister");

const showLogin =
    document.getElementById("showLogin");

const loginMessage =
    document.getElementById("loginMessage");

const registerMessage =
    document.getElementById("registerMessage");

const userName =
    document.getElementById("userName");

const memberUserName =
    document.getElementById("memberUserName");

const userAvatar =
    document.getElementById("userAvatar");

const messageInput =
    document.getElementById("messageInput");

const sendButton =
    document.getElementById("sendButton");

const messages =
    document.getElementById("messages");

const channelName =
    document.getElementById("channelName");

const createChannel =
    document.getElementById("createChannel");



// =========================
// MENSAGENS DOS CANAIS
// =========================

const channelMessages = {

    "Geral": [

        {
            name: "João Silva",
            avatar: "JS",
            time: "Hoje às 19:32",
            text: "Pessoal, alguém conhece um editor para um projeto de curta-metragem?"
        },

        {
            name: "Maria Alves",
            avatar: "MA",
            time: "Hoje às 19:35",
            text: "Eu trabalho com edição! Qual seria o prazo do projeto?"
        }

    ],


    "Vagas de emprego": [

        {
            name: "Pedro Costa",
            avatar: "PC",
            time: "Hoje às 18:20",
            text: "Estou procurando alguém para trabalhar como assistente de produção."
        },

        {
            name: "Ana Souza",
            avatar: "AS",
            time: "Hoje às 18:45",
            text: "Tenho interesse! Pode mandar mais informações?"
        }

    ],


    "Produção": [

        {
            name: "João Silva",
            avatar: "JS",
            time: "Hoje às 17:20",
            text: "Alguém tem experiência com produção de curta-metragem?"
        }

    ],


    "Direção": [

        {
            name: "Maria Alves",
            avatar: "MA",
            time: "Hoje às 16:30",
            text: "Estou procurando pessoas interessadas em direção audiovisual."
        }

    ],


    "Edição": [

        {
            name: "Pedro Costa",
            avatar: "PC",
            time: "Hoje às 15:40",
            text: "Qual programa vocês costumam usar para edição?"
        }

    ],


    "Áudio": [

        {
            name: "Ana Souza",
            avatar: "AS",
            time: "Hoje às 14:25",
            text: "Alguém trabalha com captação de áudio para cinema?"
        }

    ],


    "Fotografia": [

        {
            name: "João Silva",
            avatar: "JS",
            time: "Hoje às 13:15",
            text: "Estou procurando fotógrafo para um projeto independente."
        }

    ],


    "Projetos e ideias": [

        {
            name: "Maria Alves",
            avatar: "MA",
            time: "Hoje às 12:30",
            text: "Tenho uma ideia para um curta e queria encontrar pessoas para formar uma equipe."
        }

    ]

};



// =========================
// MOSTRAR CADASTRO
// =========================

showRegister.addEventListener(
    "click",
    function() {

        loginPage.classList.add("hidden");

        registerPage.classList.remove("hidden");

        loginMessage.textContent = "";

    }
);



// =========================
// MOSTRAR LOGIN
// =========================

showLogin.addEventListener(
    "click",
    function() {

        registerPage.classList.add("hidden");

        loginPage.classList.remove("hidden");

        registerMessage.textContent = "";

    }
);



// =========================
// LOGIN
// =========================

loginForm.addEventListener(
    "submit",
    function(event) {

        event.preventDefault();


        const email =
            document.getElementById("loginEmail").value;

        const password =
            document.getElementById("loginPassword").value;


        if (
            email === "" ||
            password === ""
        ) {

            loginMessage.textContent =
                "Preencha todos os campos.";

            return;
        }


        /*
            Por enquanto o login é uma demonstração.

            Depois podemos colocar banco de dados
            para verificar e-mail e senha.
        */


        entrarNaComunidade("Usuário");

    }
);



// =========================
// CADASTRO
// =========================

registerForm.addEventListener(
    "submit",
    function(event) {

        event.preventDefault();


        const name =
            document.getElementById("registerName").value;

        const email =
            document.getElementById("registerEmail").value;

        const password =
            document.getElementById("registerPassword").value;


        if (
            name === "" ||
            email === "" ||
            password === ""
        ) {

            registerMessage.textContent =
                "Preencha todos os campos.";

            return;
        }


        entrarNaComunidade(name);

    }
);



// =========================
// ENTRAR NA COMUNIDADE
// =========================

function entrarNaComunidade(name) {

    loginPage.classList.add("hidden");

    registerPage.classList.add("hidden");

    app.classList.remove("hidden");


    userName.textContent = name;

    memberUserName.textContent = name;


    const initials =
        name
            .substring(0, 2)
            .toUpperCase();


    userAvatar.textContent =
        initials;


    carregarCanal("Geral");

}



// =========================
// CARREGAR CANAL
// =========================

function carregarCanal(name) {

    /*
        Muda somente a área do chat.
    */


    channelName.textContent =
        name.toLowerCase();


    messageInput.placeholder =
        "Enviar mensagem em #" +
        name.toLowerCase();


    messages.innerHTML = "";


    // Mensagem inicial do canal

    const welcome =
        document.createElement("div");


    welcome.classList.add("welcome");


    welcome.innerHTML = `

        <div class="welcome-icon">
            #
        </div>

        <h1>
            ${name}
        </h1>

        <p>
            Este é o canal de ${name.toLowerCase()}.
            Converse com outros profissionais do audiovisual.
        </p>

    `;


    messages.appendChild(welcome);


    /*
        Verifica se existem mensagens
        salvas para esse canal.
    */

    if (channelMessages[name]) {

        channelMessages[name].forEach(
            function(message) {

                criarMensagem(
                    message.name,
                    message.avatar,
                    message.time,
                    message.text
                );

            }
        );

    }

}



// =========================
// CRIAR MENSAGEM
// =========================

function criarMensagem(
    name,
    avatar,
    time,
    text
) {

    const message =
        document.createElement("div");


    message.classList.add("message");


    message.innerHTML = `

        <div class="avatar message-avatar">
            ${avatar}
        </div>

        <div>

            <div class="message-info">

                <strong>
                    ${escapeHTML(name)}
                </strong>

                <span>
                    ${time}
                </span>

            </div>

            <p>
                ${escapeHTML(text)}
            </p>

        </div>

    `;


    messages.appendChild(message);

}



// =========================
// ENVIAR MENSAGEM
// =========================

function sendMessage() {

    const text =
        messageInput.value.trim();


    if (text === "") {

        return;

    }


    const currentChannel =
        channelName.textContent;


    /*
        Como o nome mostrado está em
        letras minúsculas, procuramos
        o canal correspondente.
    */

    let channel = null;


    for (
        const name in channelMessages
    ) {

        if (
            name.toLowerCase() ===
            currentChannel
        ) {

            channel = name;

            break;

        }

    }


    /*
        Se o canal ainda não tiver
        mensagens, criamos uma lista.
    */

    if (!channelMessages[channel]) {

        channelMessages[channel] = [];

    }


    const newMessage = {

        name: userName.textContent,

        avatar:
            userAvatar.textContent,

        time: "Agora",

        text: text

    };


    channelMessages[channel].push(
        newMessage
    );


    criarMensagem(
        newMessage.name,
        newMessage.avatar,
        newMessage.time,
        newMessage.text
    );


    messageInput.value = "";


    /*
        Faz o chat descer para
        a mensagem mais recente.
    */

    messages.scrollTop =
        messages.scrollHeight;

}



// =========================
// BOTÃO ENVIAR
// =========================

sendButton.addEventListener(
    "click",
    sendMessage
);



// =========================
// ENTER ENVIA MENSAGEM
// =========================

messageInput.addEventListener(
    "keydown",
    function(event) {

        if (
            event.key === "Enter"
        ) {

            sendMessage();

        }

    }
);



// =========================
// TROCAR DE CANAL
// =========================

function configurarCanais() {

    const channels =
        document.querySelectorAll(
            ".channel"
        );


    channels.forEach(
        function(channel) {

            channel.addEventListener(
                "click",
                function() {


                    /*
                        Remove o destaque
                        de todos os canais.
                    */

                    document
                        .querySelectorAll(".channel")
                        .forEach(
                            function(item) {

                                item.classList.remove(
                                    "active"
                                );

                            }
                        );


                    /*
                        Coloca destaque
                        no canal escolhido.
                    */

                    this.classList.add(
                        "active"
                    );


                    const name =
                        this.dataset.channel;


                    /*
                        SOMENTE O CHAT MUDA.
                    */

                    carregarCanal(name);

                }
            );

        }
    );

}


configurarCanais();



// =========================
// CRIAR CANAL
// =========================

createChannel.addEventListener(
    "click",
    function() {

        const name =
            prompt(
                "Digite o nome do novo canal:"
            );


        if (!name) {

            return;

        }


        const cleanName =
            name
                .toLowerCase()
                .replace(/\s+/g, "-");


        const newChannel =
            document.createElement("button");


        newChannel.classList.add(
            "channel"
        );


        newChannel.dataset.channel =
            name;


        newChannel.innerHTML = `

            <span>#</span>

            <span>
                ${cleanName}
            </span>

        `;


        createChannel.parentNode.insertBefore(
            newChannel,
            createChannel
        );


        /*
            Cria uma lista de mensagens
            para o novo canal.
        */

        channelMessages[name] = [];


        /*
            Faz o novo canal funcionar.
        */

        newChannel.addEventListener(
            "click",
            function() {

                document
                    .querySelectorAll(".channel")
                    .forEach(
                        function(item) {

                            item.classList.remove(
                                "active"
                            );

                        }
                    );


                this.classList.add(
                    "active"
                );


                carregarCanal(name);

            }
        );

    }
);



// =========================
// EXPLORAR
// =========================

document
    .getElementById("exploreButton")
    .addEventListener(
        "click",
        function() {

            /*
                Por enquanto não faz nada.

                Essa função será adicionada
                quando o grupo decidir o que
                vai existir no Explorar.
            */

        }
    );



// =========================
// MINHAS VAGAS
// =========================

document
    .getElementById("jobsButton")
    .addEventListener(
        "click",
        function() {

            /*
                Por enquanto não faz nada.

                Essa função será adicionada
                posteriormente.
            */

        }
    );



// =========================
// INÍCIO
// =========================

document
    .getElementById("homeButton")
    .addEventListener(
        "click",
        function() {

            /*
                O início volta para
                o canal geral.
            */

            document
                .querySelectorAll(".menu-item")
                .forEach(
                    function(item) {

                        item.classList.remove(
                            "active"
                        );

                    }
                );


            this.classList.add(
                "active"
            );


            document
                .querySelectorAll(".channel")
                .forEach(
                    function(item) {

                        item.classList.remove(
                            "active"
                        );

                    }
                );


            const geral =
                document.querySelector(
                    '[data-channel="Geral"]'
                );


            if (geral) {

                geral.classList.add(
                    "active"
                );

            }


            carregarCanal("Geral");

        }
    );



// =========================
// PROTEÇÃO DO TEXTO
// =========================

function escapeHTML(text) {

    const div =
        document.createElement("div");


    div.textContent = text;


    return div.innerHTML;

}
