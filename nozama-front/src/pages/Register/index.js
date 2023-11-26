import React from 'react';

import { Container, Title, HiperLink } from './styles';
import Input from '../../components/Input';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';

function Register() {
  const navigate = useNavigate();

  return (
    <Container>
      <Title>Register</Title>
      <Input placeholder="Usuário" />
      <Input placeholder="Senha" />
      <Button text="Cadastrar" />

      <HiperLink onClick={() => navigate('/login')}>Já possui uma conta? Entrar</HiperLink>
    </Container>
  );
}

export default Register;