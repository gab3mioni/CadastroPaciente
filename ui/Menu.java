package ui;

import domain.Paciente;
import domain.Psicologo;
import repository.InterfaceRepository;
import service.PacienteExporter;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final InterfaceRepository<Paciente> pacienteRepository;
    private final InterfaceRepository<Psicologo> psicologoRepository;

    public Menu(
            InterfaceRepository<Paciente> pacienteRepository,
            InterfaceRepository<Psicologo> psicologoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.psicologoRepository = psicologoRepository;
    }

    public void exibirLogin() {
        Scanner leia = new Scanner(System.in);
        String login;
        String senha;
        boolean autenticado;

        do {
            System.out.println("\n--------------------");
            System.out.println("PsiFacilita - Sistema de Gestão");
            System.out.print("Login: ");
            login = leia.nextLine();
            System.out.print("Senha: ");
            senha = leia.nextLine();

            autenticado = this.autenticar(login, senha);

            if (autenticado) {
                System.out.println("\n\tLogin efetuado com sucesso.\n");
                exibirMenu();
            } else {
                System.out.println("\n\tLogin ou senha inválidos.\n");
            }
        } while (!autenticado);

        leia.close();
    }

    public boolean autenticar(String login, String senha) {
        return psicologoRepository.listar().stream()
                .anyMatch(usuario -> usuario.getLogin().equals(login) && usuario.getSenha().equals(senha));
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

        int id = pacienteRepository.getProximoId();

        System.out.print("Nome: ");
        String nome = leia.nextLine();

        String login = pacienteRepository.getNewLogin(nome);
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
                true);

        pacienteRepository.adicionar(paciente);
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.listar();
        if (pacientes.isEmpty()) {
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
                            "\nObservações: " + paciente.getObservacoes());
        }
    }

    public void listarPsicologos() {
        List<Psicologo> psicologos = psicologoRepository.listar();
        if (psicologos.isEmpty()) {
            System.out.println("\n\tNenhum psicólogo cadastrado.\n");
            return;
        }

        System.out.println("Lista de Psicólogos:");
        for (Psicologo psicologo : psicologos) {
            System.out.println(
                    "\nID: " + psicologo.getId() +
                            "\nNome: " + psicologo.getNome() +
                            "\nCRP: " + psicologo.getCrp() +
                            "\nEspecialidade: " + psicologo.getEspecialidade());
        }
    }

    public void exportarPacientes() {
        List<Paciente> pacientes = pacienteRepository.listar();
        String nomeArquivo = "pacientes.txt";

        PacienteExporter.exportarPacientesParaTxt(pacientes, nomeArquivo);
    }
}
