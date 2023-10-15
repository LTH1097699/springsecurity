CREATE TABLE IF NOT EXISTS clients
(
    id              SERIAL          NOT NULL PRIMARY KEY,
    client_id       VARCHAR(200)    NOT NULL,
    secret          VARCHAR(200)    NOT NULL,
    scope           VARCHAR[]       NOT NULL,
    auth_method     VARCHAR(100)    NOT NULL,
    grant_type      VARCHAR[]       NOT NULL,
    redirect_uri    VARCHAR[]       NOT NULL
);

INSERT INTO clients (id, client_id, secret, scope, auth_method, grant_type, redirect_uri)
SELECT 1, 'client', '$2a$10$fGXu2cUGs0Raz74YYmX7sumwGZcwJby5QkdpcHi9Q7hnlAOdkzsG.', ARRAY['openid'], 'client_secret_basic', ARRAY['authorization_code'], ARRAY['https://springone.io/authorize']
WHERE NOT EXISTS (SELECT * FROM clients WHERE id = 1);