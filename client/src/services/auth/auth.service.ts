import api from "../api";
import {
  LoginRequestDTO,
  LoginResponseDTO,
  RegisterRequestDTO,
} from "./auth.types";

export const authService = {
  login: async (credentials: LoginRequestDTO): Promise<LoginResponseDTO> => {
    try {
      const response = await api.post<LoginResponseDTO>("/auth/login", credentials);
      return response.data;
    } catch (error: any) {
      console.error("Erro detalhado no login:", error.response?.status, error.response?.data);
      throw error;
    }
  },

  register: async (userData: RegisterRequestDTO): Promise<void> => {
    await api.post("/auth/register", userData);
  },
};
