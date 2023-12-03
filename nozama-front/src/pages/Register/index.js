import React, { useContext, useState } from 'react';

import { Container, Title, HiperLink } from './styles';
import Input from '../../components/Input';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalContext';
import api from '../../services/api';

function Register() {
  const navigate = useNavigate();

  const context = useContext(GlobalContext);

  const [email, setEmail] = useState('');
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const createUser = () => {
    const user = {
      "nome": username,
      "email": email,
      "senha": password
    }

    context.createUser(user);
    navigate('/');
  }

  return (
    <Container>
      <Title>Register</Title>
      <Input placeholder="Email" onChange={e => setEmail(e.target.value)} />
      <Input placeholder="Nome de usuário" onChange={e => setUsername(e.target.value)} />
      <Input placeholder="Senha" onChange={e => setPassword(e.target.value)} />
      <Button text="Cadastrar" onClick={createUser} />

      <HiperLink onClick={() => navigate('/login')}>Já possui uma conta? Entrar</HiperLink>
    </Container>
  );
}

export default Register;