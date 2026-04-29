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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Ao porão de carga desativado e empoeirado.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Ao convés de trabalho imediato da tripulação.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Ao casco externo que protege contra radiação.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Ao combustível reserva guardado para emergências.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Às janelas de observação da nave.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Apaga todos os dados antigos para economizar energia.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Cria um novo compartimento físico do zero.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Desliga o painel de armazenamento para evitar ruído.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Marca o espaço como "ocupado" e garante que a informação não se perca.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Envia o dado para fora da nave através do vácuo.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'A capacidade de armazenar dados permanentemente sem energia.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'A cor brilhante dos compartimentos eletrônicos.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'A recuperação de valores em nanossegundos.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'O tamanho físico gigantesco de seus componentes.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'A necessidade de intervenção humana manual.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Para que a tripulação possa decorar o painel.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Para permitir que o processador localize e recupere o valor desejado.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Para esconder a informação de invasores alienígenas.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Para aumentar o peso físico da nave espacial.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 1
                )
        ),
        'Apenas por razões estéticas de design do software.',
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
                "order" = 1
                AND mission_id = (
                    SELECT
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'São os códigos secretos de autodestruição da nave.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'São nomes aleatórios gerados pelo computador de bordo.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'São os nomes técnicos dados às variáveis e funções.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'São os parafusos físicos que prendem o painel da nave.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'São sinais de rádio vindos de outras galáxias.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Para economizar memória RAM e combustível.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Para evitar erros de interpretação pelo compilador e falhas de sintaxe.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Porque números são considerados má sorte no espaço.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Apenas para deixar o código visualmente mais bonito.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Para que os números fiquem guardados apenas no processador.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'oxigenioReserva',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'oxigenio-reserva',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'oxigenio_reserva',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'OXIGENIORESERVA',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        '1oxigenioReserva',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Para confundir espiões de naves inimigas.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Garantir clareza na comunicação e evitar erros de leitura.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Acelerar a velocidade física da sonda no vácuo.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Permitir o uso de qualquer caractere especial do teclado.',
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
                        m.id
                    FROM
                        "mission" m
                        JOIN "planet" p ON m.planet_id = p.id
                    WHERE
                        p."order" = 1
                        AND m."order" = 2
                )
        ),
        'Nenhuma das anteriores.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'Porque é um valor que flutua conforme o consumo dos motores.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Porque o combustível nunca muda de quantidade.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Porque ele serve como o ID fixo da nave.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Porque ele é uma lei imutável do universo.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Nenhuma das alternativas.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Permitir que a tripulação mude as leis da física.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Armazenar valores que precisam mudar a cada nanossegundo.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Impedir que o valor seja alterado acidentalmente pelo software.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Apagar os dados da memória RAM automaticamente.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Aumentar a velocidade de processamento da sonda.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'A velocidade atual da sonda.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'O nível de oxigênio restante.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'A velocidade da luz.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'A temperatura externa do casco.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'A distância percorrida até o momento.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'O software geraria um erro de sintaxe imediato.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'O motor da nave seria desligado para economizar energia.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'A nave mudaria de nome automaticamente.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'O sistema impediria a alteração para manter a integridade da missão.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'A constante se transformaria em uma variável.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'Booleanos',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Inteiros',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Strings',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Ponto Flutuante',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Caracteres especiais',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Ponto Flutuante',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Inteiros absolutos',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Textos longos',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Booleanos de precisão',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Scripts de comando',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Inteiros',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Ponto flutuante',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Booleanos',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Strings',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Números binários',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Inteiros de contagem',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Pontos flutuantes orbitais',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Booleanos',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Identificadores snake_case',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 1
                        )
                )
        ),
        'Strings de alerta',
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
                                "order" = 1
                        )
                )
        ),
        'Comparando se o oxigênio já é igual a 100.',
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
                                "order" = 1
                        )
                )
        ),
        'Emitindo uma ordem para carregar o valor 100 no identificador oxigênio.',
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
                                "order" = 1
                        )
                )
        ),
        'Apagando o valor 100 da memória da sonda.',
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
                                "order" = 1
                        )
                )
        ),
        'Desativando os sensores de oxigênio por segurança.',
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
                                "order" = 1
                        )
                )
        ),
        'Transformando o número 100 em uma mensagem de texto.',
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
                                "order" = 1
                        )
                )
        ),
        'Porque ele representa uma ação de armazenamento, não uma verificação de igualdade.',
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
                                "order" = 1
                        )
                )
        ),
        'Porque no espaço os números valem menos que na Terra.',
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
                                "order" = 1
                        )
                )
        ),
        'Porque o símbolo "=" serve apenas para decorar o código.',
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
                                "order" = 1
                        )
                )
        ),
        'Porque o computador não entende conceitos matemáticos.',
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
                                "order" = 1
                        )
                )
        ),
        'Porque a igualdade só existe entre constantes, nunca entre variáveis.',
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
                                "order" = 1
                        )
                )
        ),
        'Que a informação está saindo da variável para o sensor.',
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
                                "order" = 1
                        )
                )
        ),
        'Que a variável está sendo deletada do sistema.',
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
                                "order" = 1
                        )
                )
        ),
        'O fluxo da informação entrando no compartimento da variável.',
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
                                "order" = 1
                        )
                )
        ),
        'A velocidade da luz necessária para mover o dado.',
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
                                "order" = 1
                        )
                )
        ),
        'O tempo que o processador leva para ler o dado.',
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
                                "order" = 1
                        )
                )
        ),
        'Garantir que os sensores fiquem sempre desligados.',
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
                                "order" = 1
                        )
                )
        ),
        'Permitir que a inteligência da nave tome decisões baseadas nos valores guardados.',
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
                                "order" = 1
                        )
                )
        ),
        'Mudar fisicamente a posição da nave no espaço.',
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
                                "order" = 1
                        )
                )
        ),
        'Aumentar o número de bits disponíveis na memória RAM.',
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
                                "order" = 1
                        )
                )
        ),
        'Nenhuma das anteriores.',
        false
    );

