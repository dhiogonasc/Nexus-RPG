import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';
import { router } from 'expo-router';

export default function Home() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>NEXUS RPG</Text>
      <Text style={styles.subtitle}>Terminal de Comando</Text>
      
      <TouchableOpacity 
        style={styles.button} 
        onPress={() => router.push('/mission')}
      >
        <Text style={styles.buttonText}>Iniciar Missão</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { 
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center', 
    backgroundColor: '#0B0C10' // Fundo escuro espacial
  },
  title: { 
    fontSize: 40, 
    fontWeight: 'bold', 
    color: '#66FCF1', // Azul neon
    marginBottom: 5,
    letterSpacing: 2
  },
  subtitle: { 
    fontSize: 16, 
    color: '#C5C6C7', 
    marginBottom: 50 
  },
  button: { 
    backgroundColor: '#45A29E', 
    paddingVertical: 15, 
    paddingHorizontal: 40,
    borderRadius: 8 
  },
  buttonText: { 
    color: '#0B0C10', 
    fontWeight: 'bold', 
    fontSize: 18,
    textTransform: 'uppercase'
  }
});