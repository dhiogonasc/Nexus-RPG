INSERT INTO
    "mission" (
        planet_id,
        "name",
        "description",
        "content",
        "order",
        "xp_bonus"
    )
SELECT
    p.id,
    m.name,
    m.description,
    m.content,
    m.mission_order,
    m.xp_bonus
FROM
    (
        VALUES
            (
                'Memória',
                'Conceito de memória e armazenamento',
                'Imagine que o computador de bordo da sua nave possui um imenso painel de armazenamento composto por bilhões de pequenos compartimentos eletrônicos. No vácuo do espaço, a memória (RAM) funciona como o convés de trabalho imediato da tripulação: quando você define um dado, o sistema reserva um endereço físico específico nesses compartimentos para garantir que a informação não se perca no ruído cósmico. É como designar um slot específico no rack de carga para um cilindro de oxigênio; o computador marca aquele espaço como "ocupado" e vincula um nome a ele, permitindo que o processador localize e recupere o valor em nanossegundos, garantindo que as operações de voo sejam fluidas e instantâneas.',
                1,
                10
            ),
            (
                'Identificadores',
                'Convenções de escrita',
                'Para que a comunicação entre os engenheiros na Terra e o software da sonda seja clara, utilizamos os identificadores, que são os nomes técnicos que damos às nossas variáveis e funções. Como em um mapa estelar, não podemos usar nomes aleatórios ou confusos; seguimos regras rígidas para evitar erros de leitura. O padrão camelCase (ex: altitudeNave) ou o snake_case (ex: pressao_interna) são as nossas linguagens de comando. Além disso, existem restrições de segurança: nunca começamos um identificador com números e evitamos caracteres especiais ou espaços, garantindo que o compilador não interprete um nome de sensor como um comando de autodestruição ou um erro de sintaxe.',
                2,
                20
            ),
            (
                'Constantes e variáveis',
                'Tipos de armazenamento de dados',
                'No controle de missão, diferenciamos os dados pela sua natureza de mudança. As variáveis são como a velocidade da sonda ou o nível de combustível: valores que flutuam constantemente conforme os motores queimam ou a gravidade de um planeta nos acelera. Já as constantes são os pilares imutáveis do universo e do hardware, como a velocidade da luz ($c \approx 300.000$ km/s) ou o ID único do chassi da nave. Definir algo como constante impede que, por um erro de cálculo, o software tente alterar o valor da gravidade terrestre no meio de uma simulação, servindo como uma trava de segurança crítica para a integridade da missão.',
                3,
                30
            ),
            (
                'Tipos Primitivos',
                'Natureza, propriedades, comportamento de dados',
                'A eficiência de uma sonda depende de como ela classifica a informação para não desperdiçar bits. Os inteiros são usados para contagens absolutas, como o número de satélites em órbita ou dias de missão (sem frações). Os reais ou ponto flutuante são fundamentais para a navegação de precisão, lidando com decimais em cálculos de trajetórias orbitais complexas. Para a comunicação textual, usamos caracteres e strings, que formam as mensagens de alerta no painel ou nomes de galáxias. Por fim, os booleanos são os interruptores binários do sistema: eles respondem apenas com "verdadeiro" ou "falso", indicando se a escotilha está selada ou se o motor principal está ativo.',
                4,
                50
            ),
            (
                'Operadores de Atribuição',
                'Processo de armazernamento de valores',
                'O operador de atribuição é o comando de "carregar" um valor em um compartimento da memória. Quando escrevemos oxigenio = 100, estamos emitindo uma ordem para que o identificador oxigenio receba a carga total. Em algumas linguagens de pseudocódigo espacial, usamos a seta <- para visualizar o fluxo da informação entrando na variável. Esse ato não é uma comparação de igualdade matemática, mas sim uma ação de armazenamento: você está pegando um dado bruto vindo dos sensores e injetando-o na estrutura de controle para que a inteligência da nave possa processá-lo e tomar a próxima decisão de rota.',
                5,
                80
            )
    ) AS m (
        name,
        description,
        content,
        mission_order,
        xp_bonus
    )
    CROSS JOIN (
        SELECT
            id
        FROM
            "planet"
        WHERE
            "order" = 1
        LIMIT
            1
    ) AS p;

