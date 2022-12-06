import React from "react";
const Sidebar = () => {
  return (
    <div
      class="col-md-3 col-lg-2 sidebar-offcanvas pl-0"
      id="sidebar"
      role="navigation"
      style={{ backgroundColor: "#e9ecef" }}
    >
      <ul class="nav flex-column sticky-top pl-0 pt-5 p-3 mt-3 ">
        <li class="nav-item mb-2 mt-3">
          <a class="nav-link text-secondary" href="/">
            <h5>DXC Forum</h5>
          </a>
        </li>
        <li class="nav-item mb-2 ">
          <a class="nav-link text-secondary" href="/">
            <i class="far fa-chart-bar font-weight-bold"></i>{" "}
            <span className="ml-3">Overview</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a
            class="nav-link text-secondary"
            href="/mentoring"
            data-toggle="collapse"
            data-target="#submenu1"
          >
            <i class="far fa-users font-weight-bold"></i>{" "}
            <span className="ml-3"> Mentoring</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a class="nav-link text-secondary" href="/training">
            <i class="fa-solid fa-paper-plane font-weight-bold"></i>
            <span className="ml-3">Training</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a class="nav-link text-secondary" href="/certification">
            <i class="fa-solid fa-certificate font-weight-bold"></i>
            <span className="ml-3">Certification</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a class="nav-link text-secondary" href="/java_factory">
            <i class="far fa-brands fa-java font-weight-bold"></i>
            <span className="ml-3">Java Factory</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a class="nav-link text-secondary" href="/consultancy">
            <i class="fa fa-question font-weight-bold"></i>{" "}
            <span className="ml-3">Consultancy</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a class="nav-link text-secondary" href="/rfp">
            <i class="far fa-chart-pie font-weight-bold"></i>{" "}
            <span className="ml-3">RFP Tracker</span>
          </a>
        </li>
        <li class="nav-item mb-2">
          <a class="nav-link text-secondary" href="#">
            <i class="fa-solid fa-right-from-bracket"></i>
            <span className="ml-3">Logout</span>
          </a>
        </li>
      </ul>
    </div>
  );
};

export default Sidebar;
