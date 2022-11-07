import React from "react";
import GoToLogin from "./GoToLogin";

const Menu = (props) => {

    if (sessionStorage.getItem('user') === null) {
        return (<GoToLogin />);
    }

    return (
        <>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">Hi, {sessionStorage.getItem('user')}.</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="/loan">Apply for Loan</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/transactions">Make Transaction</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/viewstatement">View Statement</a>
        </li>    
      </ul>
    </div>
  </div>
</nav>
        </>
    )
};

export default Menu;