package app.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Logger;

public class InMemoryRepository<T> implements CrudRepository<T> {
    private static final Logger logger = Logger.getLogger(InMemoryRepository.class.getName());
    private final Map<String, T> storage = new HashMap<>();
    
    /*
     * Função que lança exceção para entidades não encontradas e pode ser reutilizada
     * em outros métodos que fazem uma busca de entidade por id.
    */
    private void throwNotFoundException(String id) {
        logger.warning("Entidade com id " + id + " não encontrada.");
        throw new NoSuchElementException("Entidade com id " + id + " não encontrada.");
    }

    /*
     * Função que implementa o método save da interface CrudRepository.
     * Este método adiciona uma nova entidade ao storage que consiste em
     * um Map cuja chave é um id aleatório e o valor a entidade.
     * Obs: retorna o id gerado para atualizar a entidade posteriormente
     * caso o usuário deseje guardar o id gerado na própria entidade.
     */
    @Override
    public String save(T entity) {
        final String id = UUID.randomUUID().toString();
        storage.put(id, entity);
        logger.info("Entidade com id " + id + " adicionada ao armazenamento.");

        return id;
    }

    /*
     * Função que implementa o método update da interface CrudRepository.
     * Este método atualiza uma entidade no storage que consiste em
     * um Map cuja chave é o id da entidade e o valor a entidade.
    */
    @Override
    public void update(String id, T entity) {
        if (storage.containsKey(id)) {
            storage.put(id, entity);
            logger.info("Entidade com id " + id + " atualizada no armazenamento.");
        } else {
            this.throwNotFoundException(id);
        }
    }

    /*
     * Função que implementa o método delete da interface CrudRepository.
     * Este método remove uma entidade do storage que consiste em
     * um Map cuja chave é o id da entidade e o valor a entidade.
     */
    @Override
    public void delete(String id) {
        if (storage.containsKey(id)) {
            storage.remove(id);
            logger.info("Entidade com id " + id + " removida do armazenamento.");
        } else {
            this.throwNotFoundException(id);
        }
    }

    @Override
    public T findById(String id) {
        if (storage.containsKey(id)) {
            logger.info("Entidade com id " + id + " encontrada no armazenamento.");
            return storage.get(id);
        } else {
            return null;
        }
    }

    @Override
    public List<T> findAll() {
        if(storage.isEmpty()) {
            logger.info("Armazenamento vazio.");
            return new ArrayList<>();
        } else {
            logger.info("Armazenamento contendo " + storage.size() + " entidades.");
            return new ArrayList<>(storage.values());
        }
    }
}