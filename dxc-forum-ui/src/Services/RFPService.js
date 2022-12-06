import httpClient from "./BaseURL";

function getAll() {
  return httpClient.get("/rfp");
}

function getById(id) {
  return httpClient.get(`/rfp/${id}`);
}

function addRFP(rfp) {
  return httpClient.post("/rfp", rfp);
}

function deleteRFP(id) {
  return httpClient.delete(`/rfp/${id}`);
}

function updateRFP(id, rfp) {
  return httpClient.put(`/rfp/${id}`, rfp);
}

function addPhases(phases) {
  return httpClient.post(`/rfpPhases`, phases);
}

export default { getAll, getById, addRFP, deleteRFP, updateRFP, addPhases };
