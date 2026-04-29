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