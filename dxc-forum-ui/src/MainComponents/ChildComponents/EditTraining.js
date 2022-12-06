import React, { Component } from "react";
import { withRouter } from "../../Components/CustomNavigation";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import trainingService from "../../Services/trainingService";

class UpdateTraining extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.params.id,
      topicName: "",
      batch: "",
      trainerName: "",
      batchSize: "",
      sessionDate: "",
      sessionTime: "",
      sessionLink: "",
      sessionVideo: "",
    };
    this.changeTopicName = this.changeTopicName.bind(this);
    this.changeBatch = this.changeBatch.bind(this);
    this.changeTrainerName = this.changeTrainerName.bind(this);
    this.changeBatchSize = this.changeBatchSize.bind(this);
    this.changeSessionDate = this.changeSessionDate.bind(this);
    this.changeSessionTime = this.changeSessionTime.bind(this);
    this.changeSessionLink = this.changeSessionLink.bind(this);
    this.changeSessionVideo = this.changeSessionVideo.bind(this);
    this.updateTrainingById = this.updateTrainingById.bind(this);
  }

  componentDidMount() {
    trainingService.getTrainingById(this.state.id).then((res) => {
      let training = res.data;
      this.setState({
        topicName: training.topicName,
        batch: training.batch,
        trainerName: training.trainerName,
        batchSize: training.batchSize,
        sessionDate: training.sessionDate,
        sessionTime: training.sessionTime,
        sessionLink: training.sessionLink,
        sessionVideo: training.sessionVideo,
      });
    });
  }

  updateTrainingById = (e) => {
    e.preventDefault();
    let training = {
      topicName: this.state.topicName,
      batch: this.state.batch,
      trainerName: this.state.trainerName,
      batchSize: this.state.batchSize,
      sessionDate: this.state.sessionDate,
      sessionTime: this.state.sessionTime,
      sessionLink: this.state.sessionLink,
      sessionVideo: this.state.sessionVideo,
    };
    // console.log('training => ' + JSON.stringify(training));
    // console.log('id => ' + JSON.stringify(this.state.id));
    trainingService.updateTraining(training, this.state.id).then((res) => {
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
  changeSessionTime = (event) => {
    this.setState({ sessionTime: event.target.value });
  };
  changeSessionLink = (event) => {
    this.setState({ sessionLink: event.target.value });
  };
  changeSessionVideo = (event) => {
    this.setState({ sessionVideo: event.target.value });
  };
  cancel() {
    // this.props.history.push(`/training`);
    this.props.navigate("/training");
    window.location.reload(false);
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
                <li class="breadcrumb-item">
                  <a href="/training">Training</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  Edit Training
                </li>
              </ol>
            </small>
          </nav>

          {/* <i class="fa-solid fa-edit fa-2x d-inline mr-2"></i> */}
          <h1 class="d-inline">Edit Training</h1>
          <div class="content-container">
            <div class="container-fluid">
              <div class="card shadow-sm mb-5 mt-3">
                <div className="card-body">
                  <form>
                    <div className="form-group">
                      <label> Batch</label>
                      <input
                        placeholder="Batch No."
                        name="batch"
                        className="form-control"
                        value={this.state.batch}
                        onChange={this.changeBatch}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label> Topic Name</label>
                      <input
                        placeholder="Topic Name"
                        name="topicName"
                        className="form-control"
                        value={this.state.topicName}
                        onChange={this.changeTopicName}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Trainer Name</label>
                      <input
                        placeholder="Trainer Name"
                        name="trainerName"
                        className="form-control"
                        value={this.state.trainerName}
                        onChange={this.changeTrainerName}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Batch Size</label>
                      <input
                        placeholder="Batch Size"
                        name="batchSize"
                        className="form-control"
                        value={this.state.batchSize}
                        onChange={this.changeBatchSize}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Session Date</label>
                      <input
                        placeholder="Session Date"
                        name="sessionDate"
                        className="form-control"
                        value={this.state.sessionDate}
                        onChange={this.changeSessionDate}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Session Time</label>
                      <input
                        placeholder="Session Time"
                        name="sessionTime"
                        className="form-control"
                        value={this.state.sessionTime}
                        onChange={this.changeSessionTime}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Session Link</label>
                      <input
                        placeholder="Session Link"
                        name="sessionLink"
                        className="form-control"
                        value={this.state.sessionLink}
                        onChange={this.changeSessionLink}
                      ></input>
                    </div>
                    <div className="form-group">
                      <label>Recorded Video</label>
                      <input
                        placeholder="Recorded Video"
                        name="sessionVideo"
                        className="form-control"
                        value={this.state.sessionVideo}
                        onChange={this.changeSessionVideo}
                      />
                    </div>
                    <button
                      className="btn btn-success"
                      onClick={this.updateTrainingById}
                    >
                      Save
                    </button>
                    <button
                      className="btn btn-danger"
                      onClick={this.cancel.bind(this)}
                      style={{ marginLeft: "10px" }}
                    >
                      Reset
                    </button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default withRouter(UpdateTraining);
