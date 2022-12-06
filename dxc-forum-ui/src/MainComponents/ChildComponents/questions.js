import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Navbar from "../../Components/Navbar";
import Sidebar from "../../Components/Sidebar";
import JavaFactoryService from "../../Services/JavaFactoryService";
import Editor from "ckeditor5-custom-build/build/ckeditor";
import { CKEditor } from "@ckeditor/ckeditor5-react";

function Question() {
  //For Saving the Questions in DB
  const navigate = useNavigate();
  const [title, setTitle] = useState("");
  const [body, setBody] = useState("");

  const saveQuestion = (e) => {
    e.preventDefault();

    const question = {
      title,
      body,
    };

    JavaFactoryService.saveQues(question)
      .then((response) => {
        console.log("Questions data", response.data);
        navigate("/java_factory");
        window.location.reload(false);
      })
      .catch((error) => {
        console.log("Something went wrong in add certificate", error);
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
                Question
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
                <h1 class="d-inline">Ask Question</h1>
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
                      <label for="title">
                        <b>Title</b>
                      </label>
                      <br></br>
                      <small>
                        Be specific and imagine you’re asking a question to
                        another person
                      </small>
                      <input
                        class="form-control shadow-sm mt-3"
                        name="title"
                        placeholder="e.g. Is there any project available for allocation ?"
                        onChange={(e) => setTitle(e.target.value)}
                        value={title}
                      ></input>
                    </div>
                    {/*  */}
                    <div class="form-group mt-4">
                      <label for="body">
                        <b>Body</b>
                      </label>
                      <br></br>
                      <small>
                        Include all the information someone would need to answer
                        your question
                      </small>
                      {/* <textarea
                        rows="4"
                        class="form-control shadow-sm mt-3"
                        name="body"
                        onChange={(e) => setBody(e.target.value)}
                        value={body}
                        placeholder="Include all the information someone would need to answer your question"
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
                      Post Question
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

export default Question;
