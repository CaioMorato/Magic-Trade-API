package api.trade.magic.magic_trade_api.infra.repository;

import api.trade.magic.magic_trade_api.infra.entity.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InventoryItemsRepository extends JpaRepository<InventoryItems, UUID> {
    List<InventoryItems> findByInventoryId(UUID inventoryId);
}
