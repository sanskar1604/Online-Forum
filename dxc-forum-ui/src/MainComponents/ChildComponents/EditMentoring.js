import React, { Component } from "react";
import MentoringService from "../../Services/MentoringService";

import { withRouter } from "../../Components/CustomNavigation";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";

class UpdateMentoring extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.params.id,
      batch: "",
      empId: "",
      name: "",
      email: "",
      heScore: "",
      date: "",
      heRank: "",
      project: "",
      projectTitle: "",
      techStack: "",
      status: "",
    };
    this.changeEmpId = this.changeEmpId.bind(this);
    this.changeBatch = this.changeBatch.bind(this);
    this.changeName = this.changeName.bind(this);
    this.changeEmail = this.changeEmail.bind(this);
    this.changeHeScore = this.changeHeScore.bind(this);
    this.changeDate = this.changeDate.bind(this);
    this.changeHeRank = this.changeHeRank.bind(this);
    this.changeProject = this.changeProject.bind(this);
    this.changeProjectTitle = this.changeProjectTitle.bind(this);
    this.changeTechStack = this.changeTechStack.bind(this);
    this.changeStatus = this.changeStatus.bind(this);
  }

  componentDidMount() {
    MentoringService.getById(this.state.id).then((res) => {
      let mentoring = res.data;
      this.setState({
        batch: mentoring.batch,
        empId: mentoring.empId,
        name: mentoring.name,
        email: mentoring.email,
        heScore: mentoring.heScore,
        date: mentoring.date,
        heRank: mentoring.heRank,
        project: mentoring.project,
        projectTitle: mentoring.projectTitle,
        techStack: mentoring.techStack,
        status: mentoring.status,
      });
    });
  }

  updateMentoringById = (e) => {
    e.preventDefault();
    let mentoring = {
      batch: this.state.batch,
      empId: this.state.empId,
      name: this.state.name,
      email: this.state.email,
      heScore: this.state.heScore,
      date: this.state.date,
      heRank: this.state.heRank,
      project: this.state.project,
      projectTitle: this.state.projectTitle,
      techStack: this.state.techStack,
      status: this.state.status,
    };
    // console.log('training => ' + JSON.stringify(training));
    // console.log('id => ' + JSON.stringify(this.state.id));
    MentoringService.update(mentoring, this.state.id).then((res) => {
      this.props.navigate("/mentoring");
      window.location.reload(false);
    });
  };
  changeName = (event) => {
    this.setState({ name: event.target.value });
  };
  changeBatch = (event) => {
    this.setState({ batch: event.target.value });
  };
  changeEmpId = (event) => {
    this.setState({ empId: event.target.value });
  };
  changeEmail = (event) => {
    this.setState({ email: event.target.value });
  };
  changeHeScore = (event) => {
    this.setState({ heScore: event.target.value });
  };
  changeDate = (event) => {
    this.setState({ date: event.target.value });
  };
  changeHeRank = (event) => {
    this.setState({ heRank: event.target.value });
  };
  changeProject = (event) => {
    this.setState({ project: event.target.value });
  };
  changeStatus = (event) => {
    this.setState({ status: event.target.value });
  };
  changeProjectTitle = (event) => {
    this.setState({ projectTitle: event.target.value });
  };
  changeTechStack = (event) => {
    this.setState({ techStack: event.target.value });
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
                  <a href="/mentoring">Mentoring</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  Edit Mentoring
                </li>
              </ol>
            </small>
          </nav>

          {/* <i class="fa-solid fa-edit fa-2x mr-2 d-inline"></i> */}
          <small>
            <h1 class="d-inline">Edit Mentoring</h1>
            <div class="content-container">
              <div class="container-fluid">
                <div class="card shadow-sm mb-5 mt-3">
                  <div className="card-body">
                    <form>
                      <div class="form-group mt-3">
                        <label>Batch</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Batch"
                          name="batch"
                          value={this.state.batch}
                          onChange={this.changeBatch}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Employee ID</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <small class="text-danger" style={{ fontSize: 10 }}>
                          *Insert Only Numerical Data
                        </small>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Employee ID"
                          name="empId"
                          onChange={this.changeEmpId}
                          value={this.state.empId}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Employee Name</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Employee Name"
                          name="name"
                          onChange={this.changeName}
                          value={this.state.name}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Employee Email</label>
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Employee Email"
                          name="email"
                          onChange={this.changeEmail}
                          value={this.state.email}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>HackerEarth Score</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <small class="text-danger" style={{ fontSize: 10 }}>
                          *Insert Only Numerical Data
                        </small>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="HackerEarth Score"
                          name="heScore"
                          onChange={this.changeHeScore}
                          value={this.state.heScore}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Date</label>
                        <input
                          type="date"
                          class="form-control shadow-sm"
                          placeholder="Date"
                          name="date"
                          onChange={this.changeDate}
                          value={this.state.date}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>HackerEarth Rank</label>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <small class="text-danger" style={{ fontSize: 10 }}>
                          *Insert Only Numerical Data
                        </small>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="HackerEarth Rank"
                          name="heRank"
                          onChange={this.changeHeRank}
                          value={this.state.heRank}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Project</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Project"
                          name="project"
                          onChange={this.changeProject}
                          value={this.state.project}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Project Title</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Project Title"
                          name="projectTitle"
                          onChange={this.changeProjectTitle}
                          value={this.state.projectTitle}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Technology Stack</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Technology Stack"
                          name="techStack"
                          onChange={this.changeTechStack}
                          value={this.state.techStack}
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Project Status</label>
                        <input
                          class="form-control shadow-sm"
                          type="text"
                          placeholder="Project Status"
                          name="status"
                          onChange={this.changeStatus}
                          value={this.state.status}
                        ></input>
                      </div>
                      <button
                        class="btn btn-success mt-3"
                        onClick={this.updateMentoringById}
                      >
                        Update
                      </button>
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
export default withRouter(UpdateMentoring);
