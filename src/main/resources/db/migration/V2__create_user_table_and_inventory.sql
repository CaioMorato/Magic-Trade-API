CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(30),
    email VARCHAR(50),
    balance INT,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE inventory (
    id UUID PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    user_id UUID NOT NULL,
    created_at TIMESTAMPTZ DEFAULT now(),

    CONSTRAINT fk_inventory_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);