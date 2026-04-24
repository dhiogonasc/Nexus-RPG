import React, { useState, useRef } from 'react';
import {
  Text,
  View,
  TouchableOpacity,
  ImageBackground,
  Animated,
} from 'react-native';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { LinearGradient } from 'expo-linear-gradient';
import { BlurView } from 'expo-blur';
import { CarouselStyles as S } from '@/styles/CarouselStyle';
import { router } from 'expo-router';
import { PLANETAS } from '@/data/planetas'; 


export default function PlanetCarousel() {
  const [index, setIndex] = useState(0);
  const [isAnimating, setIsAnimating] = useState(false);
  const userCurrentPlanetId = '2';

  const scaleAnim = useRef(new Animated.Value(1)).current;
  const opacityAnim = useRef(new Animated.Value(1)).current;
  const translateXAnim = useRef(new Animated.Value(0)).current;

  const planeta = PLANETAS[index];



  const navegar = (alvo: 'ant' | 'prox' | number) => {
    if (isAnimating) return;
    setIsAnimating(true);

    let proximoIndex = 0;
    let direcaoAnimacao = 1;

    if (typeof alvo === 'number') {
      proximoIndex = alvo;
      direcaoAnimacao = alvo > index ? -1 : 1;
    } else {
      proximoIndex = alvo === 'prox'
        ? (index + 1) % PLANETAS.length
        : (index - 1 + PLANETAS.length) % PLANETAS.length;
      direcaoAnimacao = alvo === 'prox' ? -1 : 1;
    }

    Animated.parallel([
      Animated.timing(opacityAnim, { toValue: 0, duration: 200, useNativeDriver: true }),
      Animated.timing(scaleAnim, { toValue: 0.85, duration: 200, useNativeDriver: true }),
      Animated.timing(translateXAnim, {
        toValue: direcaoAnimacao * 40,
        duration: 200,
        useNativeDriver: true,
      }),
    ]).start(() => {
      setIndex(proximoIndex);
      translateXAnim.setValue(-direcaoAnimacao * 40);

      Animated.parallel([
        Animated.spring(opacityAnim, { toValue: 1, useNativeDriver: true }),
        Animated.spring(scaleAnim, { toValue: 1, friction: 6, useNativeDriver: true }),
        Animated.spring(translateXAnim, { toValue: 0, friction: 7, useNativeDriver: true }),
      ]).start(() => setIsAnimating(false));
    });
  };

  return (
    <View style={S.wrapper}>
      <ImageBackground
        source={require('../../assets/GalaxyBG.png')}
        style={S.galaxyBackground}
        resizeMode="cover"
      >
        <LinearGradient
          colors={['rgba(2,6,23,0.2)', 'rgba(2,6,23,0.85)']}
          style={S.galaxyOverlay}
        />

        {/* Orbit ring decorativo */}
        <View style={[S.orbitRing, { borderColor: planeta.accentColor + '25' }]} />

        {/* Planeta animado */}
        <Animated.View
          style={[
            S.planetContainer,
            {
              opacity: opacityAnim,
              transform: [{ scale: scaleAnim }, { translateX: translateXAnim }],
            },
          ]}
        >
          <ImageBackground
            source={planeta.imagem}
            style={S.planetImage}
            resizeMode="contain"
          />
        </Animated.View>

        {/* Controles de navegação */}
        <View style={S.controls}>
          <TouchableOpacity
            onPress={() => navegar('ant')}
            style={S.navButton}
            activeOpacity={0.7}
            accessibilityLabel="Planeta anterior"
          >
            <BlurView intensity={30} tint="dark" style={S.navBlur}>
              <MaterialCommunityIcons name="chevron-left" size={28} color="#CBD5E1" />
            </BlurView>
          </TouchableOpacity>

          <TouchableOpacity
            onPress={() => navegar('prox')}
            style={S.navButton}
            activeOpacity={0.7}
            accessibilityLabel="Próximo planeta"
          >
            <BlurView intensity={30} tint="dark" style={S.navBlur}>
              <MaterialCommunityIcons name="chevron-right" size={28} color="#CBD5E1" />
            </BlurView>
          </TouchableOpacity>
        </View>

        {/* Info card do planeta */}
        <Animated.View style={[S.infoCard, { opacity: opacityAnim }]}>
          <BlurView intensity={40} tint="dark" style={S.infoBlur}>

            
            <View style={[S.accentLine, { backgroundColor: planeta.accentColor }]} />

            {/* Visualização da posição do usuário */}
            {planeta.id === userCurrentPlanetId && (
              <View style={{ flexDirection: 'row', alignItems: 'center', marginBottom: 6 }}>
                <MaterialCommunityIcons name="map-marker" size={14} color={planeta.accentColor} />
                <Text style={{ 
                  color: planeta.accentColor, 
                  fontSize: 12, 
                  fontWeight: 'bold', 
                  marginLeft: 4,
                  textTransform: 'uppercase',
                  letterSpacing: 1
                }}>
                  Você está aqui
                </Text>
              </View>
            )}

            <Text style={S.planetName}>{planeta.nome}</Text>
            <View style={S.infoRow}>
              <View style={S.infoPill}>
                <MaterialCommunityIcons name="atom" size={12} color="#94A3B8" />
                <Text style={S.infoPillText}>{planeta.description}</Text>
              </View>
            </View>

          </BlurView>
        </Animated.View>

        {/* Indicador de posição */}
        <View style={S.dots}>
          {PLANETAS.map((_, i) => (
            <TouchableOpacity key={i} onPress={() => {
              if (i !== index) navegar(i); // Agora salta diretamente para o índice correto
            }}>
              <View
                style={[
                  S.dot,
                  i === index && { backgroundColor: planeta.accentColor, width: 20 },
                ]}
              />
            </TouchableOpacity>
          ))}


        </View>
      </ImageBackground>

          <TouchableOpacity 
              style={{ 
                backgroundColor: planeta.accentColor, 
                padding: 7,
                paddingLeft: 25,
                paddingRight: 25, 
                borderRadius: 8, 
                marginTop: 15,
                marginBottom: 25,
                alignItems: 'center',
                marginLeft: 'auto',
                marginRight: 'auto',
              }}
              onPress={() => router.push(`/planet/${planeta.id}`)} // <- NAVEGAÇÃO AQUI
            >
              <Text style={{ color: '#fff', fontWeight: 'bold' }}>
                Explorar {planeta.nome}
              </Text>
            </TouchableOpacity>
    </View>
  );
}