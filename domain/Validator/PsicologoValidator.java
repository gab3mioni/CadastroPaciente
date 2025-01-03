package domain.Validator;

/**
 * Classe responsável por validar os dados relacionados a um psicólogo.
 * Inclui validações para o CRP e especialidade do psicólogo.
 */
public class PsicologoValidator {

    /**
     * Valida se o CRP é válido.
     * O CRP não pode ser nulo, vazio e deve ter exatamente 8 caracteres.
     *
     * @param crp o CRP a ser validado.
     * @throws ValidationException se o CRP for nulo, vazio ou não tiver 8 caracteres.
     */
    public static void validarCrp(String crp) throws ValidationException {
        if (crp == null || crp.trim().isEmpty() || crp.length() != 8) {
            throw new ValidationException("CRP não pode ser vazio.");
        }
    }

    /**
     * Valida se a especialidade é válida.
     * A especialidade não pode ser nula nem vazia.
     *
     * @param especialidade a especialidade a ser validada.
     * @throws ValidationException se a especialidade for nula ou vazia.
     */
    public static void validarEspecialidade(String especialidade) throws ValidationException {
        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new ValidationException("Especialidade não pode ser vazia.");
        }
    }
}
