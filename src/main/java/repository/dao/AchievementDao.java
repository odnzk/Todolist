package repository.dao;


import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import model.User;

import java.util.Optional;

// CRUD
public interface AchievementDao extends GeneralDao<User>{
   Optional<User> findUserByUsername(String username) throws ConnectingDbException, LoadingDbException;
}