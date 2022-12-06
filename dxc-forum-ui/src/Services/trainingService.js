import axios from "axios";

const TRAINING_REST_API_URL = "http://localhost:9090/session";

class trainingService {
  uploadSessions() {
    return axios.get(TRAINING_REST_API_URL);
  }
  createTraining(training) {
    return axios.post(TRAINING_REST_API_URL, training);
  }

  getTrainingById(trainingId) {
    return axios.get(TRAINING_REST_API_URL + "/" + trainingId);
  }

  updateTraining(training, trainingId) {
    return axios.put(TRAINING_REST_API_URL + "/" + trainingId, training);
  }

  deleteTraining(trainingId) {
    return axios.delete(TRAINING_REST_API_URL + "/" + trainingId);
  }

  upload(filePath) {
    return axios.post(TRAINING_REST_API_URL + "-excel", filePath);
  }
  totalSession() {
    return axios.get(TRAINING_REST_API_URL + "/total");
  }
}

export default new trainingService();
