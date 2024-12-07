package domain.Validator;

/**
 * Exceção personalizada para erros de validação.
 * Utilizada para sinalizar falhas nas validações de dados das entidades do sistema.
 */
public class ValidationException extends Exception {

    /**
     * Construtor que cria uma instância de ValidationException com uma mensagem específica.
     *
     * @param message A mensagem descritiva do erro de validação.
     */
    public ValidationException(String message) {
        super(message);
    }

    /**
     * Construtor que cria uma instância de ValidationException com uma mensagem e uma causa.
     *
     * @param message A mensagem descritiva do erro de validação.
     * @param cause   A causa original da exceção.
     */
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
