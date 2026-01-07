CREATE TABLE users (
    id UUID PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    balance INT DEFAULT 0,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE inventory (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    card_id UUID NOT NULL,
    quantity INT DEFAULT 0,
    created_at TIMESTAMPTZ DEFAULT now(),

    CONSTRAINT fk_inventory_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_inventory_card FOREIGN KEY (card_id) REFERENCES cards(id) ON DELETE CASCADE,
    CONSTRAINT uk_inventory_user_card UNIQUE(user_id, card_id)
);