INSERT INTO
    "mission" (
        planet_id,
        "name",
        "description",
        "content",
        "order",
        "xp_bonus"
    )
SELECT
    p.id,
    m.name,
    m.description,
    m.content,
    m.mission_order,
    m.xp_bonus
FROM
    (
        VALUES
            (
                'Operadores Relacionais',
                'Comparação de dados',
                'Os operadores relacionais funcionam como os sensores de comparação da sonda, verificando a relação entre dois dados de telemetria. Usamos o == para confirmar se a pressão atual é exatamente igual à pressão nominal, ou != para detectar se a temperatura está fora do padrão esperado. Os sinais de maior e menor (>, <, >=, <=) são vitais para a navegação: eles disparam alertas se a distância até um asteroide for menor que o limite de segurança ou se a velocidade de escape for atingida. Essas comparações resultam sempre em um valor lógico (verdadeiro ou falso), servindo de base para qualquer decisão automática do sistema de bordo.',
                1,
                10
            ),
            (
                'Operadores Lógicos',
                'Verificação de dados por condição',
                'Quando a situação no espaço se torna complexa, um único sensor não basta; precisamos combinar múltiplas leituras usando operadores lógicos. O operador E (AND) é o mais rigoroso: ele exige que todas as condições sejam verdadeiras (ex: "temos combustível E os motores estão resfriados") para autorizar a ignição. O OU (OR) é mais flexível, disparando um protocolo se ao menos uma condição ocorrer (ex: "alerta se houver radiação alta OU se a escotilha abrir"). Já o NÃO (NOT) é o inversor de sinais, usado para verificar estados negativos, como "enquanto NÃO houver sinal da Terra", permitindo que a lógica da IA lide com cenários multifatoriais de forma sofisticada.',
                2,
                20
            ),
            (
                'Condicional Simples',
                'Estrutura de controle para decisões simples',
                'A condicional simples é o nível básico de autonomia da nossa sonda. Ela funciona como um gatilho de "ação única": se uma condição específica for detectada no vácuo, o programa executa um bloco de código e depois segue viagem normalmente. Imagine um script de manutenção que diz: "SE o nível de poeira nos painéis solares for maior que 80%, ative os sopradores". Se a poeira estiver baixa, o computador simplesmente ignora esse comando e passa para a próxima linha. É o controle mais direto para eventos que não possuem uma alternativa imediata, apenas uma ação corretiva pontual.',
                3,
                30
            ),
            (
                'Condicional Composta',
                'Estrutura de controle para decisões compostas',
                'Em situações de "tudo ou nada", utilizamos a condicional composta. Ela oferece dois caminhos mutuamente exclusivos, como uma bifurcação em uma órbita planetária. Se a condição principal for verdadeira, a nave executa o primeiro bloco; caso contrário (SENÃO), ela obrigatoriamente executa o segundo. É o protocolo ideal para sistemas vitais: "SE a integridade do casco for de 100%, mantenha a aceleração total; SENÃO, reduza a velocidade e inicie reparos internos". Não há meio-termo aqui; o computador sempre escolherá uma das duas rotas de execução baseando-se na segurança da missão.',
                4,
                50
            ),
            (
                'Condicionais Encadeadas',
                'Estrutura de controle para decisões encadeadas',
                'Para missões de exploração em ambientes desconhecidos, as decisões raramente são apenas "sim" ou "não", exigindo as condicionais encadeadas. Elas funcionam como uma árvore de decisão com múltiplas camadas de verificação. O sistema testa a primeira condição; se falhar, pula para o SENÃO SE e testa a próxima, e assim por diante. Por exemplo, ao analisar um mineral em Marte: "SE o mineral for ouro, catalogue como raro; SENÃO SE for ferro, catalogue como recurso de construção; SENÃO SE for gelo, catalogue como fonte de água; SENÃO, catalogue como rocha comum". Isso permite que a IA classifique e reaja a uma vasta gama de descobertas de forma organizada.',
                5,
                80
            ),
            (
                'Estrutura de Escolha Switch-Case',
                'Estrutura de controle para cenários determinados',
                'A estrutura de escolha é o nosso seletor de comandos de alta velocidade, ideal para quando uma única variável pode ter vários estados fixos e conhecidos. Em vez de testar múltiplas condições complexas, o computador "pula" diretamente para o caso correspondente. Pense no controle de luzes da cabine: a variável modo_missão pode ser "LANÇAMENTO", "ORBITA" ou "POUSO". O Switch/Case direciona instantaneamente o hardware para configurar as cores e alertas específicos de cada fase, funcionando como uma mesa de comando onde cada botão ativa uma sub-rotina diferente sem a necessidade de processar longas cadeias de "SE" e "SENÃO".',
                6,
                130
            )
    ) AS m (
        name,
        description,
        content,
        mission_order,
        xp_bonus
    )
    CROSS JOIN (
        SELECT
            id
        FROM
            "planet"
        WHERE
            "order" = 2
        LIMIT
            1
    ) AS p;

