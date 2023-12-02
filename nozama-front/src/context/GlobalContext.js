import { createContext } from "react";
import { useProducts } from "./hooks/useProducts";

const GlobalContext = createContext()

function GlobalProvider({ children }) {
  const {
    getProducts,
    createProduct,
    products
  } = useProducts()

  return (
    <GlobalContext.Provider
      value={
        {
          getProducts,
          createProduct,
          products
        }
      }>
      {children}
    </GlobalContext.Provider>
  )
}

export { GlobalContext, GlobalProvider }
