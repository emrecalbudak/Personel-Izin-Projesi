import React from "react";
import { useRef, useState, useEffect, useContext } from "react";
import "primereact/resources/themes/saga-green/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import "primereact/resources/themes/arya-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import AuthContext from "./context/AuthProvider";
import axios from "./api/axios";

const LOGIN_URL = "/auth";

const Login = () => {
  const { setAuth } = useContext(AuthContext);
  const userRef = useRef();
  const errRef = useRef();

  const [user, setUser] = useState("");
  const [password, setPassword] = useState("");
  const [errorMsg, setErrorMsg] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    userRef.current.focus();
  }, []);

  useEffect(() => {
    setErrorMsg("");
  }, [user, password]);

  const handleSubmit = async (e) => {//
    e.preventDefault();

    try {
      const response = await axios.post(LOGIN_URL,JSON.stringify({userName:user, password}),
      {
        headers: {'Content-Type': 'application/json'},
        withCredentials:true
      }

      );
      console.log(JSON.stringify(response?.data));
      const accessToken = response?.data?.accessToken;
      const roles = response?.data?.roles;
      setAuth({user, password, roles,accessToken});
      setUser("");
      setPassword("");
      setSuccess(true);
    } catch (err) {
      if(!err?.response){
        setErrorMsg('No Server Response');
      } else if (err.response?.status ===400){
        setErrorMsg('Missing Username or Password')
      }else if (err.response?.status ===401){
        setErrorMsg('Unauthorized');
      }else{
        setErrorMsg("Login Failed");
      }
      errRef.current.focus();
    }
  };

  return (
    <div className="App-header">
      {success ? (
        <section>
          <h1>You are logged in</h1>
          <br />
          <p>
            <a href> Go to home</a>
          </p>
        </section>
      ) : (
        <section>
          <p
            ref={errRef}
            className={errorMsg ? "errmsg" : "offscreen"}
            aria-live="assertive"
          >
            {errorMsg}
          </p>
          <h1>Sign In</h1>
          <form onSubmit={handleSubmit}>
            <label htmlFor="username"></label>
            <InputText
              type="text"
              id="username"
              ref={userRef}
              autoComplete="off"
              onChange={(e) => setUser(e.target.value)}
              value={user}
              placeholder={"enter your username"}
              required
            />

            <br />
            <br />
            <label htmlFor="password"></label>
            <InputText
              type="password"
              id="password"
              ref={userRef}
              autoComplete="off"
              onChange={(e) => setPassword(e.target.value)}
              value={password}
              placeholder={"enter your password"}
              required
            />
            <br />
            <br />

            <Button icon="pi pi-check" label="submit"></Button>
          </form>
        </section>
      )}
    </div>
  );
};
export default Login;
