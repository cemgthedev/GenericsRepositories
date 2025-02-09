package app.types;

import java.util.List;

public interface CrudRepository<T> {
    String save(T entity);
    void update(String id, T entity);
    void delete(String id);
    T findById(String id);
    List<T> findAll();
}
