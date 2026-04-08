package api.trade.magic.magic_trade_api.domain.repository;

import api.trade.magic.magic_trade_api.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    Optional<User> findByIdForUpdate(UUID id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    User save(User user);
    void deleteById(UUID id);
}
