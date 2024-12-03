package domain.Validator;

/**
 * Classe responsável por validar os dados relacionados a um paciente.
 * Inclui validações para CPF, RG, telefone e campos genéricos.
 */
public class PacienteValidator {

    /**
     * Valida se o CPF é válido.
     * O CPF deve ter exatamente 11 dígitos, não pode ser nulo ou vazio.
     *
     * @param cpf o CPF a ser validado.
     * @throws IllegalArgumentException se o CPF for nulo, vazio ou não tiver 11 dígitos.
     */
    public static void validarCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty() || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }
    }

    /**
     * Valida se o RG é válido.
     * O RG deve ter exatamente 10 dígitos, não pode ser nulo ou vazio.
     *
     * @param rg o RG a ser validado.
     * @throws IllegalArgumentException se o RG for nulo ou vazio.
     */
    public static void validarRg(String rg) {
        if (rg == null || rg.trim().isEmpty()) {
            throw new IllegalArgumentException("RG não pode ser vazio.");
        }
    }

    /**
     * Valida se o telefone é válido.
     * O telefone deve ter exatamente 11 dígitos, não pode ser nulo ou vazio.
     *
     * @param telefone o telefone a ser validado.
     * @throws IllegalArgumentException se o telefone for nulo, vazio ou não tiver 11 dígitos.
     */
    public static void validarTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty() || telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
    }

    /**
     * Valida se um campo genérico não é nulo nem vazio.
     *
     * @param campo o campo a ser validado.
     * @throws IllegalArgumentException se o campo for nulo ou vazio.
     */
    public static void validarCampo(String campo) {
        if (campo == null || campo.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo não pode ser vazio.");
        }
    }
}
