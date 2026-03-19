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

  // --- Estilos logo la em baixo ---
  bottomLogo: {
    width: 120,
    height: 120,
    alignSelf: 'center',
    marginTop: 0,
  },
});