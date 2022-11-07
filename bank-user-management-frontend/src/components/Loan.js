import React, { useState } from "react";
import GoToLogin from './GoToLogin';
import * as constants from '../services/constants';

const Loan = (props) => {

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(branch + " " + amount);
  };

  const [branch, setBranch] = useState('');
  const [amount, setAmount] = useState(0);

  if(sessionStorage.getItem('user') === null) {
    return (<GoToLogin />);
  }

    return <>
        <div className="mb-md-1 mt-md-1 pb-1">
                <h2 className="fw-bold text-uppercase">Loan</h2>
                <p className="text-dark-50 mb-3">Please the details!</p>
                <form onSubmit={handleSubmit}>
                  <div className="row">
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                          htmlFor="customer-first-name"
                        >
                          Customer ID 
                        </label>
                        <input
                          type="text"
                          value={sessionStorage.getItem('user')}
                          disabled
                        />
                      </div>
                    </div>
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                        >
                          Branch 
                        </label>
                        <div>
                          <select onChange={(e) => {setBranch(e.target.value)}}>
                            {constants.branches.map(branch => <option key={branch} value={branch}>{branch}</option>)}
                          </select>
                        </div>
                      </div>
                    </div>
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                        >
                          Enter the Loan Amount 
                        </label>
                        <input
                          type="number"
                          value={amount}
                          onChange={(e) => {setAmount(e.target.value)}}
                          required
                        />
                      </div>
                    </div>

                    


                  <div className="d-grid gap-2">
                    <button className="btn btn-info" type="submit">
                      Apply
                    </button>
                  </div>
                </div>
                </form>
              </div>
    </>;
};

export default Loan;