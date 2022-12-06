import httpClient from "./BaseURL";

function addJSPService(rfp_jsp) {
  return httpClient.post(`/rfpJSP`, rfp_jsp);
}
function getAll() {
  return httpClient.get(`/rfpJSP`);
}
function getfindByRfpId(id)
{
  return httpClient.get(`/rfpJSP/jspbyrfp/${id}`);
}

export default {addJSPService, getAll, getfindByRfpId};
