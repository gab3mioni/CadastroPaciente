package domain;

public class PacienteValidator {

    public static void validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
    }

    public static void validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF deve ter 11 dígitos.");
        }
    }

    public static void validarRg(String rg) {
        if (rg == null || rg.trim().isEmpty()) {
            throw new IllegalArgumentException("RG deve ter 10 dígitos.");
        }
    }

    public static void validarTelefone(String telefone) {
        if (telefone == null || telefone.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido.");
        }
    }

    public static void validarCampo(String campo) {
        if (campo == null || campo.trim().isEmpty()) {
            throw new IllegalArgumentException("O campo não pode ser vazio.");
        }
    }
}
