import React from "react";
import GoToLogin from "./GoToLogin";

const handleSubmit = () => {

};

const Transactions = (props) => {

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
                          htmlFor="customer-first-name"
                        >
                          Select the Transaction
                        </label>
                        <input
                          type="text"
                          required
                        />
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