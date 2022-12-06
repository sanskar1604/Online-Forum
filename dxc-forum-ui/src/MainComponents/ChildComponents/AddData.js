import React, { useState } from "react";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import { useNavigate } from "react-router-dom";
import dataService from "../../Services/dataService";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";
import { useParams } from "react-router-dom";

export default function AddData() {
  const navigate = useNavigate();
  const params=useParams();

  const [module, SetModule] = useState("");
  const [requirement, setRequirement] = useState("");
  const [requirement_details, setRequirementDetails] = useState("");
  const [units, setNumberofUnits] = useState("");
  const [complexity, setComplexity] = useState("");
  const [cut_estimation, setCutEstimation] = useState("");
  const [assumptions, setAssumptions] = useState("");
  const [comments, setComments] = useState("");
  
  const saveData = (e) => {
    e.preventDefault();

    const data = {
      module,
      requirement,
      requirement_details,
      units,
      complexity,
      cut_estimation,
      assumptions,
      comments,
  
    };

    dataService.addData(data)
      .then((response) => {
        console.log("Detailed Data Added Successfully", response.data);
        navigate(`/rfp/estimate_rfp/data/${params.id}`);
        window.location.reload(false);
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
              <li class="breadcrumb-item">
                <a href="/data">detailed Data</a>
              </li>
              <li class="breadcrumb-item active" aria-current="page">
                Add detailed Data
              </li>
            </ol>
          </small>
        </nav>

        {/* <i class="fa-solid fa-plus fa-2x d-inline mr-2"></i> */}
        <small>
          <h1 class="d-inline">Add detailed Data</h1>
          <div class="content-container">
            <div class="container-fluid">
              <div class="card shadow-sm mb-5 mt-3">
                <div className="card-body">
                  <form>
                    <div class="form-group mt-3">
                      <label>Module</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder=" Module "
                        name="module"
                        value={module}
                        onChange={(e) => SetModule(e.target.value)}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Requirement/ Usecase/ Functionality</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Requirment "
                        name="Requirment"
                        onChange={(e) => setRequirement(e.target.value)}
                        value={requirement}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Requirement Details</label>
                       <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Requirment Details "
                        name="requirment_details"
                        onChange={(e) => setRequirementDetails(e.target.value)}
                        value={requirement_details}
                        required
                      ></input>
                      
                    </div>
                    <div class="form-group mt-3">
                      <label>Number of units(APIs/Micro services)</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder=" "
                        name="units"
                        onChange={(e) => setNumberofUnits(e.target.value)}
                        value={units}
                        required
                      ></input>
                      
                    </div>
                    
                    <div class="form-group mt-3">
                      <label>complexity</label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Type"
                        name="type"
                        onChange={(e) => setType(e.target.value)}
                        value={type}
                        required
                      ></input> */}
                      <select
                        class="form-control shadow-sm"
                        onChange={(e) => setComplexity(e.target.value)}
                      >
                        <option selected disabled>
                          --Select Type--
                        </option>
                        <option value="Simple">Simple</option>
                        <option value="Moderate">
                          Moderate
                        </option>
                        <option value="Complex">Complex</option>
                        <option value="Very Complex">
                          Very Complex
                        </option>
                      </select>
                    </div>
                    <div class="form-group mt-3">
                      <label>CUT Estimation(PH)</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder=" "
                        name="cut_estimation"
                        onChange={(e) => setCutEstimation(e.target.value)}
                        value={cut_estimation}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Assumption made while Estimating</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder=" "
                        name="assumptions"
                        onChange={(e) => setAssumptions(e.target.value)}
                        value={assumptions}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Comments</label>
                      <input
                        class="form-control shadow-sm"
                        type="text"
                        placeholder="Comments"
                        name="comments"
                        onChange={(e) => setComments(e.target.value)}
                        value={comments}
                        required
                      ></input>
                    </div>
                   
                    <button
                      class="btn btn-success mt-3"
                      onClick={(e) => saveData(e)}
                    >
                      Add
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