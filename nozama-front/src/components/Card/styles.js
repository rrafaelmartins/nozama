import styled from 'styled-components';

export const Container = styled.div`
  border: 1px solid black;
  max-width: 200px;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 10px;

  padding: 10px;
`;

export const Name = styled.p`
  font-size: 18px;
`;

export const Price = styled.p`
  font-size: 18px;
  color: red;
`;