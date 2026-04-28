// src/utils/mappers.ts
import { 
  UserDTO, TaskDTO, PlanetDetail, MissionDetail 
} from '../types/backend';
import { 
  UserProfile, ResumoPlaneta, DetalhesPlaneta, DetalhesMissao 
} from '../types/frontend';
import { VISUAIS_DOS_PLANETAS } from '../data/planetVisuals';

export function adaptarPerfil(backendUser: UserDTO): UserProfile {
  // Como level, planet e mission são opcionais (?) no UserProgressionDTO, 
  // usamos o "chaining operator" (?.) para não quebrar o app caso venham nulos.
  const nomeNivel = backendUser.progression.level?.name || 'Iniciante';

  return {
    id: String(backendUser.id),
    nome: backendUser.username,
    xp: backendUser.xp,
    oxigenio: backendUser.oxygen,
    nivelAtual: nomeNivel.replace('_', ' '), // Troca "ALUMINIUM_I" por "ALUMINIUM I"
    planetaAtual: backendUser.progression.planet?.name || 'Nenhum',
  };
}

// A página de Home recebe um TaskDTO (que contém a lista de referências dinâmicas dos planetas)
export function adaptarHome(backendHome: TaskDTO): ResumoPlaneta[] {
  return backendHome.tasks.map((task) => {
    const visual = VISUAIS_DOS_PLANETAS[String(task.id)] || { img: null, cor: '#888' };
    
    return {
      id: String(task.id),
      nome: task.name,
      descricao: task.description,
      status: task.execution.status,
      isCurrent: task.execution.isCurrent,
      imagem: visual.img,
      cor: visual.cor,
    };
  });
}

// A página de detalhes do planeta recebe um PlanetDetail
export function adaptarMissoesDoPlaneta(backendPlanet: PlanetDetail): DetalhesPlaneta {
  return {
    id: String(backendPlanet.id),
    nome: backendPlanet.name,
    conteudo: backendPlanet.content,
    progresso: {
      completas: backendPlanet.missions.progress.completed,
      total: backendPlanet.missions.progress.total,
    },
    missoes: backendPlanet.missions.tasks.map((mission) => ({
      id: String(mission.id),
      titulo: `Missão ${mission.order}`, 
      descricao: mission.description,
      status: mission.execution.status,
    })),
  };
}

// A página de jogar a missão recebe o MissionDetail
export function adaptarMissao(backendData: MissionDetail): DetalhesMissao {
  return {
    id: String(backendData.id),
    titulo: `Missão ${backendData.order}`,
    conteudo: backendData.content,
    xpBonus: backendData.xpBonus,
    questoes: backendData.questions.map(q => ({
      id: String(q.id),
      pergunta: q.content,
      opcoes: q.alternatives.map(alt => alt.content),
      respostaCorretaIndex: 0 // A ser definido com a validação do backend depois
    }))
  };
}