INSERT INTO
    "mission" (
        planet_id,
        "name",
        "description",
        "content",
        "order",
        "xp_bonus"
    )
SELECT
    p.id,
    m.name,
    m.description,
    m.content,
    m.mission_order,
    m.xp_bonus
FROM
    (
        VALUES
            (
                'Laço "Enquanto" (While)',
                'Estrutura de repetição para iterações indeterminadas',
                'O laço Enquanto funciona como um protocolo de segurança preventiva que monitora uma condição antes de realizar qualquer ação. Imagine a sonda tentando atravessar um cinturão de asteroides: "Enquanto houver destroços à frente, execute manobras de desvio". O computador de bordo testa a condição no início; se o caminho já estiver livre de imediato, o bloco de código nem sequer é iniciado. É a estrutura ideal para situações de incerteza, onde não sabemos quantas vezes a tarefa será necessária, mas sabemos exatamente quando ela deve parar para poupar os recursos da nave.',
                1,
                10
            ),
            (
                'Laço "Faça-Enquanto" (Do-While)',
                'Estrutura de repetição para iterações indeterminadas',
                'Diferente do anterior, o Faça-Enquanto é um protocolo de execução garantida. Ele ordena que a nave realize a operação primeiro e só depois verifique se precisa repeti-la. No contexto espacial, imagine o sistema de pressurização da cabine: o computador "faz" a injeção de oxigênio e só "então verifica" se a pressão atingiu o nível ideal. Se não atingiu, ele repete. Isso garante que a ação vital ocorra pelo menos uma vez, sendo essencial para rotinas de inicialização de hardware onde um teste inicial é obrigatório antes de avaliar a continuidade.',
                2,
                20
            ),
            (
                'Laço "Para" (For)',
                'Estrutura de repetição para iterações determinadas',
                'O laço Para é a ferramenta de precisão matemática para missões com plano de voo definido. Ele é utilizado quando sabemos exatamente a quantidade de repetições necessárias, como disparar 4 sondas de pesquisa em sequência. Ele agrupa em uma única linha a inicialização (de onde começamos), a condição (até onde vamos) e o incremento (o passo dado). É como programar uma varredura de radar em um quadrante: "Parta do grau 0, vá até o 360, avançando de 1 em 1". Por ser compacto e previsível, é o laço mais utilizado para processar listas fixas de dados astronômicos.',
                3,
                30
            ),
            (
                'Contadores e Acumuladores',
                'Variáveis auxiliares de iteração',
                'Para gerenciar essas repetições, usamos dois tipos de variáveis auxiliares que funcionam como os registros de bordo. Os contadores são como o odômetro da nave: eles somam "um por um" (ex: voltas = voltas + 1) para registrar quantas órbitas completamos. Já os acumuladores são como o medidor de carga total das baterias solares: eles somam valores variáveis (ex: energia_total = energia_total + carga_recebida) para consolidar um montante final. Sem eles, o computador perderia o rastro do progresso da missão e não saberia quando interromper um ciclo de trabalho.',
                4,
                50
            ),
            (
                'Loops Infinitos',
                'Iterações ininitas',
                'Um loop infinito é o equivalente a uma pane nos sistemas de navegação, onde o código entra em um ciclo eterno e trava o processador. Isso ocorre quando a condição de parada nunca é atingida — como ordenar que a nave "avance enquanto a distância for maior que zero", mas esquecer de reduzir a distância a cada passo. Para evitar esse desastre, o programador espacial deve garantir que, dentro do bloco de repetição, exista sempre uma instrução que aproxime a variável de controle do valor de saída. Monitorar o incremento correto e testar as condições de borda são as principais defesas contra o congelamento do software em pleno espaço profundo.',
                5,
                80
            )
    ) AS m (
        name,
        description,
        content,
        mission_order,
        xp_bonus
    )
    CROSS JOIN (
        SELECT
            id
        FROM
            "planet"
        WHERE
            "order" = 3
        LIMIT
            1
    ) AS p;

