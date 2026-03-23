import React from 'react';
import { StyleSheet, 
  Text, 
  View, 
  ScrollView, 
  TouchableOpacity, 
  StatusBar, 
  Image, 
} from 'react-native';

import { SafeAreaView } from 'react-native-safe-area-context';

import { MaterialCommunityIcons } from '@expo/vector-icons';
import { HomeStyles } from '@/styles/homePageStyles';
import { LinearGradient } from 'expo-linear-gradient';


import PlanetCarousel from '@/components/PlanetCarousel';
import Footer from '@/components/FooterBar.jsx';
import AntDesign from '@expo/vector-icons/AntDesign';
import FontAwesome5 from '@expo/vector-icons/FontAwesome5';


export default function HomePage() {
  return (
    <SafeAreaView style={HomeStyles.container}>
      <StatusBar barStyle="light-content" />
      
      <View style={HomeStyles.header}>
        <View>
          <Text style={HomeStyles.greeting}>Olá,</Text>
          <Text style={HomeStyles.userName}>Bem-vindo viajante!</Text>
        </View>
        <TouchableOpacity style={HomeStyles.profileBadge}>
            <Text style={HomeStyles.textProfile}>10/10</Text>
          <AntDesign name="thunderbolt" size={24} color="#fffb00" />
        </TouchableOpacity>
      </View>

      <ScrollView showsVerticalScrollIndicator={false} contentContainerStyle={HomeStyles.scrollContent}>

        <View style={HomeStyles.imageContainer}>
                <Image
                  source={require('../assets/Astronaut.png')}
                  style={HomeStyles.topImage}
                  resizeMode="cover"
                />
      
                <LinearGradient
                  colors={['transparent', '#000000']}
                  style={HomeStyles.gradientFade}
                />
              </View>
        
        <View style={HomeStyles.charCard}>
          <View style={HomeStyles.charInfo}>
            <View style={HomeStyles.avatarPlaceholder}>
              <FontAwesome5 name="user-astronaut" size={24} color="#fff" />
            </View>
            <View>
              <Text style={HomeStyles.charName}>ChuckBass</Text>
              <Text style={HomeStyles.charClass}>Nível 5</Text>
            </View>
          </View>
          <TouchableOpacity style={HomeStyles.buttonPrimary}>
            <Text style={HomeStyles.buttonText}>Abrir Inventário de Personagem</Text>
          </TouchableOpacity>
        </View>
        <View style={HomeStyles.textTituloPlaneta}>
            <Text style={HomeStyles.textTitulo}>Planeta Atual</Text>
        </View>

        <PlanetCarousel/>

        <View>
            <Text style={HomeStyles.sectionTitle}>Conquistas Recentes</Text>
            <View style={HomeStyles.achievementList}>
            <View style={HomeStyles.achievementItem}>
                <MaterialCommunityIcons name="gold" size={24} color="#EAB308" />
                <View style={HomeStyles.achievementTextCont}>
                <Text style={HomeStyles.achievementTitle}>Colecionador</Text>
                <Text style={HomeStyles.achievementDesc}>Pegou seu primeiro resource.</Text>
                </View>
            </View>

            <View style={HomeStyles.achievementItem}>
                <MaterialCommunityIcons name="book-open-variant" size={24} color="#EAB308" />
                <View style={HomeStyles.achievementTextCont}>
                <Text style={HomeStyles.achievementTitle}>Aventureiro de primeira viajem!</Text>
                <Text style={HomeStyles.achievementDesc}>Concluiu sua primeira expedição.</Text>
                </View>
            </View>
            </View>
        </View>
        
      </ScrollView>

      <Footer/>

    </SafeAreaView>
  );
}

