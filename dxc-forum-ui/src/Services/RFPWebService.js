import httpClient from "./BaseURL";

function addWebService(rfp_web_services) {
  return httpClient.post(`/rfpWebServices`, rfp_web_services);
}
function getAll() {
  return httpClient.get(`/rfpWebServices`);
}
function getfindByRfpId(id)
{
  return httpClient.get(`/rfpWebServices/webservicesbyrfp/${id}`);
}

export default {addWebService, getAll, getfindByRfpId};
