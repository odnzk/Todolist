package services;

import exceptions.ConnectingDbException;
import exceptions.LoadingDbException;
import model.User;
import repository.UserDao;
import repository.impl.UserDaoImpl;
import util.PasswordEncoder;

import java.util.Objects;

public class SignUpService {
    private UserDao userDao = new UserDaoImpl();

    public boolean userAlreadyExist(User user) throws ConnectingDbException, LoadingDbException {
        return Objects.nonNull(userDao.findUserByUsername(user.getUsername()));
    }

    public void signUp(User user) throws LoadingDbException {
        PasswordEncoder passwordEncoder = new PasswordEncoder();
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userDao.insert(user);
    }

}
