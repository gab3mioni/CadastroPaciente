package domain.Validator;

public class PessoaValidator {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
    }

    public static void validarLogin(String login) {
        if (login == null || login.trim().isEmpty()) {
            throw new IllegalArgumentException("Login não pode ser vazio.");
        }
    }

    public static void validarSenha(String senha) {
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha não pode ser vazia.");
        }

        if (senha.length() < 8) {
            throw new IllegalArgumentException("A senha deve ter pelo menos 8 caracteres.");
        }

        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W_])(?=\\S+$).{8,}$";

        if (!senha.matches(regex)) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula, um número e um caractere especial.");
        }
    }
}
