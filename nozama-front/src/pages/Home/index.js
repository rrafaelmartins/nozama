import React, { useContext, useEffect, useState } from 'react'
import { Container } from './styles'

import Section from '../../components/Section';
import Card from '../../components/Card';
import Button from '../../components/Button';
import { GlobalContext } from '../../context/GlobalContext';
import Input from '../../components/Input';
import api from '../../services/api';

function Home() {

  const context = useContext(GlobalContext);

  const [products, setProducts] = useState([]);
  const [name, setName] = useState('');
  const [price, setPrice] = useState(0);

  const [isLoaded, setIsLoaded] = useState(false);

  useEffect(() => {
    if (isLoaded) {
      return;
    }

    const fetchData = async () => {
      api.get('/produtos')
        .then(res => {
          console.log(res.data);
          setProducts(res.data);
        })
        .catch(error => {
          console.error(error);
        });
      setIsLoaded(true);
    };

    fetchData();
  }, [context, isLoaded]);

  function addProduct() {
    context.createProduct({
      nome: name,
      preco: price
    });

    setProducts([...products, {
      nome: name,
      preco: price
    }]);

    setIsLoaded(false);

  }

  return (
    <Container>
      <Section title="Carrinho">
        <Card
          name={'Produto 1'}
          price={10}
        />
      </Section>

      <Section title="Produtos">
        {products.map(product => (
          <Card
            name={product.nome}
            price={product.preco}
          />
        )
        )}
      </Section>
      <Section title="Adicionar produto">
        <Input placeholder="Nome do produto" onChange={e => setName(e.target.value)} />
        <Input placeholder="Preço do produto" type="number" onChange={e => setPrice(e.target.value)} />
        <Button text="Adicionar" onClick={addProduct} />
      </Section>

    </Container >
  )
}

export default Home;