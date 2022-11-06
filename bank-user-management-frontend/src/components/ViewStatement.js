import React from "react";

const handleSubmit = () => {

};

const ViewStatement = () => {
    return (
    <>
        <div className="mb-md-1 mt-md-1 pb-1">
                <h2 className="fw-bold text-uppercase">View Statements</h2>
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
                          value="CID"
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
                      <div className="form-outline">
                        <label className="form-label" htmlFor="customer-dob">
                          From Date
                        </label>
                        <input
                          type="date"
                          id="customer-dob"
                          className="form-control form-control-lg"
                          name="customer-dob"
                          min="1995-01-01"
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
                          id="customer-dob"
                          className="form-control form-control-lg"
                          name="customer-dob"
                          min="1995-01-01"
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