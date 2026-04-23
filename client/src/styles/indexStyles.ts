import { StyleSheet } from 'react-native';

export const styles = StyleSheet.create({
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
    marginBottom: 50,
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
    padding: 0,
  },
  button: {
    backgroundColor: '#D58BE8',
    height: 55,
    borderRadius: 16,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 0,
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

  // --- Estilos logo la em baixo ---
  bottomLogo: {
    width: 120,
    height: 120,
    alignSelf: 'center',
    marginTop: 50,
  },

  // --- Estilos Missões ---
  gridContainer: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'space-between',
    paddingHorizontal: 20,
    paddingBottom: 40,
    marginTop: -20,
  },
  card: {
    backgroundColor: '#2A2765',
    borderRadius: 24,
    padding: 20,
    width: '48%',
    height: '60%',
    marginBottom: 20,
    alignItems: 'center',
  },
  circleContainer: {
    marginBottom: 16,
    backgroundColor: '#1C1A4A',
    borderRadius: 50,
    padding: 4,
  },
  circle: {
    width: 80,
    height: 80,
    borderRadius: 40,
    borderWidth: 3,
    borderColor: '#4A478A',
    justifyContent: 'center',
    alignItems: 'center',
  },
  cardTitle: {
    color: '#FFFFFF',
    fontSize: 14,
    fontWeight: 'bold',
    textAlign: 'center',
    marginBottom: 8,
  },
  cardDescription: {
    color: '#9CA3AF',
    fontSize: 12,
    textAlign: 'center',
    lineHeight: 16,
  },
  imageCards: {
    width: 100,
    height: 80,
    resizeMode: 'contain',
  }
});