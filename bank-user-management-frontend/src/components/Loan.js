import React, { useState } from "react";
import GoToLogin from "./GoToLogin";
import * as constants from "../services/constants";
import * as utils from "../services/requests";
import { useNavigate } from "react-router-dom";

const Loan = (props) => {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };
  const handleSubmit = (e) => {
    e.preventDefault();
    const branchId = {
      Hyderabad: 1,
      Bangalore: 2,
      Chennai: 3,
    };
    utils
      .post("/applyLoan", {
        customerNumber: sessionStorage.getItem("user"),
        branchId: branchId[branch],
        loanAmount: amount,
      })
      .then((response) => {
        console.log(response);
        window.alert("Successful");
      })
      .catch((err) => {
        console.log(err);
        window.alert("Loan Not Submitted");
      });
  };
  const formatLoanData = (data) => {
    console.log(data);
    let rlist = [];
    let ret = {};
    for (var i = 0; i < data.length; i++) {
      console.log(data[i]["id"]);
      ret["Loan request ID"] = data[i]["id"];
      ret["Customer ID"] = data[i]["customerNumber"];
      ret["Customer Name"] =
        data[i]["customerMaster"]["firstName"] +
        " " +
        data[i]["customerMaster"]["lastName"];
      ret["Loan Amount"] = data[i]["loanAmount"];
      ret["Branch ID"] = data[i]["branchId"];
      ret["Branch Name"] = data[i]["branchMaster"]["BranchName"];
      ret["Branch City"] = data[i]["branchMaster"]["branchCity"];

      rlist.push(ret);
    }
    return rlist;
  };

  let logout = (e) => {
    e.preventDefault();
    sessionStorage.removeItem("user");
    console.log("Loggedout Successfully");
    route_("/");
  };

  const viewLoan = (e) => {
    e.preventDefault();
    utils
      .get("/viewLoan", {
        customerId: sessionStorage.getItem("user"),
      })
      .then((response) => {
        console.log(response);
        let data = formatLoanData(response.data);
        sessionStorage.setItem("data", JSON.stringify(data));
        console.log(JSON.parse(sessionStorage.getItem("data")));
        sessionStorage.setItem("text", "LOANS AWAITING APPROVAL");

        route_("/jsonTable");
      })
      .catch((err) => {
        console.log(err);
        window.alert("Request Not processed - Try Again!");
      });
  };

  const [branch, setBranch] = useState("Hyderabad");
  const [amount, setAmount] = useState(0);

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
      <div className="container h-100">
        <div className="row d-flex justify-content-center align-items-center h-100">
          <div className="col-12 col-md-8 col-lg-6 col-xl-5">
            <div
              className="card bg-white text-dark border border-success border-2"
              style={{ borderRadius: 2 + "rem" }}
            >
              <div className="card-body px-5 text-center">
                <div className="mb-md-1 mt-md-2 pb-3">
                  <h2 className="fw-bold mb-1 text-uppercase">Loan</h2>
                  <p className="text-dark-50 mb-3">
                    Please enter loan details!
                  </p>
                  <form onSubmit={handleSubmit}>
                    <div className="form-outline mb-4">
                      <label className="form-label" htmlFor="customer-id">
                        Customer Id
                      </label>
                      <input
                        type="text"
                        id="customer-id"
                        className="form-control form-control-lg"
                        name="customer-id"
                        value={sessionStorage.getItem("user")}
                        disabled
                      />
                    </div>

                    <div
                      className="form-outline mb-4"
                      name="branch"
                      id="branch"
                    >
                      <label className="form-label" htmlFor="branch">
                        Branch
                      </label>
                      <select
                        className="form-control form-control-lg"
                        onChange={(e) => {
                          setBranch(e.target.value);
                        }}
                      >
                        {constants.branches.map((branch) => (
                          <option key={branch} value={branch}>
                            {branch}
                          </option>
                        ))}
                      </select>
                    </div>

                    <div className="form-outline mb-4">
                      <label className="form-label" htmlFor="loan">
                        Loan Amount
                      </label>
                      <input
                        type="number"
                        value={amount}
                        onChange={(e) => {
                          setAmount(e.target.value);
                        }}
                        required
                        id="loan"
                        className="form-control form-control-lg"
                        name="loan"
                      />
                    </div>

                    <div className="d-grid gap-2">
                      <button className="btn btn-info" type="submit">
                        Apply
                      </button>
                    </div>
                    <br />
                    <br />
                    <div className="d-grid gap-2">
                      <button
                        className="btn btn-info"
                        type="button"
                        onClick={viewLoan}
                      >
                        View applied Loans
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

export default Loan;
