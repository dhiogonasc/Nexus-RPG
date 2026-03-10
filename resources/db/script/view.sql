-- Missao, Questões e Alternativas

CREATE OR REPLACE VIEW vw_mission_details AS
SELECT 
    m.id as mission_id,
    m.title as mission_title,
    b.name as boss_name, -- Adicionado para contexto
    q.id as question_id,
    q."statement" as question_text,
    q."order" as question_order,
    a.id as alternative_id,
    a."content" as alternative_text,
    a.is_correct
FROM mission m
JOIN boss b ON m.id = b.mission_id
JOIN question q ON m.id = q.mission_id
JOIN alternative a ON q.id = a.question_id
ORDER BY m.id, q."order", a.id;

-- SELECT * FROM vw_mission_details;


-- Progresso do usuário em missões

CREATE OR REPLACE VIEW vw_user_mission_progress AS
SELECT 
    u.name as user_name,
    m.title as mission_title,
    um.status as mission_status,
    um.best_result,
    COUNT(uma.id) as total_attempts,
    COALESCE(MAX(uma.is_boss_defeated::int)::boolean, false) as boss_defeated
FROM "user" u
JOIN user_mission um ON u.id = um.user_id
JOIN mission m ON um.mission_id = m.id
LEFT JOIN user_mission_attempt uma ON um.id = uma.user_mission_id
GROUP BY u.name, m.title, um.status, um.best_result;

-- SELECT * FROM vw_user_mission_progress;


-- Histórico de conquistas por usuário

CREATE VIEW vw_user_achievements_history AS
SELECT 
    u.name as user_name,
    ach.name as achievement_name,
    ach.bonus_xp,
    ua.earned_at,
    m.title as related_mission
FROM user_achievement ua
JOIN "user" u ON ua.user_id = u.id
JOIN achievement ach ON ua.achievement_id = ach.id
LEFT JOIN mission m ON ach.mission_id = m.id;

-- SELECT * FROM vw_user_achievements_history;
