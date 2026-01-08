package api.trade.magic.magic_trade_api.application.controller.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler global para exceções genéricas da aplicação.
 * Responsável por:
 * - Validação de DTOs (Bean Validation)
 * - Exceções não capturadas por handlers específicos
 *
 * @Order(2) garante que este handler seja processado após handlers específicos de domínio.
 */
@ControllerAdvice
@Order(2)
public class GlobalExceptionHandler {

    /**
     * Trata erros de validação de entrada (DTOs com @Valid).
     * Captura violações de @NotBlank, @Email, @Size, @Positive, etc.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        response.put("error", "Validação falhou");
        response.put("code", "VALIDATION_ERROR");
        response.put("details", errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Handler fallback para qualquer exceção não tratada.
     * Retorna 500 Internal Server Error com mensagem genérica por segurança.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Erro interno do servidor");
        response.put("code", "INTERNAL_SERVER_ERROR");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
