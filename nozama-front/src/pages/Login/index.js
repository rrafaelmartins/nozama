import React, { useState } from 'react';

import { Container, Title, HiperLink } from './styles';
import Input from '../../components/Input';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';

function Login() {
  const navigate = useNavigate();

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const login = () => {

  }

  return (
    <Container>
      <Title>Login</Title>
      <Input placeholder="Email" onChange={e => setEmail(e.target.value)} />
      <Input placeholder="Senha" onChange={e => setPassword(e.target.value)} />
      <Button text="Entrar" onClick={() => navigate('/')} />

      <HiperLink onClick={() => navigate('/register')}>Ainda não possui uma conta? Registrar</HiperLink>
    </Container>
  );
}

export default Login;