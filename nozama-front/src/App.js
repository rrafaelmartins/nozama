import AppRoutes from './routes/Router';
import GlobalStyle from './styles/global';

import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <GlobalStyle />
        <AppRoutes />
      </BrowserRouter>
    </div>
  );
}

export default App;
