import React from 'react';
import { Text, View, TouchableOpacity, Alert } from 'react-native';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { styles } from '@/styles/FooterStyle'; 

export default function Footer() {
  const handleExit = () => {
    Alert.alert(
      "Certeza q vai sair?",
      "Vai sair pra q mlk, volta!",
      [
        {
          text: "Cancelar",
          style: "cancel"
        },
        { 
          text: "Sair",
          onPress: () => console.log("Usuário saiu"),
          style: "destructive"
        }
      ]
    );
  };

  return (
    <View style={styles.container}>
      
      <TouchableOpacity style={styles.button} onPress={() => console.log('Missões')}>
        <MaterialCommunityIcons name="shield-check" size={24} color="#94A3B8" />
        <Text style={styles.buttonText}>Missões</Text>
      </TouchableOpacity>

      <TouchableOpacity style={[styles.button, styles.homeButton]} onPress={() => console.log('Home')}>
        <MaterialCommunityIcons name="home-variant" size={28} color="#A855F7" />
        <Text style={[styles.buttonText, styles.homeButtonText]}>Home</Text>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={handleExit}>
        <MaterialCommunityIcons name="logout" size={24} color="#EF4444" />
        <Text style={[styles.buttonText, styles.exitText]}>Sair</Text>
      </TouchableOpacity>

    </View>
  );
}