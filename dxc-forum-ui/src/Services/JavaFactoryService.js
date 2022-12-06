import httpClient from "./BaseURL";

function getAllQues() {
  return httpClient.get("/question");
}

function saveQues(question) {
  return httpClient.post("/question", question);
}

function getAllAns() {
  return httpClient.get("/answer");
}

function getQuesById(id) {
  return httpClient.get(`/question/${id}`);
}

function getAnsById(id) {
  return httpClient.get(`/answer/${id}`);
}

function totalQuestion() {
  return httpClient.get("/total_question");
}

function findByQuesId(id) {
  return httpClient.get(`/ansbyquesid/${id}`);
}

function saveAnswer(answer) {
  return httpClient.post("/answer", answer);
}

function totalAns(id) {
  return httpClient.get(`/totalAns/${id}`);
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
  totalAns,
};
