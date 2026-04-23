import React, { useState } from 'react';
import {
  View,
  Text,
  Platform,
  Image,
  StatusBar,
  ScrollView,
  KeyboardAvoidingView,
} from 'react-native';

import { styles } from '@/styles/MissionsStyles';

import { LinearGradient } from 'expo-linear-gradient';

interface Mission {
  id: number;
  namePlanet: string;
  description: string;
  imgPlanet: any;
}

const mockMissions: Mission[] = [
  { id: 1, 
    namePlanet: 'Ertra', 
    description: 'Extraia minérios condutores resolvendo algoritmos de repetição.', 
    imgPlanet: require('../assets/Earth.png')},

  { id: 2, 
    namePlanet: 'Algorion', 
    description: 'Colete fragmentos de cristal de memória nas zonas de alta radiação.', 
    imgPlanet: require('../assets/PurplePlanet.png')},

  { id: 3, 
    namePlanet: 'Sintaxia', 
    description: 'Refine o plasma bruto respondendo corretamente a desafios de lógica booleana.', 
    imgPlanet: require('../assets/Saturn.png')},

  { id: 4, 
    namePlanet: 'Vertex', 
    description: 'Mapeie e colete recursos biológicos raros no núcleo profundo do planeta.', 
    imgPlanet: require('../assets/BluePlanet.png')},
];

export default function missions() {
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

        <Text style={styles.title}>Missões</Text>

          <LinearGradient
            colors={['transparent', '#000000']}
            style={styles.gradientFade}
          />

          <View style={styles.gridContainer}>
          {mockMissions.map((item) => (
            <View key={item.id} style={styles.card}>
              
              <View style={styles.circleContainer}>
                <View style={styles.circleInside}>
                  <Image source={item.imgPlanet}
                    style={styles.imageCards}
                  ></Image>
                </View>
              </View>

              <Text style={styles.cardTitle}>{item.namePlanet}</Text>
              <Text style={styles.cardDescription}>{item.description}</Text>
            </View>
          ))}
        </View>
        </View>


      </ScrollView>
    </KeyboardAvoidingView>
  );
}
