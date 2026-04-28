import axios from "axios";
import { storage } from "./storage";
import { MissionDetail } from '../types/backend';

const api = axios.create({
  baseURL: `http://localhost:8080`,
});

api.interceptors.request.use(
  async (config) => {
    const token = await storage.getToken();

    if (token && !config.url?.includes("/auth/")) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => {
    return Promise.reject(error);
  },
);

// Função para buscar missões de um planeta
export async function fetchMissoesDoPlaneta(planetaId: string) {
  const response = await api.get(`/planetas/${planetaId}/missoes`);
  return response.data;
}

export async function fetchDetalhesMissao(missaoId: string): Promise<MissionDetail> {
  const response = await fetch(`${API_URL}/missions/${missaoId}`); // Verifique se essa é a rota certa do seu back
  if (!response.ok) throw new Error('Falha ao buscar detalhes da missão');
  return response.json();
}

export default api;
