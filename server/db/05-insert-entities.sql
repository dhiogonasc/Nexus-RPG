-- ====================
-- LEVEL
-- ====================
INSERT INTO
    "level" (
        "name",
        "description",
        "order",
        "xp_bonus",
        "xp_required"
    )
VALUES
    -- ALUMINIUM TIER (Iniciante)
    (
        'ALUMINIUM_I',
        'Iniciante - primeiro estágio de exploração: resistência alumínio',
        1,
        0,
        0
    ),
    (
        'ALUMINIUM_II',
        'Iniciante - segundo estágio de exploração: resistência alumínio',
        2,
        10,
        50
    ),
    (
        'ALUMINIUM_III',
        'Iniciante - terceiro estágio de exploração: resistência alumínio',
        3,
        10,
        50
    ),
    -- IRON TIER (Intermediário)
    (
        'IRON_I',
        'Intermediário - primeiro estágio de exploração: resistência ferro',
        4,
        20,
        100
    ),
    (
        'IRON_II',
        'Intermediário - segundo estágio de exploração: resistência ferro',
        5,
        30,
        150
    ),
    (
        'IRON_III',
        'Intermediário - terceiro estágio de exploração: resistência ferro',
        6,
        50,
        250
    ),
    -- NICKEL TIER (Avançado)
    (
        'NICKEL_I',
        'Avançado - primeiro estágio de exploração: resistência níquel',
        7,
        80,
        400
    ),
    (
        'NICKEL_II',
        'Avançado - segundo estágio de exploração: resistência níquel',
        8,
        130,
        650
    ),
    (
        'NICKEL_III',
        'Avançado - terceiro estágio de exploração: resistência níquel',
        9,
        210,
        1050
    ),
    -- PALLADIUM TIER (Elite)
    (
        'PALLADIUM_I',
        'Elite - primeiro estágio de exploração: resistência paládio',
        10,
        340,
        1700
    ),
    (
        'PALLADIUM_II',
        'Elite - segundo estágio de exploração: resistência paládio',
        11,
        550,
        2750
    ),
    (
        'PALLADIUM_III',
        'Elite - terceiro estágio de exploração: resistência paládio',
        12,
        890,
        4450
    );

-- ====================
-- PLANET
-- ====================
INSERT INTO
    "planet" (
        "name",
        "description",
        "content",
        "order",
        "xp_bonus"
    )
VALUES
    (
        'VARIABILI',
        'Módulo fundamental: análise de constantes, variáveis e tipagem de dados.',
        'planet content',
        1,
        100
    ),
    (
        'BIFURCA_9',
        'Módulo de fluxo: implementação de estruturas condicionais e tomadas de decisão.',
        'planet content',
        2,
        200
    ),
    (
        'CICLUS',
        'Módulo de repetição: execução de estruturas de controle de fluxo e loops.',
        'planet content',
        3,
        300
    ),
    (
        'MATRX_0',
        'Módulo de coleções: manipulação de arrays e estruturas de dados indexadas.',
        'planet content',
        4,
        500
    );

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
    -- VARIABILI (Planet ID: 1)
    (
        1,
        'Constantes e Identificadores',
        'Definição de valores imutáveis e convenções de nomenclatura.',
        'mission content',
        1,
        10
    ),
    (
        1,
        'Variáveis e Mutabilidade',
        'Alocação de memória e manipulação de estados variáveis.',
        'mission content',
        2,
        20
    ),
    (
        1,
        'Tipagem Primitiva',
        'Processamento de tipos numéricos, booleanos e caracteres.',
        'mission content',
        3,
        30
    ),
    -- BIFURCA_9 (Planet ID: 2)
    (
        2,
        'Estrutura de Decisão Simples',
        'Implementação de fluxos lógicos baseados em SE/ENTÃO.',
        'mission content',
        1,
        10
    ),
    (
        2,
        'Encadeamento Lógico',
        'Operação de condicionais compostas e seletores múltiplos.',
        'mission content',
        2,
        20
    ),
    (
        2,
        'Operadores Comparativos',
        'Avaliação de expressões lógicas e relacionais.',
        'mission content',
        3,
        30
    ),
    -- CICLUS (Planet ID: 3)
    (
        3,
        'Iteração por Condição',
        'Execução de laços de repetição baseados em estados lógicos (While).',
        'mission content',
        1,
        10
    ),
    (
        3,
        'Iteração por Contagem',
        'Processamento de loops com intervalos definidos (For).',
        'mission content',
        2,
        20
    ),
    (
        3,
        'Controle de Fluxo Interno',
        'Aplicação de comandos de interrupção e continuidade (Break/Continue).',
        'mission content',
        3,
        30
    ),
    -- MATRX_0 (Planet ID: 4)
    (
        4,
        'Inicialização de Vetores',
        'Estruturação de coleções de dados lineares e indexação.',
        'mission content',
        1,
        10
    ),
    (
        4,
        'Manipulação de Índices',
        'Acesso e modificação de elementos em posições específicas da memória.',
        'mission content',
        2,
        20
    ),
    (
        4,
        'Iteração de Coleções',
        'Processamento sequencial de elementos em estruturas de array.',
        'mission content',
        3,
        30
    );