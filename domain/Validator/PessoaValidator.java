package domain.Validator;

/**
 * Classe responsável por validar os dados de uma pessoa, como nome, login e senha.
 * Fornece métodos estáticos para garantir que os dados atendam aos requisitos de formato e preenchimento.
 */
public class PessoaValidator {

    /**
     * Valida se o nome é válido, ou seja, não é nulo nem vazio.
     *
     * @param nome o nome a ser validado.
     * @throws ValidationException se o nome for nulo ou vazio.
     */
    public static void validarNome(String nome) throws ValidationException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ValidationException("Nome não pode ser vazio.");
        }
    }

    /**
     * Valida se o login é válido, ou seja, não é nulo nem vazio.
     *
     * @param login o login a ser validado.
     * @throws ValidationException se o login for nulo ou vazio.
     */
    public static void validarLogin(String login) throws ValidationException {
        if (login == null || login.trim().isEmpty()) {
            throw new ValidationException("Login não pode ser vazio.");
        }
    }

    /**
     * Valida se a senha atende aos requisitos de segurança:
     * - Não pode ser nula ou vazia.
     * - Deve ter pelo menos 8 caracteres.
     * - Deve conter pelo menos uma letra maiúscula, um número e um caractere especial.
     *
     * @param senha a senha a ser validada.
     * @throws ValidationException se a senha for nula, vazia, menor que 8 caracteres
     *                                  ou não atender aos critérios de segurança.
     */
    public static void validarSenha(String senha) throws ValidationException {
        if (senha == null || senha.trim().isEmpty()) {
            throw new ValidationException("Senha não pode ser vazia.");
        }

        if (senha.length() < 8) {
            throw new ValidationException("A senha deve ter pelo menos 8 caracteres.");
        }

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_])(?=\\S+$).{8,}$";

        if (!senha.matches(regex)) {
            throw new ValidationException("A senha deve conter pelo menos uma letra maiúscula, um número e um caractere especial.");
        }
    }
}
