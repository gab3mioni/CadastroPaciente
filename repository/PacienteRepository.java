package repository;

import domain.Paciente;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do repositório para gerenciar pacientes.
 * Esta classe implementa as operações básicas de um repositório para entidades do tipo {@link Paciente}.
 */
public class PacienteRepository implements InterfaceRepository<Paciente> {

    // Lista que armazena os pacientes
    private final List<Paciente> pacientes = new ArrayList<>();

    /**
     * Adiciona um paciente ao repositório.
     * 
     * @param paciente O paciente a ser adicionado.
     */
    @Override
    public void adicionar(Paciente paciente) {
        pacientes.add(paciente);
    }

    /**
     * Retorna uma lista com todos os pacientes armazenados no repositório.
     * 
     * @return Uma lista com todos os pacientes.
     */
    @Override
    public List<Paciente> listar() {
        return new ArrayList<>(pacientes);
    }

    /**
     * Busca um paciente no repositório pelo seu ID.
     * 
     * @param id O ID do paciente a ser buscado.
     * @return O paciente correspondente ao ID fornecido, ou null se não encontrado.
     */
    @Override
    public Paciente buscarPorId(int id) {
        return pacientes.stream()
                .filter(paciente -> paciente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retorna o próximo ID disponível para um novo paciente.
     * O próximo ID é calculado com base no tamanho da lista de pacientes.
     * 
     * @return O próximo ID disponível.
     */
    @Override
    public int getProximoId() {
        return pacientes.size() + 1;
    }

    /**
     * Retorna o primeiro nome do paciente a partir de seu nome completo.
     * 
     * @param nome O nome completo do paciente.
     * @return O primeiro nome do paciente.
     */
    @Override
    public String getPrimeiroNome(String nome) {
        return nome.split(" ")[0];
    }

    /**
     * Gera um novo login baseado no primeiro nome do paciente.
     * O login gerado é a versão em minúsculo do primeiro nome do paciente.
     * 
     * @param nome O nome completo do paciente.
     * @return O login gerado a partir do primeiro nome.
     */
    @Override
    public String getNewLogin(String nome) {
        String primeiroNome = getPrimeiroNome(nome);
        return primeiroNome.substring(0, 1).toLowerCase() + primeiroNome.substring(1);
    }
}
