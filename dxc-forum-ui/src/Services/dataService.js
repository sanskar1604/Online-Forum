import httpClient from "./BaseURL";

function getAll() {
  return httpClient.get("/data");
}

function getById(id) {
  return httpClient.get(`/data/${id}`);
}

function addData(data) {
  return httpClient.post("/data", data);
}

function deleteData(id) {
  return httpClient.delete(`/data/${id}`);
}

function updateData(id, data) {
  return httpClient.put(`/data/${id}`, data);
}

export default { getAll, getById, addData, deleteData, updateData };