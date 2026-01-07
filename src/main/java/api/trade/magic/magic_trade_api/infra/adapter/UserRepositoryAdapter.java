package api.trade.magic.magic_trade_api.infra.adapter;

import api.trade.magic.magic_trade_api.domain.model.User;
import api.trade.magic.magic_trade_api.domain.repository.UserRepository;
import api.trade.magic.magic_trade_api.infra.mapper.UserMapper;
import api.trade.magic.magic_trade_api.infra.repository.JPAUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserRepositoryAdapter  implements UserRepository {
    private final JPAUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public UserRepositoryAdapter(JPAUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }


    @Override
    public Optional<User> findById(UUID id){
        return jpaUserRepository.findById(id).map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByIdForUpdate(UUID id){
        return jpaUserRepository.findByIdForUpdate(id).map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email).map(userMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        var entity = userMapper.toEntity(user);
        var savedEntity = jpaUserRepository.save(entity);
        return userMapper.toDomain(savedEntity);
    }


    @Override
    public void deleteById(UUID id) {
        jpaUserRepository.deleteById(id);
    }
}
