package api.trade.magic.magic_trade_api.domain.service;

import api.trade.magic.magic_trade_api.domain.exception.EmailAlreadyExistsException;
import api.trade.magic.magic_trade_api.domain.exception.UserNotFoundException;
import api.trade.magic.magic_trade_api.domain.model.User;
import api.trade.magic.magic_trade_api.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Criar novo usuário com email único e saldo inicial zero.
     * @param name Nome do usuário (não nulo/vazio)
     * @param email Email do usuário (não nulo/vazio, único)
     * @return User criado e persistido
     * @throws EmailAlreadyExistsException se email já existe
     */
    @Transactional
    public User createUser(String name, String email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException(email);
        }
        User user = User.createNew(name, email);
        return userRepository.save(user);
    }

    /**
     * Buscar usuário por ID.
     * @param id UUID do usuário
     * @return User encontrado
     * @throws UserNotFoundException se não encontrado
     */
    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    /**
     * Adicionar saldo ao usuário.
     * @param id UUID do usuário
     * @param amount Valor a adicionar (deve ser positivo)
     * @return User com saldo atualizado
     * @throws UserNotFoundException se usuário não encontrado
     */
    @Transactional
    public User addBalance(UUID id, Integer amount) {
        User user = userRepository.findByIdForUpdate(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.addBalance(amount);
        return userRepository.save(user);
    }
}

