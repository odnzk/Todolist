package services;

import model.User;
import repository.dao.UserDao;
import repository.impl.UserDaoImpl;

public class UserService {
    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void updateUser(User user){
        userDao.update(user);
    }
}