INSERT INTO
    "mission" (
        planet_id,
        "name",
        "description",
        "content",
        "order",
        "xp_bonus"
    )
SELECT
    p.id,
    m.name,
    m.description,
    m.content,
    m.mission_order,
    m.xp_bonus
FROM
    (
        VALUES
            (
                'Arrays',
                'Definição de vetores unidimensionais.',
                'Imagine o compartimento de carga da nave como um longo corredor com armários numerados de forma idêntica. Um vetor é exatamente isso: uma estrutura que permite armazenar múltiplos dados do mesmo tipo sob um único nome de missão (ex: amostrasSolo). Em vez de criar variáveis como amostra1, amostra2 e assim por diante, definimos um vetor com um tamanho fixo. Isso economiza memória e organiza a telemetria, permitindo que o computador de bordo trate todo o conjunto como uma única unidade logística, facilitando o transporte de grandes volumes de informação entre os módulos do sistema.',
                1,
                10
            ),
            (
                'Índices',
                'Referência de posição de items de um vetor',
                'Para localizar uma amostra específica dentro desse corredor, utilizamos os índices. Na programação espacial (e na maioria das linguagens), a contagem sempre começa no zero. Assim, a primeira amostra coletada estará na posição [0], a segunda na [1], e assim por diante. O índice é a coordenada exata dentro do vetor; sem ele, o processador ficaria perdido tentando adivinhar em qual gaveta do rack de memória o dado foi guardado. É a precisão de endereçamento que garante que a nave não confunda a pressão da cabine com a temperatura do motor.',
                2,
                20
            ),
            (
                'Acesso a Elementos',
                'Uso de índice para acesso a valores',
                'O acesso a elementos é a operação de "abrir a gaveta" para ler ou alterar o que está lá dentro. Se o sensor detectar que a amostra na posição 5 foi contaminada, o código pode executar um comando direto como amostrasSolo[5] = "descartada". Essa capacidade de acessar qualquer ponto do vetor instantaneamente — sem precisar passar por todos os anteriores — é o que chamamos de acesso aleatório. É vital para situações de emergência onde o sistema de bordo precisa consultar um dado histórico específico em milissegundos.',
                3,
                30
            ),
            (
                'Iteração em Vetores',
                'Uso de índice para iteração em vetores',
                'A iteração é o processo de enviar um robô de manutenção para percorrer todo o corredor de armários, um por um. Geralmente utilizamos um laço Para (For) para realizar essa tarefa de forma automática. O contador do laço serve como o índice que aponta para cada posição do vetor. Por exemplo, para transmitir todas as fotos tiradas em Marte para a Terra, o programa inicia no índice 0 e avança até o último armário, executando a função de transmissão em cada etapa. É a maneira mais eficiente de processar coleções massivas de dados sem repetir linhas de código manualmente.',
                4,
                50
            ),
            (
                'Operações Comuns',
                'Uso comum da iteração em vetores',
                'No dia a dia da exploração espacial, realizamos diversas operações comuns sobre esses vetores para extrair inteligência dos dados brutos. Podemos realizar uma busca para encontrar em qual posição do vetor está o registro de um asteroide perigoso; podemos calcular a soma ou média de todos os valores de radiação coletados durante o percurso para avaliar a saúde da tripulação; ou ainda percorrer a lista para identificar o maior ou menor valor de temperatura registrado, ajudando a definir os limites de resistência térmica para o próximo pouso planetário.',
                5,
                80
            )
    ) AS m (
        name,
        description,
        content,
        mission_order,
        xp_bonus
    )
    CROSS JOIN (
        SELECT
            id
        FROM
            "planet"
        WHERE
            "order" = 4
        LIMIT
            1
    ) AS p;