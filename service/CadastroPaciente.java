package service;

import repository.PacienteRepository;
import ui.MenuCadastro;

public class CadastroPaciente {
    public static void main(String[] args) {

        PacienteRepository repository = new PacienteRepository();
        MenuCadastro menu = new MenuCadastro(repository);

        menu.exibirMenu();
    }
}