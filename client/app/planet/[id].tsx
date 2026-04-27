import React from 'react';
import { 
  View, 
  Text, 
  StyleSheet, 
  TouchableOpacity, 
  ImageBackground, 
  ScrollView 
} from 'react-native';
import { useLocalSearchParams, useRouter } from 'expo-router';
import { PLANETAS } from '@/data/planetas'; 
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { LinearGradient } from 'expo-linear-gradient';
import { BlurView } from 'expo-blur';
import { styles } from '@/styles/idStyle';

export default function PlanetDetails() {
  const { id } = useLocalSearchParams();
  const router = useRouter();

  const planeta = PLANETAS.find(p => p.id === id);

  if (!planeta) {
    return (
      <View style={styles.center}>
        <Text style={{ color: 'white' }}>Planeta não encontrado.</Text>
        <TouchableOpacity onPress={() => router.back()}>
          <Text style={{ color: '#406fd4', marginTop: 10 }}>Voltar</Text>
        </TouchableOpacity>
      </View>
    );
  }

  return (
    // Fundo da Galáxia
    <ImageBackground
      source={require('../../assets/GalaxyBG.png')} 
      style={styles.container}
      resizeMode="cover"
    >
      {/* Overlay escuro para dar contraste */}
      <LinearGradient
        colors={['rgba(2,6,23,0.3)', 'rgba(2,6,23,0.95)']}
        style={StyleSheet.absoluteFillObject}
      />

      <View style={styles.header}>
        <TouchableOpacity 
          style={styles.backButton} 
          onPress={() => router.back()}
          activeOpacity={0.7}
        >
          <BlurView intensity={30} tint="dark" style={styles.iconBlur}>
            <MaterialCommunityIcons name="arrow-left" size={24} color={planeta.accentColor} />
          </BlurView>
        </TouchableOpacity>
      </View>

      <ScrollView contentContainerStyle={styles.scrollContent} showsVerticalScrollIndicator={false}>
        
        {/* Imagem do Planeta */}
        <View style={styles.imageContainer}>
          <ImageBackground 
            source={planeta.imagem} 
            style={styles.image} 
            resizeMode="contain"
          />
        </View>

        <View style={styles.contentWrapper}>
          <BlurView intensity={40} tint="dark" style={styles.contentBlur}>
            
            <View style={[styles.accentLine, { backgroundColor: planeta.accentColor }]} />
            
            <Text style={[styles.title, { color: planeta.accentColor }]}>
              {planeta.nome}
            </Text>
            
            <View style={styles.descriptionContainer}>
              
              <Text style={[styles.description, {alignSelf: 'flex-start', paddingBottom: 16}]}>
                <View style={{ flexDirection: 'row', alignItems: 'center' }}>
                  <MaterialCommunityIcons name="atom" size={16} color="#94A3B8" style={{ marginRight: 8 }} />
                  {planeta.description}
                </View>
              </Text>
              <Text style={styles.description}>
                {planeta.content}
              </Text>
            </View>

            {/* --- ÁREA PARA O CONTEÚDO --- */}
            <Text style={styles.sectionTitle}>Módulos Disponíveis</Text>
            
            {planeta.missoes.map((missao) => (
              <TouchableOpacity
                key={missao.id}
                activeOpacity={0.8}
                style={[styles.moduleCard, { borderLeftColor: planeta.accentColor }]}
                onPress={() => router.push({
                  pathname: `/mission/[id]`,
                  params: { id: missao.id, planetId: planeta.id }
                })}
              >
                <MaterialCommunityIcons name="rocket-launch-outline" size={20} color={planeta.accentColor} />
                <Text style={styles.moduleText}>{missao.titulo}</Text>
              </TouchableOpacity>
            ))}

          </BlurView>
        </View>

      </ScrollView>
    </ImageBackground>
  );
}