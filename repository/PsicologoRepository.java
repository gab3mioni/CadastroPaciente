package repository;

import domain.Psicologo;

import java.util.ArrayList;
import java.util.List;

public class PsicologoRepository implements InterfaceRepository<Psicologo> {

    private final List<Psicologo> psicologos = new ArrayList<>();

    @Override
    public void adicionar(Psicologo psicologo) {
        psicologos.add(psicologo);
    }

    @Override
    public List<Psicologo> listar() {
        return new ArrayList<>(psicologos);
    }

    @Override
    public Psicologo buscarPorId(int id) {
        return psicologos.stream()
                .filter(psicologo -> psicologo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getProximoId() {
        return psicologos.size() + 1;
    }

    @Override
    public String getPrimeiroNome(String nome) {
        return nome.split(" ")[0];
    }
    
    @Override
    public String getNewLogin(String nome) {
        String primeiroNome = getPrimeiroNome(nome);
        return primeiroNome.substring(0, 1).toLowerCase() + primeiroNome.substring(1);
    }
}
