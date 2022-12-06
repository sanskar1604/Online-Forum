import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "../Components/Navbar";

function Signup() {
  return (
    <>
      <Navbar />
      <div class="col main pt-5 mt-3">
        <div class="content-container">
          <div class="row mt-5">
            <div class="col-md-6 offset-md-3">
              <div class="container-fluid">
                {/* <div class="jumbotron">
                  <div class="card shadow-sm">
                    <div className="card-body"> */}
                <div class="container text-center">
                  <img
                    src={require("../images/dxc_logo_purple.png")}
                    alt=""
                    height="60"
                    width="80%"
                  />
                </div>
                <h4 class="text-center">Register here</h4>
                <hr />
                <form class="mt-4">
                  <div class="form-group">
                    {/* <label for=""></label> */}
                    <input
                      type="text"
                      class="form-control shadow-sm"
                      placeholder="Employee ID"
                    ></input>
                  </div>
                  <div class="form-group">
                    {/* <label for=""></label> */}
                    <input
                      type="text"
                      class="form-control shadow-sm"
                      placeholder="Name"
                      required
                    ></input>
                  </div>
                  <div class="form-group">
                    {/* <label for=""></label> */}
                    <input
                      type="email"
                      class="form-control shadow-sm"
                      placeholder="Email"
                    ></input>
                  </div>
                  <div class="form-group">
                    {/* <label for=""></label> */}
                    <input
                      type="password"
                      class="form-control shadow-sm"
                      placeholder="Password"
                    ></input>
                  </div>
                  <button class="btn btn-dark text-light">Signup</button>
                </form>
                <div class="mt-2">
                  <span style={{ fontSize: 15 }}>
                    Already Register ?&nbsp;
                    <a href="/login" class="text-danger">
                      Login Here
                    </a>
                  </span>
                </div>
                {/* </div>
                  </div>
                </div> */}
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Signup;
