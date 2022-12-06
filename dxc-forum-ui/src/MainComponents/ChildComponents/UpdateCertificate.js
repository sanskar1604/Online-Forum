import React, { Component } from "react";
import CertificationService from "../../Services/CertificationService";
import { withRouter } from "../../Components/CustomNavigation";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";

class UpdateCertification extends Component {
  constructor(props) {
    super(props);

    this.state = {
      id: this.props.params.id,
      empId: "",
      name: "",
      status: "",
      date: "",
    };
    this.changeEmpId = this.changeEmpId.bind(this);
    this.changeName = this.changeName.bind(this);
    this.changeStatus = this.changeStatus.bind(this);
    this.changeDate = this.changeDate.bind(this);
  }

  componentDidMount() {
    CertificationService.getById(this.state.id).then((res) => {
      let certification = res.data;
      this.setState({
        empId: certification.empId,
        name: certification.name,
        status: certification.status,
        date: certification.date,
      });
    });
  }

  update = (e) => {
    e.preventDefault();
    let certificate = {
      empId: this.state.empId,
      name: this.state.name,
      status: this.state.status,
      date: this.state.date,
    };
    CertificationService.update(certificate, this.state.id).then((res) => {
      this.props.navigate(`/certification`);
      window.location.reload(false);
    });
  };
  changeEmpId = (event) => {
    this.setState({ empId: event.target.value });
  };
  changeName = (event) => {
    this.setState({ name: event.target.value });
  };
  changeStatus = (event) => {
    this.setState({ status: event.target.value });
  };
  changeDate = (event) => {
    this.setState({ date: event.target.value });
  };
  cancel() {
    this.props.navigate(`/certification`);
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
                  <a href="/certification">Certification</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  Edit Certificate
                </li>
              </ol>
            </small>
          </nav>

          {/* <i class="fa-solid fa-edit fa-2x d-inline mr-2"></i> */}
          <small>
            <h1 class="d-inline">Edit Certificate</h1>
            <div class="content-container">
              <div class="container-fluid">
                <div class="card shadow-sm mb-5 mt-3">
                  <div className="card-body">
                    <form>
                      <div className="form-group">
                        <label>Employee ID</label>
                        <input
                          placeholder="Emp ID"
                          name="name"
                          className="form-control"
                          value={this.state.empId}
                          onChange={this.changeEmpId}
                        ></input>
                      </div>
                      <div className="form-group">
                        <label>Certificate Name</label>
                        <input
                          placeholder="Name of the certification"
                          name="name"
                          className="form-control"
                          value={this.state.name}
                          onChange={this.changeName}
                        ></input>
                      </div>
                      <div className="form-group">
                        <label>Status</label>
                        <input
                          placeholder="status[yes/no]"
                          name="status"
                          className="form-control"
                          value={this.state.status}
                          onChange={this.changeStatus}
                        ></input>
                      </div>
                      <div className="form-group">
                        <label>Submission Date</label>
                        <input
                          placeholder="Submission Date"
                          name="date"
                          className="form-control"
                          value={this.state.date}
                          onChange={this.changeDate}
                        ></input>
                      </div>
                      <button className="btn btn-success" onClick={this.update}>
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
          </small>
        </div>
      </>
    );
  }
}
export default withRouter(UpdateCertification);
