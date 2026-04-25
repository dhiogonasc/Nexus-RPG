import { ExecutionDTO, TaskDTO } from "./common";
import { LevelLabel, PlanetLabel } from "./enum";

export interface PlanetDTO {
  id: number;
  name: PlanetLabel;
  description: string;
  content: string;
  xpBonus: number;
  missions: TaskDTO;
  execution: ExecutionDTO;
  order: number;
}

export interface LevelDTO {
  id: number;
  name: LevelLabel;
  description: string;
}