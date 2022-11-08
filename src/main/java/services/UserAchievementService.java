package services;

import model.Achievement;
import model.User;
import repository.impl.UserAchievementsDaoImpl;

public class UserAchievementService {
    private final UserAchievementsDaoImpl userAchievementsDao;

    public UserAchievementService(UserAchievementsDaoImpl userAchievementsDao) {
        this.userAchievementsDao = userAchievementsDao;
    }

    public void unlockAchievement(Achievement ach, User user) {
        userAchievementsDao.insert(user.getId(), ach.getId());
    }

    public void findAllUserAchievements(User user) {
        userAchievementsDao.findAllUserAchievements(user.getId());
    }

}
