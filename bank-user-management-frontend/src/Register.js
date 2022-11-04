import { useState } from "react";

function Register() {
  let [firstName, setFirstName] = useState("");
  let [lastName, setLastName] = useState("");
  let [city, setCity] = useState("");
  let [phone, setPhone] = useState(0);
  let [occupation, setOccupation] = useState("");
  let [dob, setDob] = useState();

  let handleSubmit = (e) => {
    e.preventDefault();

    let customer = {
      firstName,
      lastName,
      city,
      phone,
      occupation,
      dob,
    };

    console.log(customer);
  };

  return (
    <div className="container py-2 h-100">
      <div className="row d-flex justify-content-center align-items-center h-100">
        <div className="col-12 col-xl-7">
          <div
            className="card bg-white text-dark border border-success border-2"
            style={{ borderRadius: 2 + "rem" }}
          >
            <div className="card-body p-5 text-center">
              <div className="mb-md-3 mt-md-3 pb-3">
                <h2 className="fw-bold mb-2 text-uppercase">Register</h2>
                <p className="text-dark-50 mb-5">Please enter your details!</p>
                <form onSubmit={handleSubmit}>
                  <div className="row">
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label" for="customer-first-name">
                          First Name
                        </label>
                        <input
                          type="text"
                          id="customer-first-name"
                          className="form-control form-control-lg"
                          name="customer-first-name"
                          value={firstName}
                          onChange={(e) => setFirstName(e.target.value)}
                        />
                      </div>
                    </div>

                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label" for="customer-last-name">
                          Last Name
                        </label>
                        <input
                          type="text"
                          id="customer-last-name"
                          className="form-control form-control-lg"
                          name="customer-last-name"
                          value={lastName}
                          onChange={(e) => setLastName(e.target.value)}
                        />
                      </div>
                    </div>
                  </div>

                  <div className="row">
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label" for="customer-city">
                          City
                        </label>
                        <input
                          type="text"
                          id="customer-city"
                          className="form-control form-control-lg"
                          name="customer-city"
                          value={city}
                          onChange={(e) => setCity(e.target.value)}
                        />
                      </div>
                    </div>
                    <div className="col-6">
                      <div className="form-outline mb-2">
                        <label className="form-label" for="customer-contact">
                          Contact Number
                        </label>
                        <input
                          type="tel"
                          id="customer-contact"
                          className="form-control form-control-lg"
                          name="customer-contact"
                          value={phone}
                          onChange={(e) => setPhone(e.target.value)}
                        />
                      </div>
                    </div>
                  </div>

                  <div className="row mb-5">
                    <div className="col-6">
                      <div className="form-outline">
                        <label className="form-label" for="customer-occupation">
                          Occupation
                        </label>
                        <input
                          type="text"
                          id="customer-occupation"
                          className="form-control form-control-lg"
                          name="customer-occupation"
                          value={occupation}
                          onChange={(e) => setOccupation(e.target.value)}
                        />
                      </div>
                    </div>

                    <div className="col-6">
                      <div className="form-outline">
                        <label className="form-label" for="customer-dob">
                          date of Birth
                        </label>
                        <input
                          type="date"
                          id="customer-dob"
                          className="form-control form-control-lg"
                          name="customer-dob"
                          value={dob}
                          onChange={(e) => setDob(e.target.value)}
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
                <button className="btn btn-success">Login Here!</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Register;
