-- ====================
-- QUESTION
-- ====================
INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    -- VARIABILI (Planet ID: 1, Missions: 1, 2, 3)
    (
        1,
        'Qual a principal diferença entre uma constante e uma variável em termos de alocação de memória?',
        'Uma constante impede a reatribuição de valor após a inicialização, enquanto a variável permite mutabilidade.',
        1
    ),
    (
        1,
        'Em linguagens de tipagem estática, o que define o tipo de dado que uma variável pode armazenar?',
        'A declaração explícita do tipo no momento da reserva de memória define o domínio de dados aceito.',
        2
    ),
    -- BIFURCA_9 (Planet ID: 2, Missions: 4, 5, 6)
    (
        4,
        'Qual o resultado lógico de uma estrutura condicional quando a expressão booleana é avaliada como falsa?',
        'O fluxo de execução ignora o bloco principal e desvia para a cláusula alternativa (ELSE) ou para a próxima instrução.',
        1
    ),
    (
        4,
        'Qual operador é utilizado para verificar a igualdade estrita entre dois operandos sem realizar atribuição?',
        'O operador de comparação (==) avalia a relação de igualdade, retornando um valor booleano.',
        2
    ),
    -- CICLUS (Planet ID: 3, Missions: 7, 8, 9)
    (
        7,
        'Qual a condição necessária para evitar a execução de um loop infinito em uma estrutura WHILE?',
        'A expressão de controle deve, obrigatoriamente, ser alterada para Falsa em algum momento dentro do ciclo.',
        1
    ),
    (
        7,
        'Em que cenário a instrução BREAK é tecnicamente preferível ao controle natural da condição do loop?',
        'Quando se faz necessária a interrupção imediata do fluxo ao encontrar um critério de saída específico antes do fim da iteração.',
        2
    ),
    -- MATRX_0 (Planet ID: 4, Missions: 10, 11, 12)
    (
        10,
        'Como o índice de um elemento em um array se relaciona com sua posição física na memória?',
        'O índice representa o deslocamento (offset) em relação ao endereço base do primeiro elemento do array.',
        1
    ),
    (
        10,
        'O que ocorre ao tentar acessar um índice de valor igual ao tamanho total (length) de um array estático?',
        'Ocorre um erro de exceção (Out of Bounds), pois a indexação é baseada em zero e termina em length-1.',
        2
    );

-- ====================
-- ALTERNATIVE
-- ====================
INSERT INTO
    "alternative" (question_id, "content", "is_correct")
VALUES
    -- Questões de VARIABILI (Question IDs: 1 e 2)
    (
        1,
        'Constantes são imutáveis após inicialização, enquanto variáveis permitem reatribuição.',
        true
    ),
    (
        1,
        'Constantes e variáveis ocupam o mesmo espaço e permitem alteração a qualquer momento.',
        false
    ),
    (
        2,
        'O tipo de dado limita os valores possíveis e as operações executáveis pela variável.',
        true
    ),
    (
        2,
        'O tipo de dado é meramente estético e não interfere na alocação de memória.',
        false
    ),
    -- Questões de BIFURCA_9 (Question IDs: 3 e 4)
    (
        3,
        'O fluxo é desviado para o bloco oposto ou para a instrução subsequente ao bloco condicional.',
        true
    ),
    (
        3,
        'A execução do programa é interrompida imediatamente caso a condição seja falsa.',
        false
    ),
    (
        4,
        'O operador "==" compara valores, enquanto "=" realiza a atribuição de um novo valor.',
        true
    ),
    (
        4,
        'O operador "==" é utilizado exclusivamente para somar valores booleanos.',
        false
    ),
    -- Questões de CICLUS (Question IDs: 5 e 6)
    (
        5,
        'A expressão de controle deve ser atualizada para "falsa" durante a execução do laço.',
        true
    ),
    (
        5,
        'A condição deve ser mantida sempre como "verdadeira" para garantir a persistência dos dados.',
        false
    ),
    (
        6,
        'Para forçar a saída de um laço antes que a condição principal seja invalidada.',
        true
    ),
    (
        6,
        'Para reiniciar o contador do loop e voltar à primeira iteração do bloco.',
        false
    ),
    -- Questões de MATRX_0 (Question IDs: 7 e 8)
    (
        7,
        'O índice funciona como um deslocamento numérico a partir do endereço inicial do array.',
        true
    ),
    (
        7,
        'O índice é um nome aleatório atribuído a cada célula de memória individual.',
        false
    ),
    (
        8,
        'Ocorre um erro de acesso, pois o último índice válido é sempre "tamanho - 1".',
        true
    ),
    (
        8,
        'O array expande automaticamente o seu tamanho para comportar o novo índice.',
        false
    );