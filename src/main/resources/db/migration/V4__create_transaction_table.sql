CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    buyer_id UUID NOT NULL,
    seller_id UUID NOT NULL,
    offer_id UUID NOT NULL,
    card_id UUID NOT NULL,
    quantity INT NOT NULL,
    total_price INT NOT NULL,
    transaction_date TIMESTAMPTZ DEFAULT now(),

    CONSTRAINT fk_transactions_buyer FOREIGN KEY (buyer_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_transactions_seller FOREIGN KEY (seller_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_transactions_offer FOREIGN KEY (offer_id) REFERENCES offers(id) ON DELETE CASCADE,
    CONSTRAINT fk_transactions_card FOREIGN KEY (card_id) REFERENCES cards(id) ON DELETE CASCADE
);
