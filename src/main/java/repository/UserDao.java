package repository;


import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import model.User;

import java.util.List;
import java.util.Optional;

// CRUD
public interface UserDao extends GeneralDao<User>{
   Optional<User> findUserByUsername(String username) throws ConnectingDbException, LoadingDbException;
}
