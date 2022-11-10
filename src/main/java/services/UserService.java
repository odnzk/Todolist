package services;

import model.User;
import repository.dao.UserDao;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void updateUser(User user){
        userDao.update(user);
    }
}
