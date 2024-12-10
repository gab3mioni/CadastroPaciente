package ui;

import domain.Paciente;
import domain.Psicologo;
import repository.InterfaceRepository;
import service.PacienteExporter;
import service.PacienteReader;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pela interface do usuário e exibição dos menus do sistema
 * de gestão PsiFacilita.
 * Oferece funcionalidades para autenticação de psicólogos, cadastro de
 * pacientes, listagem de pacientes,
 * exportação de dados dos pacientes para um arquivo e visualização de
 * psicólogos cadastrados.
 */
public class Menu {

    private final InterfaceRepository<Paciente> pacienteRepository;
    private final InterfaceRepository<Psicologo> psicologoRepository;

    /**
     * Constrói um objeto Menu com os repositórios de pacientes e psicólogos.
     * 
     * @param pacienteRepository  Repositório responsável pelas operações de
     *                            persistência dos pacientes.
     * @param psicologoRepository Repositório responsável pelas operações de
     *                            persistência dos psicólogos.
     */
    public Menu(
            InterfaceRepository<Paciente> pacienteRepository,
            InterfaceRepository<Psicologo> psicologoRepository) {
        this.pacienteRepository = pacienteRepository;
        this.psicologoRepository = psicologoRepository;
    }

    /**
     * Exibe a tela de login e autentica o psicólogo no sistema.
     * O usuário deve inserir o login e senha para acessar o menu principal.
     */
    public void exibirLogin() {
        Scanner leia = new Scanner(System.in);
        String login;
        String senha;
        boolean autenticado;

        do {
            try {
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
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro: " + e.getMessage());
                autenticado = false;
            } catch (Exception e) {
                System.out.println("\nOcorreu um erro inesperado: " + e.getMessage());
                autenticado = false;
            }
        } while (!autenticado);

        leia.close();
    }

    /**
     * Realiza a autenticação do psicólogo com o login e senha fornecidos.
     * 
     * @param login O login do psicólogo.
     * @param senha A senha do psicólogo.
     * @return true se o login e senha forem válidos, caso contrário, false.
     */
    public boolean autenticar(String login, String senha) {
        try {
            return psicologoRepository.listar().stream()
                    .anyMatch(usuario -> usuario.getLogin().equals(login) && usuario.getSenha().equals(senha));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Exibe o menu principal após o login bem-sucedido.
     * O menu oferece opções para cadastrar pacientes, listar pacientes,
     * exportar pacientes para um arquivo e sair do sistema.
     */
    public void exibirMenu() {
        Scanner leia = new Scanner(System.in);

        int opcao = 0;

        do {
            try {
                System.out.println("\n--------------------");
                System.out.println("PsiFacilita - Sistema de Gestão");
                System.out.println("1. Cadastrar paciente");
                System.out.println("2. Listar paciente");
                System.out.println("3. Importar pacientes de arquivo");
                System.out.println("4. Exportar pacientes para arquivo");
                System.out.println("5. Sair");
                System.out.println("--------------------");
                System.out.print("\n\tEscolha uma opção: ");
                opcao = leia.nextInt();

                leia.nextLine();

                switch (opcao) {
                    case 1 -> cadastrarPaciente(leia);
                    case 2 -> listarPacientes();
                    case 3 -> importarPacientes();
                    case 4 -> exportarPacientes();
                    case 5 -> System.out.println("\n\tSaindo...\n");
                    default -> System.out.println("\n\tOpção inválida.\n");
                }
            } catch (Exception e) {
                System.out.println("\n\tOpção inválida\n");
                leia = new Scanner(System.in);
            }
        } while (opcao != 5);
    }

    /**
     * Realiza o cadastro de um novo paciente no sistema.
     * As informações do paciente são solicitadas ao usuário e registradas no
     * repositório.
     * 
     * @param leia O objeto Scanner usado para ler as entradas do usuário.
     */
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

        try {
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
        } catch (Exception e) {
            System.out.println("\n\tErro ao cadastrar paciente.\n");
        }
    }

    /**
     * Exibe a lista de pacientes cadastrados no sistema.
     * Caso não haja pacientes, uma mensagem informando a ausência de registros é
     * exibida.
     */
    public void listarPacientes() {
        List<Paciente> pacientes = pacienteRepository.listar();
        try {
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
        } catch (Exception e) {
            System.out.println("\n\tErro ao listar pacientes.\n");
        }
    }

    /**
     * Exibe a lista de psicólogos cadastrados no sistema.
     * Caso não haja psicólogos, uma mensagem informando a ausência de registros é
     * exibida.
     */
    public void listarPsicologos() {
        List<Psicologo> psicologos = psicologoRepository.listar();
        try {
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
        } catch (Exception e) {
            System.out.println("\n\tErro ao listar psicólogos.\n");
        }
    }

    /**
     * Exporta a lista de pacientes cadastrados para um arquivo de texto.
     * O arquivo gerado contém todas as informações dos pacientes registrados no
     * sistema.
     */
    public void exportarPacientes() {
        try {
            List<Paciente> pacientes = pacienteRepository.listar();
            String diretorio = "../";
            String nomeArquivo = "pacientes.txt";

            PacienteExporter.exportarPacientesParaTxt(pacientes, nomeArquivo, diretorio);
        } catch (Exception e) {
            System.out.println("\n\tErro ao exportar pacientes.\n");
        }
    }

    /**
     * Verifica se um paciente com o CPF informado já existe no repositório.
     * 
     * @param cpf o CPF do paciente a ser verificado
     * @return {@code true} se o paciente com o CPF informado já existir no
     *         repositório, caso contrário {@code false}
     */
    private boolean pacienteJaExiste(String cpf) {
        try {
            return pacienteRepository.listar().stream()
                    .anyMatch(paciente -> paciente.getCpf().equals(cpf));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Importa pacientes a partir de um arquivo de texto e os adiciona ao
     * repositório,
     * caso não existam já no sistema.
     * 
     * O arquivo de texto deve estar localizado no diretório informado e o nome do
     * arquivo é
     * pré-definido como "pacientes.txt". Para cada paciente no arquivo, o método
     * verifica se o
     * paciente já está registrado no repositório antes de adicionar.
     * 
     * Após a importação, é exibida uma mensagem de sucesso na consola.
     */
    public void importarPacientes() {
        try {
            String nomeArquivo = "pacientes.txt";
            String diretorio = "../";

            for (Paciente novoPaciente : PacienteReader.lerPacientesDeTxt(nomeArquivo, diretorio)) {
                if (!pacienteJaExiste(novoPaciente.getCpf())) {
                    pacienteRepository.adicionar(novoPaciente);
                }
            }

            System.out.println("\n\tPaciente(s) importado(s) com sucesso!\n");
        } catch (Exception e) {
            System.out.println("\n\tErro ao importar pacientes.\n");
        }
    }
}