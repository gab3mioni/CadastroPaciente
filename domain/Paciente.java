package domain;

import domain.Validator.PacienteValidator;
import domain.Validator.PessoaValidator;
import domain.Validator.ValidationException;

/**
 * Representa um paciente, contendo informações pessoais e de contato.
 * A classe realiza validações dos dados inseridos através de validadores específicos.
 */
public class Paciente extends Pessoa {

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

    /**
     * Construtor da classe Paciente.
     * Realiza validações nos dados do paciente antes de atribuí-los às propriedades.
     * 
     * @param id Identificador único do paciente.
     * @param nome Nome completo do paciente.
     * @param login Login de acesso do paciente.
     * @param senha Senha de acesso do paciente.
     * @param cpf CPF do paciente.
     * @param rg RG do paciente.
     * @param telefone Telefone do paciente.
     * @param trabalho Trabalho do paciente.
     * @param escolaridade Escolaridade do paciente.
     * @param curso Curso que o paciente está cursando.
     * @param nomePai Nome do pai do paciente.
     * @param nomeMae Nome da mãe do paciente.
     * @param observacoes Observações sobre o paciente.
     * @param status Status de saúde ou ativo do paciente.
     */
    public Paciente(
            int id,
            String nome,
            String login,
            String senha,
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
        super(id, nome, login, senha);

        try {
            PessoaValidator.validarNome(nomePai);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Nome do pai inválido", e);
        }

        try {
            PessoaValidator.validarNome(nomeMae);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Nome da mãe inválido", e);
        }

        try {
            PacienteValidator.validarCpf(cpf);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("CPF inválido", e);
        }

        try {
            PacienteValidator.validarRg(rg);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("RG inválido", e);
        }

        try {
            PacienteValidator.validarTelefone(telefone);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Telefone inválido", e);
        }

        try {
            PacienteValidator.validarCampo(trabalho);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Trabalho inválido", e);
        }

        try {
            PacienteValidator.validarCampo(escolaridade);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Escolaridade inválida", e);
        }

        try {
            PacienteValidator.validarCampo(curso);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Curso inválido", e);
        }

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

    // Métodos getters e setters

    /**
     * Obtém o CPF do paciente.
     * 
     * @return CPF do paciente.
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Obtém o RG do paciente.
     * 
     * @return RG do paciente.
     */
    public String getRg() {
        return rg;
    }

    /**
     * Obtém o telefone do paciente.
     * 
     * @return Telefone do paciente.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Obtém o trabalho do paciente.
     * 
     * @return Trabalho do paciente.
     */
    public String getTrabalho() {
        return trabalho;
    }

    /**
     * Obtém a escolaridade do paciente.
     * 
     * @return Escolaridade do paciente.
     */
    public String getEscolaridade() {
        return escolaridade;
    }

    /**
     * Obtém o curso do paciente.
     * 
     * @return Curso do paciente.
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Obtém o nome do pai do paciente.
     * 
     * @return Nome do pai do paciente.
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Obtém o nome da mãe do paciente.
     * 
     * @return Nome da mãe do paciente.
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Obtém as observações sobre o paciente.
     * 
     * @return Observações sobre o paciente.
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * Obtém o status do paciente.
     * 
     * @return Status do paciente (ativo ou não).
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Define o CPF do paciente, realizando validações.
     * 
     * @param cpf CPF do paciente.
     * @throws IllegalArgumentException se o CPF for inválido.
     */
    public void setCpf(String cpf) {
        try {
            PacienteValidator.validarCpf(cpf);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("CPF inválido", e);
        }

        this.cpf = cpf;
    }

    /**
     * Define o RG do paciente, realizando validações.
     * 
     * @param rg RG do paciente.
     * @throws IllegalArgumentException se o RG for inválido.
     */
    public void setRg(String rg) {
        try {
            PacienteValidator.validarRg(rg);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("RG inválido", e);
        }

        this.rg = rg;
    }

    /**
     * Define o telefone do paciente, realizando validações.
     * 
     * @param telefone Telefone do paciente.
     * @throws IllegalArgumentException se o telefone for inválido.
     */
    public void setTelefone(String telefone) {
        try {
            PacienteValidator.validarTelefone(telefone);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Telefone inválido", e);
        }

        this.telefone = telefone;
    }

    /**
     * Define o trabalho do paciente, realizando validações.
     * 
     * @param trabalho Trabalho do paciente.
     * @throws IllegalArgumentException se o trabalho for inválido.
     */
    public void setTrabalho(String trabalho) {
        try {
            PacienteValidator.validarCampo(trabalho);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Trabalho inválido", e);
        }

        this.trabalho = trabalho;
    }

    /**
     * Define a escolaridade do paciente, realizando validações.
     * 
     * @param escolaridade Escolaridade do paciente.
     * @throws IllegalArgumentException se a escolaridade for inválida.
     */
    public void setEscolaridade(String escolaridade) {
        try {
            PacienteValidator.validarCampo(escolaridade);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Escolaridade inválida", e);
        }

        this.escolaridade = escolaridade;
    }

    /**
     * Define o curso do paciente, realizando validações.
     * 
     * @param curso Curso do paciente.
     * @throws IllegalArgumentException se o curso for inválido.
     */
    public void setCurso(String curso) {
        try {
            PacienteValidator.validarCampo(curso);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Curso inválido", e);
        }

        this.curso = curso;
    }

    /**
     * Define o nome do pai do paciente, realizando validações.
     * 
     * @param nomePai Nome do pai do paciente.
     * @throws IllegalArgumentException se o nome do pai for inválido.
     */
    public void setNomePai(String nomePai) {
        try {
            PessoaValidator.validarNome(nomePai);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Nome do pai inválido", e);
        }

        this.nomePai = nomePai;
    }

    /**
     * Define o nome da mãe do paciente, realizando validações.
     * 
     * @param nomeMae Nome da mãe do paciente.
     * @throws IllegalArgumentException se o nome da mãe for inválido.
     */
    public void setNomeMae(String nomeMae) {
        try {
            PessoaValidator.validarNome(nomeMae);
        } catch (ValidationException e) {
            throw new IllegalArgumentException("Nome da mãe inválido", e);
        }
        
        this.nomeMae = nomeMae;
    }

    /**
     * Define as observações sobre o paciente.
     * 
     * @param observacoes Observações sobre o paciente.
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    /**
     * Define o status do paciente (ativo ou não).
     * 
     * @param status Status do paciente.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
