import React, { Component } from "react";
import { useNavigate } from "react-router-dom";
import "jquery/dist/jquery.min.js";
import { Link } from "react-router-dom";
import trainingService from "../Services/trainingService";
import { withRouter } from "../Components/CustomNavigation";
import Navbar from "../Components/Navbar";
import Sidebar from "../Components/Sidebar";

class TrainingComponents extends Component {
  formatDate = (dateString) => {
    const options = { year: "numeric", month: "numeric", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };
  constructor(props) {
    super(props);

    this.state = {
      trainings: [],
    };
    this.deleteTraining = this.deleteTraining.bind(this);
    this.linkButton = this.linkButton.bind(this);
  }
  deleteTraining = (id) => {
    trainingService.deleteTraining(id).then((res) => {
      this.setState({
        trainings: this.state.trainings.filter(
          (training) => training.id !== id
        ),
      });
    });
  };

  componentDidMount() {
    trainingService.uploadSessions().then((res) => {
      this.setState({ trainings: res.data });
    });
  }

  linkButton(link) {
    window.open(link);
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
                  Training
                </li>
              </ol>
            </small>
          </nav>

          <div class="container">
            <small>
              <div class="row">
                <div class="col-md-9">
                  {/* <i class="fa-solid fa-paper-plane fa-2x mr-2 d-inline"></i> */}
                  <h1 class="d-inline">Training</h1>
                </div>
                <div class="col-md-3 mt-2">
                  <a
                    href="http://localhost:9090/download/training.xlsx"
                    class="btn btn-primary mr-2"
                  >
                    <i class="fa fa-download mr-2"></i>
                    Export
                  </a>
                  <a
                    href="/training/add-training"
                    class="btn btn-md btn-secondary d-inline text-light"
                  >
                    Add Data
                  </a>
                </div>
              </div>
            </small>
          </div>
          <div class="content-container">
            <div class="container-fluid">
              {/* <div class="card shadow-sm mb-5">
                <div className="card-body"> */}
              <small>
                <table class="table table-striped table-bordered mt-3 mb-5">
                  <thead class="thead-light">
                    <tr>
                      <th>#</th>
                      <th> Batch</th>
                      <th> Topic</th>
                      <th> Trainer Name</th>
                      <th> Batch Size</th>
                      <th> Session Date</th>
                      <th> Session Link</th>
                      <th> Recorded Video</th>
                      <th>Action </th>
                    </tr>
                  </thead>
                  <tbody>
                    {this.state.trainings.map((training, index) => (
                      <tr key={training.id}>
                        <td> {index + 1}</td>
                        <td> {training.batch}</td>
                        <td> {training.topicName}</td>
                        <td className="col-1"> {training.trainerName}</td>
                        <td className="col-1"> {training.batchSize}</td>
                        <td> {this.formatDate(training.sessionDate)}</td>
                        <td className="text-center">
                          {" "}
                          <button
                            className="btn btn-info btn-sm "
                            onClick={() =>
                              this.linkButton(training.sessionLink)
                            }
                          >
                            Click Here
                          </button>
                        </td>
                        <td className="text-center">
                          {" "}
                          <button
                            className="btn btn-info btn-sm"
                            onClick={() =>
                              this.linkButton(training.sessionVideo)
                            }
                          >
                            Click Here
                          </button>
                        </td>
                        {/* <td>
                              <Link
                                to={`/training/${training.id}`}
                                class="btn btn-sm btn-success text-light mb-1"
                                // style={{ marginRight: 1 }}
                              >
                                Edit
                              </Link>
                              <a
                                class="btn btn-danger btn-sm text-light"
                                onClick={() => this.deleteTraining(training.id)}
                              >
                                Delete
                              </a>
                            </td> */}
                        <td>
                          <div class="dropdown">
                            <span class="btn btn-sm btn-secondary d-inline">
                              Action&nbsp;
                              <i class="fas fa-caret-down d-inline"></i>
                            </span>
                            <div class="dropdown-content">
                              <Link to={`/training/${training.id}`}>Edit</Link>

                              <a
                                onClick={() => this.deleteTraining(training.id)}
                              >
                                Delete
                              </a>
                            </div>
                          </div>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </small>
              {/* </div>
              </div> */}
            </div>
          </div>
        </div>
      </>
    );
  }
}
export default withRouter(TrainingComponents);
