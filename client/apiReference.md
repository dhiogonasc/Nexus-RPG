## 🚀 Configuração Base

* **URL Base:** `http://localhost:8080` (Definida pela variável `{{baseUrl}}`)
* **Autenticação:** Quase todos os endpoints exigem um token JWT no Header (`Authorization: Bearer {{token}}`).
* **Formato de Dados:** `application/json`

---

## 01. Autenticação
Endpoints públicos para criação de conta e obtenção de acesso.

### Cadastrar Novo Usuário
* **Método:** `POST`
* **URL:** `/auth/register`
* **Request Body:**
```json
{
    "username": "username",
    "email": "email@email.com",
    "password": "123456"
}
```

### Login
* **Método:** `POST`
* **URL:** `/auth/login`
* **Request Body:**
```json
{
    "email": "email@eamil.com",
    "password": "123456"
}
```
* **Nota:** O script de teste do Postman salvará automaticamente o `token` retornado para uso nas próximas requisições.

---

## 02. Planetas
Gerenciamento de locais exploráveis.

### Listar Planetas
* **Método:** `GET`
* **URL:** `/planets`
* **Response Body:**
```json
[
    {
        "planet": {
            "id": 1,
            "name": "nome do planeta (VARIABILIS, BIFURCA_9, CICLUS, MATRIX_0)",
            "order": 1
        },
        "status": "status do planeta (LOCKED, UNLOCKED, COMPLETED)",
        "isAccessible": true,
        "progress": 0.00
    },
]
```

### Detalhes do Planeta
* **Método:** `GET`
* **URL:** `/planets/{{planetId}}`
* **Response Body:**
```json
{
    "planet": {
        "id": 1,
        "name": "nome do planeta (VARIABILIS, BIFURCA_9, CICLUS, MATRIX_0)",
        "description": "descrição do planeta (opcional)",
        "order": 1,
        "xpBonus": 100,
        "missions": [
            {
                "mission": {
                    "id": 1,
                    "name": "Planet : Mission",
                    "order": 1,
                    "difficulty": "dificuldade da missao (EASY, MEDIUM, HARD)"
                },
                "status": "status da missão (LOCKED, UNLOCKED, COMPLETED)",
                "isAccessible": true,
                "bestResult": 0.00,
                "progress": 0.00
            },
        ],
        "resource": {
            "resource": {
                "id": 1,
                "name": "Planet : Resource"
            },
            "isCollected": false
        }
    },
    "status": "status do planeta (LOCKED, UNLOCKED, COMPLETED)",
    "isAccessible": true,
    "progress": 0.00
}
```

---

## 📜 03. Missões
Sistema de objetivos e progresso.

### Listar Missões (Paginado)
* **Método:** `GET`
* **URL:** `/missions?planetId={{planetId}}&page=0&size=10`
* **Parâmetros:**
    * `planetId`: ID do planeta onde as missões ocorrem.
    * `page`: Número da página (inicia em 0).
    * `size`: Quantidade de itens por página.
* **Response Body:**
```json
{
    "content": [
        {
            "mission": {
                "id": 1,
                "name": "Planet : Mission",
                "order": 1,
                "difficulty": "dificuldade da missao (EASY, MEDIUM, HARD)"
            },
            "status": "status da missão (LOCKED, UNLOCKED, COMPLETED)",
            "isAccessible": true,
            "bestResult": 0.00,
            "progress": 0.00
        },
    ],
    "page": {
        "size": 10,
        "number": 0,
        "totalElements": 1,
        "totalPages": 1
    }
}
```

### Detalhes da Missão
* **Método:** `GET`
* **URL:** `/missions/{{missionId}}`
* **Response Body:**
```json
{
    "mission": {
        "id": 1,
        "name": "Planet : Mission ",
        "description": null,
        "order": 1,
        "difficulty": "dificuldade da missao (EASY, MEDIUM, HARD)",
        "xpBonus": 100,
        "planet": {
            "id": 1,
            "name": "nome do planeta (VARIABILIS, BIFURCA_9, CICLUS, MATRIX_0)",
            "order": 1
        }
    },
    "status": "status da missão (LOCKED, UNLOCKED, COMPLETED)",
    "isAccessible": true,
    "bestResult": 0.00,
    "progress": 0.00
}
```

---

## 📦 04. Recursos
Acesso a itens e recursos do jogo.

### Listar Recursos
* **Método:** `GET`
* **URL:** `/resources`
* **Response Body:**
```json
[
    {
        "resource": {
            "id": 1,
            "name": "Planet - 1 : Resource"
        },
        "isCollected": false
    },
    {
        "resource": {
            "id": 2,
            "name": "Planet - 2 : Resource"
        },
        "isCollected": false
    },
    {
        "resource": {
            "id": 3,
            "name": "Planet - 3 : Resource"
        },
        "isCollected": false
    },
    {
        "resource": {
            "id": 4,
            "name": "Planet - 4 : Resource"
        },
        "isCollected": false
    }
]
```

### Detalhes do Recurso
* **Método:** `GET`
* **URL:** `/resources/{{resourceId}}`
* **Response Body:**
```json
{
    "resource": {
        "id": 1,
        "name": "Planet : Resource",
        "description": "descrição do recurso",
        "xpBonus": 100,
        "planet": {
            "id": 1,
            "name": "nome do planeta (VARIABILIS, BIFURCA_9, CICLUS, MATRIX_0)",
            "order": 1
        }
    },
    "isCollected": false,
    "collectedAt": null
}
```

---

## 👤 05. Usuário
Gerenciamento do perfil do jogador autenticado.

### Meu Perfil
* **Método:** `GET`
* **URL:** `/me`
* **Response Body (Esperado):**
```json
{
    "id": 1,
    "username": "username",
    "email": "email@email.com",
    "level": {
        "id": 1,
        "name": "nome do level ('ALUMINIUM_I', 'ALUMINIUM_II', 'ALUMINIUM_III', 'IRON_I', 'IRON_II', 'IRON_III', 'NICKEL_I', 'NICKEL_II', 'NICKEL_III', 'PALLADIUM_I', 'PALLADIUM_II', 'PALLADIUM_III'",
        "description": "descrição do level",
        "order": 1,
        "xpRequired": 0
    },
    "currentPlanet": {
        "planet": {
            "id": 1,
            "name": "nome do planeta (VARIABILIS, BIFURCA_9, CICLUS, MATRIX_0)",
            "order": 1
        },
        "status": "status do planeta (LOCKED, UNLOCKED, COMPLETED)",
        "isAccessible": true,
        "progress": 0.00
    },
    "currentMission": {
        "mission": {
            "id": 1,
            "name": "Planet : Mission ",
            "order": 1,
            "difficulty": "dificuldade da missao (EASY, MEDIUM, HARD)"
        },
        "status": "status da missão (LOCKED, UNLOCKED, COMPLETED)",
        "isAccessible": true,
        "bestResult": 0.00,
        "progress": 0.00
    },
    "collectedResources": {
        "resources": [],
        "progress": 0.00
    },
    "xp": 0,
    "oxygen": 10
}
```

---