
CREATE TABLE users (id SERIAL PRIMARY KEY, username VARCHAR(255), password VARCHAR(255), role VARCHAR(50));
CREATE TABLE card (id SERIAL PRIMARY KEY, card_number VARCHAR(255), status VARCHAR(50), balance NUMERIC, owner_id BIGINT);
