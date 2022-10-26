package dao;


import models.Todo;
import models.User;

import java.util.List;
import java.util.Optional;

// CRUD
public interface UserDao extends GeneralDao<User>{
   Optional<User> findUserById(Long id); // todo + expceptions
   Optional<List<User>> getAllUsers(); // ???
}
