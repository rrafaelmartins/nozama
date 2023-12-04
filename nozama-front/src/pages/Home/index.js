import React, { useContext, useEffect, useState } from 'react'
import { Container, Title, PedidosWrapper, Text, Separator } from './styles'

import Section from '../../components/Section';
import Card from '../../components/Card';
import Button from '../../components/Button';
import { GlobalContext } from '../../context/GlobalContext';
import Input from '../../components/Input';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';

function Home() {

  const context = useContext(GlobalContext);

  const [products, setProducts] = useState([]);
  const [name, setName] = useState('');
  const [price, setPrice] = useState(0);
  const [cart, setCart] = useState([]);
  const [quantidade, setQuantidade] = useState(0);

  const [isLoaded, setIsLoaded] = useState(false);

  const user = context.user;

  const navigate = useNavigate();

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

      api.get(`/carrinho/${user.id}`)
        .then(res => {
          console.log(res.data);
          setCart(res.data.produtos);
        })
        .catch(error => {
          console.error(error);
        });
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
      <Title>Olá, {user.nome}</Title>

      <Separator />

      <Section title="Carrinho">
        {cart.map(product => (
          <Card
            key={product.produto.id}
            name={product.produto.nome}
            price={product.produto.preco}
          />
        )
        )}
      </Section>
      <Button text="Finalizar compra" onClick={() => navigate(`/pagamentos/${user.id}`)} />

      <Separator />

      <Section title="Produtos">
        {products.map(product => (
          <Card
            name={product.nome}
            price={product.preco}
          >
            <Input placeholder="Quantidade" type="number" onChange={setQuantidade} />
            <Button text="Adicionar ao carrinho" onClick={() => context.addProductToCart({
              "produto_id": product.id,
              "quantidade": quantidade
            }, user.id)} />
          </Card>
        )
        )}
      </Section>

      <Separator />

      <PedidosWrapper>
        <Title>Pedidos</Title>
        <Text>Pedido 1</Text>
        <Text>Pedido 2</Text>
        <Text>Pedido 3</Text>
      </PedidosWrapper>

      <Separator />

      <Section title="Adicionar produto">
        <Input placeholder="Nome do produto" onChange={e => setName(e.target.value)} />
        <Input placeholder="Preço do produto" type="number" onChange={e => setPrice(e.target.value)} />
        <Button text="Adicionar" onClick={addProduct} />
      </Section>

    </Container >
  )
}

export default Home;