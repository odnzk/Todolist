package repository.dao;

import java.util.Optional;

public interface CrudDao<T> {
    void insert(T item);

    void delete(Long itemId);

    void update(T item);

    Optional<T> findItem(Long itemId);
}
