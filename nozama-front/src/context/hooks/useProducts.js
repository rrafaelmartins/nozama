import { useState } from "react";
import api from "../../services/api";

export function useProducts() {

  const [products, setProducts] = useState([]);

  const getProducts = () => {
    setProducts([]);
    api.get('/produtos')
      .then(res => {
        console.log(res);
      })
      .catch((error) => {
        console.log(error)
      })
  }

  const createProduct = (product) => {
    api.post('/produtos', product)
      .then(res => {
        console.log(res);
      })
      .catch((error) => {
        console.log(error)
      })
  }

  return {
    getProducts,
    createProduct,
    products
  }
}