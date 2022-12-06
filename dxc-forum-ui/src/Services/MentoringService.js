import httpClient from "./BaseURL";

function getAll() {
  return httpClient.get("/mentoring");
}

function AddMentoring(mentor) {
  return httpClient.post("/mentoring", mentor);
}

function getById(id) {
  return httpClient.get(`/mentoring/${id}`);
}

function update(mentoring, id) {
  return httpClient.put(`/mentoring/${id}`, mentoring);
}

function deleteById(id) {
  return httpClient.delete(`/mentoring/${id}`);
}

function totalEmployee() {
  return httpClient.get("/total_employee");
}

export default {
  getAll,
  AddMentoring,
  getById,
  update,
  deleteById,
  totalEmployee,
};
