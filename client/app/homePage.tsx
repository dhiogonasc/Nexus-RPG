import React, { useEffect, useRef } from 'react';
import {
  Text,
  View,
  ScrollView,
  StatusBar,
  Animated,
  Platform,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { HomeStyles as S } from '@/styles/homePageStyles'; // Ajuste o path conforme seu projeto
import PlanetCarousel from '@/components/PlanetCarousel';
// import { MaterialCommunityIcons } from '@expo/vector-icons';

interface UserData {
  id: string;
  name: string;
}

const mockUserData: UserData = {
  id: '12345',
  name: 'Flávio',
};

export default function HomePage() {
  const fadeAnim = useRef(new Animated.Value(0)).current;
  const slideAnim = useRef(new Animated.Value(30)).current;
  const user = mockUserData;

  useEffect(() => {
    Animated.parallel([
      Animated.timing(fadeAnim, {
        toValue: 1,
        duration: 800,
        // useNativeDriver funciona na Web para transform e opacity
        useNativeDriver: true, 
      }),
      Animated.timing(slideAnim, {
        toValue: 0,
        duration: 600,
        useNativeDriver: true,
      }),
    ]).start();
  }, [fadeAnim, slideAnim]);

  return (
    <SafeAreaView style={S.container} edges={['top']}>
      <StatusBar barStyle="light-content" translucent backgroundColor="transparent" />

      {/* ── Header ── */}
      <Animated.View
        style={[
          S.headerContainer,
          { opacity: fadeAnim, transform: [{ translateY: slideAnim }] },
        ]}
      >
        <View style={S.headerContent}>
          <View style={S.headerText}>
            <Text style={S.headerIcon}> 🧑‍🚀 </Text>
            <Text style={S.userName}>Astronauta {user.name}!</Text>
          </View>
        </View>
      </Animated.View>

      <ScrollView
        showsVerticalScrollIndicator={false}
        contentContainerStyle={S.scrollContent}
      >
        {/* ── Section: Planeta Atual ── */}
        <View style={S.section}>
          <View style={S.sectionHeader}>
            <View style={S.sectionAccent} />
            <Text style={S.sectionTitle}>PLANETA ATUAL</Text>
          </View>
          
          <PlanetCarousel />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}