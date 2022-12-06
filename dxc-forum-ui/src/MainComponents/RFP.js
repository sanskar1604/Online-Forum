import { initOnLoad } from "apexcharts";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../Components/Navbar";
import Sidebar from "../Components/Sidebar";
import RFPService from "../Services/RFPService";

function RFP() {
  const navigate = useNavigate();
  // getting all data from db
  const [rfps, setRfp] = useState([]);

  useEffect(() => {
    init();
  }, []);

  const init = () => {
    RFPService.getAll()
      .then((response) => {
        console.log("RFP Data", response.data);
        setRfp(response.data);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };
  const goRouteId = (id) => {
    navigate(`/rfp/estimate_rfp/${id}`);
  };
  // Delete RFP Data by id
  const handleDelete = (id) => {
    RFPService.deleteRFP(id)
      .then((response) => {
        console.log("Data Deleted Successfully");
        init();
      })
      .catch((error) => {
        console.log("Something went wrong", error);
      });
  };
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
                RFP Tracker
              </li>
            </ol>
          </small>
        </nav>

        <div class="container">
          <small>
            <div class="row">
              <div class="col-md-10">
                {/* <i class="far fa-chart-pie font-weight-bold fa-2x d-inline mr-2"></i> */}
                <h1 class="d-inline">RFP Tracker</h1>
              </div>
              <div class="col-md-2 mt-2">
                <a
                  href="/rfp/add-rfp"
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
            {/* <div class="card shadow-sm"> */}
            {/* <div className="card-body"> */}
            <small>
              <table id="" class="table table-striped table-bordered mt-3 mb-5">
                <thead class="thead-light">
                  <tr>
                    <th>#</th>
                    <th>RFP Title</th>
                    <th>Client</th>
                    <th>Status</th>
                    <th>Region</th>
                    <th>Technology</th>
                    <th>Java Capability-RFP Team</th>
                    <th>DXC Solutioning Lead</th>
                    <th>Type</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {rfps.map((rfp, index) => (
                    <tr>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {index + 1}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.rfpTitle}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.client}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.status}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.region}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.technology}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.javaCapabilityRfpTeam}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.dxcSolutioningLead}
                      </td>
                      <td class="rfp-row" onClick={() => goRouteId(rfp.id)}>
                        {rfp.type}
                      </td>

                      <td>
                        <div class="dropdown">
                          <span class="btn btn-sm btn-secondary d-inline">
                            Action&nbsp;
                            <i class="fas fa-caret-down d-inline"></i>
                          </span>
                          <div class="dropdown-content">
                            <Link to={`/rfp/edit_rfp/${rfp.id}`}>Edit</Link>

                            <a
                              class="text-dark"
                              onClick={(e) => {
                                handleDelete(rfp.id);
                              }}
                            >
                              Delete
                            </a>
                            <Link to={`/rfp/view_rfp/${rfp.id}`}>View</Link>
                            {/* <Link to={`/rfp/estimate_rfp/${rfp.id}`}>
                                Estimates
                              </Link> */}
                          </div>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </small>
            {/* </div> */}
            {/* </div> */}
          </div>
        </div>
      </div>
    </>
  );
}

export default RFP;
