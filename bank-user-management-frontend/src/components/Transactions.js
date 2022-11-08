import React, { useState } from "react";
import GoToLogin from "./GoToLogin";
import Menu from "./Menu";
import * as utils from '../services/requests';

const Transactions = (props) => {
  
  const [transaction, setTransaction] = useState('Withdraw');
  const [amount, setAmount] = useState(0);

  const handleSubmit = (e) => {
    e.preventDefault();
    utils.post("/makeTransaction", { "customerNumber": sessionStorage.getItem('user'),
      "transactionType": transaction,
      "transactionAmount": amount})
    .then((response) => {
      console.log(response);
    })
    .catch((err) => {
      console.log(err);
    })
    console.log(transaction + " " + amount);
  }

  if(sessionStorage.getItem('user') === null) {
    return (<GoToLogin />);
  }

    return <>
    <Menu> </Menu>
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