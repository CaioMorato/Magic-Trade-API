package api.trade.magic.magic_trade_api.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public final class User {
    private final UUID id;
    private String name;
    private final String email;
    private Integer balance;
    private final OffsetDateTime createdAt;

    private User(UUID id, String name, String email, Integer balance, OffsetDateTime createdAt) {
        this.id = id; // ID pode ser nulo ao criar novo usuário (banco gerará)
        this.name = name;
        this.email = Objects.requireNonNull(email, "Email não pode ser nulo.");
        this.balance = Objects.requireNonNullElse(balance, 0);
        this.createdAt = Objects.requireNonNull(createdAt, "Data de criação não pode ser nula.");
    }

    // Criar usuário com saldo.
    public static User createNew(String name, String email, Integer balance){
        String n = normalizeName(name);
        String e = normalizeEmail(email);
        if (balance == null || balance < 0) throw new IllegalArgumentException("Saldo não pode ser nulo ou negativo.");
        return new User(null, n, e, balance, OffsetDateTime.now()); // ID null - banco gerará
    }

    // Criar usuário com saldo zero
    public static User createNew(String name, String email){
        return createNew(name, email, 0);
    }

    // Reconstruir usuário existente do repositório (sem validações de criação)
    public static User fromRepository(UUID id, String name, String email, Integer balance, OffsetDateTime createdAt){
        return new User(id, name, email, balance, createdAt);
    }

    public User addBalance(Integer amount){
        if (amount == null || amount <= 0) throw new IllegalArgumentException("Quantidade não pode ser nula ou menor que zero.");
        // overflow-safe add
        this.balance = Math.addExact(this.balance, amount);
        return this;
    }

    public User deductBalance(Integer amount){
        if (amount == null || amount <= 0) throw new IllegalArgumentException("Quantidade não pode ser nula ou menor que zero.");
        if (this.balance < amount) throw new IllegalArgumentException("Saldo insuficiente.");
        this.balance = this.balance - amount;
        return this;
    }

    private static String normalizeName(String name) {
        if (name == null) throw new IllegalArgumentException("Nome não pode ser nulo.");
        String n = name.trim();
        if (n.isEmpty()) throw new IllegalArgumentException("Nome não pode ser vazio.");
        return n;
    }

    private static String normalizeEmail(String email) {
        if (email == null) throw new IllegalArgumentException("Email não pode ser nulo.");
        String e = email.trim().toLowerCase();
        if (e.isEmpty() || !e.contains("@")) throw new IllegalArgumentException("Email inválido.");
        return e;
    }

    // Getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Integer getBalance() { return balance; }
    public OffsetDateTime getCreatedAt() { return createdAt; }

    // Optional: allow changing name through domain method
    public void changeName(String newName) {
        this.name = normalizeName(newName);
    }
}
