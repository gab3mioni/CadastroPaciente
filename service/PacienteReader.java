package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.Paciente;
import repository.PacienteRepository;

public class PacienteReader {

    public static List<Paciente> lerPacientesDeTxt(String nomeArquivo, String diretorio) {
        List<Paciente> pacientes = new ArrayList<>();
        PacienteRepository pacienteRepository = new PacienteRepository();

        try (BufferedReader reader = new BufferedReader(new FileReader(diretorio + nomeArquivo))) {
            String linha;

            int id = 0;
            String nome = null;
            String login = null;
            String senha = null;
            String cpf = null;
            String rg = null;
            String telefone = null;
            String trabalho = null;
            String escolaridade = null;
            String curso = null;
            String nomePai = null;
            String nomeMae = null;
            String observacoes = null;
            boolean status = false;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("ID: ")) {
                    id = Integer.parseInt(linha.split(": ")[1].trim());
                } else if (linha.startsWith("Nome: ")) {
                    nome = linha.split(": ")[1].trim();
                } else if (linha.startsWith("CPF: ")) {
                    cpf = linha.split(": ")[1].trim();
                } else if (linha.startsWith("RG: ")) {
                    rg = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Telefone: ")) {
                    telefone = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Trabalho: ")) {
                    trabalho = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Escolaridade: ")) {
                    escolaridade = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Curso: ")) {
                    curso = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Nome do Pai: ")) {
                    nomePai = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Nome da Mãe: ")) {
                    nomeMae = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Observações: ")) {
                    observacoes = linha.split(": ")[1].trim();
                } else if (linha.startsWith("Status: ")) {
                    status = Boolean.parseBoolean(linha.split(": ")[1].trim());
                } else if (linha.startsWith("----------------------------------")) {

                    login = pacienteRepository.getNewLogin(nome);
                    senha = "SenhaParaAlterar123@";

                    Paciente paciente = new Paciente(
                            id, nome, login, senha, cpf, rg, telefone, trabalho, escolaridade, curso, nomePai, nomeMae, observacoes, status
                    );

                    pacientes.add(paciente);

                    id = 0;
                    nome = null;
                    login = null;
                    senha = null;
                    cpf = null;
                    rg = null;
                    telefone = null;
                    trabalho = null;
                    escolaridade = null;
                    curso = null;
                    nomePai = null;
                    nomeMae = null;
                    observacoes = null;
                    status = false;
                }
            }

            if (nome != null) {
                login = pacienteRepository.getNewLogin(nome);
                senha = "SenhaParaAlterar123@";

                Paciente paciente = new Paciente(
                        id, nome, login, senha, cpf, rg, telefone, trabalho, escolaridade, curso, nomePai, nomeMae, observacoes, status
                );
                pacientes.add(paciente);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler pacientes do arquivo: " + e.getMessage());
        }

        return pacientes;
    }
}