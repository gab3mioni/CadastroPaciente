import java.util.Scanner;

public class CadastroPaciente {
    public static void main(String[] args) {

        PacienteRepository repository = new PacienteRepository();
        MenuCadastro menu = new MenuCadastro(repository);

        menu.exibirMenu();
    }
}