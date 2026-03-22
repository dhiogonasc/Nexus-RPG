import React, { useState } from 'react';
import { StyleSheet, Text, View, TouchableOpacity, Dimensions, ImageBackground } from 'react-native';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { styles } from '@/styles/CarouselStyle'; 
import { LinearGradient } from 'expo-linear-gradient';

const { width } = Dimensions.get('window');

const PLANETAS = [
  { id: '1', nome: 'Xylos-Prime', imagem: require('../../assets/PurplePlanet.png') },
  { id: '2', nome: 'Zion', imagem: require('../../assets/Earth.png')},
  { id: '3', nome: 'Glacies', imagem: require('../../assets/Saturn.png')},
];

export default function PlanetCarousel() {
  const [index, setIndex] = useState(0);

  const navegar = (direcao: 'ant' | 'prox') => {
    if (direcao === 'prox') {
      setIndex((index + 1) % PLANETAS.length);
    } else {
      setIndex((index - 1 + PLANETAS.length) % PLANETAS.length);
    }
  };

  return (
    <View>
      
    <ImageBackground
      source={require('../../assets/GalaxyPNG.png')} 
      style={styles.navegador}
      resizeMode="cover" 

    >
    <LinearGradient
      colors={['transparent', '#000000']}
      style={styles.gradientFade}
     />
    <View style={styles.container}>
      <View style={styles.navegador}>
        

        <TouchableOpacity onPress={() => navegar('ant')}>
          <MaterialCommunityIcons name="chevron-left" size={45} color="#ffffff" />
        </TouchableOpacity>

        <ImageBackground 
          source={PLANETAS[index].imagem} 
          style={styles.card} 

          resizeMode="contain" 
        >

        </ImageBackground>

        <TouchableOpacity onPress={() => navegar('prox')}>
          <MaterialCommunityIcons name="chevron-right" size={45} color="#ffffff" />
        </TouchableOpacity>

      </View>

      <Text style={styles.nome}>{PLANETAS[index].nome}</Text>

    </View>
    </ImageBackground>
    </View>
  );
}