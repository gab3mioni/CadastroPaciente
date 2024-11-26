import java.util.List;

public interface InterfacePacienteRepository {
    void adicionarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
    Paciente buscarPacientePorId(int id);
    int getProximoId();
}