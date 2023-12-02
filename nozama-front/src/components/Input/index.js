import React from 'react';

import { Container } from './styles';

function Input({ placeholder, onChange, type }) {
  return (
    <Container placeholder={placeholder} onChange={onChange} type={type}>

    </Container>
  );
}

export default Input;