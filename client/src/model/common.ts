export interface ExecutionDTO {
  status: EntityStatus;
  isCurrent: boolean;
}

export interface ProgressDTO {
  completed: number;
  total: number;
}

export interface EntityReferenceDTO {
  id: number;
  name: string;
  description: string;
  order: number;
  execution: ExecutionDTO;
}

export interface TaskDTO {
  tasks: EntityReferenceDTO[];
  progress: ProgressDTO;
}