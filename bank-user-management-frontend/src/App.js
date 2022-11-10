import "./App.css";
import React from "react";
import Login from "./components/Login";
import Register from "./components/Register";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Menu from "./components/Menu";
import Loan from "./components/Loan";
import Transactions from "./components/Transactions";
import ViewStatement from "./components/ViewStatement";
import JsonTable from "./components/JsonTable";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route exact path="/" element={<Login />} />
        <Route exact path="/register" element={<Register />} />
        <Route exact path="/menu" element={<Menu />} />
        <Route exact path="/loan" element={<Loan />} />
        <Route exact path="/transactions" element={<Transactions />} />
        <Route exact path="/viewstatement" element={<ViewStatement />} />
        <Route exact path="/jsonTable" element={<JsonTable />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
