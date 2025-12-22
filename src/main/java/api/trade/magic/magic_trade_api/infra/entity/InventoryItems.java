package api.trade.magic.magic_trade_api.infra.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="inventory_items")
public class InventoryItems {
    @Id
    @GeneratedValue()
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="inventory_id", nullable = false)
    public Inventory inventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name="card_id", nullable = false)
    public Card card;

    public Integer quantity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
