import { useState } from "react";
import api from "../../services/api";

export function useAuth() {

  const [logged, setLogged] = useState(false);
  const [user, setUser] = useState([]);

  const createUser = (userObj) => {
    api.post('/usuarios', userObj)
      .then(res => {
        setUser(res.data);
        setLogged(true);
      })
      .catch((error) => {
        console.log(error)
        setLogged(false);
      })
  }

  const login = (userObj) => {
    api.post('/usuarios/login', userObj)
      .then(res => {
        console.log(res);
        setUser(res.data);
        setLogged(true);
      })
      .catch((error) => {
        console.log(error)
        setLogged(false);
      })
  }

  return {
    createUser,
    login,
    logged,
    user
  }
}