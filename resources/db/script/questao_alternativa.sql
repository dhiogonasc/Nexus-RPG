TRUNCATE TABLE "question" RESTART IDENTITY CASCADE;

INSERT INTO "question" (mission_id, "description", "code_snippet", "order")
VALUES
    (1, 'Question 1 - Mission 1', NULL, 1),
    (1, 'Question 2 - Mission 1', NULL, 2),
	(1, 'Question 3 - Mission 1', NULL, 3),
	(2, 'Question 1 - Mission 2', NULL, 1),
	(2, 'Question 2 - Mission 2', NULL, 2),
	(2, 'Question 3 - Mission 2', NULL, 3),
	(3, 'Question 1 - Mission 3', NULL, 1),
	(3, 'Question 2 - Mission 3', NULL, 2),
	(3, 'Question 3 - Mission 3', NULL, 3);

INSERT INTO "alternative" (question_id, "content", "feedback_tip", "is_correct") VALUES
    (1, 'Content Alt 1 - Question 1', 'Feedback Alt 1 - Question 1', true),
    (1, 'Content Alt 2 - Question 1', 'Feedback Alt 2 - Question 1', false),
    (1, 'Content Alt 3 - Question 1', 'Feedback Alt 3 - Question 1', false),
    (1, 'Content Alt 4 - Question 1', 'Feedback Alt 4 - Question 1', false),
    (1, 'Content Alt 5 - Question 1', 'Feedback Alt 5 - Question 1', false),

    (2, 'Content Alt 1 - Question 2', 'Feedback Alt 1 - Question 2', true),
    (2, 'Content Alt 2 - Question 2', 'Feedback Alt 2 - Question 2', false),
    (2, 'Content Alt 3 - Question 2', 'Feedback Alt 3 - Question 2', false),
    (2, 'Content Alt 4 - Question 2', 'Feedback Alt 4 - Question 2', false),
    (2, 'Content Alt 5 - Question 2', 'Feedback Alt 5 - Question 2', false),
    
    (3, 'Content Alt 1 - Question 3', 'Feedback Alt 1 - Question 3', true),
    (3, 'Content Alt 2 - Question 3', 'Feedback Alt 2 - Question 3', false),
    (3, 'Content Alt 3 - Question 3', 'Feedback Alt 3 - Question 3', false),
    (3, 'Content Alt 4 - Question 3', 'Feedback Alt 4 - Question 3', false),
    (3, 'Content Alt 5 - Question 3', 'Feedback Alt 5 - Question 3', false);
