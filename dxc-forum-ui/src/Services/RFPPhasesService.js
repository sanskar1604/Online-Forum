import httpClient from "./BaseURL";



function addPhases(phases) {

  return httpClient.post(`/rfpPhases`, phases);

}

function getAll() {

  return httpClient.get(`/rfpPhases`);

}

function getfindByRfpId(id)
{
  return httpClient.get(`/rfpPhases/phasesbyrfp/${id}`);
}

export default {addPhases, getAll, getfindByRfpId};