import { api } from "@/services";
import React, { useEffect, useState } from "react";
import { ActivityIndicator, Text, View } from "react-native";

interface LevelDTO {
  name: string;
  xpRequired: number;
}

interface UserDTO {
  username: string;
  email: string;
  xp: number;
  oxygen: number;
  level: LevelDTO;
}

const ProfileScreen = () => {
  const [user, setUser] = useState<UserDTO | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchProfile();
  }, []);

  const fetchProfile = async () => {
    try {
      const response = await api.get<UserDTO>("/me");
      setUser(response.data);
    } catch (error) {
      console.error("Erro ao carregar perfil");
    } finally {
      setLoading(false);
    }
  };

  if (loading) return <ActivityIndicator />;
  if (!user) return <Text>Usuário não encontrado</Text>;

  const progress = (user.xp / user.level.xpRequired) * 100;

  return (
    <View>
      <View>
        <Text>Perfil de: {user.username}</Text>
        <Text>E-mail: {user.email}</Text>
      </View>

      <View>
        <Text>Nível: {user.level.name}</Text>
        <Text>XP Atual: {user.xp}</Text>
        <Text>XP Necessário: {user.level.xpRequired}</Text>
        <Text>Progresso: {progress.toFixed(2)}%</Text>
        <Text>Status Oxigênio: {user.oxygen}%</Text>
      </View>

      <View>
        <Text>
          Faltam {user.level.xpRequired - user.xp} XP para subir de nível
        </Text>
      </View>
    </View>
  );
};

export default ProfileScreen;
