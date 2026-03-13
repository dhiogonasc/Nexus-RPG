import { View, Text, StyleSheet, TouchableOpacity } from 'react-native';
import { router } from 'expo-router';

export default function Mission() {
  return (
    <View style={styles.container}>
      <Text style={styles.systemText}>Anomalia detectada no setor 7...</Text>
      <Text style={styles.question}>Para calibrar os motores de dobra, qual é o gás mais abundante na atmosfera de Júpiter?</Text>
      
      <TouchableOpacity style={styles.optionButton}>
        <Text style={styles.optionText}>A) Oxigênio</Text>
      </TouchableOpacity>
      
      <TouchableOpacity style={styles.optionButton}>
        <Text style={styles.optionText}>B) Hidrogênio</Text>
      </TouchableOpacity>

      <TouchableOpacity style={styles.optionButton}>
        <Text style={styles.optionText}>C) Nitrogênio</Text>
      </TouchableOpacity>
      
      <TouchableOpacity style={styles.backButton} onPress={() => router.back()}>
        <Text style={styles.backText}>[ Abortar Missão ]</Text>
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { 
    flex: 1, 
    padding: 24, 
    justifyContent: 'center', 
    backgroundColor: '#0B0C10' 
  },
  systemText: { 
    color: '#ff4c4c', // Vermelho de alerta
    fontSize: 14, 
    marginBottom: 20, 
    textAlign: 'center',
    fontStyle: 'italic'
  },
  question: { 
    color: '#66FCF1', 
    fontSize: 22, 
    fontWeight: 'bold', 
    marginBottom: 40, 
    textAlign: 'center',
    lineHeight: 30
  },
  optionButton: { 
    backgroundColor: '#1F2833', 
    padding: 18, 
    borderRadius: 8, 
    marginBottom: 15,
    borderWidth: 1,
    borderColor: '#45A29E'
  },
  optionText: { 
    color: '#FFFFFF', 
    fontSize: 16,
    fontWeight: '500'
  },
  backButton: { 
    marginTop: 40, 
    alignItems: 'center' 
  },
  backText: { 
    color: '#C5C6C7', 
    fontSize: 14,
    textDecorationLine: 'underline'
  }
});