import React, { useState } from 'react';
import { View, Text, StyleSheet, TouchableOpacity, ImageBackground } from 'react-native';
import { useLocalSearchParams, useRouter } from 'expo-router';
import { PLANETAS } from '@/data/planetas';
import { LinearGradient } from 'expo-linear-gradient';
import { BlurView } from 'expo-blur';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { styles } from '@/styles/idMissionStyle';

export default function MissionPage() {
  const router = useRouter();
  // Pegamos o ID da missão e o ID do planeta que enviamos pelos parâmetros
  const { id, planetId } = useLocalSearchParams();

  // Encontra o planeta para pegar a cor (accentColor)
  const planeta = PLANETAS.find(p => p.id === planetId);
  // Encontra a missão específica dentro do planeta
  const missao = planeta?.missoes.find(m => m.id === id);

  const [opcaoSelecionada, setOpcaoSelecionada] = useState<number | null>(null);

  if (!planeta || !missao) {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#020617' }}>
        <Text style={{ color: 'white' }}>Missão não encontrada.</Text>
        <TouchableOpacity onPress={() => router.back()}><Text style={{ color: '#406fd4' }}>Voltar</Text></TouchableOpacity>
      </View>
    );
  }

  const confirmarResposta = () => {
    if (opcaoSelecionada === missao.respostaCorretaIndex) {
      alert("Parabéns! Resposta correta!");
      // Aqui você futuramente adiciona lógica de XP, marcar como concluído, etc.
      router.back();
    } else {
      alert("Ops, tente novamente!");
    }
  };

  return (
    <ImageBackground
      source={require('../../assets/GalaxyBG.png')} 
      style={styles.container}
      resizeMode="cover"
    >
      <LinearGradient colors={['rgba(2,6,23,0.6)', 'rgba(2,6,23,0.95)']} style={StyleSheet.absoluteFillObject} />

      {/* Header */}
      <View style={styles.header}>
        <TouchableOpacity style={styles.backButton} onPress={() => router.back()}>
          <BlurView intensity={30} tint="dark" style={styles.iconBlur}>
            <MaterialCommunityIcons name="close" size={24} color={planeta.accentColor} />
          </BlurView>
        </TouchableOpacity>
        <Text style={[styles.headerTitle, { color: planeta.accentColor }]}>{planeta.nome} - {missao.titulo}</Text>
        <View style={{ width: 45 }} /> {/* Espaçador para centralizar o título */}
      </View>

      {/* Conteúdo da Pergunta */}
      <View style={styles.content}>
        <BlurView intensity={40} tint="dark" style={styles.questionCard}>
          <Text style={styles.questionText}>{missao.pergunta}</Text>
        </BlurView>

        {/* Alternativas */}
        <View style={styles.optionsContainer}>
          {missao.opcoes.map((opcao, index) => {
            const isSelected = opcaoSelecionada === index;
            return (
              <TouchableOpacity
                key={index}
                activeOpacity={0.8}
                style={[
                  styles.optionButton,
                  isSelected && { borderColor: planeta.accentColor, backgroundColor: 'rgba(255,255,255,0.1)' }
                ]}
                onPress={() => setOpcaoSelecionada(index)}
              >
                <View style={[styles.radioCircle, isSelected && { borderColor: planeta.accentColor }]}>
                  {isSelected && <View style={[styles.radioDot, { backgroundColor: planeta.accentColor }]} />}
                </View>
                <Text style={styles.optionText}>{opcao}</Text>
              </TouchableOpacity>
            );
          })}
        </View>

        {/* Botão de Confirmar */}
        <TouchableOpacity 
          style={[styles.confirmButton, { backgroundColor: opcaoSelecionada !== null ? planeta.accentColor : '#334155' }]}
          disabled={opcaoSelecionada === null}
          onPress={confirmarResposta}
        >
          <Text style={styles.confirmButtonText}>Confirmar</Text>
        </TouchableOpacity>
      </View>
    </ImageBackground>
  );
}