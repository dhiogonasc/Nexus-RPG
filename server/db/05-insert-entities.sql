-- ====================
-- LEVEL
-- ====================
INSERT INTO "level" ("name", "description", "order", "xp_bonus", "xp_required")
VALUES
    -- ALUMINIUM TIER (Iniciante)
    ('ALUMINIUM_I',   'Iniciante - primeiro estágio de exploração: resistência alumínio', 1, 0, 0),
    ('ALUMINIUM_II',  'Iniciante - segundo estágio de exploração: resistência alumínio', 2, 10, 50),
    ('ALUMINIUM_III', 'Iniciante - terceiro estágio de exploração: resistência alumínio', 3, 10, 50),

    -- IRON TIER (Intermediário)
    ('IRON_I',        'Intermediário - primeiro estágio de exploração: resistência ferro', 4, 20, 100),
    ('IRON_II',       'Intermediário - segundo estágio de exploração: resistência ferro', 5, 30, 150),
    ('IRON_III',      'Intermediário - terceiro estágio de exploração: resistência ferro', 6, 50, 250),

    -- NICKEL TIER (Avançado)
    ('NICKEL_I',      'Avançado - primeiro estágio de exploração: resistência níquel', 7, 80, 400),
    ('NICKEL_II',     'Avançado - segundo estágio de exploração: resistência níquel', 8, 130, 650),
    ('NICKEL_III',    'Avançado - terceiro estágio de exploração: resistência níquel', 9, 210, 1050),

    -- PALLADIUM TIER (Elite)
    ('PALLADIUM_I',   'Elite - primeiro estágio de exploração: resistência paládio', 10, 340, 1700),
    ('PALLADIUM_II',  'Elite - segundo estágio de exploração: resistência paládio', 11, 550, 2750),
    ('PALLADIUM_III', 'Elite - terceiro estágio de exploração: resistência paládio', 12, 890, 4450);

-- ====================
-- PLANET
-- ====================
INSERT INTO "planet" ("name", "description", "content", "order", "xp_bonus")
VALUES
    ('VARIABILI',
     'Módulo fundamental: análise de constantes, variáveis e tipagem de dados.',
     'planet content', 1, 100),

    ('BIFURCA_9',
     'Módulo de fluxo: implementação de estruturas condicionais e tomadas de decisão.',
     'planet content', 2, 200),

    ('CICLUS',
     'Módulo de repetição: execução de estruturas de controle de fluxo e loops.',
     'planet content', 3, 300),

    ('MATRX_0',
     'Módulo de coleções: manipulação de arrays e estruturas de dados indexadas.',
     'planet content', 4, 500);

-- ====================
-- MISSION
-- ====================
INSERT INTO
    "mission" (
    planet_id,
    "name",
    "description",
    "content",
    "order",
    "xp_bonus"
)
VALUES
    (1, 'Planet - 1 : Mission - 1 ', 'mission description', 'mission content', 1, 10),
    (1, 'Planet - 1 : Mission - 2 ', 'mission description', 'mission content', 2, 10),
    (2, 'Planet - 2 : Mission - 1 ', 'mission description', 'mission content', 1, 10),
    (2, 'Planet - 2 : Mission - 2 ', 'mission description', 'mission content', 2, 10);