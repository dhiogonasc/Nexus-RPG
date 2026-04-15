import { styles } from "@/styles/indexStyles";
import { useRouter } from "expo-router";
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

import EmailInput from "@/components/EmailInput";
import PasswordInput from "@/components/PasswordInput";
import { authService } from "@/services";
import { storage } from "@/services/storage";
import { LinearGradient } from "expo-linear-gradient";
import { Link } from "expo-router";

export default function index() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  const router = useRouter();

  const handleLogin = async () => {
    try {
      const data = await authService.login({ email, password });

      if (data.accessToken) {
        await storage.saveToken(data.accessToken);
        console.log("Login realizado com sucesso! Token salvo.");

        router.replace("/profile");
      } else {
        console.error("Token não encontrado na resposta do servidor");
      }
    } catch (error) {
      console.error("Erro ao logar", error);
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
            source={require("../assets/LoginImg.jpg")}
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
          <Text style={styles.title}>Bem vindo de volta!</Text>

          <View>
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

          <View>
            <PasswordInput
              iconName="lock"
              placeholder="Digite sua senha"
              value={password}
              onChangeText={setPassword}
              secureTextEntry={!showPassword}
            />

            <TouchableOpacity
              style={styles.eyeIcon}
              onPress={() => setShowPassword(!showPassword)}
            ></TouchableOpacity>
          </View>

          <TouchableOpacity style={styles.button} onPress={handleLogin}>
            <Text style={styles.buttonText}>Entrar</Text>
          </TouchableOpacity>

          <View style={styles.registerContainer}>
            <Text style={styles.registerButton}> Não possui conta? </Text>
            <Link href="/register" style={styles.registerLink}>
              Registrar-se
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
