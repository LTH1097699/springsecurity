CREATE TABLE IF NOT EXISTS users
(
    id          SERIAL          NOT NULL PRIMARY KEY,
    user_name   VARCHAR(200)    NOT NULL,
    password    VARCHAR(200)    NOT NULL
);

CREATE TABLE IF NOT EXISTS user_privilege
(
    id          SERIAL          NOT NULL PRIMARY KEY,
    name        VARCHAR(100)    NOT NULL,
    user_id     INTEGER         NOT NULL
);

INSERT INTO users (id, user_name, password)
SELECT 1, 'lth', '$2a$10$JIk2Z8NHtX3YevsWmd7voOeueoXSBGV9WE6MWgu9CeIRWBg7mtpzS'
WHERE NOT EXISTS (SELECT * from users WHERE id = 1);

INSERT INTO user_privilege (id, name, user_id)
SELECT 1, 'ADMIN', 1
WHERE NOT EXISTS (SELECT * FROM user_privilege WHERE id = 1 );

INSERT INTO users (id, user_name, password)
SELECT 2, 'lth22', '$2a$10$JIk2Z8NHtX3YevsWmd7voOeueoXSBGV9WE6MWgu9CeIRWBg7mtpzS'
WHERE NOT EXISTS (SELECT * from users WHERE id = 2);

INSERT INTO user_privilege (id, name, user_id)
SELECT 2, 'USER', 2
WHERE NOT EXISTS (SELECT * FROM user_privilege WHERE id = 2 );