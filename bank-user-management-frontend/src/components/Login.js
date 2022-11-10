import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as utils from "../services/requests";

function Login() {
  const navigate = useNavigate();

  const route_ = (path) => {
    navigate(path);
  };

  let [customerId, setCustomerId] = useState(0);
  let [customerPassword, setCustomerPassword] = useState("");

  let handleSubmit = (e) => {
    e.preventDefault();
    utils
      .post("/", {
        customerId: customerId,
        customerPassword: customerPassword,
      })
      .then((response) => {
        if (response.data === "Login Details Correct") {
          sessionStorage.setItem("user", customerId);
          route_("/menu");
        } else if (response.data === "Login Details incorrect") {
          window.alert("Invalid credentials");
        } else {
          window.alert("Please Create an account to Login");
          route_("/register");
        }
        console.log(response.data);
      })
      .catch((err) => {
        console.log(err.response.status);
      });
  };

  return (
    <div className="container py-2 h-100">
      <div className="row d-flex justify-content-center align-items-center h-100">
        <div className="col-12 col-md-8 col-lg-6 col-xl-5">
          <div
            className="card bg-white text-dark border border-success border-2"
            style={{ borderRadius: 2 + "rem" }}
          >
            <div className="card-body p-5 text-center">
              <div className="mb-md-5 mt-md-4 pb-3">
                <h2 className="fw-bold mb-2 text-uppercase">Login</h2>
                <p className="text-dark-50 mb-5">
                  Please enter your Customer Id and password!
                </p>
                <form onSubmit={handleSubmit}>
                  <div className="form-outline mb-4">
                    <input
                      type="number"
                      id="customer-id"
                      className="form-control form-control-lg"
                      name="customer-id"
                      value={customerId}
                      onChange={(e) => setCustomerId(e.target.value)}
                    />
                    <label className="form-label" htmlFor="customer-id">
                      Customer Id
                    </label>
                  </div>

                  <div className="form-outline mb-4">
                    <input
                      type="password"
                      id="customer-password"
                      className="form-control form-control-lg"
                      name="customer-password"
                      value={customerPassword}
                      onChange={(e) => setCustomerPassword(e.target.value)}
                    />
                    <label className="form-label" htmlFor="customer-password">
                      Password
                    </label>
                  </div>

                  <div className="d-grid gap-2">
                    <button className="btn btn-info" type="submit">
                      Login
                    </button>
                  </div>
                </form>
              </div>

              <div className="d-grid gap-2">
                <p className="text-center">Don't have an account?</p>
                <Link to="/register" className="btn btn-success">
                  Register With Us!
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
