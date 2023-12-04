import React, { useEffect, useState } from 'react';

import { Container, Title, Text } from './styles';
import { useParams } from 'react-router-dom';
import api from '../../services/api';
import Section from '../../components/Section';
import Card from '../../components/Card';
import Input from '../../components/Input';
import Button from '../../components/Button';

function Rastreio() {

  const { id } = useParams();

  const [pedido, setPedido] = useState({});
  const [envio, setEnvio] = useState([]);

  useEffect(() => {
    api.get(`/pedidos/${id}`)
      .then(res => {
        setPedido(res.data);
      })
      .catch(error => {
        console.error(error);
      });

    api.get(`/envios/${id}/rastrear`)
      .then(res => {
        setEnvio(res.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  return (
    <Container>
      <Title>Rastreio</Title>
      <Text>Id do pedido: {pedido.id}</Text>

      {
        pedido.produtos &&

        <Section title="Produtos">
          {pedido.produtos.map(product => (
            <Card
              name={product.produto.nome}
              price={product.produto.preco}
            />
          )
          )}
        </Section>
      }
      <Text>Status: {envio.status}</Text>
      <Text>Local: {envio.local}</Text>
      <Text>Previsão de entrega: {envio.previsaoEntrega}</Text>
    </Container>
  );
}

export default Rastreio;