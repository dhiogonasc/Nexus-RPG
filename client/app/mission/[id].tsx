// app/mission/[id].tsx
import React, { useState, useEffect } from 'react';
import { 
  View, 
  Text, 
  StyleSheet, 
  TouchableOpacity, 
  ImageBackground,
  ActivityIndicator,
  Alert
} from 'react-native';
import { useLocalSearchParams, useRouter } from 'expo-router';
import { LinearGradient } from 'expo-linear-gradient';
import { BlurView } from 'expo-blur';
import { MaterialCommunityIcons } from '@expo/vector-icons';
import { styles } from '@/styles/idMissionStyle';

// Novas importações da nossa arquitetura
import { fetchDetalhesMissao } from '@/services/api';
import { adaptarMissao } from '@/utils/mappers';
import { DetalhesMissao } from '@/types/frontend';
import { VISUAIS_DOS_PLANETAS } from '@/data/planetVisuals';

export default function MissionPage() {
  const router = useRouter();
  const { id, planetId } = useLocalSearchParams();

  // Estados de Dados da API
  const [missao, setMissao] = useState<DetalhesMissao | null>(null);
  const [loading, setLoading] = useState(true);

  // Estados do Jogo (Quiz)
  const [questaoAtualIndex, setQuestaoAtualIndex] = useState(0);
  const [opcaoSelecionada, setOpcaoSelecionada] = useState<number | null>(null);

  // Busca a missão no backend quando a tela abre
  useEffect(() => {
    async function carregarMissao() {
      try {
        setLoading(true);
        const dadosSujos = await fetchDetalhesMissao(id as string);
        const dadosLimpos = adaptarMissao(dadosSujos);
        setMissao(dadosLimpos);
      } catch (error) {
        console.error("Erro ao carregar missão:", error);
      } finally {
        setLoading(false);
      }
    }

    if (id) carregarMissao();
  }, [id]);

  if (loading) {
    return (
      <View style={[styles.container, { justifyContent: 'center', alignItems: 'center', backgroundColor: '#020617' }]}>
        <ActivityIndicator size="large" color="#406fd4" />
      </View>
    );
  }

  if (!missao || missao.questoes.length === 0) {
    return (
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor: '#020617' }}>
        <Text style={{ color: 'white' }}>Nenhuma questão encontrada para esta missão.</Text>
        <TouchableOpacity onPress={() => router.back()}><Text style={{ color: '#406fd4', marginTop: 10 }}>Voltar</Text></TouchableOpacity>
      </View>
    );
  }

  // Pega as cores do planeta (ou usa um azul padrão se falhar)
  const visual = VISUAIS_DOS_PLANETAS[planetId as string] || { cor: '#406fd4' };
  
  // Isola a questão que o usuário está vendo agora
  const questaoAtual = missao.questoes[questaoAtualIndex];

  const confirmarResposta = () => {
    // Atenção: A validação ideal deve ser feita mandando a resposta pro backend!
    // Como combinamos que o mapper fixou a correta como 0 temporariamente:
    if (opcaoSelecionada === questaoAtual.respostaCorretaIndex) {
      
      // Verifica se tem mais questões
      if (questaoAtualIndex + 1 < missao.questoes.length) {
        Alert.alert("Correto!", "Vamos para a próxima pergunta.");
        setQuestaoAtualIndex(prev => prev + 1); // Avança para a próxima pergunta
        setOpcaoSelecionada(null); // Limpa a seleção
      } else {
        // Acabou a missão!
        Alert.alert(
          "Missão Concluída!", 
          `Parabéns! Você ganhou ${missao.xpBonus} de XP.`,
          [{ text: "Incrível!", onPress: () => router.back() }]
        );
      }

    } else {
      Alert.alert("Ops!", "Resposta incorreta, tente novamente.");
    }
  };

  return (
    <ImageBackground
      source={require('../../assets/GalaxyBG.png')} 
      style={styles.container}
      resizeMode="cover"
    >
      <LinearGradient colors={['rgba(2,6,23,0.6)', 'rgba(2,6,23,0.95)']} style={StyleSheet.absoluteFillObject} />

      <View style={styles.header}>
        <TouchableOpacity style={styles.backButton} onPress={() => router.back()}>
          <BlurView intensity={30} tint="dark" style={styles.iconBlur}>
            <MaterialCommunityIcons name="close" size={24} color={visual.cor} />
          </BlurView>
        </TouchableOpacity>
        <Text style={[styles.headerTitle, { color: visual.cor }]}>
          {missao.titulo} - {questaoAtualIndex + 1}/{missao.questoes.length}
        </Text>
        <View style={{ width: 45 }} />
      </View>

      <View style={styles.content}>
        <BlurView intensity={40} tint="dark" style={styles.questionCard}>
          <Text style={styles.questionText}>{questaoAtual.pergunta}</Text>
        </BlurView>

        <View style={styles.optionsContainer}>
          {questaoAtual.opcoes.map((opcao, index) => {
            const isSelected = opcaoSelecionada === index;
            return (
              <TouchableOpacity
                key={index}
                activeOpacity={0.8}
                style={[
                  styles.optionButton,
                  isSelected && { borderColor: visual.cor, backgroundColor: 'rgba(255,255,255,0.1)' }
                ]}
                onPress={() => setOpcaoSelecionada(index)}
              >
                <View style={[styles.radioCircle, isSelected && { borderColor: visual.cor }]}>
                  {isSelected && <View style={[styles.radioDot, { backgroundColor: visual.cor }]} />}
                </View>
                <Text style={styles.optionText}>{opcao}</Text>
              </TouchableOpacity>
            );
          })}
        </View>

        <TouchableOpacity 
          style={[styles.confirmButton, { backgroundColor: opcaoSelecionada !== null ? visual.cor : '#334155' }]}
          disabled={opcaoSelecionada === null}
          onPress={confirmarResposta}
        >
          <Text style={styles.confirmButtonText}>Confirmar</Text>
        </TouchableOpacity>
      </View>
    </ImageBackground>
  );
}