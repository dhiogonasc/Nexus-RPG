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

      {/* Header com botão de voltar com efeito de vidro */}
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

      {/* ScrollView caso o conteúdo do planeta fique muito grande */}
      <ScrollView contentContainerStyle={styles.scrollContent} showsVerticalScrollIndicator={false}>
        
        {/* Imagem do Planeta */}
        <View style={styles.imageContainer}>
          <ImageBackground 
            source={planeta.imagem} 
            style={styles.image} 
            resizeMode="contain"
          />
        </View>

        {/* Conteúdo Dinâmico com Glassmorphism */}
        <View style={styles.contentWrapper}>
          <BlurView intensity={40} tint="dark" style={styles.contentBlur}>
            
            {/* Linha de sotaque com a cor do planeta */}
            <View style={[styles.accentLine, { backgroundColor: planeta.accentColor }]} />
            
            <Text style={[styles.title, { color: planeta.accentColor }]}>
              {planeta.nome}
            </Text>
            
            <View style={styles.descriptionContainer}>
              <MaterialCommunityIcons name="atom" size={16} color="#94A3B8" />
              <Text style={styles.description}>
                {planeta.description}
              </Text>
            </View>

            {/* --- ÁREA PARA O SEU CONTEÚDO (Módulos/Fases) --- */}
            <Text style={styles.sectionTitle}>Módulos Disponíveis</Text>
            
            <TouchableOpacity activeOpacity={0.8} style={[styles.moduleCard, { borderLeftColor: planeta.accentColor }]}>
              <MaterialCommunityIcons name="rocket-launch-outline" size={20} color={planeta.accentColor} />
              <Text style={styles.moduleText}>Questão 1</Text>
            </TouchableOpacity>

            <TouchableOpacity activeOpacity={0.8} style={[styles.moduleCard, { borderLeftColor: planeta.accentColor }]}>
              <MaterialCommunityIcons name="rocket-launch-outline" size={20} color={planeta.accentColor} />
              <Text style={styles.moduleText}>Questão 2</Text>
            </TouchableOpacity>

            <TouchableOpacity activeOpacity={0.8} style={[styles.moduleCard, { borderLeftColor: planeta.accentColor }]}>
              <MaterialCommunityIcons name="rocket-launch-outline" size={20} color={planeta.accentColor} />
              <Text style={styles.moduleText}>Questão 3</Text>
            </TouchableOpacity>

            <TouchableOpacity activeOpacity={0.8} style={[styles.moduleCard, { borderLeftColor: planeta.accentColor }]}>
              <MaterialCommunityIcons name="rocket-launch-outline" size={20} color={planeta.accentColor} />
              <Text style={styles.moduleText}>Questão 4</Text>
            </TouchableOpacity>

            <TouchableOpacity activeOpacity={0.8} style={[styles.moduleCard, { borderLeftColor: planeta.accentColor }]}>
              <MaterialCommunityIcons name="rocket-launch-outline" size={20} color={planeta.accentColor} />
              <Text style={styles.moduleText}>Questão 5</Text>
            </TouchableOpacity>

          </BlurView>
        </View>

      </ScrollView>
    </ImageBackground>
  );
}

const styles = StyleSheet.create({
  container: { 
    flex: 1, 
  },
  center: { 
    flex: 1, 
    justifyContent: 'center', 
    alignItems: 'center', 
    backgroundColor: '#020617' 
  },
  header: {
    paddingTop: 60, // Ajuste dependendo do notch/status bar do celular
    paddingHorizontal: 20,
    zIndex: 10,
  },
  backButton: { 
    width: 45,
    height: 45,
    borderRadius: 25,
    overflow: 'hidden',
  },
  iconBlur: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  scrollContent: {
    flexGrow: 1,
    paddingBottom: 40,
  },
  imageContainer: {
    alignItems: 'center',
    justifyContent: 'center',
    height: 280,
    marginVertical: 10,
  },
  image: { 
    width: 250, 
    height: 250 
  },
  contentWrapper: {
    flex: 1,
    paddingHorizontal: 20,
  },
  contentBlur: { 
    flex: 1, 
    padding: 25, 
    borderRadius: 24, 
    overflow: 'hidden',
    borderWidth: 1,
    borderColor: 'rgba(255,255,255,0.1)',
  },
  accentLine: {
    height: 4,
    width: 40,
    borderRadius: 2,
    marginBottom: 20,
  },
  title: { 
    fontSize: 32, 
    fontWeight: 'bold', 
    marginBottom: 10,
    letterSpacing: 0.5,
  },
  descriptionContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 30,
    backgroundColor: 'rgba(255,255,255,0.05)',
    padding: 12,
    borderRadius: 12,
  },
  description: { 
    fontSize: 16, 
    color: '#CBD5E1',
    marginLeft: 8,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: 'bold',
    color: '#fff',
    marginBottom: 15,
  },
  moduleCard: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: 'rgba(2, 6, 23, 0.5)',
    padding: 15,
    borderRadius: 12,
    marginBottom: 10,
    borderLeftWidth: 4,
  },
  moduleText: {
    color: '#E2E8F0',
    fontSize: 16,
    marginLeft: 10,
    fontWeight: '500'
  }
});