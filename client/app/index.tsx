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
import { Link } from 'expo-router';
import { LinearGradient } from 'expo-linear-gradient';
import EmailInput from '@/components/EmailInput';
import PasswordInput from '@/components/PasswordInput';

export default function index() {

  const [email, setEmail] = useState('');

  const [password, setPassword] = useState('');

  const [showPassword, setShowPassword] = useState(false);

  const handleLogin = () => {
    if (email === '' || password === '') {
      alert('Por favor, preencha todos os campos.');
      return;
    }
    console.log('Login efetuado com:', email, password);
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
            source={require('../assets/LoginImg.jpg')}
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
            >
            </TouchableOpacity>
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

        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#000000',
  },

  // --- Estilos da Imagem de Topo ---
  imageContainer: {
    width: '100%',
    height: 230,
    position: 'relative',
  },
  topImage: {
    width: '100%',
    height: '100%',
  },
  gradientFade: {
    position: 'absolute',
    left: 0,
    right: 0,
    bottom: 0,
    height: 120,
  },

  // --- Estilos do Formulário ---
  formContainer: {
    flex: 1,
    paddingHorizontal: 40,
    paddingTop: 25,
  },
  title: {
    fontSize: 32,
    fontWeight: '800',
    color: '#FFFFFF',
    marginBottom: 30,
    textAlign: 'center',
  },
  input: {
    backgroundColor: '#2B2B2B',
    color: '#FFFFFF',
    width: '100%',
    height: 55,
    borderRadius: 8,
    paddingHorizontal: 15,
    marginBottom: 25,
    fontSize: 16,
    borderWidth: 1,
    borderColor: '#C4C4C4',
  },
  passwordContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#2B2B2B',
    width: '100%',
    height: 55,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#C4C4C4',
    marginBottom: 85,
  },
  passwordInput: {
    flex: 1,
    height: '100%',
    paddingHorizontal: 15,
    fontSize: 16,
    color: '#FFFFFF',
  },
  eyeIcon: {
    padding: 10,
  },
  button: {
    backgroundColor: '#D58BE8',
    height: 55,
    borderRadius: 16,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 30,
  },
  buttonText: {
    color: '#000000',
    fontSize: 18,
    fontWeight: 'bold',
  },
  registerContainer: {
    marginTop: 30,
    alignItems: 'center',
    display: 'flex',
    flexDirection: 'row',
    justifyContent: 'center',
  },
  registerButton: {
    color: '#888888',
    fontSize: 16,
    fontWeight: '400',
  },
  registerLink: {
    color: '#F6D48F',
    fontSize: 18,
    fontWeight: '800',
  },
  inputContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#2B2B2B',
    width: '100%',
    height: 55,
    borderRadius: 8,
    borderWidth: 1,
    borderColor: '#C4C4C4',
    marginBottom: 15,
    paddingHorizontal: 15,
  },
  icon: {
    marginRight: 10,
  },
  textInput: {
    flex: 1,
    height: '100%',
    color: '#FFFFFF',
    fontSize: 16,
  },
});