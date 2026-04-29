INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                m.id
            FROM
                "mission" m
                JOIN "planet" p ON m.planet_id = p.id
            WHERE
                p."order" = 1
                AND m."order" = 1
        ),
        'Utilizando a analogia da nave espacial, a Memória RAM pode ser comparada a qual parte da embarcação?',
        'A RAM funciona como o convés de trabalho, onde as ações imediatas acontecem para garantir fluidez e rapidez nas operações.',
        1
    ),
    (
        (
            SELECT
                m.id
            FROM
                "mission" m
                JOIN "planet" p ON m.planet_id = p.id
            WHERE
                p."order" = 1
                AND m."order" = 1
        ),
        'O que o computador faz ao reservar um "endereço físico" nos compartimentos eletrônicos?',
        'Reservar um endereço garante que aquele dado tenha um lugar fixo e exclusivo, evitando que ele seja sobrescrito ou perdido no sistema.',
        2
    ),
    (
        (
            SELECT
                m.id
            FROM
                "mission" m
                JOIN "planet" p ON m.planet_id = p.id
            WHERE
                p."order" = 1
                AND m."order" = 1
        ),
        'Qual a característica fundamental da memória mencionada no texto que garante que as operações de voo sejam fluidas?',
        'A velocidade é a chave: a capacidade de recuperar informações em nanossegundos é o que diferencia a memória de trabalho de outros tipos de armazenamento.',
        3
    ),
    (
        (
            SELECT
                m.id
            FROM
                "mission" m
                JOIN "planet" p ON m.planet_id = p.id
            WHERE
                p."order" = 1
                AND m."order" = 1
        ),
        'Na analogia do rack de carga, por que o computador vincula um "nome" a um slot ocupado?',
        'O nome serve como uma referência (ou etiqueta) para que o processador identifique rapidamente o conteúdo de um endereço de memória específico.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'De acordo com o texto, o que representam os "identificadores" no software da sonda?',
        'Identificadores são os nomes atribuídos a elementos do código (como variáveis e funções) para que o sistema e os humanos consigam identificá-los.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Por que existem restrições de segurança que impedem o uso de números no início de um nome ou o uso de espaços?',
        'Restrições de escrita existem para evitar que o compilador confunda nomes de arquivos ou sensores com comandos de sistema ou erros de sintaxe.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Se um engenheiro precisar nomear um sensor de "oxigênio reserva" usando o padrão snake_case, como ficaria o nome?',
        'O padrão snake_case utiliza letras minúsculas separadas por um sublinhado (underscore), simulando o rastro de uma serpente.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Qual a importância de seguir regras rígidas de escrita (convenções) ao nomear componentes do software?',
        'Convenções de escrita garantem que a comunicação seja clara e que erros humanos de leitura sejam minimizados durante a manutenção do software.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Ao monitorar a sonda, por que o nível de combustível é considerado uma variável?',
        'O nível de combustível é uma variável porque seu valor diminui conforme os motores são acionados, representando um dado que flutua durante a missão.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Qual a principal diferença entre uma constante e uma variável no software da nave?',
        'Variáveis armazenam dados que podem mudar durante a execução, enquanto constantes armazenam valores fixos que não podem ser alterados.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Qual destes exemplos melhor representa uma constante física mencionada no texto?',
        'A velocidade da luz é uma constante universal; seu valor é fixo e serve como base imutável para os cálculos físicos da sonda.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'O que aconteceria se tentássemos alterar o valor de uma constante durante a simulação de voo?',
        'O sistema impediria a alteração, pois constantes funcionam como travas de segurança para garantir a integridade dos dados fundamentais.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Para registrar a quantidade exata de satélites em órbita, sem utilizar frações, qual tipo de dado o computador da nave utiliza?',
        'Números inteiros são ideais para contagens de unidades completas onde não faz sentido existir uma metade ou fração.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Em cálculos de trajetórias espaciais que exigem extrema precisão decimal, qual destes tipos de dados é fundamental?',
        'O ponto flutuante (ou real) permite representar números com casas decimais, garantindo a precisão necessária para navegação.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'As mensagens de texto exibidas no painel de comando, como o nome de uma galáxia, pertencem a qual categoria de dados?',
        'Strings são sequências de caracteres utilizadas para formar palavras, frases e mensagens de texto no sistema.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Qual tipo de dado funciona como um "interruptor binário", respondendo apenas se uma condição é verdadeira ou falsa?',
        'Dados booleanos são usados para representar apenas dois estados possíveis (verdadeiro/falso), como o estado ativo ou inativo de um motor.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Ao escrever o comando "oxigenio = 100", qual ação o sistema da nave está realizando?',
        'A atribuição é um comando de carga que coloca um valor específico dentro de um compartimento de memória identificado por um nome.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Por que o símbolo "=" na programação de uma sonda não deve ser confundido com uma igualdade matemática comum?',
        'Na programação, o símbolo de igualdade é um operador de ação (armazenamento), indicando que o valor à direita será injetado na variável à esquerda.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'O que a representação visual da seta (<-) indica sobre o processo de atribuição de dados?',
        'A seta simboliza o fluxo direcional da informação, mostrando que o dado está sendo movido de uma fonte para dentro de um identificador.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 1
                )
        ),
        'Qual a importância de injetar os dados brutos dos sensores em estruturas de controle através da atribuição?',
        'Esse processo permite que o sistema armazene informações momentâneas para processá-las e tomar decisões críticas, como ajustes de rota.',
        4
    );

