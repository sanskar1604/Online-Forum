import React, { useEffect, useState } from "react";
import JavaConsultancyService from "../../Services/JavaConsultancyService";
import { withRouter } from "../../Components/CustomNavigation";
import { useParams, useNavigate } from "react-router-dom";
import { Interaction } from "chart.js";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";

function ConsultancyAnswer() {
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

  const saveAnswer = (e) => {
    e.preventDefault();

    const ans = {
      answer,
      question: {
        id: params.id,
      },
    };
    JavaConsultancyService.saveAnswer(ans)
      .then((response) => {
        console.log("Data saved successfully");
        navigate(`/Consultancy/ConsultancyAnswer/${params.id}`);
        window.location.reload(false);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  useEffect(() => {
    init();
    getAnsByQuesId();
  }, []);

  const init = () => {
    JavaConsultancyService.getQuesById(params.id)
      .then((response) => {
        setQuestion(response.data);
        console.log("Question", response.data);
      })
      .catch((error) => {
        console.log("Error", error);
      });
  };

  const getAnsByQuesId = () => {
    JavaConsultancyService.findByQuesId(params.id)
      .then((response) => {
        setAnswers(response.data);
        console.log("C_Ans with C_Ques C_ID", response.data);
      })
      .catch((error) => {
        console.log("Error", error);
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
                <a href="/java_consultancy">Java Consultancy</a>
              </li>
              <li class="breadcrumb-item active" aria-current="page">
                Solution
              </li>
            </ol>
          </small>
        </nav>
        <div class="content-container">
          <div class="container-fluid">
            <div class="card shadow-sm mb-5">
              <small>
                <div className="card-body">
                  <h2>{question.title}</h2>
                  <p>
                    Category:{" "}
                    <span class="text-primary">{question.category}</span>
                  </p>
                  <hr></hr>
                  <h5>Query Description</h5>
                  <p class="text-dark">
                    <div class="jumbotron">
                      <p
                        dangerouslySetInnerHTML={{ __html: question.body }}
                      ></p>
                      <small class="float-right font-weight-bold">
                        {formatDate(question.createdDate)}
                      </small>
                    </div>
                  </p>
                  {/* <span class="badge text-bg-info mb-4 mx-3">
                          React JS
                        </span>
                        <span class="badge text-bg-info">Node Js</span> */}
                  <br></br>
                  <hr></hr>
                  <h5>All Solution</h5>
                  {answers.map((ans) => (
                    <div class="jumbotron">
                      <p dangerouslySetInnerHTML={{ __html: ans.answer }}></p>
                      <small class="float-right font-weight-bold">
                        {formatDate(ans.createdDate)}
                      </small>
                    </div>
                  ))}
                  <h5>Your Solution</h5>
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
                          placeholder="Your Solution"
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
              </small>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default ConsultancyAnswer;
