import React, { useContext, useState } from 'react';

import { Container, Title, HiperLink } from './styles';
import Input from '../../components/Input';
import Button from '../../components/Button';
import { useNavigate } from 'react-router-dom';
import { GlobalContext } from '../../context/GlobalContext';

function Login() {
  const navigate = useNavigate();

  const context = useContext(GlobalContext);

  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const login = () => {
    const user = {
      "email": email,
      "senha": password
    }

    context.login(user);
  }

  return (
    <Container>
      <Title>Login</Title>
      <Input placeholder="Email" onChange={e => setEmail(e.target.value)} />
      <Input placeholder="Senha" type="password" onChange={e => setPassword(e.target.value)} />
      <Button text="Entrar" onClick={login} />

      <HiperLink onClick={() => navigate('/register')}>Ainda não possui uma conta? Registrar</HiperLink>
    </Container>
  );
}

export default Login;