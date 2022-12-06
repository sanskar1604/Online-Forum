import React, { useState } from "react";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import { Link, useNavigate } from "react-router-dom";
import RFPService from "../../Services/RFPService";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";
import { useParams } from "react-router-dom";

export default function AddPhasesForm(props) {
  const navigate = useNavigate();

  const params = useParams();

  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "short", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };

  let roundOff = (num, places) => {
    const x = Math.pow(10, places);
    return Math.round(num * x) / x;
  };

  const [phases, SetPhases] = useState("");
  const [estimationVariables, setEstimationVariable] = useState("");
  const [effort_PH, setEffortPh] = useState("");
  const [effortManMonths, setEffortManMonths] = useState("");

  const [x, setX] = useState("");

  const [first, setFirst] = useState(0);
  const [second, setSecond] = useState(0);
  const [third, setThird] = useState(0);
  const [fourth, setFourth] = useState(0);
  const [fifth, setFifth] = useState(0);
  const [sixth, setSixth] = useState(0);
  const [seventh, setSeventh] = useState(0);
  const [eighth, setEighth] = useState(0);
  const [ninth, setNinth] = useState(0);
  const [tenth, setTenth] = useState(0);
  const [eleven, setEleven] = useState(0);
  const [twelve, setTwelve] = useState(0);
  const [thirteen, setThirteen] = useState(0);
  const [fourteen, setFourteen] = useState(0);
  const [fifteen, setFifteen] = useState(0);
  const [sixteen, setSixteen] = useState(0);
  const [seventeen, setSeventeen] = useState(0);
  const [eighteen, setEighteen] = useState(0);

  const [sdb, setSdb] = useState(0);
  const [spi, setSpi] = useState(0);
  const [wdb, setWdb] = useState(0);
  const [wpi, setWpi] = useState(0);
  const [jdb, setJdb] = useState(0);
  const [jpi, setJpi] = useState(0);

  const changeFirstInput = (e) => {
    setFirst(e.target.value);
    const result = (first / seventh) * eighth;
    setSecond(roundOff(result, 1));
  };
  const changeSecondInput = (e) => {
    // setSecond(e.target.value);
    const result2 = second / 160;
    setThird(roundOff(result2, 1));
  };
  const changeThirdInput = (e) => {
    setThird(e.target.value);
  };
  const changeFourthInput = (e) => {
    setFourth(e.target.value);
  };
  const changeFifthInput = (e) => {
    setFifth(e.target.value);
    const result3 = (fifth / 160) * 10;
    setSixth(roundOff(result3, 1));
  };
  const changeSixInput = (e) => {
    // setNinth(e.target.value);
  };
  const changeSevenInput = (e) => {
    const result = (first / seventh) * eighth;
    setSecond(roundOff(result * 10, 1));
    setSeventh(e.target.value);
  };
  const changeEightInput = (e) => {
    setEighth(e.target.value);
    const result = (first / seventh) * eighth;
    setSecond(roundOff(result, 1));
    setNinth(roundOff((eighth / 160) * 10, 1));
  };
  const changeNinthInput = (e) => {
    setNinth(e.target.value);
  };
  const changeTenInput = (e) => {
    setTenth(e.target.value);
  };
  const changeElevenInput = (e) => {
    setEleven(e.target.value);
    setTwelve(roundOff(eleven / 160, 1));
  };
  const changeTewelthInput = (e) => {
    setTwelve(e.target.value);
  };
  const changeThirteenInput = (e) => {
    setThirteen(e.target.value);
  };
  const changeFourteenInput = (e) => {
    const result1 = (fourteen * 15) / 100;
    setEleven(roundOff(result1 * 10, 1));
    setFourteen(e.target.value);
    setFifteen(roundOff((fourteen / 160) * 10, 1));
  };
  const changeFifteenInput = (e) => {
    setFifteen(e.target.value);
  };
  const changeSixteenInput = (e) => {
    setSixteen(e.target.value);
  };
  const changeSeventeenInput = (e) => {
    setSeventeen(e.target.value);
    setEighteen(roundOff((seventeen / 160) * 10, 1));
  };
  const changeEighteenInput = () => {};

  const changeSdb = (e) => {
    setSdb(e.target.value);
  };
  const changeSpi = () => {};
  const changeWdb = () => {};
  const changeWpi = () => {};
  const changeJdb = () => {};
  const changeJpi = () => {};

  function handleChange(event) {}

  // function handleClick(){
  //   // setX(estimationVariables);

  //   // const toComponentB=()=>{
  //   //   navigate('/EstimateRFP',{state:{id:1,value:x}});
  //   //     }

  // }

  const handleClick = () => {
    navigate(`/rfp/estimate_rfp/${params.id}`, {
      state: {
        first: first,
        second: second,
        third: third,
        fourth: fourth,
        fifth: fifth,
        sixth: sixth,
        seventh: seventh,
        eighth: eighth,
        ninth: ninth,
        tenth: tenth,
        eleven: eleven,
        twelve: twelve,
        thirteen: thirteen,
        fourteen: fourteen,
        fifteen: fifteen,
        sixteen: sixteen,
        seventeen: seventeen,
        eighteen: eighteen,
        sDB: sdb,
        sPI: spi,
        wDB: wdb,
        wPI: wpi,
        jDB: jdb,
        jPI: jpi,
      },
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
                <a href="/rfp">RFP Tracker</a>
              </li>
              <li class="breadcrumb-item active" aria-current="page">
                Add Data
              </li>
            </ol>
          </small>
        </nav>

        {/* <i class="fa-solid fa-plus fa-2x d-inline mr-2"></i> */}
        <small>
          <h1 class="d-inline">Add Data</h1>
          <div class="content-container">
            <div class="container-fluid">
              <div class="card shadow-sm mb-5 mt-3">
                <div className="card-body">
                  <form>
                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        Business Requirements & Functional Specifications
                      </label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Business Requirements & Functional Specifications"
                        name="phases"
                        value="Business Requirements & Functional Specifications"
                        onChange={(e) => SetPhases(e.target.value)}
                        required></input> */}
                    </div>
                    <div class="form-group mt-3">
                      <label>EstimationVariables</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Estimation Variables"
                        name="first"
                        onChange={(e) => {
                          changeFirstInput(e);

                          setEstimationVariable(e.target.value);
                        }}
                        value={first}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(PH)</label>
                      {
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Effort(PH)"
                          name="second"
                          onChange={(e) => {
                            changeSecondInput(e);

                            setEffortPh(e.target.value);
                          }}
                          value={second}
                          required
                        ></input>
                      }
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(man-months)</label>
                      {
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Effort(man-months)"
                          name="third"
                          onChange={(e) => {
                            changeThirdInput(e);

                            setEffortManMonths(e.target.value);
                          }}
                          value={third}
                          required
                        ></input>
                      }
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        Detailed Design
                      </label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Detailed Design"
                        name="phases"
                        value="Detailed Design"
                        onChange={(e) => SetPhases(e.target.value)}
                        required></input> */}
                    </div>
                    <div class="form-group mt-3">
                      <label>EstimationVariables</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Estimation Variables"
                        name="fourth"
                        onChange={(e) => {
                          changeFourthInput(e);

                          setEstimationVariable(e.target.value);
                        }}
                        value={fourth}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(PH)</label>
                      {
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Effort(PH)"
                          name="fifth"
                          onChange={(e) => {
                            changeFifthInput(e);

                            setEffortPh(e.target.value);
                          }}
                          value={fifth}
                          required
                        ></input>
                      }
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(man-months)</label>
                      {
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Effort(man-months)"
                          name="sixth"
                          onChange={(e) => {
                            changeSixInput(e);

                            setEffortManMonths(e.target.value);
                          }}
                          value={sixth}
                          required
                        ></input>
                      }
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        Code & Unit Test
                      </label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Code & Unit Test"
                        name="phases"
                        value="Code & Unit Test"
                        onChange={(e) => SetPhases(e.target.value)}
                        required></input> */}
                    </div>
                    <div class="form-group mt-3">
                      <label>EstimationVariables</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Estimation Variables"
                        name="seventh"
                        onChange={(e) => {
                          changeSevenInput(e);

                          setEstimationVariable(e.target.variable);
                        }}
                        value={seventh}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(PH)</label>
                      {
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Effort(PH)"
                          name="eighth"
                          onChange={(e) => {
                            changeEightInput(e);

                            setEffortPh(e.target.value);
                          }}
                          value={eighth}
                          required
                        ></input>
                      }
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(man-months)</label>
                      {
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Effort(man-months)"
                          name="ninth"
                          onChange={(e) => {
                            changeNinthInput(e);

                            setEffortManMonths(e.target.value);
                          }}
                          value={ninth}
                          required
                        ></input>
                      }
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        System Testing & System Integration Testing
                      </label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="System Testing & System Integration Testing"
                        name="phases"
                        value="System Testing & System Integration Testing"
                        onChange={(e) => SetPhases(e.target.value)}
                        required></input> */}
                    </div>
                    <div class="form-group mt-3">
                      <label>EstimationVariables</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Estimation Variables"
                        name="tenth"
                        onChange={changeTenInput}
                        value={tenth}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(PH)</label>
                      {
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Effort(PH)"
                          name="eleven"
                          onChange={changeElevenInput}
                          value={eleven}
                          required
                        ></input>
                      }
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(man-months)</label>
                      {
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Effort(man-months)"
                          name="twelve"
                          onChange={changeTewelthInput}
                          value={twelve}
                          required
                        ></input>
                      }
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        User Acceptance Testing
                      </label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="User Acceptance Testing"
                        name="phases"
                        value="User Acceptance Testing"
                        onChange={(e) => SetPhases(e.target.value)}
                        required></input> */}
                    </div>
                    <div class="form-group mt-3">
                      <label>EstimationVariables</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Estimation Variables"
                        name="thirteen"
                        onChange={changeThirteenInput}
                        value={thirteen}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(PH)</label>
                      {
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Effort(PH)"
                          name="fourteen"
                          onChange={changeFourteenInput}
                          value={fourteen}
                          required
                        ></input>
                      }
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(man-months)</label>
                      {
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Effort(man-months)"
                          name="fifteen"
                          onChange={changeFifteenInput}
                          value={fifteen}
                          required
                        ></input>
                      }
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        Project Management
                      </label>
                      {/* <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Project Management"
                        name="phases"
                        value="Project Management"
                        onChange={(e) => SetPhases(e.target.value)}
                        required></input> */}
                    </div>
                    <div class="form-group mt-3">
                      <label>EstimationVariables</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Estimation Variables"
                        name="sixteen"
                        onChange={changeSixteenInput}
                        value={sixteen}
                        required
                      ></input>
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(PH)</label>
                      {
                        <input
                          type="text"
                          class="form-control shadow-sm"
                          placeholder="Effort(PH)"
                          name="seventeen"
                          onChange={changeSeventeenInput}
                          value={seventeen}
                          required
                        ></input>
                      }
                    </div>
                    <div class="form-group mt-3">
                      <label>Effort(man-months)</label>
                      {
                        <input
                          type="email"
                          class="form-control shadow-sm"
                          placeholder="Effort(man-months)"
                          name="eighteen"
                          onChange={changeEighteenInput}
                          value={eighteen}
                          required
                        ></input>
                      }
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        Springboot / Microservices / API
                      </label>
                    </div>
                    <div class="form-group mt-3">
                      <label>DB Operations</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="DB Operations"
                        name="sdb"
                        onChange={changeSdb}
                        value={sdb}
                        required
                      ></input>
                    </div>

                    <div class="form-group mt-3">
                      <label>Parameters / Interface</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Parameters / Interface"
                        name="spi"
                        onChange={(e) => setSpi(e.target.value)}
                        value={spi}
                        required
                      ></input>
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        WebServices (Spring MVC, Rest API)
                      </label>
                    </div>
                    <div class="form-group mt-3">
                      <label>DB Operations</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="DB Operations"
                        name="wdb"
                        onChange={(e) => setWdb(e.target.value)}
                        value={wdb}
                        required
                      ></input>
                    </div>

                    <div class="form-group mt-3">
                      <label>Parameters / Interface</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Parameters / Interface"
                        name="wpi"
                        onChange={(e) => setWpi(e.target.value)}
                        value={wpi}
                        required
                      ></input>
                    </div>

                    <div class="form-group mt-3">
                      <label style={{ fontSize: 20, fontWeight: "bold" }}>
                        JSP Servlet / JSF
                      </label>
                    </div>
                    <div class="form-group mt-3">
                      <label>DB Operations</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="DB Operations"
                        name="jdb"
                        onChange={(e) => setJdb(e.target.value)}
                        value={jdb}
                        required
                      ></input>
                    </div>

                    <div class="form-group mt-3">
                      <label>Parameters / Interface</label>
                      <input
                        type="text"
                        class="form-control shadow-sm"
                        placeholder="Parameters / Interface"
                        name="Parameters / Interface"
                        onChange={(e) => setJpi(e.target.value)}
                        value={jpi}
                        required
                      ></input>
                    </div>

                    <button
                      type="submit"
                      class="btn btn-success mt-3"
                      onClick={() => {
                        handleClick();
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
}
