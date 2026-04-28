-- ====================
-- QUESTION
-- ====================
INSERT INTO
    "question" (mission_id, "content", "explanation", "order")
VALUES
    (1, 'Question 1 - Mission 1 - Planet 1', 'question explanation', 1),
    (1, 'Question 2 - Mission 1 - Planet 1', 'question explanation', 2),
    (2, 'Question 1 - Mission 2 - Planet 1', 'question explanation', 1),
    (2, 'Question 2 - Mission 2 - Planet 1', 'question explanation', 2),
    (3, 'Question 1 - Mission 1 - Planet 2', 'question explanation', 1),
    (3, 'Question 2 - Mission 1 - Planet 2', 'question explanation', 2),
    (4, 'Question 1 - Mission 2 - Planet 2', 'question explanation', 1),
    (4, 'Question 2 - Mission 2 - Planet 2', 'question explanation', 2);

-- ====================
-- ALTERNATIVE
-- ====================
INSERT INTO
    "alternative" (
    question_id,
    "content",
    "is_correct"
)
VALUES
    -- Questão 1 - Missão 1 - Planet 1
    (
        1,
        'Content Alt 1 - Question 1 - Mission 1 - Planet 1',
        true
    ),
    (
        1,
        'Content Alt 2 - Question 1 - Mission 1 - Planet 1',
        false
    ),
    -- Questão 2 - Missão 1 - Planet 1
    (
        2,
        'Content Alt 1 - Question 2 - Mission 1 - Planet 1',
        true
    ),
    (
        2,
        'Content Alt 2 - Question 2 - Mission 1 - Planet 1',
        false
    ),
    -- Questão 1 - Missão 2 - Planet 1
    (
        3,
        'Content Alt 1 - Question 1 - Mission 2 - Planet 1',
        true
    ),
    (
        3,
        'Content Alt 2 - Question 1 - Mission 2 - Planet 1',
        false
    ),
    -- Questão 2 - Missão 2 - Planet 1
    (
        4,
        'Content Alt 1 - Question 2 - Mission 2 - Planet 1',
        true
    ),
    (
        4,
        'Content Alt 2 - Question 2 - Mission 2 - Planet 1',
        false
    ),
    -- Questão 1 - Missão 1 - Planet 2
    (
        5,
        'Content Alt 1 - Question 1 - Mission 1 - Planet 2',
        true
    ),
    (
        5,
        'Content Alt 2 - Question 1 - Mission 1 - Planet 2',
        false
    ),
    -- Questão 2 - Missão 1 - Planet 2
    (
        6,
        'Content Alt 1 - Question 2 - Mission 1 - Planet 2',
        true
    ),
    (
        6,
        'Content Alt 2 - Question 2 - Mission 1 - Planet 2',
        false
    ),
    -- Questão 1 - Missão 2 - Planet 2
    (
        7,
        'Content Alt 1 - Question 1 - Mission 2 - Planet 2',
        true
    ),
    (
        7,
        'Content Alt 2 - Question 1 - Mission 2 - Planet 2',
        false
    ),
    -- Questão 2 - Missão 2 - Planet 2
    (
        8,
        'Content Alt 1 - Question 2 - Mission 2 - Planet 2',
        true
    ),
    (
        8,
        'Content Alt 2 - Question 2 - Mission 2 - Planet 2',
        false
    );