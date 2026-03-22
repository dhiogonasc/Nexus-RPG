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
} from "react-native";

import { styles } from "@/styles/registerStyles";

import { LinearGradient } from "expo-linear-gradient";
import { Link, router } from "expo-router";
import { Alert } from "react-native";

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
      style={styles.container}
    >
      <ScrollView
        contentContainerStyle={{ flexGrow: 1 }}
        keyboardShouldPersistTaps="handled"
        showsVerticalScrollIndicator={false}
      >
        <StatusBar
          barStyle="light-content"
          translucent
          backgroundColor="transparent"
        />

        <View style={styles.imageContainer}>
          <Image
            source={require("../assets/RegisterImg.png")}
            style={styles.topImage}
            resizeMode="cover"
          />

          {/* Efeito esfumaçado na base da imagem */}

          <LinearGradient
            colors={["transparent", "#000000"]}
            style={styles.gradientFade}
          />
        </View>

        <View style={styles.formContainer}>
          <Text style={styles.title}>Crie sua conta agora!</Text>

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

          <TouchableOpacity style={styles.button} onPress={handleRegister}>
            <Text style={styles.buttonText}>Entrar</Text>
          </TouchableOpacity>

          <View style={styles.registerContainer}>
            <Text style={styles.registerButton}> Já tem uma conta? </Text>
            <Link href="/" style={styles.registerLink}>
              Entrar
            </Link>
          </View>

          <Image
            source={require("../assets/LogoNexus.jpg")}
            style={styles.bottomLogo}
            resizeMode="cover"
          />
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}
