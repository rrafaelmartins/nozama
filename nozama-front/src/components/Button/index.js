import React from 'react';

import { Container, Text } from './styles';

function Button({ text, onClick }) {
  return (
    <Container onClick={onClick} >
      <Text>{text}</Text>
    </Container >
  );
}

export default Button;