package services;

import repository.UserDao;
import exceptions.LoadingDbException;
import model.User;

import java.util.Objects;

public class SignUpService {
    private UserDao userDao;

    // todo add exceptions when handling with sql queries
    public boolean userAlreadyExist(User user) {
        return Objects.nonNull(userDao.findUserByEmail(user.getEmail()))
                || Objects.nonNull(userDao.findUserByUsername(user.getUsername()));
    }

    public void signUp(User user) throws LoadingDbException {
        try {
            String password = passwordEncoder.encode(account.getPassword());

            account.setPassword(password);
            accountsRepository.save(account);
        } catch (DbException ex) {
            throw new LoadingDataException("Failed to load account's data", ex);
        }
    }

}
