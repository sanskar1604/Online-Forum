import httpClient from "./BaseURL";

function getAllQues() {
  return httpClient.get("/consultancy_question");
}

function saveQues(c_question) {
  return httpClient.post("/consultancy_question", c_question);
}

function getAllAns() {
  return httpClient.get("/consultancy_answer");
}

function getQuesById(c_id) {
  return httpClient.get(`/consultancy_question/${c_id}`);
}

function getAnsById(c_id) {
  return httpClient.get(`/consultancy_answer/${c_id}`);
}

function totalQuestion() {
  return httpClient.get("/consultancy_question/c_total_question");
}

function findByQuesId(id) {
  return httpClient.get(`/c_ansbyquesid/${id}`);
}

function saveAnswer(c_answer) {
  return httpClient.post("/consultancy_answer", c_answer);
}

export default {
  getAllQues,
  saveQues,
  getAllAns,
  getQuesById,
  getAnsById,
  totalQuestion,
  findByQuesId,
  saveAnswer,
};
