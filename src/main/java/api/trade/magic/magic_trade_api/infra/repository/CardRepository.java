package api.trade.magic.magic_trade_api.infra.repository;

import api.trade.magic.magic_trade_api.infra.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
