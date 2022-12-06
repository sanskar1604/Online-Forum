import React, { useEffect, useState } from "react";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import { useParams, useNavigate, Link } from "react-router-dom";
import { initOnLoad } from "apexcharts";
import RFPService from "../../Services/RFPService";
export default function ViewRFP() {
  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "numeric", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };
  const params = useParams();
  const [rfp, setRfp] = useState([]);

  useEffect(() => {
    init();
  }, []);

  const init = (id) => {
    RFPService.getById(params.id)
      .then((response) => {
        setRfp(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      <Navbar />
      {/* <Sidebar /> */}
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
                RFP
              </li>
            </ol>
          </small>
        </nav>
        <small>
          <Link to={`/rfp`} class="btn btn-success text-light">
            Go Back
          </Link>
          <br></br>
          {/* <i class="fa-solid fa-eye fa-2x d-inline mr-2"></i> */}
          <h1 class="d-inline">
            View RFP - <small class="text-success">{rfp.rfpTitle}</small>
          </h1>
        </small>

        <div class="content-container mt-3">
          <div class="container-fluid">
            {/* <div class="card shadow-sm mb-5"> */}
            {/* <div className="card-body"> */}
            {/* <table class="table">
                  <tbody>
                    <tr>
                      <th scope="row">1.</th>
                      <td>ID</td>
                      <td>
                        <b>{rfp.id}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">2.</th>
                      <td>RFP Title</td>
                      <td>
                        <b>{rfp.rfpTitle}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">3.</th>
                      <td>Client</td>
                      <td>
                        <b>{rfp.client}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">4.</th>
                      <td>Status</td>
                      <td>
                        <b>{rfp.status}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">5.</th>
                      <td>Region</td>
                      <td>
                        <b>{rfp.region}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">6.</th>
                      <td>Technology</td>
                      <td>
                        <b>{rfp.technology}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">7.</th>
                      <td>Java Capability-RFP Tea</td>
                      <td>
                        <b>{rfp.javaCapabilityRfpTeam}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">8.</th>
                      <td>DXC Solutioning Lead</td>
                      <td>
                        <b>{rfp.dxcSolutioningLead}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">9.</th>
                      <td>Type</td>
                      <td>
                        <b>{rfp.type}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">10.</th>
                      <td>Total Deal Value</td>
                      <td>
                        <b>{rfp.totalDealValue}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">11.</th>
                      <td>OPX ID</td>
                      <td>
                        <b>{rfp.opxId}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">12.</th>
                      <td>Date Of Entry</td>
                      <td>
                        <b>{rfp.dateOfEntry}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">13.</th>
                      <td>ETA To Submit RFP</td>
                      <td>
                        <b>{rfp.etaToSubmitRfp}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">14.</th>
                      <td>Realization Date</td>
                      <td>
                        <b>{rfp.realizationDate}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">15.</th>
                      <td>TCV USD</td>
                      <td>
                        <b>{rfp.tcvUsd}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">16.</th>
                      <td>Effort</td>
                      <td>
                        <b>{rfp.effort}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">17.</th>
                      <td>Project Planned Status</td>
                      <td>
                        <b>{rfp.projectPlannedStatus}</b>
                      </td>
                    </tr>
                    <tr>
                      <th scope="row">18.</th>
                      <td>Notes</td>
                      <td>
                        <b
                          dangerouslySetInnerHTML={{
                            __html: rfp.notes,
                          }}
                        ></b>
                      </td>
                    </tr>
                  </tbody>
                </table> */}
            <small>
              <small>
                <table id="" class="table table-striped table-bordered">
                  <thead class="thead-light">
                    <tr>
                      <th>RFP Title</th>
                      <th>Client</th>
                      <th>Status</th>
                      <th>Region</th>
                      <th>Technology</th>
                      <th>Java Capability-RFP Team</th>
                      <th>DXC Solutioning Lead</th>
                      <th>Type</th>
                      <th>Notes</th>
                      <th>Total Deal Value</th>
                      <th>OPX ID</th>
                      <th>Date Of Entry</th>
                      <th>ETA to Submit RFP</th>
                      <th>Realization Date (Win)</th>
                      <th>TCV USD</th>
                      <th>Effort (Person Hour)</th>
                      <th>Project Planned Status</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>{rfp.rfpTitle}</td>
                      <td>{rfp.client}</td>
                      <td>{rfp.status}</td>
                      <td>{rfp.region}</td>
                      <td>{rfp.technology}</td>
                      <td>{rfp.javaCapabilityRfpTeam}</td>
                      <td>{rfp.dxcSolutioningLead}</td>
                      <td>{rfp.type}</td>
                      {/* <td dangerouslySetInnerHTML={{ __html: rfp.notes }}></td>
                       */}
                      <td>{rfp.notes}</td>
                      <td>{rfp.totalDealValue}</td>
                      <td>{rfp.opxId}</td>
                      <td>{formatDate(rfp.dateOfEntry)}</td>
                      <td>{formatDate(rfp.etaToSubmitRfp)}</td>
                      <td>{formatDate(rfp.realizationDate)}</td>
                      <td>{rfp.tcvUsd}</td>
                      <td>{rfp.effort}</td>
                      <td>{rfp.projectPlannedStatus}</td>
                    </tr>
                  </tbody>
                </table>
              </small>
            </small>
            {/* </div> */}
            {/* </div> */}
          </div>
        </div>
      </div>
    </>
  );
}
