import { useState } from "react";
import api from "../../services/api";

export function useProducts() {

  const [products, setProducts] = useState([]);
  const [cart, setCart] = useState([]);

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

  return {
    createProduct,
    addProductToCart,
    products
  }
}