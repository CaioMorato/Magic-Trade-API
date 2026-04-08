package api.trade.magic.magic_trade_api.infra.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="offers")
public class Offer {

    @Id
    @GeneratedValue()
    public UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "seller_id", nullable = false)
    public UserEntity seller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "card_id", nullable = false)
    public Card card;

    public Integer quantity;

    @Column(name = "unit_price")
    public Integer unitPrice;

    public String status;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
