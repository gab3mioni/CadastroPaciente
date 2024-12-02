package service;

import domain.Paciente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PacienteExporter {

    public static void exportarPacientesParaTxt(
        List<Paciente> pacientes, 
        String nomeArquivo,
        String diretorio
        ) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio + nomeArquivo))) {
            if (pacientes.isEmpty()) {
                writer.write("Nenhum paciente cadastrado.");
            } else {
                for (Paciente paciente : pacientes) {
                    writer.write("ID: " + paciente.getId() + "\n");
                    writer.write("Nome: " + paciente.getNome() + "\n");
                    writer.write("CPF: " + paciente.getCpf() + "\n");
                    writer.write("RG: " + paciente.getRg() + "\n");
                    writer.write("Telefone: " + paciente.getTelefone() + "\n");
                    writer.write("Trabalho: " + paciente.getTrabalho() + "\n");
                    writer.write("Escolaridade: " + paciente.getEscolaridade() + "\n");
                    writer.write("Curso: " + paciente.getCurso() + "\n");
                    writer.write("Nome do Pai: " + paciente.getNomePai() + "\n");
                    writer.write("Nome da Mãe: " + paciente.getNomeMae() + "\n");
                    writer.write("Observações: " + paciente.getObservacoes() + "\n");
                    writer.write("Status: " + (paciente.getStatus() ? "Ativo" : "Inativo"));
                    writer.write("\n----------------------------------\n");
                }
            }
            System.out.println("Lista de pacientes exportada com sucesso para o arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar pacientes para o arquivo: " + e.getMessage());
        }
    }
}
