import { initOnLoad } from "apexcharts";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import MentoringService from "../../Services/MentoringService";
import { useParams, useNavigate } from "react-router-dom";

function ViewMentoring() {
  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "numeric", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };
  const params = useParams();
  const [mentor, setMentor] = useState([]);

  useEffect(() => {
    init();
  }, []);
  const init = () => {
    MentoringService.getById(params.id)
      .then((response) => {
        setMentor(response.data);
        console.log(response.data);
        console.log(mentor);
      })
      .catch((error) => {
        console.log(error);
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
                View Mentoring
              </li>
            </ol>
          </small>
        </nav>

        {/* <i class="fa-solid fa-eye fa-2x d-inline mr-2"></i> */}
        <small>
          <h1 class="d-inline">
            View - <small class="text-success">{mentor.name}</small>
          </h1>
          <div class="content-container">
            <div class="container-fluid">
              <div class="card shadow-sm mb-5">
                <div className="card-body">
                  <table class="table">
                    <tbody>
                      <tr>
                        <th scope="row">1.</th>
                        <td>ID</td>
                        <td>
                          <b>{mentor.id}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">2.</th>
                        <td>Batch</td>
                        <td>
                          <b>{mentor.batch}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">3.</th>
                        <td>DECP Employee ID</td>
                        <td>
                          <b>{mentor.empId}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">4.</th>
                        <td>DECP Name</td>
                        <td>
                          <b>{mentor.name}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">5.</th>
                        <td>DECP Email</td>
                        <td>
                          <b>{mentor.email}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">6.</th>
                        <td>DECP HackerEarth Score</td>
                        <td>
                          <b>{mentor.heScore}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">7.</th>
                        <td>DECP HackerEarth Rank</td>
                        <td>
                          <b>{mentor.heRank}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">8.</th>
                        <td>HackerEarth Score Update Date</td>
                        <td>
                          <b>{formatDate(mentor.updateDate)}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">9.</th>
                        <td>Project</td>
                        <td>
                          <b>{mentor.project}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">10.</th>
                        <td>Project Title</td>
                        <td>
                          <b>{mentor.projectTitle}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">11.</th>
                        <td>Technology Used In Project</td>
                        <td>
                          <b>{mentor.techStack}</b>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">12.</th>
                        <td>Project Status</td>
                        <td>
                          <b>{mentor.projectStatus}</b>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </small>
      </div>
    </>
  );
}

export default ViewMentoring;
