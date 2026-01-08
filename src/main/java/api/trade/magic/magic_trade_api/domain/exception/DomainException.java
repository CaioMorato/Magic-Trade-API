package api.trade.magic.magic_trade_api.domain.exception;

import org.springframework.http.HttpStatus;

/**
 * Exceção base para todas as exceções de domínio.
 * Cada exceção de domínio deve herdar desta classe e definir seu HttpStatus.
 */
public abstract class DomainException extends RuntimeException {
    private final HttpStatus httpStatus;

    public DomainException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

