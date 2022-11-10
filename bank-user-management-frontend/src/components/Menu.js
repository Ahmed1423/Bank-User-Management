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
    route_("/");
  };

  return (
    <>
      <nav className="navbar navbar-expand-lg mx-2">
        <a
          className="btn btn-dark mx-auto btn-lg"
          onClick={() => {
            route_("/menu");
          }}
        >
          Menu
        </a>
        <div>
          <span className="fw-bold fs-italic p-1">
            Hi, {sessionStorage.getItem("user")}
          </span>
          <a className="btn btn-danger ms-end btn-lg" onClick={logout}>
            Logout
          </a>
        </div>
      </nav>
      <div className="container">
        <div className="row row-cols-1 row-cols-md-3 g-4 mt-5">
          <div className="col">
            <div className="card h-100">
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXREWRt4uB2NkmuZVikiyoX--HE3Um0QZbhA&usqp=CAU"
                className="card-img-top"
                alt="Hollywood Sign on The Hill"
              />
              <div className="card-body text-center">
                <a
                  className="card-title btn btn-primary"
                  onClick={() => {
                    route_("/loan");
                  }}
                >
                  Apply for Loan
                </a>
                <p className="card-text  fw-bold">
                  Take a Loan to fulfill your needs in just 2 mins
                </p>
              </div>
            </div>
          </div>
          <div className="col">
            <div className="card h-100">
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXREWRt4uB2NkmuZVikiyoX--HE3Um0QZbhA&usqp=CAU"
                className="card-img-top"
                alt="Palm Springs Road"
              />
              <div className="card-body text-center">
                <a
                  className="card-title btn btn-primary"
                  onClick={() => {
                    route_("/transactions");
                  }}
                >
                  Transactions
                </a>
                <p className="card-text fw-bold">
                  Deposit or Withdraw from/to your account
                </p>
              </div>
            </div>
          </div>
          <div className="col">
            <div className="card h-100">
              <img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQXREWRt4uB2NkmuZVikiyoX--HE3Um0QZbhA&usqp=CAU"
                className="card-img-top"
                alt="Los Angeles Skyscrapers"
              />
              <div className="card-body text-center">
                <a
                  className="card-title btn btn-primary"
                  onClick={() => {
                    route_("/viewstatement");
                  }}
                >
                  View Statement
                </a>
                <p className="card-text  fw-bold">
                  View all your transaction statments
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Menu;
