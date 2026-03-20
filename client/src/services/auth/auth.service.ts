import api from "../api";
import {
  LoginRequestDTO,
  LoginResponseDTO,
  RegisterRequestDTO,
} from "./auth.types";

export const authService = {
  login: async (credentials: LoginRequestDTO): Promise<LoginResponseDTO> => {
    try {
      const response = await api.post<LoginResponseDTO>(
        "/auth/login",
        credentials,
      );
      return response.data;
    } catch (error: any) {
      console.error("Erro:", error.response?.status, error.response?.data);
      throw error;
    }
  },

  register: async (userData: RegisterRequestDTO): Promise<void> => {
    try {
      await api.post("/auth/register", userData, {
        headers: {
          Authorization: undefined,
        },
      });
    } catch (error: any) {
      console.error(
        "Erro no Registro:",
        error.response?.status,
        error.response?.data,
      );
      throw error;
    }
  },
};
