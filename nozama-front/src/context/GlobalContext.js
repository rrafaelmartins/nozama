import { createContext } from "react";
import { useProducts } from "./hooks/useProducts";
import { useAuth } from "./hooks/useAuth";

const GlobalContext = createContext()

function GlobalProvider({ children }) {
  const {
    createProduct,
    isLoaded,
    products,
    addProductToCart,
  } = useProducts()

  const {
    createUser,
    login,
    logged,
    user
  } = useAuth()

  return (
    <GlobalContext.Provider
      value={
        {
          createProduct,
          isLoaded,
          products,
          createUser,
          login,
          logged,
          user,
          addProductToCart
        }
      }>
      {children}
    </GlobalContext.Provider>
  )
}

export { GlobalContext, GlobalProvider }
