// app/planet/[id].tsx
import React, { useEffect, useState } from 'react';
import { 
  View, 
  Text, 
  StyleSheet, 
  TouchableOpacity, 
  ImageBackground, 
  ScrollView,
  ActivityIndicator
} from 'react-native';
import { useLocalSearchParams, useRouter } from 'expo-router';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { LinearGradient } from 'expo-linear-gradient';
import { BlurView } from 'expo-blur';
import { styles } from '@/styles/idStyle';

// Nossas novas importações!
import { fetchMissoesDoPlaneta } from '@/services/api';
import { adaptarMissoesDoPlaneta } from '@/utils/mappers';
import { DetalhesPlaneta } from '@/types/frontend';
import { VISUAIS_DOS_PLANETAS } from '@/data/planetVisuals'; // Para pegar a cor e imagem

export default function PlanetDetails() {
  const { id } = useLocalSearchParams();
  const router = useRouter();

  // Estados da tela
  const [planeta, setPlaneta] = useState<DetalhesPlaneta | null>(null);
  const [loading, setLoading] = useState(true);

  // Busca os dados assim que a tela abre
  useEffect(() => {
    async function carregarDados() {
      try {
        setLoading(true);
        // 1. Busca na API
        const dadosSujos = await fetchMissoesDoPlaneta(id as string);
        // 2. Passa pelo Mapper
        const dadosLimpos = adaptarMissoesDoPlaneta(dadosSujos);
        // 3. Salva no estado
        setPlaneta(dadosLimpos);
      } catch (error) {
        console.error("Erro ao carregar planeta:", error);
      } finally {
        setLoading(false);
      }
    }

    if (id) carregarDados();
  }, [id]);

  if (loading) {
    return (
      <View style={[styles.center, { flex: 1, backgroundColor: '#020617', justifyContent: 'center' }]}>
        <ActivityIndicator size="large" color="#406fd4" />
      </View>
    );
  }

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

  // Pega a imagem e a cor baseadas no ID do planeta. 
  // Se não achar, usa um fallback padrão.
  const visual = VISUAIS_DOS_PLANETAS[planeta.id] || { img: null, cor: '#406fd4' };

  return (
    <ImageBackground
      source={require('../../assets/GalaxyBG.png')} 
      style={styles.container}
      resizeMode="cover"
    >
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
            <MaterialCommunityIcons name="arrow-left" size={24} color={visual.cor} />
          </BlurView>
        </TouchableOpacity>
      </View>

      <ScrollView contentContainerStyle={styles.scrollContent} showsVerticalScrollIndicator={false}>
        
        <View style={styles.imageContainer}>
          <ImageBackground 
            source={visual.img} 
            style={styles.image} 
            resizeMode="contain"
          />
        </View>

        <View style={styles.contentWrapper}>
          <BlurView intensity={40} tint="dark" style={styles.contentBlur}>
            
            <View style={[styles.accentLine, { backgroundColor: visual.cor }]} />
            
            <Text style={[styles.title, { color: visual.cor }]}>
              {planeta.nome}
            </Text>
            
            <View style={styles.descriptionContainer}>
              <Text style={[styles.description, {alignSelf: 'flex-start', paddingBottom: 16}]}>
                <View style={{ flexDirection: 'row', alignItems: 'center' }}>
                  <MaterialCommunityIcons name="atom" size={16} color="#94A3B8" style={{ marginRight: 8 }} />
                  {planeta.conteudo} {/* Usando o conteúdo que vem da API */}
                </View>
              </Text>
            </View>

            <Text style={styles.sectionTitle}>Módulos Disponíveis</Text>
            
            {/* Agora varremos o array de 'missoes' que nosso mapper criou */}
            {planeta.missoes.map((missao) => {
              const isLocked = missao.status === 'LOCKED';

              return (
                <TouchableOpacity
                  key={missao.id}
                  activeOpacity={0.8}
                  disabled={isLocked} // Desativa o clique se estiver bloqueado
                  style={[
                    styles.moduleCard, 
                    { 
                      borderLeftColor: isLocked ? '#555' : visual.cor,
                      opacity: isLocked ? 0.5 : 1 // Deixa meio transparente se bloqueado
                    }
                  ]}
                  onPress={() => router.push({
                    pathname: `/mission/[id]`,
                    params: { id: missao.id, planetId: planeta.id }
                  })}
                >
                  <MaterialCommunityIcons 
                    // Troca o ícone se estiver bloqueado
                    name={isLocked ? "lock" : "rocket-launch-outline"} 
                    size={20} 
                    color={isLocked ? '#999' : visual.cor} 
                  />
                  <Text style={[
                    styles.moduleText, 
                    isLocked && { color: '#999' } // Texto cinza se bloqueado
                  ]}>
                    {missao.titulo}
                  </Text>
                </TouchableOpacity>
              );
            })}

          </BlurView>
        </View>
      </ScrollView>
    </ImageBackground>
  );
}