package repository;

import java.util.List;

public interface InterfaceRepository<T> {
    void adicionar(T entidade);
    List<T> listar();
    T buscarPorId(int id);
    int getProximoId();
    String getPrimeiroNome(String nome);
    String getNewLogin(String nome);
}