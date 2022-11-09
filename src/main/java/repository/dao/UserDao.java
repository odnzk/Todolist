package repository.dao;


import model.User;

import java.util.Optional;

public interface UserDao {
    void insert(User user);

    void delete(Long itemId);

    void update(User user);

    Optional<User> findUserByUsername(String username);
}
