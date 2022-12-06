import httpClient from "./BaseURL";

function getAll() {
  return httpClient.get("/certification");
}
function save(certificate) {
  return httpClient.post("/certification", certificate);
}
function deleteById(id) {
  return httpClient.delete(`/certification/${id}`);
}
function getById(id) {
  return httpClient.get(`/certification/${id}`);
}
function update(certificate, id) {
  return httpClient.put("/certification/" + id, certificate);
}
function totalCertificate() {
  return httpClient.get("/total_certificate");
}

function exportCertificate() {
  return httpClient.get("/download/certificate.xlsx");
}
export default {
  getAll,
  save,
  deleteById,
  getById,
  update,
  totalCertificate,
  exportCertificate,
};
