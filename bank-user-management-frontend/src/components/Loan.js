import React, { useState } from "react";
import GoToLogin from './GoToLogin';
import * as constants from '../services/constants';
import Menu from "./Menu";
import * as utils from '../services/requests';

const Loan = (props) => {

  const handleSubmit = (e) => {
    e.preventDefault();
    utils.post("/applyLoan", {
      "C_ID": sessionStorage.getItem('user'),
      "B_ID":branch,
      "loan_amount":amount
    }).then((response) => {
        console.log(response);
      })
      .catch((err) => {
        console.log(err);
      })
    };

  const [branch, setBranch] = useState("Hyderabad");
  const [amount, setAmount] = useState(0);

  if(sessionStorage.getItem('user') === null) {
    return (<GoToLogin />);
  }

    return <>
    <Menu> </Menu>
    <div className="container py-4 h-100">
      <div className="row d-flex justify-content-center align-items-center h-100">
        <div className="col-12 col-md-8 col-lg-6 col-xl-5">
          <div
            className="card bg-white text-dark border border-success border-2"
            style={{ borderRadius: 2 + "rem" }}
          >
            <div className="card-body p-5 text-center">
              <div className="mb-md-5 mt-md-4 pb-3">
                <h2 className="fw-bold mb-2 text-uppercase">Loan</h2>
                <p className="text-dark-50 mb-5">
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
                      value={sessionStorage.getItem('user')}
                      disabled
                    />
                
                  </div>

                  <div className="form-outline mb-4" name="branch" id="branch">
                  <label className="form-label" htmlFor="branch">
                      Branch
                    </label>
                  <select className="form-control form-control-lg" onChange={(e) => {setBranch(e.target.value)}}>
                            {constants.branches.map(branch => <option key={branch} value={branch}>{branch}</option>)}
                          </select>
                    
                  </div>

                  <div className="form-outline mb-4">
                  <label className="form-label" htmlFor="loan">
                      Loan Amount
                    </label>
                    <input
                      type="number"
                      value={amount}
                      onChange={(e) => {setAmount(e.target.value)}}
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
                </form>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
    </>;
};

export default Loan;