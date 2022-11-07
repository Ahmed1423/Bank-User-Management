import React from "react";
import {useNavigate} from "react-router-dom";
import GoToLogin from "./GoToLogin";

const Menu = (props) => {

    const navigate = useNavigate();

    const route_ = (path) => {
        navigate(path);
    }

    if(sessionStorage.getItem('user') === null) {
        return (<GoToLogin />);
      }

    return (
        <>
            <h2> Hi, {sessionStorage.getItem('user')}.</h2>
            <button className="btn btn-info" onClick={() => {route_("/loan")}}>Loan</button>
            <br></br>
            <button className="btn btn-info" onClick={() => {route_("/transactions")}}>Transactions</button>
            <br></br>
            <button className="btn btn-info" onClick={() => {route_("/viewstatement")}}>View Statement</button>
            <br></br>
            <br></br>
            <button className="btn btn-info" onClick={() => {sessionStorage.removeItem('user'); route_("/login")}}>Logout</button>
        </>
    )
};

export default Menu;