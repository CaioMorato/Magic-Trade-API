CREATE TABLE cards (
    id UUID PRIMARY KEY,
    name VARCHAR(50),
    rarity VARCHAR(50),
    set_code VARCHAR(50),
    set_number VARCHAR(50),
    base_price INT,
    image_url VARCHAR(100),
    created_at TIMESTAMPTZ DEFAULT now()
);
