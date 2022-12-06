import React, { useEffect, useState } from "react";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import { useParams, useNavigate } from "react-router-dom";
import RFPService from "../../Services/RFPService";

import AddPhasesForm from "./AddPhasesForm";
import { useLocation } from "react-router-dom";
import { Link } from "react-router-dom";
import RFPSpringbootService from "../../Services/RFPSpringbootService";

import { isEmptyObject } from "jquery";
import RFPPhasesService from "../../Services/RFPPhasesService";
import RFPWebService from "../../Services/RFPWebService";
import RFPJSPService from "../../Services/RFPJSPService";

export default function EstimateRFP() {
  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "short", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };

  let roundOff = (num, places) => {
    const x = Math.pow(10, places);
    return Math.round(num * x) / x;
  };
  const params = useParams();
  const navigate = useNavigate();
  const [rfp, setRfp] = useState([]);

  useEffect(() => {
    init();
    if (state !== null) {
      console.log("true");

      setFirst(parseFloat(state.first));
      setSecond(parseFloat(state.second));
      setThird(parseFloat(state.third));
      setFourth(parseFloat(state.fourth));
      setFifth(parseFloat(state.fifth));
      setSixth(parseFloat(state.sixth));
      setSeventh(parseFloat(state.seventh));
      setEighth(parseFloat(state.eighth));
      setNinth(parseFloat(state.ninth));
      setTenth(parseFloat(state.tenth));
      setEleven(parseFloat(state.eleven));
      setTwelve(parseFloat(state.twelve));
      setThirteen(parseFloat(state.thirteen));
      setFourteen(parseFloat(state.fourteen));
      setFifteen(parseFloat(state.fifteen));
      setSixteen(parseFloat(state.sixteen));
      setSeventeen(parseFloat(state.seventeen));
      setEighteen(parseFloat(state.eighteen));
      console.log(state.sixteen);
      console.log(state);
      console.log(state.sDB);

      //SpringBoot Table{
      if (state.sDB == 1) {
        setSimpleDB(parseInt(state.sDB));
      } else if (state.sDB == 3) {
        setMediumDB(parseInt(state.sDB));
      } else if (state.sDB > 3 && state.sDB <= 7) {
        setComplexDB(parseInt(state.sDB));
      } else if (state.sDB >= 8) {
        setVeryComplexDB(parseInt(state.sDB));
      }

      if (state.sPI <= 4) {
        setSimplePI(parseInt(state.sPI));
      } else if (state.sPI > 4 && state.sPI <= 10) {
        setMediumPI(parseInt(state.sPI));
      } else if (state.sPI > 10 && state.sPI <= 15) {
        setComplexPI(parseInt(state.sPI));
      } else if (state.sPI > 15) {
        setVeryComplexPI(parseInt(state.sPI));
        console.log(veryComplexPI);
      }
      //}

      //WebService Table {
      if (state.wDB == 1) {
        setWSimpleDB(state.wDB);
      } else if (state.wDB == 3) {
        setWMediumDB(parseInt(state.wDB));
      } else if (state.wDB >= 4 && state.wDB <= 7) {
        setWComplexDB(parseInt(state.wDB));
      } else if (state.wDB >= 8) {
        setWVeryComplexDB(parseInt(state.wDB));
      }

      if (state.wPI <= 4) {
        setWSimplePI(parseInt(state.wPI));
      } else if (state.wPI > 4 && state.wPI <= 10) {
        setWMediumPI(parseInt(state.wPI));
      } else if (state.wPI > 10 && state.wPI <= 15) {
        setWComplexPI(parseInt(state.wPI));
      } else if (state.wPI > 15) {
        setWVeryComplexPI(parseInt(state.wPI));
      }
      //}

      //jsp tables

      if (state.jDB == 1) {
        setJSimpleDB(state.jDB);
      } else if (state.jDB == 3) {
        setJMediumDB(parseInt(state.jDB));
      } else if (state.jDB > 3 && state.jDB <= 7) {
        setJComplexDB(parseInt(state.jDB));
      } else if (state.jDB >= 8) {
        setJVeryComplexDB(parseInt(state.jDB));
      }

      if (state.jPI <= 4) {
        setJSimplePI(parseInt(state.jPI));
      } else if (state.jPI > 4 && state.jPI <= 10) {
        setJMediumPI(parseInt(state.jPI));
      } else if (state.jPI > 10 && state.jPI <= 15) {
        setJComplexPI(parseInt(state.jPI));
      } else if (state.jPI > 15) {
        setJVeryComplexPI(parseInt(state.jPI));
      }
    } else {
      console.log("false");
    }

    //  if(location.state!==null){

    //   // setSdb(parseInt(location.state.sDB));
    //   // setSpi(parseInt(location.state.sPI));
    //   // setWdb(parseInt(location.state.wDB));
    //   // setWpi(parseInt(location.state.wPI));
    //   // setJdb(parseInt(location.state.jDB));
    //   // setJpi(parseInt(location.state.jPI));
    //  }
  }, []);

  const init = () => {
    RFPService.getById(params.id)
      .then((response) => {
        setRfp(response.data);
      })
      .catch((error) => {
        console.log(error);
      });

    //Phases Table fetch by id from Database
    RFPPhasesService.getfindByRfpId(params.id)
      .then((response) => {
        console.log("From phases table databse", response.data[0].first);
        setFirst(parseInt(response.data[0].first));
        setSecond(parseInt(response.data[0].second));
        setThird(parseFloat(response.data[0].third));
        setFourth(parseInt(response.data[0].fourth));
        setFifth(parseInt(response.data[0].fifth));
        setSixth(parseFloat(response.data[0].sixth));
        setSeventh(parseInt(response.data[0].seventh));
        setEighth(parseInt(response.data[0].eighth));
        setNinth(parseFloat(response.data[0].ninth));
        setTenth(parseInt(response.data[0].tenth));
        setEleven(parseInt(response.data[0].eleven));
        setTwelve(parseFloat(response.data[0].twelve));
        setThirteen(parseInt(response.data[0].thirteen));
        setFourteen(parseInt(response.data[0].fourteen));
        setFifteen(parseFloat(response.data[0].fifteen));
        setSixteen(parseInt(response.data[0].sixteen));
        setSeventeen(parseInt(response.data[0].seventeen));
        setEighteen(parseFloat(response.data[0].eighteen));
      })
      .catch((error) => {
        console.log("Error", error);
      });

    //SpringBoot Table fetch by id from Database
    RFPSpringbootService.getfindByRfpId(params.id)
      .then((response) => {
        console.log(
          "From Springboot table databse",
          response.data[0].complexDB
        );
        setSimpleDB(response.data[0].simpleDB);
        setMediumDB(response.data[0].mediumDB);
        setComplexDB(response.data[0].complexDB);
        setVeryComplexDB(response.data[0].veryComplexDB);
        setSimplePI(response.data[0].simplePI);
        setMediumPI(response.data[0].mediumPI);
        setComplexPI(response.data[0].complexPI);
        setVeryComplexPI(response.data[0].veryComplexPI);
      })
      .catch((error) => {
        console.log("Error", error);
      });

    //WebService Table fetch by id from Database
    RFPWebService.getfindByRfpId(params.id)
      .then((response) => {
        console.log(
          "From WebService table databse",
          response.data[0].wcomplexDB
        );
        setWSimpleDB(response.data[0].wsimpleDB);
        setWMediumDB(response.data[0].wmediumDB);
        setWComplexDB(response.data[0].wcomplexDB);
        setWVeryComplexDB(response.data[0].wveryComplexDB);
        setWSimplePI(response.data[0].wsimplePI);
        setWMediumPI(response.data[0].wmediumPI);
        setWComplexPI(response.data[0].wcomplexPI);
        setWVeryComplexPI(response.data[0].wveryComplexPI);
      })
      .catch((error) => {
        console.log("Error", error);
      });

    //JSP Table fetch by id from Database
    RFPJSPService.getfindByRfpId(params.id)
      .then((response) => {
        console.log("From JSP table databse", response.data[0]);
        setJSimpleDB(response.data[0].jsimpleDB);
        setJMediumDB(response.data[0].jmediumDB);
        setJComplexDB(response.data[0].jcomplexDB);
        setJVeryComplexDB(response.data[0].jveryComplexDB);
        setJSimplePI(response.data[0].jsimplePI);
        setJMediumPI(response.data[0].jmediumPI);
        setJComplexPI(response.data[0].jcomplexPI);
        setJVeryComplexPI(response.data[0].jveryComplexPI);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };

  const [first, setFirst] = useState("");
  const [second, setSecond] = useState("");
  const [third, setThird] = useState("");
  const [fourth, setFourth] = useState("");
  const [fifth, setFifth] = useState("");
  const [sixth, setSixth] = useState("");
  const [seventh, setSeventh] = useState("");
  const [eighth, setEighth] = useState("");
  const [ninth, setNinth] = useState("");
  const [tenth, setTenth] = useState("");
  const [eleven, setEleven] = useState("");
  const [twelve, setTwelve] = useState("");
  const [thirteen, setThirteen] = useState("");
  const [fourteen, setFourteen] = useState("");
  const [fifteen, setFifteen] = useState("");
  const [sixteen, setSixteen] = useState("");
  const [seventeen, setSeventeen] = useState("");
  const [eighteen, setEighteen] = useState("");

  const [simpleDB, setSimpleDB] = useState("");
  const [mediumDB, setMediumDB] = useState("");
  const [complexDB, setComplexDB] = useState("");
  const [veryComplexDB, setVeryComplexDB] = useState("");

  const [simplePI, setSimplePI] = useState("");
  const [mediumPI, setMediumPI] = useState("");
  const [complexPI, setComplexPI] = useState("");
  const [veryComplexPI, setVeryComplexPI] = useState("");

  const [wsimpleDB, setWSimpleDB] = useState("");
  const [wmediumDB, setWMediumDB] = useState("");
  const [wcomplexDB, setWComplexDB] = useState("");
  const [wveryComplexDB, setWVeryComplexDB] = useState("");

  const [wsimplePI, setWSimplePI] = useState("");
  const [wmediumPI, setWMediumPI] = useState("");
  const [wcomplexPI, setWComplexPI] = useState("");
  const [wveryComplexPI, setWVeryComplexPI] = useState("");

  const [jsimpleDB, setJSimpleDB] = useState("");
  const [jmediumDB, setJMediumDB] = useState("");
  const [jcomplexDB, setJComplexDB] = useState("");
  const [jveryComplexDB, setJVeryComplexDB] = useState("");

  const [jsimplePI, setJSimplePI] = useState("");
  const [jmediumPI, setJMediumPI] = useState("");
  const [jcomplexPI, setJComplexPI] = useState("");
  const [jveryComplexPI, setJVeryComplexPI] = useState("");

  const formSubmit = (e) => {
    e.preventDefault();
    const phase = {
      phase,

      rfp: {
        id: params.id,
      },
    };

    RFPService.addPhases(phase)
      .then((response) => {
        console.log("Success");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleClick = (e) => {
    e.preventDefault();
    const springBoot = {
      simpleDB,
      mediumDB,
      complexDB,
      veryComplexDB,
      simplePI,
      mediumPI,
      complexPI,
      veryComplexPI,
      rfp: {
        id: params.id,
      },
    };
    console.log(springBoot);

    RFPSpringbootService.addSpringbootService(springBoot)
      .then((response) => {
        console.log("Success");
      })
      .catch((error) => {
        console.log(error);
      });

    RFPSpringbootService.getAll()
      .then((response) => {
        console.log("Success");
      })
      .catch((error) => {
        console.log(error);
      });

    const phase = {
      first,
      second,
      third,
      fourth,
      fifth,
      sixth,
      seventh,
      eighth,
      ninth,
      tenth,
      eleven,
      twelve,
      thirteen,
      fourteen,
      fifteen,
      sixteen,
      seventeen,
      eighteen,
      rfp: {
        id: params.id,
      },
    };

    RFPPhasesService.addPhases(phase)
      .then((response) => {
        console.log("Success");
      })
      .catch((error) => {
        console.log(error);
      });

    RFPPhasesService.getAll()
      .then((response) => {
        console.log("Success");
      })
      .catch((error) => {
        console.log(error);
      });

    const WebService = {
      wsimpleDB,

      wmediumDB,

      wcomplexDB,

      wveryComplexDB,

      wsimplePI,

      wmediumPI,

      wcomplexPI,

      wveryComplexPI,

      rfp: {
        id: params.id,
      },
    };

    console.log(WebService);

    RFPWebService.addWebService(WebService)

      .then((response) => {
        console.log("Success");
      })

      .catch((error) => {
        console.log(error);
      });

    RFPWebService.getAll()

      .then((response) => {
        console.log("Success");
      })

      .catch((error) => {
        console.log(error);
      });

    const JSP = {
      jsimpleDB,

      jmediumDB,

      jcomplexDB,

      jveryComplexDB,

      jsimplePI,

      jmediumPI,

      jcomplexPI,

      jveryComplexPI,

      rfp: {
        id: params.id,
      },
    };

    console.log(JSP);

    RFPJSPService.addJSPService(JSP)

      .then((response) => {
        console.log("Success");
      })

      .catch((error) => {
        console.log(error);
      });

    RFPJSPService.getAll()

      .then((response) => {
        console.log("Success");

        navigate("/rfp");
      })

      .catch((error) => {
        console.log(error);
      });
  };

  const { state } = useLocation();
  // const location =useLocation();
  // console.log(location.state);
  console.log(state);

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
                RFP Estimate
              </li>
            </ol>
          </small>
        </nav>

        {/* <i class="far fa-chart-pie font-weight-bold fa-2x d-inline mr-2"></i> */}
        <small>
          <h1 class="d-inline">
            Estimate RFP - <small class="text-success">{rfp.rfpTitle}</small>
          </h1>
        </small>
        <div class="content-container mt-3 mb-5">
          <div class="container-fluid">
            <div style={{ display: "flex" }}>
              {/* <Link to={`/AddServiceForm/${params.id}`}  style={{marginLeft:"auto"}}><button class="btn btn-sm btn-success" >Add Services</button></Link> */}
              <Link
                to={`/AddPhasesForm/${params.id}`}
                style={{ marginLeft: "auto" }}
              >
                <button class="btn btn-md btn-secondary d-inline text-light">
                  Add Data
                </button>
              </Link>

              <Link
                to={`/rfp/estimate_rfp/data/${params.id}`}
                style={{ marginLeft: "20px" }}
                class="btn btn-md btn-secondary d-inline text-light"
              >
                {" "}
                Detailed Data{" "}
              </Link>
            </div>
            <br></br>
            <div class="row">
              <div class="col-md-6 col-sm-12 col-lg-6">
                <small>
                  <table class="table table-bordered">
                    <tr class="text-center estimate-table">
                      <th colspan="2">RFP Summary Info</th>
                    </tr>
                    <tr>
                      <th>RFP Name</th>
                      <td class="estimate-table-data">{rfp.rfpTitle}</td>
                    </tr>
                    <tr>
                      <th>Client</th>
                      <td class="estimate-table-data">{rfp.client}</td>
                    </tr>
                    <tr>
                      <th>Date Initiated</th>
                      <td class="estimate-table-data">
                        {formatDate(rfp.dateOfEntry)}
                      </td>
                    </tr>
                    <tr>
                      <th>Java Capability SPOC</th>
                      <td class="estimate-table-data">
                        {rfp.javaCapabilityRfpTeam}
                      </td>
                    </tr>
                    <tr>
                      <th>Java Technology Involved</th>
                      <td class="estimate-table-data">{rfp.technology}</td>
                    </tr>
                  </table>
                </small>
                <small>
                  <table class="table table-bordered">
                    <tr class="text-center estimate-table">
                      <th>Springboot / Microservices / API</th>
                      <th>Simple</th>
                      <th>Medium</th>
                      <th>Complex</th>
                      <th>Very Complex</th>
                    </tr>
                    <tr>
                      <th>DB Operations</th>
                      <td class="estimate-table-data">{simpleDB}</td>
                      <td class="estimate-table-data">{mediumDB}</td>
                      <td class="estimate-table-data">{complexDB}</td>
                      <td class="estimate-table-data">{veryComplexDB}</td>
                    </tr>
                    <tr>
                      <th>Parameter / Interface</th>
                      <td class="estimate-table-data">{simplePI}</td>
                      <td class="estimate-table-data">{mediumPI}</td>
                      <td class="estimate-table-data">{complexPI}</td>
                      <td class="estimate-table-data">{veryComplexPI}</td>
                    </tr>
                    <tr>
                      <th>Cut Effort (PH)</th>
                      <td class="estimate-table-data">16</td>
                      <td class="estimate-table-data">24</td>
                      <td class="estimate-table-data">40</td>
                      <td class="estimate-table-data">80</td>
                    </tr>
                  </table>
                  <table class="table table-bordered">
                    <tr class="text-center estimate-table">
                      <th>WebServices (Spring MVC, Rest API)</th>
                      <th>Simple</th>
                      <th>Medium</th>
                      <th>Complex</th>
                      <th>Very Complex</th>
                    </tr>
                    <tr>
                      <th>DB Operations</th>
                      <td class="estimate-table-data">{wsimpleDB}</td>
                      <td class="estimate-table-data">{wmediumDB}</td>
                      <td class="estimate-table-data">{wcomplexDB}</td>
                      <td class="estimate-table-data">{wveryComplexDB}</td>
                    </tr>
                    <tr>
                      <th>Parameter / Interface</th>
                      <td class="estimate-table-data">{wsimplePI}</td>
                      <td class="estimate-table-data">{wmediumPI}</td>
                      <td class="estimate-table-data">{wcomplexPI}</td>
                      <td class="estimate-table-data">{wveryComplexPI}</td>
                    </tr>
                    <tr>
                      <th>Cut Effort (PH)</th>
                      <td class="estimate-table-data">16</td>
                      <td class="estimate-table-data">24</td>
                      <td class="estimate-table-data">40</td>
                      <td class="estimate-table-data">80</td>
                    </tr>
                  </table>
                  <table class="table table-bordered">
                    <tr class="text-center estimate-table">
                      <th>JSP Servlet / JSF</th>
                      <th>Simple</th>
                      <th>Medium</th>
                      <th>Complex</th>
                      <th>Very Complex</th>
                    </tr>
                    <tr>
                      <th>DB Operations</th>
                      <td class="estimate-table-data">{jsimpleDB}</td>
                      <td class="estimate-table-data">{jmediumDB}</td>
                      <td class="estimate-table-data">{jcomplexDB}</td>
                      <td class="estimate-table-data">{jveryComplexDB}</td>
                    </tr>
                    <tr>
                      <th>Parameter / Interface</th>
                      <td class="estimate-table-data">{jsimplePI}</td>
                      <td class="estimate-table-data">{jmediumPI}</td>
                      <td class="estimate-table-data">{jcomplexPI}</td>
                      <td class="estimate-table-data">{jveryComplexPI}</td>
                    </tr>
                    <tr>
                      <th>Cut Effort (PH)</th>
                      <td class="estimate-table-data">16</td>
                      <td class="estimate-table-data">24</td>
                      <td class="estimate-table-data">40</td>
                      <td class="estimate-table-data">80</td>
                    </tr>
                  </table>
                </small>
              </div>
              <div class="col-md-6 col-sm-12 col-lg-6">
                <small>
                  <small>
                    <form>
                      <table class="table table-bordered">
                        <tr class="text-center estimate-table">
                          <th>Phases</th>
                          <th>Enter Estimation Variable Below</th>
                          <th>Effort(PH)</th>
                          <th>Effort(Man-Months)</th>
                        </tr>
                        <tr>
                          <th>
                            Business Requirements & Functional Specifications
                          </th>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{first} %</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{second}</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{third}</div>
                          </td>
                        </tr>
                        <tr>
                          <th>Detailed Design</th>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{fourth} %</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{fifth}</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{sixth}</div>
                          </td>
                        </tr>
                        <tr>
                          <th>Code & Unit Test</th>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{seventh} %</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{eighth}</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{ninth}</div>
                          </td>
                        </tr>
                        <tr>
                          <th>System Testing & System Integration Testing</th>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{tenth} %</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{eleven}</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{twelve}</div>
                          </td>
                        </tr>
                        <tr>
                          <th>User Acceptance Testing</th>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{thirteen} %</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{fourteen}</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{fifteen}</div>
                          </td>
                        </tr>
                        <tr>
                          <th>Project Management</th>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{sixteen} %</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{seventeen}</div>
                          </td>
                          <td class="estimate-table-data">
                            <div style={{ fontSize: 13 }}>{eighteen}</div>
                          </td>
                        </tr>

                        <tr>
                          <th>TOTAL</th>
                          <td
                            style={{ fontSize: 13 }}
                            class="estimate-table-data"
                          >
                            {first +
                              fourth +
                              seventh +
                              tenth +
                              thirteen +
                              sixteen}{" "}
                            %
                          </td>

                          <td style={{ fontSize: 13 }}>
                            {second +
                              fifth +
                              eighth +
                              eleven +
                              fourteen +
                              seventeen}
                          </td>
                          <td style={{ fontSize: 13 }}>
                            {third +
                              sixth +
                              ninth +
                              twelve +
                              fifteen +
                              eighteen}
                          </td>
                        </tr>
                      </table>
                    </form>
                  </small>
                </small>
              </div>
            </div>
            <br></br>
            <br></br>
            <button
              style={{ marginLeft: "50%" }}
              type="submit"
              class="btn btn-sm btn-success"
              onClick={(e) => {
                handleClick(e);
              }}
            >
              Submit
            </button>
          </div>
        </div>
      </div>
    </>
  );
}
