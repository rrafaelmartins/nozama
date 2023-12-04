import React from 'react';

import { Container } from './styles';

function Input({ placeholder, onChange, type, name, value }) {
  return (
    <Container
      name={name}
      placeholder={placeholder}
      onChange={onChange}
      type={type}
      value={value}
    >
    </Container>
  );
}

export default Input;