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
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 6
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Qual é a principal vantagem da estrutura Switch-Case em relação a uma longa cadeia de "SE" e "SENÃO"?',
        'O Switch-Case é mais eficiente para estados fixos, pois o computador consegue saltar diretamente para o caso correspondente sem testar todos os anteriores.',
        1
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 6
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Em qual cenário o uso do Switch-Case é mais recomendado no software da sonda?',
        'Ele é ideal para situações onde uma única variável possui valores fixos e conhecidos, como os modos de operação da nave.',
        2
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 6
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Na analogia das luzes da cabine, o que acontece quando a variável "modo_missao" muda para "POUSO"?',
        'O Switch-Case direciona o hardware instantaneamente para as configurações específicas desse caso, sem processar os outros modos.',
        3
    ),
    (
        (
            SELECT
                id
            FROM
                "mission"
            WHERE
                "order" = 6
                AND planet_id = (
                    SELECT
                        id
                    FROM
                        "planet"
                    WHERE
                        "order" = 2
                )
        ),
        'Por que o Switch-Case é comparado a uma "mesa de comando" no texto?',
        'Porque ele funciona como botões individuais, onde cada valor da variável ativa diretamente uma sub-rotina diferente e organizada.',
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
                        "order" = 3
                )
        ),
        'Qual é a principal característica do laço "Enquanto" (While) em termos de execução?',
        'O laço Enquanto testa a condição antes de executar o código; se a condição for falsa desde o início, o código nunca é rodado.',
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
                        "order" = 3
                )
        ),
        'Por que o laço Enquanto é considerado ideal para "iterações indeterminadas"?',
        'Porque ele é usado quando não sabemos previamente quantas vezes uma ação será repetida, dependendo apenas de uma condição externa.',
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
                        "order" = 3
                )
        ),
        'Na analogia da sonda no cinturão de asteroides, o que faz o laço de repetição parar de executar manobras?',
        'O laço para assim que a condição ("haver destroços à frente") se torna falsa, ou seja, quando o caminho está livre.',
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
                        "order" = 3
                )
        ),
        'O que aconteceria se a sonda encontrasse o caminho livre logo no primeiro teste do laço "Enquanto"?',
        'Como o teste é feito no início, o bloco de manobras seria totalmente ignorado e a sonda seguiria viagem direto.',
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
                        "order" = 3
                )
        ),
        'Qual é a diferença fundamental entre o laço "Enquanto" (While) e o "Faça-Enquanto" (Do-While)?',
        'No Faça-Enquanto, o bloco de código é executado obrigatoriamente pelo menos uma vez, pois a condição só é testada ao final.',
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
                        "order" = 3
                )
        ),
        'Por que o laço Faça-Enquanto é chamado de "protocolo de execução garantida"?',
        'Porque ele garante que a ação ocorra primeiro antes de qualquer verificação, sendo ideal para inicializações obrigatórias.',
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
                        "order" = 3
                )
        ),
        'No exemplo da pressurização da cabine, o que acontece se a pressão já estiver ideal antes do sistema começar?',
        'A injeção de oxigênio ocorrerá pelo menos uma vez antes do sistema verificar a pressão e decidir parar.',
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
                        "order" = 3
                )
        ),
        'Em qual cenário de engenharia de software da sonda esta estrutura é mais essencial?',
        'Em rotinas de inicialização de hardware e testes iniciais onde um comando deve ser enviado antes de avaliar o retorno dos sensores.',
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
                        "order" = 3
                )
        ),
        'Qual é a principal diferença de uso entre o laço "Para" (For) e o laço "Enquanto" (While)?',
        'O laço Para é utilizado quando sabemos exatamente a quantidade de repetições (iterações determinadas), enquanto o Enquanto depende de uma condição incerta.',
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
                        "order" = 3
                )
        ),
        'Quais são os três elementos que o laço "Para" agrupa em uma única linha de comando?',
        'O laço Para agrupa a inicialização (valor inicial), a condição (limite final) e o incremento (o passo ou intervalo de cada repetição).',
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
                        "order" = 3
                )
        ),
        'Na analogia da varredura de radar (0 a 360 graus), o que representa o "incremento" do laço?',
        'O incremento representa o "passo" dado a cada repetição, como avançar o radar de 1 em 1 grau.',
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
                        "order" = 3
                )
        ),
        'Por que o laço "Para" é o mais utilizado para processar listas fixas de dados astronômicos?',
        'Por ser compacto e previsível, permitindo percorrer toda a lista do início ao fim com um número de passos já conhecido.',
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
                        "order" = 3
                )
        ),
        'Na programação da sonda, qual variável funciona como um "odômetro", somando sempre um valor fixo (como +1) para registrar o progresso?',
        'Os contadores são usados para registrar a quantidade de vezes que um evento ocorre, somando valores constantes a cada repetição.',
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
                        "order" = 3
                )
        ),
        'Para calcular o total de energia solar coletada ao final de um dia, somando diferentes cargas recebidas, qual tipo de variável devemos usar?',
        'Os acumuladores são ideais para somar valores que variam a cada iteração, consolidando um montante total final.',
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
                        "order" = 3
                )
        ),
        'Qual é a diferença visual no código entre um contador comum e um acumulador?',
        'O contador geralmente soma 1 (ex: c = c + 1), enquanto o acumulador soma outra variável (ex: a = a + valor).',
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
                        "order" = 3
                )
        ),
        'Por que o uso correto de contadores é vital para evitar que a sonda entre em um "loop infinito"?',
        'Muitos laços de repetição dependem do contador para atingir o limite de segurança e encerrar a tarefa automaticamente.',
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
                        "order" = 3
                )
        ),
        'O que caracteriza tecnicamente um "Loop Infinito" no software da sonda?',
        'Um loop infinito ocorre quando a condição de parada de um laço de repetição nunca se torna falsa, fazendo o processador executar o mesmo bloco eternamente.',
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
                        "order" = 3
                )
        ),
        'Na analogia da nave que "avança enquanto a distância > 0", por que esquecer de reduzir a distância causa um travamento?',
        'Porque sem a redução (atualização da variável), a condição de "distância > 0" será sempre verdadeira, impedindo que o programa siga para a próxima instrução.',
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
                        "order" = 3
                )
        ),
        'Qual é a principal defesa de um programador para evitar que o software congele em um loop infinito?',
        'Garantir que, dentro do laço, exista uma instrução (como um incremento ou decremento) que aproxime a variável de controle da condição de saída.',
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
                        "order" = 3
                )
        ),
        'O que são as "condições de borda" mencionadas no texto e por que testá-las é importante?',
        'São os valores limites de uma condição (como o zero ou o valor máximo). Testá-las garante que o laço pare exatamente onde deveria, sem ultrapassar o limite lógico.',
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
                        "order" = 4
                )
        ),
        'O que é um vetor (array) na lógica de programação da sonda?',
        'Um vetor é uma estrutura de dados que permite armazenar múltiplos valores do mesmo tipo sob um único identificador, como uma lista organizada.',
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
                        "order" = 4
                )
        ),
        'Por que o uso de vetores é preferível à criação de múltiplas variáveis isoladas (ex: amostra1, amostra2, amostra3)?',
        'Vetores economizam memória e permitem que o sistema trate grandes conjuntos de dados como uma única unidade logística, facilitando o processamento.',
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
                        "order" = 4
                )
        ),
        'Qual característica é obrigatória para todos os dados armazenados em um mesmo vetor tradicional?',
        'Eles devem ser todos do mesmo tipo de dado (ex: todos números inteiros ou todos textos).',
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
                        "order" = 4
                )
        ),
        'Na analogia do corredor com armários numerados, como o programa acessa uma informação específica dentro do vetor?',
        'Através do índice, que é a posição numérica (endereço) do dado dentro da estrutura.',
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
                        "order" = 4
                )
        ),
        'Em um vetor de telemetria da sonda, qual é o índice da primeira posição de armazenamento?',
        'Na maioria das linguagens de programação, a indexação de vetores começa sempre no zero.',
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
                        "order" = 4
                )
        ),
        'Se a sonda coletou 5 amostras de solo, qual será o índice da última amostra guardada no vetor?',
        'Como a contagem começa em 0, a última posição de um vetor de tamanho N será sempre N-1. Para 5 amostras, o último índice é 4.',
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
                        "order" = 4
                )
        ),
        'O que acontece se o processador tentar acessar um índice que não existe no vetor (ex: índice 10 em um vetor de tamanho 5)?',
        'Isso gera um erro de "índice fora dos limites" (out of bounds), pois o sistema tenta acessar uma "gaveta" de memória que não foi reservada.',
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
                        "order" = 4
                )
        ),
        'Qual é a principal função do índice dentro da estrutura de um vetor?',
        'O índice serve como a coordenada exata ou endereço de memória que permite localizar e acessar um dado específico rapidamente.',
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
                        "order" = 4
                )
        ),
        'O que define o "acesso aleatório" em um vetor de dados da sonda?',
        'O acesso aleatório permite que o sistema acesse qualquer posição do vetor diretamente pelo seu índice, sem precisar percorrer os itens anteriores.',
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
                        "order" = 4
                )
        ),
        'Na operação "amostrasSolo[5] = ''descartada''", o que está acontecendo com o dado que estava anteriormente na posição 5?',
        'A operação de atribuição em um índice específico sobrescreve o valor anterior, substituindo-o pelo novo dado.',
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
                        "order" = 4
                )
        ),
        'Por que o acesso direto via índice é vital para situações de emergência no espaço?',
        'Porque ele permite consultar ou alterar informações críticas em milissegundos, garantindo uma resposta rápida do sistema de bordo.',
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
                        "order" = 4
                )
        ),
        'Se quisermos APENAS ler o valor da temperatura no índice 2 sem alterá-lo, como seria a lógica?',
        'Apenas referenciamos a variável e o índice (ex: x = sensores[2]), o que copia o valor para uso sem modificar o conteúdo original.',
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
                        "order" = 4
                )
        ),
        'Como o laço "Para" (For) interage com um vetor durante uma iteração?',
        'O contador do laço Para é utilizado como o índice do vetor, permitindo acessar cada posição de forma sequencial e automática.',
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
                        "order" = 4
                )
        ),
        'Qual a principal vantagem de usar iteração para processar dados de telemetria?',
        'A iteração permite processar coleções massivas de dados com poucas linhas de código, evitando a repetição manual de comandos.',
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
                        "order" = 4
                )
        ),
        'Se um vetor de fotos tem tamanho 50, qual deve ser o valor inicial e final do contador para percorrer todo o vetor?',
        'O contador deve iniciar em 0 (primeiro índice) e terminar em 49 (último índice, que é tamanho - 1).',
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
                        "order" = 4
                )
        ),
        'O que acontece dentro do bloco de código de um laço de iteração em vetores?',
        'Uma função ou comando é executado repetidamente, mas a cada volta ele atua sobre um elemento diferente do vetor, definido pelo índice atual.',
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
                        "order" = 4
                )
        ),
        'Qual operação é utilizada para descobrir se um valor específico (como o ID de um asteroide) existe dentro de um vetor?',
        'A operação de busca percorre o vetor comparando cada elemento com o valor procurado até encontrá-lo ou chegar ao fim da lista.',
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
                        "order" = 4
                )
        ),
        'Para calcular a média de radiação de uma missão, quais passos lógicos o computador deve seguir?',
        'O computador deve primeiro somar todos os elementos do vetor (acumulação) e depois dividir o total pelo número de elementos (tamanho do vetor).',
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
                        "order" = 4
                )
        ),
        'Como o sistema identifica a maior temperatura registrada em um vetor durante uma iteração?',
        'O sistema usa uma variável auxiliar para guardar o "maior valor visto até agora", comparando-a com cada novo elemento do vetor durante o percurso.',
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
                        "order" = 4
                )
        ),
        'Por que as operações de Maior e Menor valor são importantes para o design de futuras sondas?',
        'Elas definem os limites de resistência térmica e mecânica (extremos) que os materiais devem suportar em novos pousos planetários.',
        4
    );

