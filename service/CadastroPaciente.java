package service;

import repository.InterfaceRepository;
import repository.PacienteRepository;
import repository.PsicologoRepository;
import domain.Psicologo;
import domain.Paciente;
import ui.Menu;

/**
 * Classe principal responsável pelo cadastro de pacientes e psicólogos.
 * Este serviço gerencia a criação e cadastro de psicólogos e pacientes nos
 * repositórios
 * e exibe o menu de login para o usuário.
 */
public class CadastroPaciente {

        /**
         * Método principal que inicializa os repositórios, cria objetos de
         * {@link Psicologo}
         * e {@link Paciente}, adiciona-os aos respectivos repositórios e exibe o menu
         * de login.
         */
        public static void main(String[] args) {

                // Criação dos repositórios para pacientes e psicólogos
                InterfaceRepository<Paciente> pacienteRepository = new PacienteRepository();
                InterfaceRepository<Psicologo> psicologoRepository = new PsicologoRepository();

                // Criação e exibição do menu
                Menu menu = new Menu(pacienteRepository, psicologoRepository);

                // Criação de um psicólogo e adição ao repositório
                Psicologo Janaina = new Psicologo(
                                1,
                                "Janaina",
                                "janaina",
                                "senhaTeste123@",
                                "12345678",
                                "TCC");

                psicologoRepository.adicionar(Janaina);

                // Criação de um paciente e adição ao repositório
                Paciente Joao = new Paciente(
                                1,
                                "João",
                                "joao_login",
                                "Senha@123",
                                "12345678910",
                                "123456789",
                                "11912345678",
                                "Professor",
                                "Ensino Superior",
                                "Física",
                                "Carlos",
                                "Maria",
                                "Paciente com boa saúde.",
                                true);

                pacienteRepository.adicionar(Joao);

                // Exibe o menu de login
                menu.exibirLogin();
        }
}