---==================================================
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
                        "order" = 1
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
        '=',
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
                        "order" = 1
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
        '==',
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
                        "order" = 1
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
        '!=',
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
                        "order" = 1
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
        '>',
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
                        "order" = 1
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
        '<=',
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
                        "order" = 1
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
        '==',
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
                        "order" = 1
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
        '>=',
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
                        "order" = 1
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
        '<',
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
                        "order" = 1
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
        '!=',
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
                        "order" = 1
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
        '<>',
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
                        "order" = 1
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
        '>',
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
                        "order" = 1
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
        '==',
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
                        "order" = 1
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
        '<',
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
                        "order" = 1
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
        '!=',
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
                        "order" = 1
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
        '>=',
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
                        "order" = 1
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
        'Um número inteiro positivo.',
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
                        "order" = 1
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
        'Uma string de texto com o nome do sensor.',
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
                        "order" = 1
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
        'Um valor lógico (verdadeiro ou falso).',
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
                        "order" = 1
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
        'Uma coordenada de navegação.',
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
                        "order" = 1
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
        'O valor total de combustível restante.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'A sonda pousa normalmente, ignorando o vento.',
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
                        "order" = 2
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
        'A sonda cancela o pouso, pois o operador E exige que ambas as condições sejam verdadeiras.',
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
                        "order" = 2
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
        'A sonda aguarda o combustível acabar para decidir.',
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
                        "order" = 2
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
        'O sistema reinicia os sensores de imagem.',
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
                        "order" = 2
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
        'A sonda pousa apenas se o vento for de outra galáxia.',
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
                        "order" = 2
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
        'Ativa o protocolo de emergência, pois o OU aceita que apenas uma condição seja real.',
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
                        "order" = 2
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
        'Não faz nada, pois o OU exige que as duas coisas aconteçam juntas.',
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
                        "order" = 2
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
        'Desliga todos os alarmes para não assustar a tripulação.',
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
                        "order" = 2
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
        'Espera o segundo problema acontecer para ter certeza.',
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
                        "order" = 2
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
        'O sistema trava por excesso de informação.',
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
                        "order" = 2
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
        'Operador E (AND).',
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
                        "order" = 2
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
        'Operador OU (OR).',
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
                        "order" = 2
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
        'Operador NÃO (NOT).',
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
                        "order" = 2
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
        'Operador de Atribuição (=).',
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
                        "order" = 2
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
        'Operador de Soma (+).',
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
                        "order" = 2
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
        'Para economizar o armazenamento de strings de texto.',
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
                        "order" = 2
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
        'Permitir decisões baseadas em múltiplos fatores simultâneos.',
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
                        "order" = 2
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
        'Aumentar a velocidade física dos processadores.',
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
                        "order" = 2
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
        'Substituir a necessidade de memória RAM.',
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
                        "order" = 2
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
        'Garantir que os números reais sejam sempre inteiros.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'Reinicia o computador de bordo automaticamente.',
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
                        "order" = 3
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
        'Executa um comando de autodestruição.',
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
                        "order" = 3
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
        'Ignora o comando e passa para a próxima linha de código.',
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
                        "order" = 3
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
        'Aguarda até que a condição se torne verdadeira.',
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
                        "order" = 3
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
        'Inverte a lógica dos sensores.',
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
                        "order" = 3
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
        'É o valor bruto lido pelos sensores.',
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
                        "order" = 3
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
        'É a ação corretiva que só ocorre se a condição for verdadeira.',
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
                        "order" = 3
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
        'É o nome dado à variável de armazenamento.',
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
                        "order" = 3
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
        'É a constante universal da velocidade da luz.',
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
                        "order" = 3
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
        'É o identificador camelCase da sonda.',
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
                        "order" = 3
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
        'Porque ela oferece múltiplos caminhos de decisão.',
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
                        "order" = 3
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
        'Porque ela só possui um bloco de código para uma condição específica.',
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
                        "order" = 3
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
        'Porque ela desliga a sonda após ser usada.',
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
                        "order" = 3
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
        'Porque ela não utiliza operadores lógicos.',
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
                        "order" = 3
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
        'Porque ela apaga a memória RAM.',
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
                        "order" = 3
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
        'Ativar os escudos se (IF) um impacto for detectado.',
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
                        "order" = 3
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
        'Somar a velocidade atual com a velocidade extra.',
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
                        "order" = 3
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
        'Enviar o nome da galáxia para a Terra.',
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
                        "order" = 3
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
        'Multiplicar o combustível por dois.',
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
                        "order" = 3
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
        'Contar quantos dias faltam para o fim da missão.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'Ela permite que o código pare de funcionar para economizar energia.',
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
                        "order" = 4
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
        'Ela oferece dois caminhos exclusivos: um para o sucesso da condição e outro para a falha.',
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
                        "order" = 4
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
        'Ela apaga a variável do SENÃO se o combustível acabar.',
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
                        "order" = 4
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
        'Ela apenas executa o código se a condição for verdadeira, ignorando o resto.',
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
                        "order" = 4
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
        'Ela serve para contar quantos planetas existem no sistema.',
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
                        "order" = 4
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
        'Inverter o valor de uma constante física.',
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
                        "order" = 4
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
        'Executar uma ação alternativa quando a condição inicial é falsa.',
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
                        "order" = 4
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
        'Somar dois números inteiros automaticamente.',
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
                        "order" = 4
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
        'Garantir que o nome da variável use o padrão camelCase.',
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
                        "order" = 4
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
        'Nenhuma das anteriores.',
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
                        "order" = 4
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
        'Mantém a aceleração total para chegar mais rápido.',
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
                        "order" = 4
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
        'Desliga todos os sensores de impacto.',
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
                        "order" = 4
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
        'Obrigatoriamente reduz a velocidade e inicia os reparos internos.',
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
                        "order" = 4
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
        'Pergunta para a tripulação o que deve ser feito.',
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
                        "order" = 4
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
        'Ignora o problema e continua a missão normalmente.',
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
                        "order" = 4
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
        'Para que a nave possa executar os dois caminhos ao mesmo tempo.',
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
                        "order" = 4
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
        'Porque ela permite o uso de caracteres especiais nos nomes.',
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
                        "order" = 4
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
        'Para garantir que o sistema sempre escolha uma das rotas baseada na segurança.',
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
                        "order" = 4
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
        'Para transformar variáveis em constantes durante o voo.',
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
                        "order" = 4
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
        'Apenas para economizar bits de armazenamento.',
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
                        "order" = 6
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
        'Ela permite que o computador invente novos estados sozinho.',
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
                        "order" = 6
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
        'A velocidade de execução, pois o sistema pula direto para o caso correto.',
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
                        "order" = 6
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
        'Ela consome mais bateria do que as outras estruturas.',
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
                        "order" = 6
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
        'Ela serve apenas para trocar as cores do painel.',
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
                        "order" = 6
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
        'Nenhuma das anteriores.',
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
                        "order" = 6
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
        'Quando precisamos calcular trajetórias orbitais complexas com decimais.',
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
                        "order" = 6
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
        'Quando uma variável pode assumir vários estados fixos e determinados.',
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
                        "order" = 6
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
        'Quando não sabemos quais valores a variável pode ter.',
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
                        "order" = 6
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
        'Apenas para comparar se um número é maior que outro.',
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
                        "order" = 6
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
        'Para transformar constantes em variáveis.',
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
                        "order" = 6
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
        'O sistema ativa as luzes de lançamento por engano.',
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
                        "order" = 6
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
        'O hardware configura as cores e alertas específicos do modo pouso instantaneamente.',
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
                        "order" = 6
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
        'A sonda desliga para economizar energia durante o pouso.',
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
                        "order" = 6
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
        'O computador precisa ler todo o código desde o início da missão.',
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
                        "order" = 6
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
        'A variável de estado é apagada da memória.',
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
                        "order" = 6
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
        'Porque ela é difícil de operar pelos engenheiros.',
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
                        "order" = 6
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
        'Porque ela centraliza decisões aleatórias.',
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
                        "order" = 6
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
        'Porque cada botão (caso) ativa uma ação diferente de forma direta.',
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
                        "order" = 6
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
        'Porque ela impede que a nave use sensores.',
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
                        "order" = 6
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
        'Nenhuma das anteriores.',
        false
    );

