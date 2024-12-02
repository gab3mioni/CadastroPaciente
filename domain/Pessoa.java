package domain;

import domain.Validator.PessoaValidator;

public class Pessoa {

    private String nome;
    private String login;
    private String senha;

    public Pessoa(String nome, String login, String senha) {
        PessoaValidator.validarNome(nome);
        PessoaValidator.validarLogin(login);
        PessoaValidator.validarSenha(senha);

        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        PessoaValidator.validarNome(nome);
        this.nome = nome;
    }

    public void setLogin(String login) {
        PessoaValidator.validarLogin(login);
        this.login = login;
    }

    public void setSenha(String senha) {
        PessoaValidator.validarSenha(senha);
        this.senha = senha;
    }
    
}
