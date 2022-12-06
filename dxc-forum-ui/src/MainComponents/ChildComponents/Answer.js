import React, { useEffect, useState } from "react";
import JavaFactoryService from "../../Services/JavaFactoryService";
import { withRouter } from "../../Components/CustomNavigation";
import { useParams, useNavigate } from "react-router-dom";
import { Interaction } from "chart.js";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";

function Answer() {
  const formatDate = (dateString) => {
    const options = { year: "numeric", month: "short", day: "numeric" };
    return new Date(dateString).toLocaleDateString(undefined, options);
  };
  const params = useParams();
  const navigate = useNavigate();
  console.log("Url id", params.id);

  const [question, setQuestion] = useState([]);
  const [answers, setAnswers] = useState([]);

  const [answer, setAnswer] = useState("");
  const [ques_id, setQuesId] = useState("");
  const [totalAns, setTotalAns] = useState("");

  const saveAnswer = (e) => {
    e.preventDefault();

    const ans = {
      answer,
      question: {
        id: params.id,
      },
    };
    JavaFactoryService.saveAnswer(ans)
      .then((response) => {
        console.log("Data saven successfully");
        navigate(`/java_factory/answer/${params.id}`);
        window.location.reload(false);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    init();
    getAnsByQuesId();
    totalAnswer();
  }, []);

  const init = () => {
    JavaFactoryService.getQuesById(params.id)
      .then((response) => {
        setQuestion(response.data);
        console.log("Question", response.data);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };

  const getAnsByQuesId = (id) => {
    JavaFactoryService.findByQuesId(params.id)
      .then((response) => {
        setAnswers(response.data);
        console.log("Ans with Ques ID", response.data);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };

  const totalAnswer = () => {
    JavaFactoryService.totalAns(params.id)
      .then((response) => {
        setTotalAns(response.data);
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
                <a href="/java_factory">Java Factory</a>
              </li>
              <li class="breadcrumb-item active" aria-current="page">
                Answer
              </li>
            </ol>
          </small>
        </nav>
        <div class="content-container">
          <div class="container-fluid">
            <small>
              <div class="card shadow-sm mb-5">
                <div className="card-body">
                  <h3 class="text-primary" style={{ marginLeft: 50 }}>
                    {question.title}
                  </h3>
                  <p style={{ marginLeft: 50 }}>
                    <span class="font-weight-bold">Asked:</span>{" "}
                    {formatDate(question.createdDate)}
                  </p>
                  <hr></hr>
                  <p class="text-dark">
                    <div
                      class="jumbotron"
                      dangerouslySetInnerHTML={{ __html: question.body }}
                    ></div>
                  </p>
                  {/* <span class="badge text-bg-info mb-4 mx-3">
                          React JS
                        </span>
                        <span class="badge text-bg-info">Node Js</span> */}
                  <br></br>
                  <hr></hr>
                  <h5>{totalAns} Answers</h5>
                  <div class="row">
                    <div class="col-md-1">
                      <i class="fas fa-caret-up fa-2x text-secondary"></i>
                      <h3 class="text-secondary">{totalAns}</h3>
                      <i class="fas fa-caret-down fa-2x text-secondary"></i>
                    </div>
                    <div class="col-md-11">
                      {answers.map((ans) => (
                        <div class="jumbotron">
                          <p
                            dangerouslySetInnerHTML={{ __html: ans.answer }}
                          ></p>
                          <small class="float-right font-weight-bold">
                            {formatDate(ans.createdDate)}
                          </small>
                        </div>
                      ))}
                    </div>
                  </div>

                  <h3>Your Answer</h3>
                  <form>
                    <input
                      type="hidden"
                      value={params.id}
                      name="ques_id"
                      onChange={(e) => setQuesId(e.target.value)}
                    ></input>
                    {/* <textarea
                          rows="8"
                          class="form-control shadow-sm mt-3"
                          name="body"
                          placeholder="Your Answer"
                          value={answer}
                          onChange={(e) => setAnswer(e.target.value)}
                        ></textarea> */}
                    <div className="App">
                      <CKEditor
                        editor={Editor}
                        data=""
                        onReady={(editor) => {
                          console.log("Editor is ready to use!", editor);
                        }}
                        onChange={(event, editor) => {
                          const data = editor.getData();
                          setAnswer(data);
                          console.log({ event, editor, data });
                        }}
                        onBlur={(event, editor) => {
                          console.log("Blur.", editor);
                        }}
                        onFocus={(event, editor) => {
                          console.log("Focus.", editor);
                        }}
                      />
                    </div>
                    <button
                      class="btn btn-success mt-3 mb-5"
                      onClick={(e) => saveAnswer(e)}
                    >
                      Post Answer
                    </button>
                  </form>
                </div>
              </div>
            </small>
          </div>
        </div>
      </div>
    </>
  );
}

export default Answer;
