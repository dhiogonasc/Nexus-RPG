// src/types/frontend.ts
import { EntityStatus } from './backend';

export type UserProfile = {
  id: string;
  nome: string;
  xp: number;
  oxigenio: number;
  nivelAtual: string;
  planetaAtual: string;
};

export type ResumoPlaneta = {
  id: string;
  nome: string;
  descricao: string;
  status: EntityStatus; // Usando o Enum oficial agora!
  isCurrent: boolean;
  imagem: any;
  cor: string;
};

export type ResumoMissao = {
  id: string;
  titulo: string;
  descricao: string;
  status: EntityStatus;
};

export type DetalhesPlaneta = {
  id: string;
  nome: string;
  conteudo: string;
  progresso: { completas: number; total: number };
  missoes: ResumoMissao[];
};

export type QuestaoFormatada = {
  id: string;
  pergunta: string;
  opcoes: string[];
  respostaCorretaIndex: number;
};

export type DetalhesMissao = {
  id: string;
  titulo: string;
  conteudo: string;
  xpBonus: number;
  questoes: QuestaoFormatada[];
};