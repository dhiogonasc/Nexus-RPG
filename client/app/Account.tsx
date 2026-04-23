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

import { AccountStyles } from '@/styles/AccountStyles';
import { LinearGradient } from 'expo-linear-gradient';

interface UserData {
  id: string;
  name: string;
  email: string;
  xp: number;
  level: number;
  levelName: string;
  createdAt: string; //pode mudar dependendo de como formos passar essa data
}

// Mock de dados do usuário, para testar a tela. Depois a gente substitui por dados reais vindo do backend
const mockUserData: UserData = {
  id: '12345',
  name: 'Flávio',
  email: 'flavio@email.com',
  xp: 20,
  level: 5,
  levelName: 'Aluminium II',
  createdAt: '35 de janeiro de 2027',
}

export function ProfileScreen() {
  //substitui o mock pelos dados reais do usuário quando tivermos eles, usando Hook ou algo assim
}

export default function Account() {

  const user = mockUserData;

  const HandleUpdatePassword = () => {
  //dps fazer navegar para uma tela de atualização de senha ou algum modal.
  Alert.alert(
    "Tudo certo!", 
    "O botão tá funcionando."
  );

  console.log('Função para atualizar a senha do usuário');
  };

    return (
    <KeyboardAvoidingView
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
      style={AccountStyles.container}
    >
      <ScrollView 
        contentContainerStyle={{ flexGrow: 1, paddingBottom: 60 }} 
        keyboardShouldPersistTaps='handled'
        showsVerticalScrollIndicator={false}
      >
        <StatusBar barStyle="light-content" translucent backgroundColor="transparent" />
        
        <View style={AccountStyles.imageContainer}>
          <Image
            source={require('../assets/LoginImg.jpg')}
            style={AccountStyles.topImage}
            resizeMode="cover"
          />
          <LinearGradient
            colors={['transparent', '#000000']}
            style={AccountStyles.gradientFade}
          />
        </View>
        
        <Text style={AccountStyles.title}>Seu perfil:</Text>
        
        <View style={AccountStyles.profileContainer}>
          <View style={AccountStyles.accountInfo}>
            <Text style={AccountStyles.label}>NOME</Text>
            <Text style={AccountStyles.value}>{user.name}</Text>
            <View style={AccountStyles.line}/>
          </View>

          <View style={AccountStyles.accountInfo}>
            <Text style={AccountStyles.label}>EMAIL</Text>
            <Text style={AccountStyles.value}>{user.email}</Text>
            <View style={AccountStyles.line}/>
          </View>

          <View style={AccountStyles.accountInfo}>
            <Text style={AccountStyles.label}>XP</Text>
            <Text style={AccountStyles.value}>{user.xp}</Text>
            <View style={AccountStyles.line}/>
          </View>

          <View style={AccountStyles.accountInfo}>
            <Text style={AccountStyles.label}>NÍVEL ATUAL</Text>
            <Text style={AccountStyles.value}>{user.level} - {user.levelName}</Text>
            <View style={AccountStyles.line}/>
          </View>

          <View style={AccountStyles.accountInfo}>
            <Text style={AccountStyles.label}>MEMBRO DESDE</Text>
            <Text style={AccountStyles.value}>{user.createdAt}</Text>
            <View style={AccountStyles.line}/>
          </View>

          <TouchableOpacity 
            style={AccountStyles.button} 
            onPress={HandleUpdatePassword}
            activeOpacity={0.8}
          >
            <Text style={AccountStyles.buttonText}>Atualizar Senha</Text>
          </TouchableOpacity>
        </View>

      </ScrollView>
    </KeyboardAvoidingView>
  );
}