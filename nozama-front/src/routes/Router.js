import React, { useContext } from 'react';
import { Routes, Route, Navigate, Outlet } from "react-router-dom";

import Home from '../pages/Home';
import Login from '../pages/Login';
import Register from '../pages/Register';
import { GlobalContext } from '../context/GlobalContext';
import Pagamento from '../pages/Pagamento';
import Rastreio from '../pages/Rastreio';

function AppRoutes() {
  const context = useContext(GlobalContext);

  function LoginRoute() {
    console.log(context.logged);
    return context.logged ? <Navigate to="/" /> : <Outlet />
  }

  function HomeRoute() {
    return context.logged ? <Outlet /> : <Navigate to="/login" />
  }

  return (
    <Routes>
      <Route path="/" element={<HomeRoute />}>
        <Route path='/' element={<Home />} />
        <Route path='/pagamentos/:id' element={<Pagamento />} />
        <Route path='/rastrear/:id' element={<Rastreio />} />
      </Route>

      <Route path="/login" element={<LoginRoute />}>
        <Route path="/login" element={<Login />} />
      </Route>
      <Route path='/register' element={<Register />} />

    </Routes>
  );
}

export default AppRoutes;
