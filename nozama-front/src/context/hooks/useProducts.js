import { useState } from "react";
import api from "../../services/api";

export function useProducts() {

  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);
  const [pedidosAtt, setPedidosAtt] = useState(true);

  const createProduct = (product) => {
    api.post('/produtos', product)
      .then(res => {
        console.log(res);
      })
      .catch((error) => {
        console.log(error)
      })
  }

  const addProductToCart = (product, userId) => {
    api.post(`/carrinho/${userId}/add-produto`, product)
      .then(res => {
        console.log(res);
        setCart([...cart, res.data]);
      })
      .catch((error) => {
        console.log(error)
      })
  }

  const postPedidos = (obj, produtos, userId) => {
    api.post(`/pedidos`, obj)
      .then(res => {
        api.post(`/pedidos/${res.data.id}/enviar`, {
          "produtos": produtos,
          "userId": userId,
          "estadoNome": "NOVO"
        })
          .then(res => {
            console.log("aqui", res.data);
            setPedidosAtt(false);
            console.log("aqui", pedidosAtt);
          })
          .catch(error => {
            console.error(error);
          });
      })
      .catch(error => {
        console.error(error);
      });
  }

  return {
    createProduct,
    addProductToCart,
    pedidosAtt,
    setPedidosAtt,
    postPedidos,
    products
  }
}