---==================================================
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Ele executa o código primeiro e testa a condição depois.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Ele testa a condição no início e só executa o código se ela for verdadeira.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Ele repete o código exatamente 10 vezes sempre.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Ele apaga a variável de controle após a primeira volta.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele permite realizar cálculos matemáticos complexos.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele só funciona se soubermos o número exato de asteroides.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque o número de repetições depende de uma condição que pode mudar a qualquer momento.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele desliga a nave se houver muitos erros.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele é mais rápido que o laço "Para".',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'A detecção de que não há mais destroços à frente.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O término do combustível de manobra.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Um comando vindo diretamente da Terra.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'A explosão de um asteroide próximo.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O relógio interno da nave marcar 10 segundos.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'A sonda executaria a manobra uma vez por segurança.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O sistema entraria em um loop infinito.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O bloco de código seria ignorado e a sonda seguiria adiante.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O computador formataria os dados dos sensores.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'O Faça-Enquanto nunca testa a condição.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O Faça-Enquanto garante que o código rode ao menos uma vez antes de testar a condição.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O Faça-Enquanto é usado apenas para números inteiros.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O Faça-Enquanto apaga a memória da sonda após rodar.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele sempre resulta em um valor verdadeiro.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque a ação é executada antes da verificação da condição.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele consome menos combustível que o laço Para.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele impede erros de sintaxe no código.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O sistema não fará nada.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O sistema injetará oxigênio uma vez e só então perceberá que deve parar.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O sistema entrará em loop infinito.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'A sonda desligará por segurança.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Cálculos de órbita entre galáxias.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Rotinas de inicialização onde uma ação obrigatória precede o teste.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Para apagar variáveis que não são mais usadas.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'O laço Para só funciona se a bateria estiver em 100%.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O laço Para é focado em um número definido de repetições, como um plano de voo.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O laço Para é usado apenas para apagar variáveis.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Não há diferença, são nomes diferentes para o mesmo comando.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Entrada de dados, Processamento e Saída de tela.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Inicialização, Condição e Incremento.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Nome da nave, Destino e Velocidade.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Soma, Subtração e Multiplicação.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O ponto inicial da varredura.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O valor do avanço a cada volta do laço.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O limite máximo onde o radar deve parar.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'A energia consumida pelo radar.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele permite que a sonda tome decisões aleatórias.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Pela sua previsibilidade e facilidade em percorrer sequências conhecidas.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque ele desativa os sensores para economizar bateria.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque é o único laço que aceita números reais.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'Acumulador.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Contador.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Variável Booleana.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Operador Relacional.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Constante Universal.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Contador.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Acumulador.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Estrutura Switch-Case.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Operador Lógico NÃO.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Variável do tipo String.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Não há diferença, ambos funcionam da mesma forma.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O contador soma um valor fixo; o acumulador soma valores variáveis.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O contador é usado apenas no laço PARA; o acumulador apenas no ENQUANTO.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Contadores são textos e acumuladores são números.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'O acumulador subtrai valores em vez de somar.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque a sonda ficaria sem bateria imediatamente.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque a nave perderia a conexão com a Terra.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque sem a atualização, a condição de parada do laço pode nunca ser atingida.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Porque o contador é o que gera o oxigênio da cabine.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 3
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                                "order" = 3
                        )
                )
        ),
        'É quando o código viaja para outra galáxia.',
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
                                "order" = 3
                        )
                )
        ),
        'É um ciclo eterno de repetição onde a condição de saída nunca é atingida.',
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
                                "order" = 3
                        )
                )
        ),
        'É um comando que apaga o sistema operacional.',
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
                                "order" = 3
                        )
                )
        ),
        'É quando o laço executa exatamente 100 vezes.',
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
                                "order" = 3
                        )
                )
        ),
        'Porque a nave fica sem combustível físico.',
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
                                "order" = 3
                        )
                )
        ),
        'Porque a condição de teste permanece verdadeira para sempre.',
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
                                "order" = 3
                        )
                )
        ),
        'Porque o processador decide ignorar o comando.',
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
                                "order" = 3
                        )
                )
        ),
        'Porque variáveis de distância não podem ser comparadas com zero.',
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
                                "order" = 3
                        )
                )
        ),
        'Remover todos os laços de repetição do código.',
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
                                "order" = 3
                        )
                )
        ),
        'Garantir que a variável de controle seja atualizada a cada volta do laço.',
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
                                "order" = 3
                        )
                )
        ),
        'Aumentar a velocidade do processador da sonda.',
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
                                "order" = 3
                        )
                )
        ),
        'Usar apenas condicionais simples (SE) sem repetição.',
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
                                "order" = 3
                        )
                )
        ),
        'São os limites físicos do casco da nave.',
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
                                "order" = 3
                        )
                )
        ),
        'São os valores críticos onde a condição do laço muda de verdadeira para falsa.',
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
                                "order" = 3
                        )
                )
        ),
        'São comentários inseridos no final do código.',
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
                                "order" = 3
                        )
                )
        ),
        'É o nome dado a um erro de digitação.',
        false
    );

