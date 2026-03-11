# NEXUS - Script Diagramação ER

## Script para diagramação ER via PlantText

```
@startuml
!theme plain
skinparam Linetype ortho
skinparam shadowing false

entity "Level" as level {
    * id : bigint <<PK>>
    --
    number : int <<UK>>
    xp_required : int <<CK>>
}

entity "User" as user {
    * id : bigint <<PK>>
    --
    username : varchar(255)
    email : varchar(255) <<UK>>
    password : varchar(255)
    created_at : timestamp
}

entity "UserStat" as user_stat {
    * id : bigint <<PK>>
    --
    user_id : bigint <<FK>> <<UK>>
    level_id : bigint <<FK>>
    xp_current : int <<CK>>
    streak_current : int <<CK>>
    last_access : timestamp
}

entity "Planet" as planet {
    * id : bigint <<PK>>
    --
    name : varchar(255) <<UK>>
    description : text
    planet_prerequisite_id : bigint <<FK>> <<UK>>
}


entity "Mission" as mission {
    * id : bigint <<PK>>
    --
    planet_id : bigint <<FK>>
    title : varchar(255) <<UK>>
    description : text
    mission_prerequisite_id : bigint <<FK>> <<UK>>
}

entity "Resource" as resource {
    * id : bigint <<PK>>
    --
    planet_id : bigint <<FK>> <<UK>>
    name : varchar(255) <<UK>>
    description : text
}

entity "Question" as question {
    * id : bigint <<PK>>
    --
    mission_id : bigint <<FK>>
    statement : text
    order : int
}

entity "Alternative" as alternative {
    * id : bigint <<PK>>
    --
    question_id : bigint <<FK>>
    content : text
    is_correct : boolean
}

entity "UserMission" as user_mission {
    * id : bigint <<PK>>
    --
    user_id : bigint <<FK>>
    mission_id : bigint <<FK>>
    status : varchar(50)
    best_result : float
}

entity "UserMissionAttempt" as attempt {
    * id : bigint <<PK>>
    --
    user_mission_id : bigint <<FK>>
    start_at : timestamp
    end_at : timestamp
    is_boss_defeated : boolean
    result : float
}

entity "UserResponse" as response {
    * id : bigint <<PK>>
    --
    attempt_id : bigint <<FK>>
    alternative_id : bigint <<FK>>
    is_correct : boolean
}

entity "Achievement" as achievement {
    * id : bigint <<PK>>
    --
    level_id : bigint <<FK>> <<UK>>    
    planet_id : bigint <<FK>>
    mission_id : bigint <<FK>>
    name : varchar(255)
    description : text
    bonus_xp : int <<CK>>
    "type" : varchar(50) <<CK>>
}

entity "UserAchievement" as user_achievement {
    * id : bigint <<PK>>
    --
    user_id : bigint <<FK>>
    achievement_id : bigint <<FK>>
    earned_at : timestamp
}

' Relacionamentos
user ||--|| user_stat
level ||--o{ user_stat
planet |o--o| planet : "prerequisite"
planet ||--{ mission
planet ||--|| resource
mission |o--o| mission : "prerequisite"
mission ||--{ question
question ||--{ alternative
user ||--o{ user_mission
mission ||--o{ user_mission
user_mission ||--o{ attempt
attempt ||--{ response
alternative ||--o{ response
level ||--|| achievement
planet ||--{ achievement
mission ||--{ achievement
user ||--o{ user_achievement
achievement ||--o{ user_achievement

header Nexus DB

@enduml

```

---

Visualize ou atualize: [PlantText](https://www.planttext.com/)
