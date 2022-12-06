import React, { Component } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { withRouter } from "../../Components/CustomNavigation";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import trainingService from "../../Services/trainingService";
import UploadExcel from "./UploadExcel";

class AddTrainingComponent extends Component {
  constructor(props) {
    super(props);

    this.state = {
      trainings: [],
      topicName: "",
      batch: "",
      trainerName: "",
      batchSize: "",
      sessionDate: "",
      sessionLink: "",
      sessionVideo: "",
    };
    this.changeTopicName = this.changeTopicName.bind(this);
    this.changeBatch = this.changeBatch.bind(this);
    this.changeTrainerName = this.changeTrainerName.bind(this);
    this.changeBatchSize = this.changeBatchSize.bind(this);
    this.changeSessionDate = this.changeSessionDate.bind(this);
    this.changeSessionLink = this.changeSessionLink.bind(this);
    this.changeSessionVideo = this.changeSessionVideo.bind(this);
    this.saveTraining = this.saveTraining.bind(this);
  }

  saveTraining = (e) => {
    e.preventDefault();
    let training = {
      topicName: this.state.topicName,
      batch: this.state.batch,
      trainerName: this.state.trainerName,
      batchSize: this.state.batchSize,
      sessionDate: this.state.sessionDate,
      sessionLink: this.state.sessionLink,
      sessionVideo: this.state.sessionVideo,
    };

    trainingService.createTraining(training).then((res) => {
      this.props.navigate("/training");
      window.location.reload(false);
    });
  };

  changeTopicName = (event) => {
    this.setState({ topicName: event.target.value });
  };
  changeBatch = (event) => {
    this.setState({ batch: event.target.value });
  };
  changeTrainerName = (event) => {
    this.setState({ trainerName: event.target.value });
  };
  changeBatchSize = (event) => {
    this.setState({ batchSize: event.target.value });
  };
  changeSessionDate = (event) => {
    this.setState({ sessionDate: event.target.value });
  };
  changeSessionLink = (event) => {
    this.setState({ sessionLink: event.target.value });
  };
  changeSessionVideo = (event) => {
    this.setState({ sessionVideo: event.target.value });
  };

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
                <li class="breadcrumb-item">
                  <a href="/training">Training</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  Add Training
                </li>
              </ol>
            </small>
          </nav>

          {/* <i class="fa-solid fa-plus fa-2x d-inline mr-2"></i> */}
          <small>
            <h1 class="d-inline">Add Training</h1>
            <div class="content-container">
              <div class="container-fluid">
                <div class="card shadow-sm mb-5 mt-3">
                  <div className="card-body">
                    <UploadExcel />
                    <div class="divider d-flex align-items-center my-4">
                      <p class="text-center fw-bold mx-3 mb-0">Or</p>
                    </div>
                    <form>
                      <div class="form-group mt-3">
                        <label for="validationCustom01">Batch</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          id="validationCustom01"
                          placeholder="Batch"
                          name="batch"
                          value={this.state.batch}
                          onChange={this.changeBatch}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label for="validationCustom01">Topic</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          id="validationCustom01"
                          placeholder="Topic"
                          name="topic_name"
                          value={this.state.topicName}
                          onChange={this.changeTopicName}
                        ></input>
                      </div>

                      <div class="form-group mt-3">
                        <label for="validationCustom02">Trainer Name</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          id="validationCustom02"
                          placeholder="Trainer Name"
                          name="trainer_name"
                          value={this.state.trainerName}
                          onChange={this.changeTrainerName}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label for="validationCustom02">Batch Size</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          id="validationCustom02"
                          placeholder="Batch Size"
                          name="batch_size"
                          value={this.state.batchSize}
                          onChange={this.changeBatchSize}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label for="validationCustom03">Session Date</label>
                        <input
                          type="date"
                          class="form-control shadow-sm"
                          id="validationCustom03"
                          placeholder="Session Date"
                          name="session_date"
                          value={this.state.sessionDate}
                          onChange={this.changeSessionDate}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label for="validationCustom05">Session Link</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          id="validationCustom05"
                          placeholder="Session Link"
                          name="session_link"
                          value={this.state.sessionLink}
                          onChange={this.changeSessionLink}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label for="validationCustom06">Recorded Video</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          id="validationCustom06"
                          placeholder="Session Video"
                          name="session_video"
                          value={this.state.sessionVideo}
                          onChange={this.changeSessionVideo}
                          required
                        ></input>
                      </div>
                      <div>
                        <button
                          class="btn btn-success mt-3"
                          onClick={this.saveTraining}
                        >
                          Add
                        </button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </small>
        </div>
      </>
    );
  }
}

export default withRouter(AddTrainingComponent);
