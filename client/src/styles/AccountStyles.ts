import { StyleSheet } from 'react-native';

export const AccountStyles = StyleSheet.create({
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
  title: {
    fontSize: 26,
    fontWeight: '500',
    color: '#CCCCCC',
    marginTop: 20,
    marginBottom: 30,
    textAlign: 'left',
    paddingLeft: 20,
  },
  profileContainer: {
    backgroundColor: '#1A1A1A',
    borderRadius: 7,
    padding: 20,
    marginHorizontal: 20,
  },
  accountInfo: {
    
  },
  label: {
    fontSize: 18,
    fontWeight: '600',
    color: '#FFFFFF',
    marginBottom: 8,
  },
  value: {
    fontSize: 16,
    fontWeight: '300',
    color: '#FFFFFF',
  },
  line: {
    height: 1,
    backgroundColor: '#333333',
    marginBottom: 22,
    marginTop: 22,
  },
  button: {
    backgroundColor: '#007AFF', // Azul padrão estilo iOS
    paddingVertical: 12,
    borderRadius: 8,
    alignItems: 'center',
  },
  buttonText: {
    color: '#FFF',
    fontSize: 16,
    fontWeight: 'bold',
  },
});