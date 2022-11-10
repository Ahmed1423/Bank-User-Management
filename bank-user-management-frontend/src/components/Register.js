import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as utils from "../services/requests";

function validate(customer) {
  let isCorrect = true;

  if (customer.firstName.length < 3) {
    document.getElementById("first-name-helper").style.backgroundColor = "gold";
    isCorrect = false;
  }

  if (customer.lastName.length < 3) {
    document.getElementById("last-name-helper").style.backgroundColor = "gold";
    isCorrect = false;
  }

  return isCorrect;
}

function Register() {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };

  let [customerNumber, setCustomerNumber] = useState(0);
  let [firstName, setFirstName] = useState("");
  let [lastName, setLastName] = useState("");
  let [city, setCity] = useState("");
  let [phone, setPhone] = useState(0);
  let [occupation, setOccupation] = useState("");
  let [dob, setDob] = useState();
  let [customerPassword, setCustomerPassword] = useState("");

  let handleSubmit = (e) => {
    e.preventDefault();

    let customer = {
      customerNumber: customerNumber,
      firstName: firstName,
      lastName: lastName,
      customerCity: city,
      customerContactNo: phone,
      occupation: occupation,
      customerDateOdBirth: dob,
      customerPassword: customerPassword,
    };

    if (validate(customer)) {
      console.log(JSON.stringify(customer));
      utils
        .post("/register", customer)
        .then((response) => {
          console.log(response.data);
          if (response.data === "Successful") {
            sessionStorage.setItem("user", customerNumber);
            window.alert("Account has been created successfully, Please Login");
            route_("/");
          } else {
            window.alert(response.data);
          }
        })
        .catch((err) => {
          console.log(err.response.status);
        });
    } else {
      console.log("Something");
    }
  };

  return (
    <div className="container pt-1 h-100">
      <div className="row d-flex justify-content-center align-items-center h-100">
        <div className="col-12 col-xl-7">
          <div
            className="card bg-white text-dark border border-success border-2"
            style={{ borderRadius: 2 + "rem" }}
          >
            <div className="card-body px-5 text-center">
              <div className="mb-md-1 mt-md-1 pb-1">
                <h2 className="fw-bold text-uppercase">Register</h2>
                <p className="text-dark-50 mb-3">Please enter your details!</p>
                <form onSubmit={handleSubmit}>
                  <div className="row">
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                          htmlFor="customer-first-name"
                        >
                          First Name
                        </label>
                        <input
                          type="text"
                          id="customer-first-name"
                          className="form-control form-control-lg"
                          name="customer-first-name"
                          value={firstName}
                          onChange={(e) => setFirstName(e.target.value)}
                          required
                        />
                        <small
                          className="form-text text-muted"
                          id="first-name-helper"
                        >
                          First Name should be atleast 3 characters
                        </small>
                      </div>
                    </div>

                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                          htmlFor="customer-last-name"
                        >
                          Last Name
                        </label>
                        <input
                          type="text"
                          id="customer-last-name"
                          className="form-control form-control-lg"
                          name="customer-last-name"
                          value={lastName}
                          onChange={(e) => setLastName(e.target.value)}
                          required
                        />
                        <small
                          className="form-text text-muted"
                          id="last-name-helper"
                        >
                          Last Name should be atleast 3 characters
                        </small>
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label" htmlFor="customer-city">
                          City
                        </label>
                        <input
                          type="text"
                          id="customer-city"
                          className="form-control form-control-lg"
                          name="customer-city"
                          value={city}
                          onChange={(e) => setCity(e.target.value)}
                          required
                        />
                      </div>
                    </div>
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label
                          className="form-label"
                          htmlFor="customer-contact"
                        >
                          Contact Number
                        </label>
                        <input
                          type="tel"
                          id="customer-contact"
                          className="form-control form-control-lg"
                          name="customer-contact"
                          value={phone}
                          onChange={(e) => setPhone(e.target.value)}
                          required
                        />
                        <small className="form-text text-muted">
                          Phone Number should have exactly 10 digits
                        </small>
                      </div>
                    </div>
                  </div>

                  <div className="row mb-5">
                    <div className="col-6">
                      <div className="form-outline">
                        <label
                          className="form-label"
                          htmlFor="customer-occupation"
                        >
                          Occupation
                        </label>
                        <input
                          type="text"
                          id="customer-occupation"
                          className="form-control form-control-lg"
                          name="customer-occupation"
                          value={occupation}
                          onChange={(e) => setOccupation(e.target.value)}
                          required
                        />
                      </div>
                    </div>

                    <div className="col-6">
                      <div className="form-outline">
                        <label className="form-label" htmlFor="customer-dob">
                          date of Birth
                        </label>
                        <input
                          type="date"
                          id="customer-dob"
                          className="form-control form-control-lg"
                          name="customer-dob"
                          value={dob}
                          min="1995-01-01"
                          max={new Date().toLocaleDateString("en-ca")}
                          onChange={(e) => setDob(e.target.value)}
                          required
                        />
                        <small className="form-text text-muted">
                          {" "}
                          Date of Birth should not exceed today's date
                        </small>
                      </div>
                    </div>

                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label">
                          Enter your customer ID
                        </label>
                        <input
                          type="number"
                          value={customerNumber}
                          onChange={(e) => {
                            setCustomerNumber(e.target.value);
                          }}
                          required
                        />
                      </div>
                    </div>

                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label">
                          Enter your password
                        </label>
                        <input
                          type="password"
                          value={customerPassword}
                          onChange={(e) => {
                            setCustomerPassword(e.target.value);
                          }}
                          required
                        />
                      </div>
                    </div>
                  </div>

                  <div className="d-grid gap-2">
                    <button className="btn btn-info" type="submit">
                      Register
                    </button>
                  </div>
                </form>
              </div>

              <div className="d-grid gap-2">
                <p className="text-center">Already have an account?</p>
                <Link to="/" className="btn btn-success">
                  Login Here!
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Register;
