import React, { Component } from "react";
import { withRouter } from "../../Components/CustomNavigation";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import RFPService from "../../Services/RFPService";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";
class UpdateRFP extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.params.id,
      rfpTitle: "",
      client: "",
      status: "",
      region: "",
      technology: "",
      javaCapabilityRfpTeam: "",
      dxcSolutioningLead: "",
      type: "",
      totalDealValue: "",
      opxId: "",
      dateOfEntry: "",
      etaToSubmitRfp: "",
      realizationDate: "",
      tcvUsd: "",
      effort: "",
      projectPlannedStatus: "",
      notes: "",
    };

    this.changeRfpTitle = this.changeRfpTitle.bind(this);
    this.changeClient = this.changeClient.bind(this);
    this.changeStatus = this.changeStatus.bind(this);
    this.changeRegion = this.changeRegion.bind(this);
    this.changeTechnology = this.changeTechnology.bind(this);
    this.changeJavaCapabilityRfpTeam =
      this.changeJavaCapabilityRfpTeam.bind(this);
    this.changeDxcSolutioningLead = this.changeDxcSolutioningLead.bind(this);
    this.changeType = this.changeType.bind(this);
    this.changeTotalDealValue = this.changeTotalDealValue.bind(this);
    this.changeOpxId = this.changeOpxId.bind(this);
    this.changeDateOfEntry = this.changeDateOfEntry.bind(this);
    this.changeEtaToSubmitRfp = this.changeEtaToSubmitRfp.bind(this);
    this.changeRealizationDate = this.changeRealizationDate.bind(this);
    this.changeTcvUsd = this.changeTcvUsd.bind(this);
    this.changeEffort = this.changeEffort.bind(this);
    this.changeProjectPlannedStatus =
      this.changeProjectPlannedStatus.bind(this);
    this.changeNotes = this.changeNotes.bind(this);
  }
  componentDidMount() {
    RFPService.getById(this.state.id).then((response) => {
      let rfp = response.data;
      this.setState({
        rfpTitle: rfp.rfpTitle,
        client: rfp.client,
        status: rfp.status,
        region: rfp.region,
        technology: rfp.technology,
        javaCapabilityRfpTeam: rfp.javaCapabilityRfpTeam,
        dxcSolutioningLead: rfp.dxcSolutioningLead,
        type: rfp.type,
        totalDealValue: rfp.totalDealValue,
        opxId: rfp.opxId,
        dateOfEntry: rfp.dateOfEntry,
        etaToSubmitRfp: rfp.etaToSubmitRfp,
        realizationDate: rfp.realizationDate,
        tcvUsd: rfp.tcvUsd,
        effort: rfp.effort,
        projectPlannedStatus: rfp.projectPlannedStatus,
        notes: rfp.notes,
      });
    });
  }

  updateRFPById = (e) => {
    e.preventDefault();
    let rfp = {
      rfpTitle: this.state.rfpTitle,
      client: this.state.client,
      status: this.state.status,
      region: this.state.region,
      technology: this.state.technology,
      javaCapabilityRfpTeam: this.state.javaCapabilityRfpTeam,
      dxcSolutioningLead: this.state.dxcSolutioningLead,
      type: this.state.type,
      totalDealValue: this.state.totalDealValue,
      opxId: this.state.opxId,
      dateOfEntry: this.state.dateOfEntry,
      etaToSubmitRfp: this.state.etaToSubmitRfp,
      realizationDate: this.state.realizationDate,
      tcvUsd: this.state.tcvUsd,
      effort: this.state.effort,
      projectPlannedStatus: this.state.projectPlannedStatus,
      notes: this.state.notes,
    };
    RFPService.updateRFP(this.state.id, rfp)
      .then((response) => {
        this.props.navigate("/rfp");
        window.location.reload(false);
      })
      .catch((error) => {
        console.log(error);
      });
  };
  changeRfpTitle = (event) => {
    this.setState({ rfpTitle: event.target.value });
  };
  changeClient = (event) => {
    this.setState({ client: event.target.value });
  };
  changeStatus = (event) => {
    this.setState({ status: event.target.value });
  };
  changeRegion = (event) => {
    this.setState({ region: event.target.value });
  };
  changeTechnology = (event) => {
    this.setState({ technology: event.target.value });
  };
  changeJavaCapabilityRfpTeam = (event) => {
    this.setState({ javaCapabilityRfpTeam: event.target.value });
  };
  changeDxcSolutioningLead = (event) => {
    this.setState({ dxcSolutioningLead: event.target.value });
  };
  changeType = (event) => {
    this.setState({ type: event.target.value });
  };
  changeTotalDealValue = (event) => {
    this.setState({ totalDealValue: event.target.value });
  };
  changeOpxId = (event) => {
    this.setState({ opxId: event.target.value });
  };
  changeDateOfEntry = (event) => {
    this.setState({ dateOfEntry: event.target.value });
  };
  changeEtaToSubmitRfp = (event) => {
    this.setState({ etaToSubmitRfp: event.target.value });
  };
  changeRealizationDate = (event) => {
    this.setState({ realizationDate: event.target.value });
  };
  changeTcvUsd = (event) => {
    this.setState({ tcvUsd: event.target.value });
  };
  changeEffort = (event) => {
    this.setState({ effort: event.target.value });
  };
  changeProjectPlannedStatus = (event) => {
    this.setState({ projectPlannedStatus: event.target.value });
  };
  changeNotes = (event) => {
    this.setState({ notes: event.target.value });
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
                  <a href="/rfp">RFP Tracker</a>
                </li>
                <li class="breadcrumb-item active" aria-current="page">
                  Add RFP Data
                </li>
              </ol>
            </small>
          </nav>

          {/* <i class="fa-solid fa-edit fa-2x d-inline mr-2"></i> */}
          <small>
            <h1 class="d-inline">
              Edit RFP -{" "}
              <small class="text-success">{this.state.rfpTitle}</small>
            </h1>
            <div class="content-container">
              <div class="container-fluid">
                <div class="card shadow-sm mb-5 mt-3">
                  <div className="card-body">
                    <form>
                      <div class="form-group mt-3">
                        <label>RFP Title</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="RFP Title"
                          name="rfpTitle"
                          value={this.state.rfpTitle}
                          onChange={this.changeRfpTitle}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Client</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Client"
                          name="client"
                          onChange={this.changeClient}
                          value={this.state.client}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Status</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Status"
                          name="status"
                          onChange={this.changeStatus}
                          value={this.state.status}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Region</label>
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Region"
                          name="region"
                          onChange={this.changeRegion}
                          value={this.state.region}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Technology</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Technology"
                          name="technology"
                          onChange={this.changeTechnology}
                          value={this.state.technology}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Java Capability RFP Team</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Java Capability RFP Team"
                          name="javaCapabilityRfpTeam"
                          onChange={this.changeJavaCapabilityRfpTeam}
                          value={this.state.javaCapabilityRfpTeam}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>DXC Solution Lead</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="DXC Solution Lead"
                          name="dxcSolutioningLead"
                          onChange={this.changeDxcSolutioningLead}
                          value={this.state.dxcSolutioningLead}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Type</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Type"
                          name="type"
                          onChange={this.changeType}
                          value={this.state.type}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Total Deal Value</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Total Deal Value"
                          name="totalDealValue"
                          onChange={this.changeTotalDealValue}
                          value={this.state.totalDealValue}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>OPX ID</label>
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="OPX ID"
                          name="opxId"
                          onChange={this.changeOpxId}
                          value={this.state.opxId}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Date Of Entry</label>
                        <input
                          class="form-control shadow-sm"
                          type="date"
                          placeholder="Date Of Entry"
                          name="dateOfEntry"
                          onChange={this.changeDateOfEntry}
                          value={this.state.dateOfEntry}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>ETA To Submit RFP</label>
                        <input
                          class="form-control shadow-sm"
                          type="date"
                          placeholder="ETA To Submit RFP"
                          name="etaToSubmitRfp"
                          onChange={this.changeEtaToSubmitRfp}
                          value={this.state.etaToSubmitRfp}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Realization Date (Win)</label>
                        <input
                          class="form-control shadow-sm"
                          type="date"
                          placeholder="Realization Date (Win)"
                          name="realizationDate"
                          onChange={this.changeRealizationDate}
                          value={this.state.realizationDate}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>TCV USD</label>
                        <input
                          class="form-control shadow-sm"
                          type="text"
                          placeholder="TCV USD"
                          name="tcvUsd"
                          onChange={this.changeTcvUsd}
                          value={this.state.tcvUsd}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Effort (Person Hour)</label>
                        <input
                          class="form-control shadow-sm"
                          type="text"
                          placeholder="Effort (Person Hour)"
                          name="effort"
                          onChange={this.changeEffort}
                          value={this.state.effort}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Project Planned Status</label>
                        <input
                          class="form-control shadow-sm"
                          type="text"
                          placeholder="Project Planned Status"
                          name="projectPlannedStatus"
                          onChange={this.changeProjectPlannedStatus}
                          value={this.state.projectPlannedStatus}
                          required
                        ></input>
                      </div>
                      <div class="form-group mt-3">
                        <label>Notes</label>
                        <textarea
                          class="shadow-sm form-control"
                          placeholder="Notes"
                          rows="4"
                          onChange={this.changeNotes}
                          value={this.state.notes}
                          required
                        ></textarea>
                      </div>
                      {/* <div class="form-group mt-3">
                        <label>Notes</label>
                        <div className="App">
                          <CKEditor
                            editor={Editor}
                            data=""
                            onReady={(editor) => {
                              console.log("Editor is ready to use!", editor);
                            }}
                            onChange={(event, editor) => {
                              const data = editor.getData();

                              console.log({ event, editor, data });
                            }}
                            onBlur={(event, editor) => {
                              console.log("Blur.", editor);
                            }}
                            onFocus={(event, editor) => {
                              console.log("Focus.", editor);
                            }}
                          />
                        </div>
                      </div> */}
                      <button
                        class="btn btn-success mt-3"
                        onClick={this.updateRFPById}
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
export default withRouter(UpdateRFP);
