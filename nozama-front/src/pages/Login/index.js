import React from 'react';

import { Container, Title, HiperLink } from './styles';
import Input from '../../components/Input';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';

function Login() {
  const navigate = useNavigate();

  return (
    <Container>
      <Title>Login</Title>
      <Input placeholder="Usuário" />
      <Input placeholder="Senha" />
      <Button text="Entrar" />

      <HiperLink onClick={() => navigate('/register')}>Ainda não possui uma conta? Registrar</HiperLink>
    </Container>
  );
}

export default Login;