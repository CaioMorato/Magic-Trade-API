CREATE TABLE card (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50),
    rarity VARCHAR(50),
    set_code VARCHAR(50),
    set_number VARCHAR(50),
    base_price NUMERIC(10,2),
    image_url VARCHAR(100),
    created_at TIMESTAMPTZ DEFAULT now()
);