import httpClient from "./BaseURL";

function addSpringbootService(rfp_springboot) {
  return httpClient.post(`/rfpSpringboot`, rfp_springboot);
}
function getAll() {
  return httpClient.get(`/rfpSpringboot`);
}
function getfindByRfpId(id)
{
  return httpClient.get(`/rfpSpringboot/springbootbyrfp/${id}`);
}

export default {addSpringbootService, getAll, getfindByRfpId};
