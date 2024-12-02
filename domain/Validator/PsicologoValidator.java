package domain.Validator;

public class PsicologoValidator {

    public static void validarCrp(String crp) {
        if (crp == null || crp.trim().isEmpty() || crp.length() != 8) {
            throw new IllegalArgumentException("CRP não pode ser vazio.");
        }
    }

    public static void validarEspecialidade(String especialidade) {
        if (especialidade == null || especialidade.trim().isEmpty()) {
            throw new IllegalArgumentException("Especialidade não pode ser vazia.");
        }
    }
    
}
