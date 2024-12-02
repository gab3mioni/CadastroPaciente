package domain;

import domain.Validator.PsicologoValidator;

public class Psicologo extends Pessoa {

    private String crp;
    private String especialidade;

    public Psicologo(String nome, String login, String senha, String crp, String especialidade) {
        super(nome, login, senha);
        PsicologoValidator.validarCrp(crp);
        PsicologoValidator.validarEspecialidade(especialidade);
        this.crp = crp;
        this.especialidade = especialidade;
    }

    public String getCrp() {
        return crp;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setCrp(String crp) {
        PsicologoValidator.validarCrp(crp);
        this.crp = crp;
    }

    public void setEspecialidade(String especialidade) {
        PsicologoValidator.validarEspecialidade(especialidade);
        this.especialidade = especialidade;
    }
}
