import React, { useState } from 'react';
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
} from 'react-native';
import { AccountStyles as S } from '@/styles/AccountStyles';
import { LinearGradient } from 'expo-linear-gradient';

interface UserData {
  id: string;
  name: string;
  email: string;
  xp: number;
  level: number;
  levelName: string;
  createdAt: string;
}

const mockUserData: UserData = {
  id: '12345',
  name: 'Flávio',
  email: 'flavio@email.com',
  xp: 20,
  level: 5,
  levelName: 'Aluminium II',
  createdAt: '35 de janeiro de 2027',
};

export function ProfileScreen() {
  // Substituir o mock pelos dados reais do usuário no futuro
}

export default function Account() {
  const user = mockUserData;

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

        {/* ── Conteúdo do Perfil Centralizado (Web) ── */}
        <View style={S.contentWrapper}>
          <Text style={S.title}>Seu perfil:</Text>

          <View style={S.profileContainer}>
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

            <View style={S.accountInfo}>
              <Text style={S.label}>MEMBRO DESDE</Text>
              <Text style={S.value}>{user.createdAt}</Text>
              <View style={S.line} />
            </View>

            <TouchableOpacity
              style={S.button}
              onPress={handleUpdatePassword}
              activeOpacity={0.8}
            >
              <Text style={S.buttonText}>Atualizar Senha</Text>
            </TouchableOpacity>
          </View>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}