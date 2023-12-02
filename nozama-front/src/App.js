import { GlobalProvider } from './context/GlobalContext';
import AppRoutes from './routes/Router';

import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <GlobalProvider>
        <BrowserRouter>
          <AppRoutes />
        </BrowserRouter>
      </GlobalProvider>
    </div>
  );
}

export default App;
