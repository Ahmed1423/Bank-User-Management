import React from "react";
import GoToLogin from "./GoToLogin";
import { useNavigate } from "react-router-dom";

const Menu = (props) => {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };

  if (sessionStorage.getItem("user") === null) {
    return <GoToLogin />;
  }

  let logout = (e) => {
    e.preventDefault();
    sessionStorage.removeItem("user");
    console.log("Loggedout Successfully");
    route_("/login");
  };

  return (
    <>
      <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="container-fluid">
          <span class="text-white me-4">
            <b>Hi, {sessionStorage.getItem("user")}.</b>
          </span>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#collapsibleNavbar"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <div class="btn-group">
              <button
                type="button"
                class="btn btn-primary"
                onClick={() => {
                  route_("/loan");
                }}
              >
                Apply for Loan
              </button>
              <button
                type="button"
                class="btn btn-primary"
                onClick={() => {
                  route_("/transactions");
                }}
              >
                Make Transaction
              </button>
              <button
                type="button"
                class="btn btn-primary"
                onClick={() => {
                  route_("/viewstatement");
                }}
              >
                View Statement
              </button>
            </div>
          </div>
          <div class="">
            {" "}
            <button type="button" class="btn btn-danger" onClick={logout}>
              Logout
            </button>
          </div>
        </div>
      </nav>
    </>
  );
};

export default Menu;
