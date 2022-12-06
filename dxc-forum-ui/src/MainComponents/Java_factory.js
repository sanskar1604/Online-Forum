import React, { Component } from "react";
import { Link } from "react-router-dom";
import Navbar from "../Components/Navbar";
import Sidebar from "../Components/Sidebar";
import JavaFactoryService from "../Services/JavaFactoryService";

class Java_factory extends Component {
  constructor(props) {
    super(props);
    this.state = {
      questions: [],
    };
  }
  componentDidMount() {
    JavaFactoryService.getAllQues().then((res) => {
      console.log("Question:", res.data);
      this.setState({ questions: res.data });
    });

    for (let key in this.state.questions) {
      console.log(key["title"]);
    }
  }

  render() {
    return (
      <>
        <Navbar />
        <Sidebar />
        <div class="col main pt-5 mt-3">
          <nav aria-label="breadcrumb">
            <small>
              <ol class="breadcrumb">
                <li class="breadcrumb-item">
                  <a href="/">Home</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  Java Factory
                </li>
              </ol>
            </small>
          </nav>

          <div class="container">
            <small>
              <div class="row">
                <div class="col-md-10">
                  <h1 class="d-inline">All Questions</h1>
                </div>
                <div class="col-md-2 mt-2">
                  <a
                    href="/java_factory/question"
                    class="btn btn-md btn-secondary d-inline text-light"
                  >
                    Post Question
                  </a>
                </div>
              </div>
            </small>
          </div>
          <div class="content-container">
            <div class="container-fluid">
              <small>
                <div class="card shadow-sm mb-5 mt-3">
                  <div className="card-body">
                    {this.state.questions.map((question) => (
                      <>
                        <div class="container-fluid">
                          <div class="row">
                            {/* <div class="col-md-2 col-lg-2 ml-3 col-sm-10">
                            <p>0 Votes</p>
                            <p>0 Views</p>
                            <p>0 answers</p>
                          </div> */}
                            <div class="col-md-10 col-lg-10 col-sm-10">
                              <Link
                                to={`/java_factory/answer/${question.id}`}
                                class="questions"
                              >
                                <h5 class="text-primary">{question.title}</h5>
                                <p
                                  class="text-dark"
                                  dangerouslySetInnerHTML={{
                                    __html: question.body,
                                  }}
                                ></p>
                              </Link>
                              {/* <span class="badge text-bg-info mb-4 mx-3 text-dark">
                              React JS
                            </span>
                            <span class="badge text-bg-info text-dark">
                              Node Js
                            </span> */}
                              <hr />
                            </div>
                            <hr></hr>
                          </div>
                        </div>
                      </>
                    ))}
                  </div>
                </div>
              </small>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default Java_factory;
