import "./App.css";
import React from "react";
import Login from "./components/Login";
import Register from "./components/Register";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Menu from "./components/Menu";
import Loan from "./components/Loan";
import Transactions from "./components/Transactions";
import ViewStatement from "./components/ViewStatement";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/login" element={<Login/>} />
        <Route exact path="/register" element={<Register />} />
        <Route exact path="/menu" element={<Menu/>} />
        <Route exact path="/loan" element={<Loan/>} />
        <Route exact path="/transactions" element={<Transactions/>} />
        <Route exact path="/viewstatement" element={<ViewStatement/>} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
