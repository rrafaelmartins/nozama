import React, { useContext, useEffect, useState } from 'react';

import { Container, Title, Text, Separator, CartaoWrapper, Form, Label } from './styles';
import Section from '../../components/Section';
import Card from '../../components/Card';
import Input from '../../components/Input';
import Button from '../../components/Button';
import api from '../../services/api';
import { GlobalContext } from '../../context/GlobalContext';
import { useParams } from 'react-router-dom';

function Pagamento() {

  const [forma, setForma] = React.useState('');

  const { id } = useParams();

  const [carrinho, setCarrinho] = useState([]);

  useEffect(() => {
    api.get(`/carrinho/${id}`)
      .then(res => {
        setCarrinho(res.data.produtos);
        console.log(res.data.produtos);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const teste = () => {
    let s = [];
    carrinho.map(product => {
      s.push({
        "id": product.produto.id,
      })
    })

    console.log(s);
  }
  teste();

  const finalizar = () => {
    api.post(`/pedidos`, {
      "produtos": [

      ],
      "userId": id,
      "estadoNome": "NOVO"
    })
      .then(res => {
        console.log(res.data);
      })
      .catch(error => {
        console.error(error);
      });
  }

  return (
    <Container>
      <Title>Finalizar Compra</Title>
      <Separator />
      <Section title="Produtos">
        {
          carrinho.map(product => {
            return (<Card
              key={product.produto.id}
              name={product.produto.nome}
              price={product.produto.preco}
            />)
          }
          )
        }
      </Section>
      <Separator />
      <Title>Forma de Pagamento</Title>
      <Form>
        <Section>
          <Input name="forma" type="radio" value="Crédito" onChange={e => setForma(e.target.value)} />
          <Label>Crédito</Label>
        </Section>

        <Section>
          <Input name="forma" type="radio" value="Débito" onChange={e => setForma(e.target.value)} />
          <Label>Débito</Label>
        </Section>
        <Section>
          <Input name="forma" type="radio" value="PIX" onChange={e => setForma(e.target.value)} />
          <Label>PIX</Label>
        </Section>
      </Form>
      <Separator />
      {
        (forma === 'Crédito' || forma === 'Débito') &&
        <>
          <Title>Cartão</Title>
          <CartaoWrapper>
            <Input placeholder="Número do cartão" />
            <Input placeholder="Nome do titular" />
            <Input placeholder="Validade" />
            <Input placeholder="CVV" />
            <Button text="Finalizar" />
          </CartaoWrapper>
          <Separator />
        </>
      }
      {
        forma === 'PIX' &&
        <>
          <Title>PIX</Title>
          <CartaoWrapper>
            <Text>Chave PIX: 123456789</Text>
            <Button text="Finalizar" onClick={finalizar} />
          </CartaoWrapper>
          <Separator />
        </>
      }
    </Container>
  );
}

export default Pagamento;