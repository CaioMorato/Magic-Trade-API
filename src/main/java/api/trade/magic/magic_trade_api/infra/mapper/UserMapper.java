package api.trade.magic.magic_trade_api.infra.mapper;

import api.trade.magic.magic_trade_api.domain.model.User;
import api.trade.magic.magic_trade_api.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toDomain(UserEntity userEntity){
        if (userEntity == null){
            return null;
        }

        return User.fromRepository(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getBalance(),
                userEntity.getCreatedAt()
        );
    }

    public UserEntity toEntity (User userDomain){
        if (userDomain == null){
            return null;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDomain.getId());
        userEntity.setName(userDomain.getName());
        userEntity.setEmail(userDomain.getEmail());
        userEntity.setBalance(userDomain.getBalance());
        userEntity.setCreatedAt(userDomain.getCreatedAt());

        return userEntity;
    }
}
