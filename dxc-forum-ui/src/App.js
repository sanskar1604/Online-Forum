import "./App.css";
import Dashboard from "./MainComponents/Dashboard";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Mentoring from "./MainComponents/Mentoring";
import AddMentoring from "./MainComponents/ChildComponents/AddMentoring";
import EditMentoring from "./MainComponents/ChildComponents/EditMentoring";
import Training from "./MainComponents/Training";
import Certification from "./MainComponents/Certification";
import AddCertification from "./MainComponents/ChildComponents/AddCertification";
import UpdateCertificate from "./MainComponents/ChildComponents/UpdateCertificate";
import AddTraining from "./MainComponents/ChildComponents/AddTraining";
import Java_factory from "./MainComponents/Java_factory";
import Question from "./MainComponents/ChildComponents/questions";
import Answer from "./MainComponents/ChildComponents/Answer";
import Signup from "./MainComponents/Signup";
import EditTraining from "./MainComponents/ChildComponents/EditTraining";
import Login from "./MainComponents/Login";
import Consultancy from "./MainComponents/Consultancy";
import ConsultancyQuestion from "./MainComponents/ChildComponents/ConsultancyQuestion";
import ConsultancyAnswer from "./MainComponents/ChildComponents/ConsultancyAnswer";
import RFP from "./MainComponents/RFP";
import ViewRFP from "./MainComponents/ChildComponents/ViewRFP";
import EstimateRFP from "./MainComponents/ChildComponents/EstimateRFP";
import AddRFP from "./MainComponents/ChildComponents/AddRFP";
import EditRFP from "./MainComponents/ChildComponents/EditRFP";
import ViewMentoring from "./MainComponents/ChildComponents/ViewMentoring";
import Data from "./MainComponents/Data";
import AddData from "./MainComponents/ChildComponents/AddData";
import AddPhasesForm from "./MainComponents/ChildComponents/AddPhasesForm";

function App() {
  return (
    <>
      <BrowserRouter>
        <div class="container-fluid" id="main">
          <div class="row row-offcanvas row-offcanvas-left">
            <Routes>
              <Route path="/signup" element={<Signup />} />
              <Route path="/login" element={<Login />} />
              <Route path="/" element={<Dashboard />} />
              <Route path="/mentoring" element={<Mentoring />} />
              <Route
                path="/mentoring/add-mentoring"
                element={<AddMentoring />}
              />
              <Route path="/mentoring/:id" element={<EditMentoring />} />
              <Route
                path="/mentoring/view_mentoring/:id"
                element={<ViewMentoring />}
              />
              <Route path="/training" element={<Training />} />
              <Route path="/training/add-training" element={<AddTraining />} />
              <Route path="/training/:id" element={<EditTraining />} />
              <Route path="/certification" element={<Certification />} />
              <Route
                path="/certification/add-certification"
                element={<AddCertification />}
              />
              <Route path="/certificate/:id" element={<UpdateCertificate />} />
              <Route path="/java_factory" element={<Java_factory />} />
              <Route path="/java_factory/question" element={<Question />} />
              <Route path="/java_factory/answer/:id" element={<Answer />} />
              <Route path="/consultancy" element={<Consultancy />} />

              <Route path="/consultancy" element={<Consultancy />} />
              <Route
                path="/Consultancy/ConsultancyQuestion"
                element={<ConsultancyQuestion />}
              />
              <Route
                path="/Consultancy/ConsultancyAnswer/:id"
                element={<ConsultancyAnswer />}
              />

              <Route path="/rfp" element={<RFP />} />
              <Route path="/rfp/view_rfp/:id" element={<ViewRFP />} />
              <Route path="/rfp/estimate_rfp/:id" element={<EstimateRFP />} />
              <Route path="/rfp/add-rfp" element={<AddRFP />} />
              <Route path="/rfp/edit_rfp/:id" element={<EditRFP />} />

              <Route path="/rfp/estimate_rfp/data/:id"element={<Data/>}/>
              <Route path="/rfp/adddata/:id"element={<AddData/>}/>

              <Route

                path="/AddPhasesForm/:id"

                element={<AddPhasesForm />}

              />

              {/* 
              <Route path="/consultancy/new_request" element={<NewRequest />} /> */}
            </Routes>
          </div>
        </div>
      </BrowserRouter>
    </>
  );
}

export default App;
