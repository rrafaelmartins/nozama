import React from 'react';

import { Container, ListWrapper, Title } from './styles';

function Section({ children, title }) {
  return (
    <Container>
      <Title>{title}</Title>
      <ListWrapper>
        {children}
      </ListWrapper>
    </Container>
  );
}

export default Section;