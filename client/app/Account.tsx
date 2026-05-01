import React, { useState, useEffect } from 'react';
import {
  View,
  Text,
  Platform,
  Image,
  StatusBar,
  ScrollView,
  KeyboardAvoidingView,
  TouchableOpacity,
  Alert,
  ActivityIndicator, // Adicionado para o Loading
} from 'react-native';
import { AccountStyles as S } from '@/styles/AccountStyles';
import { LinearGradient } from 'expo-linear-gradient';
import { Link } from 'expo-router';

// ⚠️ Adicione o import da sua API configurada
import api from '@/services/api'; 

interface UserData {
  id: string;
  name: string;
  email: string;
  xp: number;
  level: number;
  levelName: string;
  createdAt: string;
}

export function ProfileScreen() {
  // Substituir o mock pelos dados reais do usuário no futuro
}

export default function Account() {
  // --- NOVOS ESTADOS ---
  // Começa como 'null' porque não temos os dados até a API responder
  const [user, setUser] = useState<UserData | null>(null); 
  const [loading, setLoading] = useState<boolean>(true); // Controla a bolinha de carregamento

  // --- BUSCANDO OS DADOS NA API ---
  useEffect(() => {
    async function loadProfile() {
      try {
        // Puxa os dados do seu amigo. O Token já vai automaticamente pelo api.ts!
        const response = await api.get('/me');
        
        // ⚠️ ATENÇÃO AQUI: 
        // Adapte os nomes abaixo (response.data...) para o que o backend realmente devolve
        // Exemplo: se no back for "username", use response.data.username
        const dadosMapeados: UserData = {
          id: response.data.id || 'N/A',
          name: response.data.username || response.data.name || 'Jogador', 
          email: response.data.email || 'sem-email',
          xp: response.data.xp || 0,
          level: response.data.level || 1,
          levelName: response.data.levelName || 'Iniciante',
          // O backend costuma devolver datas num formato feio (ex: 2026-05-01T00:00). 
          // Mais tarde podemos formatar isso, por agora pegamos direto.
          createdAt: response.data.createdAt || 'Desconhecido', 
        };

        setUser(dadosMapeados);
      } catch (error) {
        console.error("Erro ao buscar perfil:", error);
        Alert.alert("Ops!", "Não foi possível carregar os dados do seu perfil.");
      } finally {
        setLoading(false); // Para a bolinha de carregar, dando sucesso ou erro
      }
    }

    loadProfile();
  }, []); // Essa array vazia [] garante que rode apenas 1 vez ao abrir a tela

  const handleUpdatePassword = () => {
    Alert.alert("Tudo certo!", "O botão tá funcionando.");
    console.log('Função para atualizar a senha do usuário');
  };

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
      style={S.container}
    >
      <ScrollView
        contentContainerStyle={S.scrollContent}
        keyboardShouldPersistTaps="handled"
        showsVerticalScrollIndicator={false}
      >
        <StatusBar barStyle="light-content" translucent backgroundColor="transparent" />

        {/* ── Imagem de Topo (Banner) ── */}
        <View style={S.imageContainer}>
          <Image
            source={require('../assets/LoginImg.jpg')} // Ajuste o path
            style={S.topImage}
            resizeMode="cover"
          />
          <LinearGradient
            colors={['transparent', '#000000']}
            style={S.gradientFade}
          />
        </View>

        {/* ── Conteúdo do Perfil Centralizado ── */}
        <View style={S.contentWrapper}>
          <Text style={S.title}>Seu perfil:</Text>

          <View style={S.profileContainer}>
            {/* --- SE ESTIVER CARREGANDO, MOSTRA A BOLINHA --- */}
            {loading ? (
              <View style={{ padding: 40, alignItems: 'center' }}>
                <ActivityIndicator size="large" color="#ffffff" />
                <Text style={{ color: '#fff', marginTop: 10 }}>Carregando seus dados...</Text>
              </View>
            ) : !user ? (
              /* --- SE DEU ERRO E NÃO TEM USUÁRIO, MOSTRA MSG --- */
              <Text style={{ color: '#ff4444', textAlign: 'center', padding: 20 }}>
                Erro ao carregar informações. Faça login novamente.
              </Text>
            ) : (
              /* --- SE DEU TUDO CERTO, MOSTRA OS DADOS REAIS --- */
              <>
                <View style={S.accountInfo}>
                  <Text style={S.label}>NOME</Text>
                  <Text style={S.value}>{user.name}</Text>
                  <View style={S.line} />
                </View>

                <View style={S.accountInfo}>
                  <Text style={S.label}>EMAIL</Text>
                  <Text style={S.value}>{user.email}</Text>
                  <View style={S.line} />
                </View>

                <View style={S.accountInfo}>
                  <Text style={S.label}>XP</Text>
                  <Text style={S.value}>{user.xp}</Text>
                  <View style={S.line} />
                </View>

                <View style={S.accountInfo}>
                  <Text style={S.label}>NÍVEL ATUAL</Text>
                  <Text style={S.value}>
                    {user.level} - {user.levelName}
                  </Text>
                  <View style={S.line} />
                </View>

                <TouchableOpacity
                  style={S.button}
                  onPress={handleUpdatePassword}
                  activeOpacity={0.8}
                >
                  <Text style={S.buttonText}>Atualizar Senha</Text>
                </TouchableOpacity>

                <Link href="/teste" style={[S.button, { width: 200, textAlign: 'center' }]}>
                  TESTE
                </Link>
              </>
            )}
          </View>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}