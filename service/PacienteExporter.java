package service;

import domain.Paciente;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Classe responsável pela exportação de informações de pacientes para um arquivo de texto.
 * A classe fornece um método para exportar os dados dos pacientes para um arquivo no formato
 * texto, permitindo a visualização das informações em um arquivo físico.
 */
public class PacienteExporter {

    /**
     * Exporte a lista de pacientes para um arquivo de texto.
     * 
     * O método percorre a lista de pacientes e escreve as informações de cada um
     * no arquivo especificado. Se a lista estiver vazia, uma mensagem indicando
     * que não há pacientes cadastrados será escrita no arquivo. Caso contrário,
     * os dados de cada paciente serão gravados no arquivo de texto, com informações
     * como ID, nome, CPF, RG, telefone, trabalho, escolaridade, curso, nome dos pais,
     * observações e status do paciente (ativo ou inativo).
     * 
     * @param pacientes Lista de pacientes a ser exportada para o arquivo.
     * @param nomeArquivo Nome do arquivo de texto onde os dados serão salvos.
     * @param diretorio Diretório onde o arquivo será salvo.
     */
    public static void exportarPacientesParaTxt(
        List<Paciente> pacientes, 
        String nomeArquivo,
        String diretorio
        ) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(diretorio + nomeArquivo))) {
            // Se a lista de pacientes estiver vazia, escreve uma mensagem no arquivo.
            if (pacientes.isEmpty()) {
                writer.write("Nenhum paciente cadastrado.");
            } else {
                // Caso contrário, escreve as informações de cada paciente.
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
            // Mensagem de sucesso após a exportação
            System.out.println("Lista de pacientes exportada com sucesso para o arquivo: " + nomeArquivo);
        } catch (IOException e) {
            // Exibe erro caso algo aconteça durante a exportação
            System.err.println("Erro ao exportar pacientes para o arquivo: " + e.getMessage());
        }
    }
}
