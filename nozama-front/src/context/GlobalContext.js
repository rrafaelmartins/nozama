import { createContext } from "react";
import { useProducts } from "./hooks/useProducts";
import { useAuth } from "./hooks/useAuth";

const GlobalContext = createContext()

function GlobalProvider({ children }) {
  const {
    createProduct,
    isLoaded,
    products
  } = useProducts()

  const {
    createUser,
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
          user
        }
      }>
      {children}
    </GlobalContext.Provider>
  )
}

export { GlobalContext, GlobalProvider }
