package api.trade.magic.magic_trade_api.application.controller.handler;

import api.trade.magic.magic_trade_api.domain.exception.EmailAlreadyExistsException;
import api.trade.magic.magic_trade_api.domain.exception.UserNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler especializado para exceções do domínio de Usuários.
 * Trata exceções específicas do fluxo de usuários (create, get, update balance).
 *
 * @Order(1) garante que este handler seja processado antes do GlobalExceptionHandler.
 */
@ControllerAdvice
@Order(1)
public class UserExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleEmailAlreadyExists(EmailAlreadyExistsException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("code", "EMAIL_ALREADY_EXISTS");
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUserNotFound(UserNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("code", "USER_NOT_FOUND");
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }
}

