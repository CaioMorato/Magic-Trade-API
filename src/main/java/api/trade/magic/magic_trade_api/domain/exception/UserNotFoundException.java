package api.trade.magic.magic_trade_api.domain.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserNotFoundException extends DomainException {
    public UserNotFoundException(UUID id) {
        super("Usuário com ID '" + id + "' não encontrado.", HttpStatus.NOT_FOUND);
    }
}

