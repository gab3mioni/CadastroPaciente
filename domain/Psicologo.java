package domain;

import domain.Validator.PsicologoValidator;

/**
 * Representa um psicólogo, que é uma pessoa especializada com um CRP e especialidade.
 * A validação dos dados do psicólogo é realizada através da classe {@link PsicologoValidator}.
 */
public class Psicologo extends Pessoa {

    private String crp;
    private String especialidade;

    /**
     * Constrói um objeto Psicologo com os dados fornecidos.
     * 
     * @param id O ID do psicólogo.
     * @param nome O nome do psicólogo.
     * @param login O login do psicólogo.
     * @param senha A senha do psicólogo.
     * @param crp O número do CRP do psicólogo.
     * @param especialidade A especialidade do psicólogo.
     * @throws IllegalArgumentException Se qualquer um dos parâmetros for inválido de acordo com a validação.
     */
    public Psicologo(int id, String nome, String login, String senha, String crp, String especialidade) {
        super(id, nome, login, senha);
        try {
            PsicologoValidator.validarCrp(crp);
            PsicologoValidator.validarEspecialidade(especialidade);
        } catch (Exception e) {
            throw new IllegalArgumentException("Dados inválidos", e);
        }

        this.crp = crp;
        this.especialidade = especialidade;
    }

    /**
     * Retorna o número do CRP do psicólogo.
     * 
     * @return O número do CRP do psicólogo.
     */
    public String getCrp() {
        return crp;
    }

    /**
     * Retorna a especialidade do psicólogo.
     * 
     * @return A especialidade do psicólogo.
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Altera o número do CRP do psicólogo, realizando validação.
     * 
     * @param crp O novo número do CRP do psicólogo.
     * @throws IllegalArgumentException Se o CRP for inválido de acordo com a validação.
     */
    public void setCrp(String crp) {
        try {
            PsicologoValidator.validarCrp(crp);
        } catch (Exception e) {
            throw new IllegalArgumentException("CRP inválido", e);
        }

        this.crp = crp;
    }

    /**
     * Altera a especialidade do psicólogo, realizando validação.
     * 
     * @param especialidade A nova especialidade do psicólogo.
     * @throws IllegalArgumentException Se a especialidade for inválida de acordo com a validação.
     */
    public void setEspecialidade(String especialidade) {
        try {
            PsicologoValidator.validarEspecialidade(especialidade);
        } catch (Exception e) {
            throw new IllegalArgumentException("Especialidade inválida", e);
        }

        this.especialidade = especialidade;
    }
}
