import { useState } from "react";
import api from "../../services/api";

export function useProducts() {

  const [products, setProducts] = useState([]);

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
    createProduct,
    products
  }
}