---==================================================
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Um sensor que mede a velocidade da luz.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Uma estrutura que armazena vários dados do mesmo tipo em uma lista única.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Um tipo de combustível sólido usado em pousos.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Um comando que desliga a sonda para economizar energia.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Uma variável que só pode guardar o valor "verdadeiro".',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Porque vetores são mais coloridos no monitor.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Porque facilitam a organização e o transporte de dados em massa.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Porque vetores não ocupam espaço na memória RAM.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Porque eles impedem que a nave sofra colisões.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Devem ter nomes de variáveis diferentes.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Devem ser obrigatoriamente do mesmo tipo.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Devem ser todos do valor zero.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Devem ser criptografados antes de serem guardados.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Devem ser apagados a cada 10 segundos.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Usando uma bússola digital.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Através do índice (posição numérica) do dado.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Perguntando ao usuário o nome de cada armário.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Chutando valores aleatórios até encontrar o correto.',
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
                        "order" = 1
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        '1',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '0',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '-1',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '10',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Nenhum, vetores não usam números.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '5',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '4',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '6',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        '0',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Depende da temperatura do motor.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O sistema cria automaticamente um novo espaço.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O programa trava ou gera uma exceção de erro.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'A sonda ignora o comando e continua funcionando normalmente.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O valor guardado no índice 0 é apagado.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Mudar o tipo de dado de real para inteiro.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Aumentar a velocidade física da nave.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Servir como o endereço de posição para localizar dados.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Criptografar as mensagens enviadas para a Terra.',
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
                        "order" = 2
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Substituir o uso de variáveis booleanas.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'A capacidade de acessar qualquer ponto do vetor instantaneamente via índice.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'É quando o sistema escolhe um índice sorteado para apagar.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'É uma falha de segurança onde os dados ficam embaralhados.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'É um modo de economia de energia da memória RAM.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Obrigação de ler todos os dados anteriores antes de chegar ao alvo.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O dado anterior é apagado e substituído pelo novo valor.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O dado anterior é movido para a posição 6 automaticamente.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O novo dado é somado ao dado anterior de forma cumulativa.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O sistema impede a gravação se já houver um dado no local.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O vetor é reiniciado para liberar espaço.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Permite consultar informações críticas em milissegundos.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Evita que a sonda gaste combustível físico.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Faz com que o processador trabalhe em temperatura negativa.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Criptografa os dados para que ninguém mais os leia.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Copiamos o valor referenciando a variável e o índice.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'A leitura de um vetor exige que o valor seja movido de lugar.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Para ler um dado, é preciso primeiro apagar os vizinhos.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O computador de bordo só permite leitura se o índice for zero.',
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
                        "order" = 3
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O valor é excluído do vetor após a leitura.',
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
                "order" = 1
                AND mission_id = (
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
                )
        ),
        'O contador do laço serve como o índice que aponta para cada posição do vetor.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O laço apaga o vetor após a primeira leitura.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O laço transforma o vetor em uma variável booleana.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O laço Para impede que o vetor seja acessado por outros sensores.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Permite processar grandes volumes de dados de forma eficiente e automática.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Aumenta a resolução das fotos enviadas de Marte.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Reduz fisicamente o tamanho dos armários na nave.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Faz com que a sonda não precise de bateria para funcionar.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Garante que todos os valores do vetor sejam zero.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Início em 0 e fim em 49.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Início em 1 e fim em 50.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Início em 0 e fim em 50.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Início em -1 e fim em 49.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O contador deve ser infinito para vetores.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'Uma ação é repetida sobre diferentes elementos usando o índice atual.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O processador desliga após cada volta do laço.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O vetor é convertido em uma String gigante.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'A iteração impede que novos dados sejam coletados.',
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
                        "order" = 4
                        AND planet_id = (
                            SELECT
                                id
                            FROM
                                "planet"
                            WHERE
                                "order" = 4
                        )
                )
        ),
        'O laço executa apenas a primeira posição e ignora o resto.',
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
                                "order" = 4
                        )
                )
        ),
        'Operação de Busca.',
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
                                "order" = 4
                        )
                )
        ),
        'Operação de Exclusão Aleatória.',
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
                                "order" = 4
                        )
                )
        ),
        'Operação de Incremento de Combustível.',
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
                                "order" = 4
                        )
                )
        ),
        'Operação de Formatação de Disco.',
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
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                                "order" = 4
                        )
                )
        ),
        'Somar todos os valores e dividir pela quantidade total.',
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
                                "order" = 4
                        )
                )
        ),
        'Multiplicar o primeiro valor pelo último.',
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
                                "order" = 4
                        )
                )
        ),
        'Subtrair o menor valor do maior valor.',
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
                                "order" = 4
                        )
                )
        ),
        'Apagar o vetor e pedir novos dados à Terra.',
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
                                "order" = 4
                        )
                )
        ),
        'A média é sempre igual ao valor do índice central.',
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
                                "order" = 4
                        )
                )
        ),
        'Comparando cada elemento com uma variável que guarda o maior valor encontrado.',
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
                                "order" = 4
                        )
                )
        ),
        'Somando 1 a cada temperatura registrada.',
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
                                "order" = 4
                        )
                )
        ),
        'Multiplicando todos os valores do vetor por zero.',
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
                                "order" = 4
                        )
                )
        ),
        'O maior valor é sempre o que está no índice 0.',
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
                                "order" = 4
                        )
                )
        ),
        'Nenhuma das anteriores.',
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
                                "order" = 4
                        )
                )
        ),
        'Para economizar espaço nos armários de carga.',
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
                                "order" = 4
                        )
                )
        ),
        'Para definir os limites de resistência térmica de novos equipamentos.',
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
                                "order" = 4
                        )
                )
        ),
        'Para garantir que a sonda nunca use o laço Para.',
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
                                "order" = 4
                        )
                )
        ),
        'Porque o maior valor indica a distância até a Lua.',
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
                                "order" = 4
                        )
                )
        ),
        'Para converter números em mensagens de texto.',
        false
    );
