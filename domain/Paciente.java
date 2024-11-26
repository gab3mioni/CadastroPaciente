package domain;

public class Paciente {

    private final int id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String trabalho;
    private String escolaridade;
    private String curso;
    private String nomePai;
    private String nomeMae;
    private String observacoes;
    private boolean status;

    public Paciente(
            int id,
            String nome,
            String cpf,
            String rg,
            String telefone,
            String trabalho,
            String escolaridade,
            String curso,
            String nomePai,
            String nomeMae,
            String observacoes,
            boolean status
    ) {
        PacienteValidator.validarNome(nome);
        PacienteValidator.validarCpf(cpf);
        PacienteValidator.validarRg(rg);
        PacienteValidator.validarTelefone(telefone);
        PacienteValidator.validarCampo(trabalho);
        PacienteValidator.validarCampo(escolaridade);
        PacienteValidator.validarCampo(curso);
        PacienteValidator.validarNome(nomePai);
        PacienteValidator.validarNome(nomeMae);

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.trabalho = trabalho;
        this.escolaridade = escolaridade;
        this.curso = curso;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.observacoes = observacoes;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTrabalho() {
        return trabalho;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public String getCurso() {
        return curso;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public boolean getStatus() {
        return status;
    }

    public void setNome(String nome) {
        PacienteValidator.validarNome(nome);
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        PacienteValidator.validarCpf(cpf);
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        PacienteValidator.validarRg(rg);
        this.rg = rg;
    }

    public void setTelefone(String telefone) {
        PacienteValidator.validarTelefone(telefone);
        this.telefone = telefone;
    }

    public void setTrabalho(String trabalho) {
        PacienteValidator.validarCampo(trabalho);
        this.trabalho = trabalho;
    }

    public void setEscolaridade(String escolaridade) {
        PacienteValidator.validarCampo(escolaridade);
        this.escolaridade = escolaridade;
    }

    public void setCurso(String curso) {
        PacienteValidator.validarCampo(curso);
        this.curso = curso;
    }

    public void setNomePai(String nomePai) {
        PacienteValidator.validarNome(nomePai);
        this.nomePai = nomePai;
    }

    public void setNomeMae(String nomeMae) {
        PacienteValidator.validarNome(nomeMae);
        this.nomeMae = nomeMae;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
