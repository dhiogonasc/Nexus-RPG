import React, { useState } from 'react';
import {
  View,
  Text,
  TouchableOpacity,
  StyleSheet,
  KeyboardAvoidingView,
  Platform,
  Image,
  StatusBar,
  ScrollView,
} from 'react-native';

import { styles } from '@/styles/registerStyles';

import { Link } from 'expo-router';
import { LinearGradient } from 'expo-linear-gradient';
import { Alert } from 'react-native';

import EmailInput from '@/components/EmailInput';
import DoublePasswordInput from '@/components/DoublePasswordInput';
import UserInput from '@/components/UserInput';

export default function RegisterScreen() {

  const [email, setEmail] = useState('');

  const [password, setPassword] = useState('');

  const [confirmPassword, setConfirmPassword] = useState('');


  const handleRegister = () => {
    if (password === '' || confirmPassword === '') {
      Alert.alert('Erro', 'Preencha as duas senhas!');
      return;
    }
    if (password !== confirmPassword) {
      Alert.alert('Erro', 'As senhas não coincidem!');
      return;
    }

    Alert.alert('Sucesso!', 'conta criada!');
  };

  return (
    <KeyboardAvoidingView
      behavior={Platform.OS === 'ios' ? 'padding' : 'height'}
      style={styles.container}
    >
      <ScrollView contentContainerStyle={{ flexGrow: 1 }}
        keyboardShouldPersistTaps='handled'
        showsVerticalScrollIndicator={false}>


        <StatusBar barStyle="light-content" translucent backgroundColor="transparent" />

        <View style={styles.imageContainer}>
          <Image
            source={require('../assets/RegisterImg.png')}
            style={styles.topImage}
            resizeMode="cover"
          />

          {/* Efeito esfumaçado na base da imagem */}

          <LinearGradient
            colors={['transparent', '#000000']}
            style={styles.gradientFade}
          />
        </View>

        <View style={styles.formContainer}>
          <Text style={styles.title}>Crie sua conta agora!</Text>

          <UserInput
            iconName="user"
            placeholder="Digite seu nome de usuário"
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
            source={require('../assets/LogoNexus.jpg')}
            style={styles.bottomLogo}
            resizeMode="cover"
          />

        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}
