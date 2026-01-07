-- Índices para tabela inventory
CREATE INDEX idx_inventory_user_id ON inventory(user_id);
CREATE INDEX idx_inventory_card_id ON inventory(card_id);

-- Índices para tabela offers
CREATE INDEX idx_offer_seller_id ON offers(seller_id);
CREATE INDEX idx_offer_card_id ON offers(card_id);
CREATE INDEX idx_offer_status ON offers(status);

-- Índices para tabela transactions
CREATE INDEX idx_transaction_buyer_id ON transactions(buyer_id);
CREATE INDEX idx_transaction_offer_id ON transactions(offer_id);
CREATE INDEX idx_transaction_date ON transactions(transaction_date);
