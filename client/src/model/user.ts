import { EntityReferenceDTO } from "./common";
import { LevelDTO } from "./domain";

export interface UserProgressionDTO {
  level: LevelDTO;
  planet: EntityReferenceDTO;
  mission: EntityReferenceDTO;
}

export interface UserDTO {
  id: number;
  username: string;
  email: string;
  xp: number;
  oxygen: number;
  progression: UserProgressionDTO;
}