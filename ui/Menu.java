package ui;

import domain.Paciente;
import repository.InterfacePacienteRepository;
import service.PacienteExporter;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final InterfacePacienteRepository repository;

    public Menu(InterfacePacienteRepository repository) {
        this.repository = repository;
    }

    public void exibirMenu() {
        Scanner leia = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n--------------------");
            System.out.println("PsiFacilita - Sistema de Gestão");
            System.out.println("1. Cadastrar paciente");
            System.out.println("2. Listar paciente");
            System.out.println("3. Exportar pacientes para arquivo");
            System.out.println("4. Sair");
            System.out.println("--------------------");
            System.out.print("\n\tEscolha uma opção: ");
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPaciente(leia);
                case 2 -> listarPacientes();
                case 3 -> exportarPacientes();
                case 4 -> System.out.println("\n\tSaindo...\n");
                default -> System.out.println("\n\tOpção inválida.\n");
            }
        } while (opcao != 4);

        leia.close();
    }

    public void cadastrarPaciente(Scanner leia) {

        int id = repository.getProximoId();

        System.out.print("Nome: ");
        String nome = leia.nextLine();

        String login = repository.getNewLogin(nome);
        String senha = "Senha@ParaAlterar123";

        System.out.print("CPF: ");
        String cpf = leia.nextLine();

        System.out.print("RG: ");
        String rg = leia.nextLine();

        System.out.print("Telefone: ");
        String telefone = leia.nextLine();

        System.out.print("Trabalho: ");
        String trabalho = leia.nextLine();

        System.out.print("Escolaridade: ");
        String escolaridade = leia.nextLine();

        System.out.print("Curso: ");
        String curso = leia.nextLine();

        System.out.print("Nome do Pai: ");
        String nomePai = leia.nextLine();

        System.out.print("Nome da mãe: ");
        String nomeMae = leia.nextLine();

        System.out.print("Observações: ");
        String observacoes = leia.nextLine();

        Paciente paciente = new Paciente(
                id,
                nome,
                login,
                senha,
                cpf,
                rg,
                telefone,
                trabalho,
                escolaridade,
                curso,
                nomePai,
                nomeMae,
                observacoes,
                true
        );

        repository.adicionarPaciente(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void listarPacientes() {
        List<Paciente> pacientes = repository.listarPacientes();
        if(pacientes.isEmpty()) {
            System.out.println("\n\tNenhum paciente cadastrado.\n");
        }
        for (Paciente paciente : pacientes) {
            System.out.println("Lista de Paciente");
            System.out.println(
                            "\nID: " + paciente.getId() +
                            "\nNome: " + paciente.getNome() +
                            "\nCPF: " + paciente.getCpf() +
                            "\nRG: " + paciente.getRg() +
                            "\nTelefone: " + paciente.getTelefone() +
                            "\nTrabalho: " + paciente.getTrabalho() +
                            "\nEscolaridade: " + paciente.getEscolaridade() +
                            "\nCurso: " + paciente.getCurso() +
                            "\nNome do Pai: " + paciente.getNomePai() +
                            "\nNome da mãe: " + paciente.getNomeMae() +
                            "\nObservações: " + paciente.getObservacoes()
            );
        }
    }

    public void exportarPacientes() {
        List<Paciente> pacientes = repository.listarPacientes();
        String nomeArquivo = "pacientes.txt";

        PacienteExporter.exportarPacientesParaTxt(pacientes, nomeArquivo);
    }
}
