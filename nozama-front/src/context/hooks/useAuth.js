import { useState } from "react";
import api from "../../services/api";

export function useAuth() {

  const [user, setUser] = useState([]);

  const createUser = (userObj) => {
    api.post('/usuarios', userObj)
      .then(res => {
        setUser(res.data);
      })
      .catch((error) => {
        console.log(error)
      })
  }

  return {
    createUser,
    user
  }
}