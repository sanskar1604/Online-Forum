import React, { useState } from "react";

const UploadExcel = () => {
  const [files, setFiles] = useState("");
  //for displaying response message
  const [fileUploadResponse, setFileUploadResponse] = useState(null);
  //base end point url
  const FILE_UPLOAD_BASE_ENDPOINT = "http://localhost:9090/session";

  const uploadFileHandler = (event) => {
    setFiles(event.target.files);
  };

  const fileSubmitHandler = (event) => {
    event.preventDefault();
    setFileUploadResponse(null);
    const formData = new FormData();
    formData.append(`file`, files[0]);
    for (var [key, value] of formData.entries()) {
      console.log(key, value);
    }

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

        // check for error response
        if (!response.ok) {
          // get error message
          const error = (data && data.message) || response.status;
          setFileUploadResponse(data.message);
          return Promise.reject(error);
        }

        console.log(data.message);
        setFileUploadResponse(data.message);
      })
      .catch((error) => {
        console.error("Error while uploading file!", error);
      });
  };

  return (
    <small>
      <form onSubmit={fileSubmitHandler}>
        <div class="form-group mt-3">
          <label>Upload Excel Sheet</label>
          <input
            class="form-control shadow-sm"
            type="file"
            multiple
            onChange={uploadFileHandler}
          />
          <button class="btn btn-sm btn-success mt-3" type="submit">
            Upload
          </button>
          {fileUploadResponse != null && (
            <p style={{ color: "green" }}>{fileUploadResponse}</p>
          )}
        </div>
      </form>
    </small>
  );
};
export default UploadExcel;
