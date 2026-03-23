import React from 'react';

import { Text, View, TouchableOpacity, Alert, Platform } from 'react-native';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { styles } from '@/styles/FooterBarStyle'; 
import { handleLogout } from '../services/serviçoLogout';

export default function Footer() {
  
  return (
    <View style={styles.container}>
      {/*  */}
      <TouchableOpacity style={styles.button} onPress={() => {/*router.replace('/(pagina)')*/}}>
        <MaterialCommunityIcons name="shield-check" size={24} color="#94A3B8" />
        <Text style={styles.buttonText}>Missões</Text>
      </TouchableOpacity>

      <TouchableOpacity style={[styles.button, styles.homeButton]} onPress={() => {/*router.replace('/(pagina)')*/}}>
        <MaterialCommunityIcons name="home-variant" size={28} color="#A855F7" />
        <Text style={[styles.buttonText, styles.homeButtonText]}>Home</Text>
      </TouchableOpacity>

      <TouchableOpacity style={styles.button} onPress={handleLogout}>
        <MaterialCommunityIcons name="logout" size={24} color="#EF4444" />
        <Text style={[styles.buttonText, styles.exitText]}>Sair</Text>
      </TouchableOpacity>

    </View>
  );
}