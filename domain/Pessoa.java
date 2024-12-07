package domain;

import domain.Validator.PessoaValidator;

/**
 * Representa uma pessoa, com atributos como ID, nome, login e senha.
 * A validação dos dados é realizada através da classe {@link PessoaValidator}.
 */
public class Pessoa {

    private final int id;
    private String nome;
    private String login;
    private String senha;

    /**
     * Constrói um objeto Pessoa com os dados fornecidos.
     * 
     * @param id O ID da pessoa.
     * @param nome O nome da pessoa.
     * @param login O login da pessoa.
     * @param senha A senha da pessoa.
     * @throws IllegalArgumentException Se qualquer um dos parâmetros for inválido de acordo com a validação.
     */
    public Pessoa(int id, String nome, String login, String senha) {
        try {
            PessoaValidator.validarNome(nome);
            PessoaValidator.validarLogin(login);
            PessoaValidator.validarSenha(senha);
        } catch (Exception e) {
            throw new IllegalArgumentException("Dados inválidos", e);
        }

        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    /**
     * Retorna o ID da pessoa.
     * 
     * @return O ID da pessoa.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna o nome da pessoa.
     * 
     * @return O nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna o login da pessoa.
     * 
     * @return O login da pessoa.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Retorna a senha da pessoa.
     * 
     * @return A senha da pessoa.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Altera o nome da pessoa, realizando validação.
     * 
     * @param nome O novo nome da pessoa.
     * @throws IllegalArgumentException Se o nome for inválido de acordo com a validação.
     */
    public void setNome(String nome) {
        try {
            PessoaValidator.validarNome(nome);
        } catch (Exception e) {
            throw new IllegalArgumentException("Nome inválido", e);
        }

        this.nome = nome;
    }

    /**
     * Altera o login da pessoa, realizando validação.
     * 
     * @param login O novo login da pessoa.
     * @throws IllegalArgumentException Se o login for inválido de acordo com a validação.
     */
    public void setLogin(String login) {
        try {
            PessoaValidator.validarLogin(login);
        } catch (Exception e) {
            throw new IllegalArgumentException("Login inválido", e);
        }

        this.login = login;
    }

    /**
     * Altera a senha da pessoa, realizando validação.
     * 
     * @param senha A nova senha da pessoa.
     * @throws IllegalArgumentException Se a senha for inválida de acordo com a validação.
     */
    public void setSenha(String senha) {
        try {
            PessoaValidator.validarSenha(senha);
        } catch (Exception e) {
            throw new IllegalArgumentException("Senha inválida", e);
        }

        this.senha = senha;
    }
}
