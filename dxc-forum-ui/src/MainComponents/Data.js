import { initOnLoad } from "apexcharts";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../Components/Navbar";
import Sidebar from "../Components/Sidebar";
import dataService from "../Services/dataService";
import { useParams } from "react-router-dom";
function Data() {
  const navigate = useNavigate();
  const params=useParams();
  // getting all data from db
  const [datas, setData] = useState([]);

  useEffect(() => {
    init();
  }, []);

  const init = () => {
    dataService.getAll()
      .then((response) => {
        console.log("Detailed Data", response.data);
        setData(response.data);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };
  const goRouteId = (id) => {
    navigate(`/rfp/estimate_data/data${id}`);
  };
  // Delete RFP Data by id
  const handleDelete = (id) => {
    dataService.deleteData(id)
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
                Detailed Data
              </li>
            </ol>
          </small>
        </nav>

        <div class="container">
          <small>
            <div class="row">
              <div class="col-md-10">
                {/* <i class="far fa-chart-pie font-weight-bold fa-2x d-inline mr-2"></i> */}
                <h1 class="d-inline">Detailed Data</h1>
              </div>
              <div class="col-md-2 mt-2">
                <Link
                  to={`/rfp/adddata/${params.id}`}
                  class="btn btn-md btn-secondary d-inline text-light"
                >
                  Add Data
                </Link>
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
                    <th>Module</th>
                    <th>Requirement</th>
                    <th>Requirement Details</th>
                    <th>Number of Units</th>
                    <th>Complexity</th>
                    <th>CUT Estimation</th>
                    <th>Assumptions</th>
                    <th>Comments</th>
                    
                  </tr>
                </thead>
                <tbody>
                  {datas.map((data, index) => (
                    <tr>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {index + 1}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.module}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.requirement}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.requirement_details}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.units}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.complexity}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.cut_estimation}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.assumptions}
                      </td>
                      <td class="data-row" onClick={() => goRouteId(data.id)}>
                        {data.comments}
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

export default Data;