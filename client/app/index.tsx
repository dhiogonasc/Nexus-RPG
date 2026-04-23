import React, { useState } from 'react';
import {
  View,
  Text,
  TouchableOpacity,
  KeyboardAvoidingView,
  Platform,
  Image,
  StatusBar,
  ScrollView,
} from 'react-native';

import { styles as S } from '@/styles/indexStyles'; // Renomeei para S para facilitar
import { Link, router } from 'expo-router';
import { LinearGradient } from 'expo-linear-gradient';
import EmailInput from '@/components/EmailInput';
import PasswordInput from '@/components/PasswordInput';
import { authService } from '@/services';
import { storage } from '@/services/storage';

export default function index() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [showPassword, setShowPassword] = useState(false);

  const handleLogin = async () => {
    try {
      const data = await authService.login({ email, password });
      await storage.saveToken(data.token);
      console.log("Login realizado com sucesso em:", data.loggedInAt);
      router.replace('/homePage');
    } catch (error) {
      console.error("Erro ao logar", error);
    }
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

        {/* ── Banner ── */}
        <View style={S.imageContainer}>
          <Image
            source={require('../assets/LoginImg.jpg')}
            style={S.topImage}
            resizeMode="cover"
          />
          <LinearGradient
            colors={['transparent', '#000000']}
            style={S.gradientFade}
          />
        </View>

        {/* ── Wrapper Centralizado para a Web ── */}
        <View style={S.contentWrapper}>
          <View style={S.formContainer}>
            <Text style={S.title}>Bem vindo!</Text>

            <View style={S.inputMargin}>
              <EmailInput
                iconName="mail"
                placeholder="Digite seu e-mail"
                keyboardType="email-address"
                autoCapitalize="none"
                autoCorrect={false}
                value={email}
                onChangeText={setEmail}
              />
            </View>

            <View style={S.inputMarginBottom}>
              <PasswordInput
                iconName="lock"
                placeholder="Digite sua senha"
                value={password}
                onChangeText={setPassword}
                secureTextEntry={!showPassword}
              />
              {/* Se o olho da senha não estiver dentro do componente PasswordInput, 
                  ele fica aqui, mas idealmente deveria estar lá dentro. */}
              <TouchableOpacity
                style={S.eyeIcon}
                onPress={() => setShowPassword(!showPassword)}
              />
            </View>

            <TouchableOpacity style={S.button} onPress={handleLogin}>
              <Text style={S.buttonText}>Entrar</Text>
            </TouchableOpacity>

            <View style={S.registerContainer}>
              <Text style={S.registerButton}>Não possui conta? </Text>
              <Link href="/register" style={S.registerLink}>
                Registrar-se 
              </Link>
            </View>
            
            <Text style={S.homeLinkContainer}>
              <Link href="/homePage" style={S.registerLink}>
                 HOME 
              </Link>
            </Text>

            <Image
              source={require('../assets/LogoNexus.jpg')}
              style={S.bottomLogo}
              resizeMode="cover"
            />
          </View>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}