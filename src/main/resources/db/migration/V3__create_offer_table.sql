CREATE TABLE offers (
    id UUID PRIMARY KEY,
    seller_id UUID NOT NULL,
    card_id UUID NOT NULL,
    quantity INT NOT NULL,
    unit_price INT NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMPTZ DEFAULT now(),

    CONSTRAINT fk_offer_user FOREIGN KEY (seller_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_offer_card FOREIGN KEY (card_id) REFERENCES cards(id) ON DELETE CASCADE
);
