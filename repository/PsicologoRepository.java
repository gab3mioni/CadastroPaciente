package repository;

import domain.Psicologo;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do repositório para gerenciar psicólogos.
 * Esta classe implementa as operações básicas de um repositório para entidades do tipo {@link Psicologo}.
 */
public class PsicologoRepository implements InterfaceRepository<Psicologo> {

    // Lista que armazena os psicólogos
    private final List<Psicologo> psicologos = new ArrayList<>();

    /**
     * Adiciona um psicólogo ao repositório.
     * 
     * @param psicologo O psicólogo a ser adicionado.
     */
    @Override
    public void adicionar(Psicologo psicologo) {
        psicologos.add(psicologo);
    }

    /**
     * Retorna uma lista com todos os psicólogos armazenados no repositório.
     * 
     * @return Uma lista com todos os psicólogos.
     */
    @Override
    public List<Psicologo> listar() {
        return new ArrayList<>(psicologos);
    }

    /**
     * Busca um psicólogo no repositório pelo seu ID.
     * 
     * @param id O ID do psicólogo a ser buscado.
     * @return O psicólogo correspondente ao ID fornecido, ou null se não encontrado.
     */
    @Override
    public Psicologo buscarPorId(int id) {
        return psicologos.stream()
                .filter(psicologo -> psicologo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Retorna o próximo ID disponível para um novo psicólogo.
     * O próximo ID é calculado com base no tamanho da lista de psicólogos.
     * 
     * @return O próximo ID disponível.
     */
    @Override
    public int getProximoId() {
        return psicologos.size() + 1;
    }

    /**
     * Retorna o primeiro nome do psicólogo a partir de seu nome completo.
     * 
     * @param nome O nome completo do psicólogo.
     * @return O primeiro nome do psicólogo.
     */
    @Override
    public String getPrimeiroNome(String nome) {
        return nome.split(" ")[0];
    }

    /**
     * Gera um novo login baseado no primeiro nome do psicólogo.
     * O login gerado é a versão em minúsculo do primeiro nome do psicólogo.
     * 
     * @param nome O nome completo do psicólogo.
     * @return O login gerado a partir do primeiro nome.
     */
    @Override
    public String getNewLogin(String nome) {
        String primeiroNome = getPrimeiroNome(nome);
        return primeiroNome.substring(0, 1).toLowerCase() + primeiroNome.substring(1);
    }
}
