import React, { useState } from "react";
import {
  Image,
  KeyboardAvoidingView,
  Platform,
  ScrollView,
  StatusBar,
  Text,
  TouchableOpacity,
  View,
  Alert,
} from "react-native";

import { styles as S } from "@/styles/registerStyles"; // Apelido 'S' para facilitar

import { LinearGradient } from "expo-linear-gradient";
import { Link, router } from "expo-router";

import DoublePasswordInput from "@/components/DoublePasswordInput";
import EmailInput from "@/components/EmailInput";
import UserInput from "@/components/UserInput";
import { authService } from "@/services";

export default function RegisterScreen() {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const handleRegister = async () => {
    if (!username || username.length < 3) {
      Alert.alert("Erro", "O nome deve ter pelo menos 3 caracteres!");
      return;
    }

    if (password.length < 6) {
      Alert.alert("Erro", "A senha deve ter no mínimo 6 caracteres!");
      return;
    }

    if (password !== confirmPassword) {
      Alert.alert("Erro", "As senhas não coincidem!");
      return;
    }

    try {
      await authService.register({ username, email, password });

      Alert.alert("Sucesso!", "Conta criada com sucesso!", [
        {
          text: "OK",
          onPress: () => router.replace("/"),
        },
      ]);
    } catch (error) {
      Alert.alert("Erro", "Não foi possível realizar o cadastro.");
      console.error("Erro ao cadastrar usuário", error);
    }
  };

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === "ios" ? "padding" : "height"}
      style={S.container}
    >
      <ScrollView
        contentContainerStyle={S.scrollContent}
        keyboardShouldPersistTaps="handled"
        showsVerticalScrollIndicator={false}
      >
        <StatusBar
          barStyle="light-content"
          translucent
          backgroundColor="transparent"
        />

        {/* ── Banner ── */}
        <View style={S.imageContainer}>
          <Image
            source={require("../assets/RegisterImg.png")}
            style={S.topImage}
            resizeMode="cover"
          />

          <LinearGradient
            colors={["transparent", "#000000"]}
            style={S.gradientFade}
          />
        </View>

        {/* ── Wrapper Centralizado para a Web ── */}
        <View style={S.contentWrapper}>
          <View style={S.formContainer}>
            <Text style={S.title}>Crie sua conta agora!</Text>

            <UserInput
              iconName="user"
              placeholder="Digite seu nome de usuário"
              value={username}
              onChangeText={setUsername}
            />

            <EmailInput
              iconName="mail"
              placeholder="Digite seu e-mail"
              keyboardType="email-address"
              autoCapitalize="none"
              autoCorrect={false}
              value={email}
              onChangeText={setEmail}
            />

            <DoublePasswordInput
              password={password}
              setPassword={setPassword}
              confirmPassword={confirmPassword}
              setConfirmPassword={setConfirmPassword}
            />

            <TouchableOpacity style={S.button} onPress={handleRegister}>
              <Text style={S.buttonText}>Entrar</Text>
            </TouchableOpacity>

            <View style={S.registerContainer}>
              <Text style={S.registerButton}> Já tem uma conta? </Text>
              <Link href="/" style={S.registerLink}>
                Entrar
              </Link>
            </View>

            <Image
              source={require("../assets/LogoNexus.jpg")}
              style={S.bottomLogo}
              resizeMode="cover"
            />
          </View>
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}