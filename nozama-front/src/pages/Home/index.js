import React from 'react'
import { Container } from './styles'

import Section from '../../components/Section';
import Card from '../../components/Card';
import Button from '../../components/Button';

function Home() {
  return (
    <Container>
      <Section title="Carrinho">
        <Card
          name={'Produto 1'}
          price={10}
        />
      </Section>
      <Section title="Produtos">
        <Card
          name={'Produto 1'}
          price={10}
        >
          <Button text="adicionar ao carrinho" />
        </Card>
        <Card
          name={'Produto 2'}
          price={10}
        >
          <Button text="adicionar ao carrinho" />
        </Card>
        <Card
          name={'Produto 3'}
          price={10}
        >
          <Button text="adicionar ao carrinho" />
        </Card>
      </Section>
    </Container >
  )
}

export default Home;