---==================================================
INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 1
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Se o computador de bordo precisa verificar se a pressão atual é exatamente igual à pressão nominal, qual operador ele deve utilizar?',
        'O operador "==" é utilizado para comparar igualdade entre dois valores, retornando verdadeiro se eles forem idênticos.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 1
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual operador relacional é utilizado para detectar se a temperatura da sonda está "fora do padrão", ou seja, diferente do valor esperado?',
        'O operador "!=" significa "diferente de" e é usado para identificar quando um valor não corresponde ao padrão definido.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 1
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Para garantir a segurança, a sonda dispara um alerta se a distância até um asteroide for "menor que" o limite de segurança. Qual símbolo representa essa comparação?',
        'O símbolo "<" (menor que) é vital para monitorar limites de proximidade e segurança na navegação espacial.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 1
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Toda comparação feita pelos sensores de telemetria usando operadores relacionais resulta sempre em qual tipo de valor?',
        'As comparações relacionais sempre resultam em um valor lógico (booleano), indicando se aquela afirmação é verdadeira ou falsa.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Imagine que a sonda só pode pousar se houver "espaço plano" E "pouco vento". O que acontece se apenas o espaço for plano, mas houver muito vento?',
        'O operador E (AND) exige que todas as condições sejam verdadeiras simultaneamente. Se uma falha, o resultado total é falso.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'O protocolo de emergência deve ser ativado se houver "falha no oxigênio" OU "incêndio na cabine". Se apenas um desses problemas ocorrer, o que o sistema faz?',
        'O operador OU (OR) é flexível: ele ativa a resposta se pelo menos uma das condições for verdadeira.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual operador lógico a IA utilizaria para executar uma tarefa especificamente enquanto "NÃO" houver sinal de rádio disponível?',
        'O operador NÃO (NOT) é um inversor, utilizado para criar lógicas baseadas na ausência ou negação de um estado.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 2
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual a principal vantagem de combinar múltiplos sensores usando operadores lógicos em uma missão espacial?',
        'A combinação de sensores permite que a nave analise cenários complexos e multifatoriais antes de tomar uma decisão automática.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Em uma estrutura de Condicional Simples, o que o software da sonda faz quando a condição de teste não é atingida (é falsa)?',
        'A condicional simples não possui um plano alternativo; se a condição for falsa, o programa simplesmente pula aquela instrução e continua a execução normal.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Utilizando o exemplo dos painéis solares, qual é o papel do comando "ative os sopradores" dentro da estrutura condicional?',
        'Este é o bloco de ação que só é executado caso o sensor detecte que a poeira ultrapassou o limite estabelecido.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Por que a condicional simples é comparada a um "gatilho de ação única" no texto?',
        'Porque ela serve para disparar uma resposta específica apenas para um evento detectado, sem se preocupar com outras possibilidades naquele momento.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 3
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual destas situações da vida real em uma nave representa melhor uma Condicional Simples?',
        'Situações onde uma ação só deve ocorrer sob uma circunstância específica, como ligar o aquecedor apenas se a temperatura cair abaixo de zero.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Diferente da condicional simples, o que a estrutura de Condicional Composta oferece ao sistema da sonda?',
        'A condicional composta introduz uma bifurcação, garantindo que exista uma ação tanto para o caso da condição ser verdadeira quanto para o caso de ser falsa.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual é o papel do comando "SENÃO" (também conhecido como ELSE) dentro de uma estrutura de decisão?',
        'O SENÃO define o caminho obrigatório que o computador deve seguir caso a condição principal testada seja considerada falsa.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Considerando o protocolo de integridade do casco (100%), qual ação o sistema toma se o sensor detectar qualquer valor diferente de 100%?',
        'Se a condição for falsa, o fluxo de execução é desviado para o bloco do SENÃO, executando as medidas de reparo e redução de velocidade.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 4
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Por que dizemos que na condicional composta não existe "meio-termo" para a execução do código?',
        'Porque o computador é forçado a escolher exatamente um dos dois caminhos disponíveis, baseando-se estritamente no resultado do teste lógico.',
        4
    );

INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Quando o sistema da sonda utiliza Condicionais Encadeadas em vez de uma Condicional Composta comum?',
        'As condicionais encadeadas são usadas quando existem mais de duas opções de decisão, permitindo testar várias condições em sequência.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'No exemplo da análise de minerais em Marte, o que acontece se o primeiro teste ("for ouro") resultar em falso?',
        'O sistema passa para a próxima verificação, que é o "SENÃO SE" (else if), para testar se o mineral corresponde à próxima categoria.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual é o papel do "SENÃO" (else) final em uma estrutura de decisões encadeadas?',
        'O "SENÃO" final funciona como uma rede de segurança, capturando qualquer caso que não tenha se encaixado em nenhuma das condições anteriores.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 5
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Como a IA da sonda se beneficia das múltiplas camadas de verificação das condicionais encadeadas?',
        'Isso permite que a sonda reaja a descobertas variadas de forma organizada, classificando dados complexos sem misturar as categorias.',
        4
    );

INSERT INTO
    "alternative" (question_id, "content", "is_correct")
VALUES
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 1
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Quando precisa escolher entre apenas dois caminhos fixos.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 1
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Quando há várias possibilidades de resposta para uma mesma situação.',
        true
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 1
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Apenas quando a bateria está abaixo de 10%.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 1
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Quando o sistema precisa apagar todos os dados da missão.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 1
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Para transformar uma variável em uma constante.',
        false
    );

INSERT INTO
    "alternative" (question_id, "content", "is_correct")
VALUES
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 2
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'O programa para de rodar e aguarda ordens da Terra.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 2
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'A sonda classifica o mineral como "ouro" mesmo assim.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 2
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'O sistema testa a próxima condição usando o SENÃO SE.',
        true
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 2
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'A memória RAM é reiniciada para limpar o erro.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 2
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'O sensor é desligado para economizar combustível.',
        false
    );

INSERT INTO
    "alternative" (question_id, "content", "is_correct")
VALUES
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 3
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Serve para iniciar a missão do zero.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 3
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'É usado para repetir a primeira condição infinitamente.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 3
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Trata todos os casos que não foram validados pelas condições anteriores.',
        true
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 3
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Impede que o sistema tome qualquer decisão.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 3
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Serve apenas para comentar o código.',
        false
    );

INSERT INTO
    "alternative" (question_id, "content", "is_correct")
VALUES
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 4
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Reduz a necessidade de usar sensores físicos.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 4
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Permite classificar e reagir a várias situações de forma estruturada.',
        true
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 4
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Torna o código mais confuso e difícil de ler para os engenheiros.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 4
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Garante que a sonda viaje mais rápido que a luz.',
        false
    ),
    (
        (
            SELECT
                id
            FROM
                "question"
            WHERE
                "order" = 4
                AND mission_id = (
                    SELECT
                        id
                    FROM
                        "mission"
                    WHERE
                        "order" = 5
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 2
                        )
                )
        ),
        'Aumenta a precisão dos cálculos de ponto flutuante.',
        false
    );