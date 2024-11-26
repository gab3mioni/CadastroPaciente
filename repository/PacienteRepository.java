package repository;

import domain.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository implements InterfacePacienteRepository {

    private final List<Paciente> pacientes = new ArrayList<>();

    @Override
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return new ArrayList<>(pacientes);
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        return pacientes.stream()
                .filter(paciente -> paciente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getProximoId() {
        return pacientes.size() + 1;
    }

}