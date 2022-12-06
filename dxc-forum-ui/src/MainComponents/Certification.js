import { useEffect, useState } from "react";
import CertificationService from "../Services/CertificationService";
import { Link } from "react-router-dom";
import "jquery/dist/jquery.min.js";
import Navbar from "../Components/Navbar";
import Sidebar from "../Components/Sidebar";
const Certification = () => {
  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "numeric", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };
  //Get all certificates
  const [certificates, setCertificates] = useState([]);

  useEffect(() => {
    init();
    downloadExcel();
  }, []);

  const init = () => {
    CertificationService.getAll()
      .then((response) => {
        console.log("certificate data", response.data);
        setCertificates(response.data);
      })
      .catch((error) => {
        console.log("Error in get all certificate", error);
      });
  };

  const downloadExcel = (e) => {
    CertificationService.exportCertificate()
      .then((response) => {
        console.log("Success");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  //Delete Certificate
  const handleDelete = (id) => {
    CertificationService.deleteById(id)
      .then((response) => {
        console.log("Data Deleted Successfully");
        init();
      })
      .catch((error) => {
        console.log("Error in deleting certificates", error);
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
                Certification
              </li>
            </ol>
          </small>
        </nav>
        {/* <p class="lead d-none d-sm-block">Add Employee Details and Records</p>
         */}

        <div class="container">
          <small>
            <div class="row">
              <div class="col-md-9">
                {/* <i class="fa-solid fa-certificate fa-2x mr-2 d-inline"></i> */}
                <h1 class="d-inline">Certification</h1>
              </div>
              <div class="col-md-3 mt-2">
                <a
                  href="http://localhost:9090/download/certificate.xlsx"
                  class="btn btn-primary mr-2"
                >
                  <i class="fa fa-download mr-2"></i>
                  Export
                </a>
                <a
                  href="/certification/add-certification"
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
            {/* <div class="card shadow-sm mb-5">
              <div className="card-body"> */}
            <small>
              <table class="table table-striped table-bordered mt-3 mb-5">
                <thead class="thead-light">
                  <tr>
                    <th>#</th>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Voucher</th>
                    <th>Staus</th>
                    <th>Date (MM/DD/YYYY)</th>
                    <th>Remarks</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {certificates.map((certificate, index) => (
                    <tr>
                      <td>{index + 1}</td>
                      <td>{certificate.empId}</td>
                      <td>{certificate.empName}</td>
                      <td>{certificate.empEmail}</td>
                      <td>{certificate.voucher}</td>
                      <td>
                        <b>{certificate.status}</b>
                      </td>
                      <td>{formatDate(certificate.date)}</td>
                      <td>{certificate.remarks}</td>
                      {/* <td>
                            <Link
                              to={`/certificate/${certificate.id}`}
                              class="btn btn-sm btn-success text-light"
                              style={{ marginRight: 2 }}
                            >
                              Edit
                            </Link>
                            <a
                              class="btn btn-danger btn-sm text-light"
                              onClick={(e) => {
                                handleDelete(certificate.id);
                              }}
                            >
                              Delete
                            </a>
                          </td> */}
                      <td>
                        <div class="dropdown">
                          <span class="btn btn-sm btn-secondary d-inline">
                            Action&nbsp;
                            <i class="fas fa-caret-down d-inline"></i>
                          </span>
                          <div class="dropdown-content">
                            <Link to={`/certificate/${certificate.id}`}>
                              Edit
                            </Link>

                            <a
                              onClick={(e) => {
                                handleDelete(certificate.id);
                              }}
                            >
                              Delete
                            </a>
                          </div>
                        </div>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </small>
            {/* </div>
            </div> */}
          </div>
        </div>
      </div>
    </>
  );
};

export default Certification;
