import React from 'react';

import { Container, Name, Price } from './styles';

function Card({ children, name, price }) {
  return (
    <Container>
      <Name>{name}</Name>
      <Price>{price}</Price>
      {children}
    </Container>
  );
}

export default Card;