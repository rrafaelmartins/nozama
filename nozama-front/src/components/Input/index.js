import React from 'react';

import { Container } from './styles';

function Input({ placeholder, onChange, type, name, value, hidden }) {
  return (
    <Container
      name={name}
      placeholder={placeholder}
      onChange={onChange}
      type={type}
      value={value}
      hidden={hidden}
    >
    </Container>
  );
}

export default Input;