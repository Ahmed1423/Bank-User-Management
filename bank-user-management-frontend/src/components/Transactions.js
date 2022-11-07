import React, { useState } from "react";
import GoToLogin from "./GoToLogin";

const Transactions = (props) => {
  
  const [transaction, setTransaction] = useState('Withdraw');
  const [amount, setAmount] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(transaction + " " + amount);
  }

  if(sessionStorage.getItem('user') === null) {
    return (<GoToLogin />);
  }

    return <>
        <div className="mb-md-1 mt-md-1 pb-1">
                <h2 className="fw-bold text-uppercase">Transactions</h2>
                <p className="text-dark-50 mb-3">Please the details!</p>
                <form onSubmit={handleSubmit}>
                  <div className="row">
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
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
                          Select the Transaction
                        </label>
                        <div>
                          <select onChange={(e) => {setTransaction(e.target.value)}}>
                            <option value="Withdraw">Withdraw</option>
                            <option value="Deposit">Deposit</option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                          htmlFor="customer-first-name"
                        >
                          Enter the Amount 
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

export default Transactions;