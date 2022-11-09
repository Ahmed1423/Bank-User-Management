import React, { useState } from "react";
import GoToLogin from "./GoToLogin";
import { useNavigate } from "react-router-dom";
import * as utils from "../services/requests";
import { format } from "date-fns";

const ViewStatement = (props) => {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };

  let logout = (e) => {
    e.preventDefault();
    sessionStorage.removeItem("user");
    console.log("Loggedout Successfully");
    route_("/login");
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(transaction + " " + fromDate + " " + toDate);

    utils
      .post("/getStatement", {
        customerId: sessionStorage.getItem("user"),
        transactionType: transaction,
        from: format(Date.parse(fromDate), "yyyy-MM-dd"),
        to: format(Date.parse(toDate), "yyyy-MM-dd"),
      })
      .then((response) => {
        console.log(response.data);
        sessionStorage.setItem("data", JSON.stringify(response.data));
        sessionStorage.setItem("text", "TRANSACTION STATEMENT");

        console.log(JSON.parse(sessionStorage.getItem("data")));
        route_("/jsonTable");
      })
      .catch((err) => {
        console.log(err);
      });
    console.log(transaction + " " + fromDate + " " + toDate);
  };

  const [transaction, setTransaction] = useState("Withdraw");
  const [fromDate, setFromDate] = useState();
  const [toDate, setToDate] = useState();

  if (sessionStorage.getItem("user") === null) {
    return <GoToLogin />;
  }

  return (
    <>
      <nav className="navbar navbar-expand-lg mx-2">
        <button
          className="btn btn-dark mx-auto btn-lg"
          onClick={() => {
            route_("/menu");
          }}
        >
          Menu
        </button>
        <div>
          <span className="fw-bold fs-italic p-1">
            Hi, {sessionStorage.getItem("user")}
          </span>
          <button className="btn btn-danger ms-end btn-lg" onClick={logout}>
            Logout
          </button>
        </div>
      </nav>

      <div className="container pt-2 h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col-12 col-md-8 col-lg-6 col-xl-5">
            <div
              className="card bg-white text-dark border border-success border-2"
              style={{ borderRadius: 2 + "rem" }}
            >
              <div className="card-body px-5 text-center">
                <div className="mb-md-2 mt-md-3 pb-1">
                  <h2 className="fw-bold mb-2 text-uppercase">
                    Transaction Statement
                  </h2>
                  <p className="text-dark-50 mb-5">
                    Please fill the details to generate the Satement.
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
                      <label className="form-label" htmlFor="customer-dob">
                        From Date
                      </label>
                      <input
                        type="date"
                        className="form-control form-control-lg"
                        value={fromDate}
                        onChange={(e) => setFromDate(e.target.value)}
                        max={new Date().toLocaleDateString("en-ca")}
                        required
                      />
                    </div>
                    <div className="form-outline mb-4">
                      <label className="form-label" htmlFor="customer-dob">
                        To date
                      </label>
                      <input
                        type="date"
                        className="form-control form-control-lg"
                        value={toDate}
                        onChange={(e) => setToDate(e.target.value)}
                        max={new Date().toLocaleDateString("en-ca")}
                        required
                      />
                    </div>

                    <div className="d-grid gap-2">
                      <button className="btn btn-info" type="submit">
                        Get Statement
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

export default ViewStatement;
