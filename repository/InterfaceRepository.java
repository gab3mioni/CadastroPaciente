package repository;

import java.util.List;

/**
 * Interface genérica que define as operações básicas de um repositório para gerenciamento de entidades.
 * 
 * @param <T> O tipo da entidade a ser manipulada no repositório.
 */
public interface InterfaceRepository<T> {

    /**
     * Adiciona uma nova entidade ao repositório.
     * 
     * @param entidade A entidade a ser adicionada ao repositório.
     */
    void adicionar(T entidade);

    /**
     * Retorna uma lista contendo todas as entidades armazenadas no repositório.
     * 
     * @return Uma lista de todas as entidades no repositório.
     */
    List<T> listar();

    /**
     * Busca uma entidade no repositório com base no seu ID.
     * 
     * @param id O ID da entidade a ser buscada.
     * @return A entidade correspondente ao ID fornecido, ou null se não encontrada.
     */
    T buscarPorId(int id);

    /**
     * Retorna o próximo ID disponível para uma nova entidade no repositório.
     * 
     * @return O próximo ID disponível.
     */
    int getProximoId();

    /**
     * Retorna o primeiro nome que corresponde ao nome fornecido, se disponível.
     * 
     * @param nome O nome a ser buscado.
     * @return O primeiro nome correspondente ao parâmetro fornecido, ou null se não encontrado.
     */
    String getPrimeiroNome(String nome);

    /**
     * Retorna um novo login baseado no nome fornecido.
     * 
     * @param nome O nome a ser utilizado para gerar um novo login.
     * @return Um novo login gerado a partir do nome fornecido.
     */
    String getNewLogin(String nome);
}
