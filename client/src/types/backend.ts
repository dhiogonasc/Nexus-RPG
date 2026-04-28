// src/types/backend.ts

export enum LevelLabel {
  ALUMINIUM_I = 'ALUMINIUM_I',
  ALUMINIUM_II = 'ALUMINIUM_II',
  ALUMINIUM_III = 'ALUMINIUM_III',
  IRON_I = 'IRON_I',
  IRON_II = 'IRON_II',
  IRON_III = 'IRON_III',
  NICKEL_I = 'NICKEL_I',
  NICKEL_II = 'NICKEL_II',
  NICKEL_III = 'NICKEL_III',
  PALLADIUM_I = 'PALLADIUM_I',
  PALLADIUM_II = 'PALLADIUM_II',
  PALLADIUM_III = 'PALLADIUM_III'
}

export enum EntityStatus {
  LOCKED = 'LOCKED',
  UNLOCKED = 'UNLOCKED',
  COMPLETED = 'COMPLETED'
}

export interface ExecutionDTO {
  status: EntityStatus;
  isCurrent: boolean;
}

export interface ProgressDTO {
  completed: number;
  total: number;
}

export interface EntityStaticReference {
  id: number;
  name: string;
  description: string;
}

export interface EntityDynamicReference {
  id: number;
  name: string;
  description: string;
  order: number;
  execution: ExecutionDTO;
}

export interface TaskDTO {
  tasks: EntityDynamicReference[];
  progress: ProgressDTO;
}

export interface AnswerComponentDTO {
  id: number;
  content: string;
}

export interface PlanetDetail extends EntityDynamicReference {
  content: string;
  missions: TaskDTO;
}

export interface MissionDetail extends EntityDynamicReference {
  content: string;
  questions: QuestionDTO[];
  xpBonus: number;
  bestResult: number;
  planet: EntityDynamicReference;
}

export interface QuestionDTO {
  id: number;
  content: string;
  order: number;
  alternatives: AnswerComponentDTO[];
}

export interface LevelReference {
  id: number;
  name: LevelLabel;
  xpBonus: number;
  xpRequired: number;
}

export interface LevelDetail {
  id: number;
  name: LevelLabel;
  description: string;
  next?: LevelReference;
}

export interface UserProgressionDTO {
  level?: LevelDetail;
  planet?: EntityStaticReference;
  mission?: EntityStaticReference;
}

export interface UserDTO {
  id: number;
  username: string;
  email: string;
  xp: number;
  oxygen: number;
  progression: UserProgressionDTO;
}