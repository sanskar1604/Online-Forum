import React, { Component } from "react";
import { Link } from "react-router-dom";
import Navbar from "../Components/Navbar";
import Sidebar from "../Components/Sidebar";
import ConsultancyService from "../Services/JavaConsultancyService";

const formatDate = (dateString) => {
  const options = { year: "numeric", month: "short", day: "numeric" };
  return new Date(dateString).toLocaleDateString(undefined, options);
};

class Consultancy extends Component {
  constructor(props) {
    super(props);
    this.state = {
      questions: [],
    };
  }

  componentDidMount() {
    ConsultancyService.getAllQues().then((res) => {
      console.log("Question:", res.data);
      this.setState({ questions: res.data });
    });

    // .catch((error) => {
    //   console.log("Something went wrong", error);
    // });
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
                  Java Consultancy
                </li>
              </ol>
            </small>
          </nav>
          {/* <p class="lead d-none d-sm-block">Add Employee Details and Records</p>
           */}

          <div class="container">
            <small>
              <div class="row">
                <div class="col-md-10">
                  <h1 class="d-inline">Raised Tickets</h1>
                </div>
                <div class="col-md-2 mt-2">
                  <a
                    href="/Consultancy/ConsultancyQuestion"
                    class="btn btn-md btn-secondary d-inline text-light"
                  >
                    Raise new ticket
                  </a>
                </div>
              </div>
            </small>
          </div>
          <div class="content-container">
            <div class="container-fluid">
              <small>
                <div class="row">
                  {this.state.questions.map((question) => (
                    <div class="col-md-4 col-sm-12 col-lg-4 mt-3">
                      <div class="card shadow-sm mb-5">
                        <div className="card-body">
                          <div class="row">
                            <div class="col-md-6">
                              <i class="fa-regular fa-pen-to-square fa-1x d-inline text-success"></i>
                              &nbsp;
                              <p class="d-inline">{question.category}</p>
                            </div>
                            <div class="col-md-6">
                              <p align="right">
                                <b>DF{question.id}</b>
                              </p>
                            </div>
                          </div>

                          <div class="container-fluid">
                            <Link
                              to={`/Consultancy/ConsultancyAnswer/${question.id}`}
                              class="questions"
                            >
                              <h5 class="text-primary question_body">
                                {question.title}
                              </h5>
                              {/* <p class="text-dark">
                              <span
                                class="question_body"
                                dangerouslySetInnerHTML={{
                                  __html: question.body,
                                }}
                              ></span>
                            </p> */}
                            </Link>
                            <small>
                              <br></br>
                              <b>{formatDate(question.createdDate)}</b>
                            </small>
                          </div>
                        </div>
                      </div>
                    </div>
                  ))}
                </div>
              </small>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default Consultancy;
