package service;

import repository.InterfaceRepository;
import repository.PacienteRepository;
import repository.PsicologoRepository;
import domain.Psicologo;
import domain.Paciente;
import ui.Menu;

public class CadastroPaciente {
    public static void main(String[] args) {

        InterfaceRepository<Paciente> pacienteRepository = new PacienteRepository();
        InterfaceRepository<Psicologo> psicologoRepository = new PsicologoRepository();

        Menu menu = new Menu(pacienteRepository,
                psicologoRepository);

        Psicologo Janaina = new Psicologo(
                1,
                "Janaina",
                "janaina",
                "senhaTeste123@",
                "12345678",
                "TCC");

        psicologoRepository.adicionar(Janaina);

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

        menu.exibirLogin();
    }
}