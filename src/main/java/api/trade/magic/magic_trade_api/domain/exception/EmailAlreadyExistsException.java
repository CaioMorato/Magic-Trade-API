package api.trade.magic.magic_trade_api.domain.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends DomainException {
    public EmailAlreadyExistsException(String email) {
        super("Email '" + email + "' já está registrado.", HttpStatus.CONFLICT);
    }
}

