import { createContext } from "react";
import { useProducts } from "./hooks/useProducts";

const GlobalContext = createContext()

function GlobalProvider({ children }) {
  const {

    createProduct,
    isLoaded,
    products
  } = useProducts()

  return (
    <GlobalContext.Provider
      value={
        {
          createProduct,
          isLoaded,
          products
        }
      }>
      {children}
    </GlobalContext.Provider>
  )
}

export { GlobalContext, GlobalProvider }
