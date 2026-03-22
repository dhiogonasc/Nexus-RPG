export interface LoginRequestDTO {
  email: string;
  password?: string;
}

export interface LoginResponseDTO {
  token: string;
  expiresIn: number;
  loggedInAt: string;
}

export interface RegisterRequestDTO {
  username: string;
  email: string;
  password?: string;
}