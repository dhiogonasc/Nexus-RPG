import axios from "axios";
import { storage } from "./storage";

const api = axios.create({
  //URL do servidor no Render
  baseURL: "https://nexus-server-gewa.onrender.com",
});

api.interceptors.request.use(
  async (config) => {
    const token = await storage.getToken();

    // Se tiver token e a rota NÃO for de autenticação (ex: login/cadastro), ele envia o token
    if (token && !config.url?.includes("/auth/")) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

export default api;