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
        'Análise de constantes, variáveis e tipagem de dados.',
        'Em uma missão espacial, os dados são os ativos mais preciosos da nave. As variáveis funcionam como os sensores do rover, capturando valores que mudam constantemente, como a altitude atual ou a temperatura externa. Já as constantes são os parâmetros imutáveis da física e da engenharia, como a velocidade da luz ou a massa do veículo. Para que o computador de bordo não falhe, usamos os tipos primitivos: números inteiros para contar o total de órbitas concluídas, reais (ponto flutuante) para calcular as coordenadas precisas de pouso, booleanos para indicar se os painéis solares estão abertos ou fechados, e strings para as mensagens de telemetria enviadas à Terra.',
        1,
        100
    ),
    (
        'BIFURCA_9',
        'Implementação de estruturas condicionais e tomadas de decisão.',
        'O software de uma sonda precisa ser autônomo, tomando decisões críticas em milésimos de segundo sem esperar pelo sinal da Terra. O fluxo condicional é o sistema de tomada de decisão da IA: o simples executa uma manobra de emergência apenas se houver um obstáculo detectado; o composto decide se a nave deve entrar em modo de hibernação ou continuar o mapeamento dependendo do nível de bateria. Quando o cenário envolve múltiplas variáveis ambientais, como pressão e radiação, utilizamos o fluxo encadeado ou estruturas de seleção para definir o protocolo exato de sobrevivência, garantindo que o software escolha o caminho seguro entre as diversas rotas possíveis no espaço profundo.',
        2,
        200
    ),
    (
        'CICLUS',
        'Execução de estruturas de controle de fluxo e loops.',
        'No espaço, muitas tarefas são cíclicas e exaustivas, e as estruturas de repetição são as responsáveis por automatizá-las. Elas permitem que o radar da nave emita pulsos constantes para mapear o solo lunar até que a área desejada seja coberta. O laço "enquanto" pode ser usado para manter o motor de propulsão ativo enquanto o combustível estiver acima de 5%; o "faça-enquanto" garante que o sistema de comunicação tente enviar um sinal ao menos uma vez antes de desistir; e o laço "para" é perfeito para varrer uma sequência exata de coordenadas estelares. Sem esses loops, o código seria quilométrico e ineficiente para processar as rotinas repetitivas de uma missão de longa duração.',
        3,
        300
    ),
    (
        'MATRX_0',
        'Manipulação de arrays e estruturas de dados indexadas.',
        'Gerenciar uma frota de satélites ou uma matriz de sensores térmicos exige organização em massa, o que fazemos através de vetores. Imagine um vetor como o registro de telemetria de uma semana, onde cada posição armazena a pressão atmosférica de um dia específico. Em vez de criar centenas de variáveis individuais, usamos um único array indexado para organizar todos os dados da missão. A iteração é a ferramenta que percorre essa lista de dados, permitindo que o computador de bordo analise rapidamente todo o vetor para encontrar, por exemplo, o pico de radiação durante uma tempestade solar ou calcular a média de oxigênio disponível nos tanques ao longo da viagem.',
        4,
        500
    );