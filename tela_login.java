import { useState } from "react";

function Login() {
  const [email, setEmail] = useState("");
  const [senha, setSenha] = useState("");

  async function handleLogin(e) {
    e.preventDefault();

    const response = await fetch("http://localhost:3000/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        email,
        senha,
      }),
    });

    const data = await response.json();

    if (response.ok) {
      console.log("Login realizado:", data);

      // Aqui você pode redirecionar para a página inicial
    } else {
      alert(data.message);
    }
  }

  return (
    <div>
      <h1>Login</h1>

      <form onSubmit={handleLogin}>
        <input
          type="email"
          placeholder="E-mail"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />

        <input
          type="password"
          placeholder="Senha"
          value={senha}
          onChange={(e) => setSenha(e.target.value)}
        />

        <button type="submit">
          Entrar
        </button>
      </form>
    </div>
  );
}

export default Login;
