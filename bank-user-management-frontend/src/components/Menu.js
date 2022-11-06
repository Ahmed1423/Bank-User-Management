import React from "react";
import {useNavigate} from "react-router-dom";

const Menu = () => {

    const navigate = useNavigate();

    const route_ = (path) => {
        navigate(path);
    }

    return (
        <>
            <button className="btn btn-info" onClick={() => {route_("/loan")}}>Loan</button>
            <br></br>
            <button className="btn btn-info" onClick={() => {route_("/transactions")}}>Transactions</button>
            <br></br>
            <button className="btn btn-info" onClick={() => {route_("/viewstatement")}}>View Statement</button>
            <br></br>
        </>
    )
};

export default Menu;