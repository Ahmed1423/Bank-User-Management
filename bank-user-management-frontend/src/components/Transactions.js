import React, { useState } from "react";
import GoToLogin from "./GoToLogin";
import Menu from "./Menu";
import * as utils from "../services/requests";
import { useNavigate } from "react-router-dom";

const Transactions = (props) => {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };

  const logout = (e) => {
    e.preventDefault();
    sessionStorage.removeItem("user");
    console.log("Loggedout Successfully");
    route_("/login");
  };

  const [transaction, setTransaction] = useState("Withdraw");
  const [amount, setAmount] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    utils
      .post("/makeTransaction", {
        customerNumber: sessionStorage.getItem("user"),
        transactionType: transaction,
        transactionAmount: amount,
      })
      .then((response) => {
        window.alert(response.data);
        console.log(response);
      })
      .catch((err) => {
        console.log(err);
      });
    console.log(transaction + " " + amount);
  };

  if (sessionStorage.getItem("user") === null) {
    return <GoToLogin />;
  }

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
      <div className="container pt-4 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col-12 col-md-8 col-lg-6 col-xl-5">
            <div
              className="card bg-white text-dark border border-success border-2"
              style={{ borderRadius: 2 + "rem" }}
            >
              <div className="card-body p-5 text-center">
                <div className="mb-md-2 mt-md-4 pb-3">
                  <h2 className="fw-bold mb-2 text-uppercase">Transaction</h2>
                  <p className="text-dark-50 mb-5">
                    Please enter the transaction details.
                  </p>
                  <form onSubmit={handleSubmit}>
                    <div className="form-outline mb-4">
                      <label className="form-label" htmlFor="customer-id">
                        Customer ID
                      </label>
                      <input
                        type="text"
                        className="form-control form-control-lg"
                        value={sessionStorage.getItem("user")}
                        disabled
                      />
                    </div>

                    <div className="form-outline mb-4">
                      <label className="form-label" htmlFor="customer-password">
                        Transaction Type (click to select)
                      </label>
                      <div>
                        <select
                          className="form-control form-control-lg"
                          onChange={(e) => {
                            setTransaction(e.target.value);
                          }}
                        >
                          <option value="Withdraw">Withdraw</option>
                          <option value="Deposit">Deposit</option>
                        </select>
                      </div>
                    </div>
                    <div className="form-outline mb-4">
                      <label
                        className="form-label"
                        htmlFor="customer-first-name"
                      >
                        Enter the Amount
                      </label>
                      <input
                        className="form-control form-control-lg"
                        type="number"
                        value={amount}
                        onChange={(e) => {
                          setAmount(e.target.value);
                        }}
                        required
                      />
                    </div>

                    <div className="d-grid gap-2">
                      <button className="btn btn-info" type="submit">
                        Submit
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Transactions;
