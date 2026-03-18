import axios from 'axios';
import { storage } from './storage';
import { LOCALHOST_IP } from './auth/host';

const api = axios.create({
  baseURL: `http://${LOCALHOST_IP}:8080`,
});

api.interceptors.request.use(async (config) => {
  const token = await storage.getToken();
  
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  
  return config;
}, (error) => {
  return Promise.reject(error);
});

export default api;