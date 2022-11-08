import React, { useState } from "react";
import GoToLogin from "./GoToLogin";
import Menu from "./Menu";
import * as utils from '../services/requests';
import { format } from 'date-fns';


const ViewStatement = (props) => {

  const handleSubmit = (e) => {
      e.preventDefault();
      console.log(transaction + " " + fromDate + " " + toDate);

      utils.post("/getStatement", { "customerId": sessionStorage.getItem('user'),
      "transactionType": transaction,
      "from": format( Date.parse(fromDate), 'yyyy-MM-dd'),
      "to":format( Date.parse(toDate), 'yyyy-MM-dd')})
    .then((response) => {
      console.log(response);
    })
    .catch((err) => {
      console.log(err);
    })
      console.log(transaction + " " + fromDate + " " + toDate);
  };

  const [transaction, setTransaction] = useState('Withdraw');
  const [fromDate, setFromDate] = useState();
  const [toDate, setToDate] = useState();

  if(sessionStorage.getItem('user') === null) {
    return (<GoToLogin />);
  }

    return (
    <>
    <Menu></Menu>
        <div className="mb-md-1 mt-md-1 pb-1">
                <h2 className="fw-bold text-uppercase">View Statements</h2>
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
                      <div className="form-outline">
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
                    </div>

                  <div className="col-6">
                      <div className="form-outline">
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
                    </div>
                    


                  <div className="d-grid gap-2">
                    <button className="btn btn-info" type="submit">
                      Apply
                    </button>
                  </div>
                </div>
                </form>
              </div>
    </>
    )
};

export default ViewStatement;