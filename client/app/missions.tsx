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

import { styles } from '@/styles/indexStyles';

import { LinearGradient } from 'expo-linear-gradient';

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

        <Text style={styles.title}>Missões!!!</Text>

          <LinearGradient
            colors={['transparent', '#000000']}
            style={styles.gradientFade}
          />
        </View>
      </ScrollView>
    </KeyboardAvoidingView>
  );
}