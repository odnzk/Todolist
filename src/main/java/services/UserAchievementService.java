package services;

import model.Achievement;
import model.User;
import repository.impl.UserAchievementsDaoImpl;

import java.util.List;
import java.util.Optional;

public class UserAchievementService {
    private final UserAchievementsDaoImpl userAchievementsDao;

    public UserAchievementService(UserAchievementsDaoImpl userAchievementsDao) {
        this.userAchievementsDao = userAchievementsDao;
    }

    public void unlockAchievement(Long userId, Long achivId) {
        if (!userAchievementsDao.isAchievementUnlocked(achivId)) {
            userAchievementsDao.insert(userId, achivId);
        }
    }

    public Optional<List<Achievement>> findAllUserAchievements(User user) {
        return userAchievementsDao.findAllUserAchievements(user.getId());
    }

//    private boolean isAchievementUnlocked(Long achivId){
//        return userAchievementsDao.checkAchievement(achivId);
//    }

    public Optional<List<Achievement>> findAllAchievements() {
        return userAchievementsDao.findAllAchievements();
    }

}
