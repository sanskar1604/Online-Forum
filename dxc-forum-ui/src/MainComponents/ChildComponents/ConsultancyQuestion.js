import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import JavaConsultancyService from "../../Services/JavaConsultancyService";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";

function ConsultancyQuestion() {
  const navigate = useNavigate();
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");
  const [category, setCategory] = useState("");
  const saveQuestion = (e) => {
    e.preventDefault();

    const c_question = {
      title,
      body,
      category,
    };

    JavaConsultancyService.saveQues(c_question)
      .then((response) => {
        console.log("Questions data", response.data);
        navigate("/Consultancy");
        window.location.reload(false);
      })
      .catch((error) => {
        console.log("Something went wrong ", error);
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
                Ticket
              </li>
            </ol>
          </small>
        </nav>
        {/* <p class="lead d-none d-sm-block">Add Employee Details and Records</p>
         */}

        <div class="container">
          <small>
            <div class="row">
              <div class="col-md-10">
                <h1 class="d-inline">Raise Ticket</h1>
              </div>
            </div>
          </small>
        </div>
        <div class="content-container">
          <div class="container-fluid">
            <small>
              <div class="card shadow-sm mb-5 mt-3">
                <div className="card-body">
                  <form>
                    <div class="form-group">
                      <label for="category">
                        {" "}
                        <b>Category</b>
                      </label>
                      <br></br>
                      <small>Choose specific category to raise a ticket</small>
                      <select
                        id=""
                        onChange={(e) => setCategory(e.target.value)}
                        class="form-control shadow-sm mt-3"
                      >
                        <option selected disabled>
                          --Select Category--
                        </option>
                        <option value="Mentoring">Mentoring</option>
                        <option value="Traning">Training</option>
                        <option value="Certification">Certification</option>
                        <option value="Java Factory">Java Factory</option>
                        <option value="RFP Tracker">RFP Tracker</option>
                        <option value="Other">Other</option>
                      </select>
                    </div>

                    <div class="form-group">
                      <label for="title">
                        <b>Query</b>
                      </label>
                      <br></br>
                      <small>Be specific while asking your query.</small>
                      <input
                        class="form-control shadow-sm mt-3"
                        name="title"
                        placeholder="e.g. Is there any project available for allocation ?"
                        onChange={(e) => setTitle(e.target.value)}
                        value={title}
                      ></input>
                    </div>
                    <div class="form-group mt-4">
                      <label for="body">
                        <b>Description</b>
                      </label>
                      <br></br>
                      <small>
                        Include all the information someone would need to
                        resolve your query.<br></br>
                      </small>
                      <br></br>
                      {/* <textarea
                        rows="4"
                        class="form-control shadow-sm mt-3"
                        name="body"
                        onChange={(e) => setBody(e.target.value)}
                        value={body}
                        placeholder="Include all the information someone would need to resolve your ticket"
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
                            setBody(data);
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
                    </div>
                    <button
                      class="btn btn-success mt-3"
                      onClick={(e) => saveQuestion(e)}
                    >
                      RaiseTicket
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

export default ConsultancyQuestion;
