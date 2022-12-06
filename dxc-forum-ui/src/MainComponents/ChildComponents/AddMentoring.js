import React from "react";
import { useState } from "react";
import MentoringService from "../../Services/MentoringService";
import { useNavigate } from "react-router-dom";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";

const AddMentoring = () => {
  const [values, setValues] = useState({
    batch: "",
    empId: "",
    name: "",
    email: "",
    heScore: "",
    updateDate: "",
    heRank: "",
    project: "",
    projectTitle: "",
    techStack: "",
  });
  const [errors, setErrors] = useState({});
  const handleChange = (event) => {
    setValues({
      ...values,

      [event.target.name]: event.target.value,
    });
  };

  const handleFormSubmit = (e) => {
    e.preventDefault();

    setErrors(validation(values));
  };
  const validation = (values) => {
    let errors = {};
    if (!values.batch) {
      errors.batch = "Batch is required.";
    }
    if (!values.empId) {
      errors.empId = "Employee ID is required.";
    }
    if (!values.name) {
      errors.name = "Employee Name is required.";
    } else if (!/^[A-Za-z\s]*$/.test(values.name)) {
      errors.name = "Employee Name is invalid.";
    }
    if (!values.email) {
      errors.email = " Employee Email is required.";
    } else if (!/\S+@\S+\.\S+/.test(values.email)) {
      errors.email = " Email is invalid !";
    }
    if (!values.heScore) {
      errors.heScore = "Hacker Earth Score is required.";
    }
    if (!values.updateDate) {
      errors.updateDate = "Date is required.";
    }
    if (!values.heRank) {
      errors.heRank = "Hacker Earth Rank is required.";
    }
    if (!values.project) {
      errors.project = "Project is required.";
    }
    if (!values.projectTitle) {
      errors.projectTitle = "Project Title is required.";
    }
    if (!values.techStack) {
      errors.techStack = "Technology Stack is required.";
    }

    return errors;
  };

  const navigate = useNavigate();

  const [batch, setBatch] = useState("");
  const [empId, setEmpId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [heScore, setHeScore] = useState("");
  const [updateDate, setUpdateDate] = useState("");
  const [heRank, setHeRank] = useState("");
  const [project, setProject] = useState("");
  const [projectTitle, setProjectTitle] = useState("");
  const [techStack, setTechStack] = useState("");
  const [projectStatus, setProjectStatus] = useState("");

  // const history = useHistory();

  const saveMentoring = (e) => {
    e.preventDefault();

    const mentor = {
      batch,
      empId,
      name,
      email,
      heScore,
      updateDate,
      heRank,
      project,
      projectTitle,
      techStack,
      projectStatus,
    };

    if (
      mentor.batch !== "" &&
      mentor.empId !== "" &&
      mentor.email !== "" &&
      mentor.heRank !== "" &&
      mentor.heScore !== "" &&
      mentor.name !== "" &&
      mentor.project !== "" &&
      mentor.projectStatus !== "" &&
      mentor.projectTitle !== "" &&
      mentor.techStack !== "" &&
      mentor.updateDate !== ""
    ) {
      MentoringService.AddMentoring(mentor)
        .then((response) => {
          console.log("Employee Data Added Successfully", response.data);
          navigate(`/mentoring`);
          //window.location.reload(false);
        })
        .catch((error) => {
          console.log("Something went wrong", error);
        });
    }
  };

  //Excel File Upload
  const [files, setFiles] = useState("");
  const [fileUploadResponse, setFileUploadResponse] = useState(null);
  const FILE_UPLOAD_BASE_ENDPOINT = "http://localhost:9090/mentoring";

  const uploadFileHandler = (event) => {
    setFiles(event.target.files);
  };

  const fileSubmitHandler = (event) => {
    event.preventDefault();
    setFileUploadResponse(null);

    const formData = new FormData();
    formData.append(`file`, files[0]);
    console.log(files);
    const requestOptions = {
      method: "POST",
      body: formData,
    };
    fetch(FILE_UPLOAD_BASE_ENDPOINT + "-excel", requestOptions)
      .then(async (response) => {
        const isJson = response.headers
          .get("content-type")
          ?.includes("application/json");
        const data = isJson && (await response.json());
        console.log("file", response);

        // check for error response
        if (!response.ok) {
          // get error message
          const error = (data && data.message) || response.status;
          setFileUploadResponse(data.message);
          return Promise.reject(error);
        }

        console.log("Data msg", data.message);
        setFileUploadResponse(data.message);
      })
      .catch((error) => {
        console.error("Error while uploading file!", error);
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
                <a href="/mentoring">Mentoring</a>
              </li>
              <li class="breadcrumb-item active" aria-current="page">
                Add Mentoring
              </li>
            </ol>
          </small>
        </nav>
        {/* <i class="fa-solid fa-plus fa-2x d-inline mr-2"></i> */}
        <small>
          <h1 class="d-inline">Add Mentoring</h1>
          <div class="content-container">
            <div class="container-fluid">
              <div class="card shadow-sm mb-5 mt-3">
                <div className="card-body">
                  <form onSubmit={fileSubmitHandler}>
                    <div class="form-group mt-3">
                      <label>Upload Excel Sheet</label>
                      <input
                        type="file"
                        class="form-control shadow-sm"
                        placeholder="Upload Excel Sheet"
                        multiple
                        onChange={uploadFileHandler}
                      ></input>
                    </div>
                    <button type="submit" class="btn btn-success mt-3">
                      Upload
                    </button>
                    {fileUploadResponse != null && (
                      <p style={{ color: "green" }}>{fileUploadResponse}</p>
                    )}
                  </form>
                  <div class="divider d-flex align-items-center my-4">
                    <p class="text-center fw-bold mx-3 mb-0">Or</p>
                  </div>
                  <form>
                    <div class="form-group mt-3">
                      <label>Batch</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Batch"
                        name="batch"
                        value={values.batch}
                        onChange={(e) => {
                          setBatch(e.target.value);
                          handleChange(e);
                        }}
                      ></input>
                      {errors.batch && (
                        <p className="error" class="text-danger">
                          {errors.batch}
                        </p>
                      )}
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
                        onChange={(e) => {
                          setEmpId(e.target.value);
                          handleChange(e);
                        }}
                        value={values.empId}
                      ></input>
                      {errors.empId && (
                        <p className="error" class="text-danger">
                          {errors.empId}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Employee Name</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Employee Name"
                        name="name"
                        onChange={(e) => {
                          setName(e.target.value);
                          handleChange(e);
                        }}
                        value={values.name}
                      ></input>
                      {errors.name && (
                        <p className="error" class="text-danger">
                          {errors.name}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Employee Email</label>
                      <input
                        type="email"
                        class="form-control shadow-sm"
                        placeholder="Employee Email"
                        name="email"
                        onChange={(e) => {
                          setEmail(e.target.value);
                          handleChange(e);
                        }}
                        value={values.email}
                      ></input>
                      {errors.email && (
                        <p className="error" class="text-danger">
                          {errors.email}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>HackerEarth Score</label>
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      <small class="text-danger" style={{ fontSize: 10 }}>
                        *Insert Only Numerical Data
                      </small>
                      <input
                        type="number"
                        class="form-control shadow-sm"
                        placeholder="HackerEarth Score"
                        name="heScore"
                        onChange={(e) => {
                          setHeScore(e.target.value);
                          handleChange(e);
                        }}
                        value={values.heScore}
                      ></input>
                      {errors.heScore && (
                        <p className="error" class="text-danger">
                          {errors.heScore}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Date</label>
                      <input
                        type="date"
                        class="form-control shadow-sm"
                        placeholder="Date"
                        name="updateDate"
                        onChange={(e) => {
                          setUpdateDate(e.target.value);
                          handleChange(e);
                        }}
                        value={values.updateDate}
                      ></input>
                      {errors.updateDate && (
                        <p className="error" class="text-danger">
                          {errors.updateDate}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>HackerEarth Rank</label>
                      &nbsp;&nbsp;&nbsp;&nbsp;
                      <small class="text-danger" style={{ fontSize: 10 }}>
                        *Insert Only Numerical Data
                      </small>
                      <input
                        type="number"
                        class="form-control shadow-sm"
                        placeholder="HackerEarth Rank"
                        name="heRank"
                        onChange={(e) => {
                          setHeRank(e.target.value);
                          handleChange(e);
                        }}
                        value={values.heRank}
                      ></input>
                      {errors.heRank && (
                        <p className="error" class="text-danger">
                          {errors.heRank}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Project</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Project"
                        name="project"
                        onChange={(e) => {
                          setProject(e.target.value);
                          handleChange(e);
                        }}
                        value={values.project}
                      ></input>
                      {errors.project && (
                        <p className="error" class="text-danger">
                          {errors.project}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Project Title</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Project Title"
                        name="projectTitle"
                        onChange={(e) => {
                          setProjectTitle(e.target.value);
                          handleChange(e);
                        }}
                        value={values.projectTitle}
                      ></input>
                      {errors.projectTitle && (
                        <p className="error" class="text-danger">
                          {errors.projectTitle}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Technology Stack</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Technology Stack"
                        name="techStack"
                        onChange={(e) => {
                          setTechStack(e.target.value);
                          handleChange(e);
                        }}
                        value={values.techStack}
                      ></input>
                      {errors.techStack && (
                        <p className="error" class="text-danger">
                          {errors.techStack}
                        </p>
                      )}
                    </div>
                    <div class="form-group mt-3">
                      <label>Project Status</label>
                      {/* <input
                        class="form-control shadow-sm"
                        type="text"
                        placeholder="Project Status"
                        name="status"
                        onChange={(e) => setStatus(e.target.value)}
                        value={status}
                        required
                      ></input> */}
                      <select
                        class="form-control shadown-sm"
                        onChange={(e) => setProjectStatus(e.target.value)}
                      >
                        <option selected disabled>
                          --Select Project Status--
                        </option>
                        <option value="In Progress">In Progress</option>
                        <option value="Started">Started</option>
                        <option value="Not Started">Not Started</option>
                      </select>
                    </div>
                    <button
                      class="btn btn-success mt-3"
                      onClick={(e) => {
                        saveMentoring(e);
                        handleFormSubmit(e);
                      }}
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
};

export default AddMentoring;
