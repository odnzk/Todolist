package services;

import model.Achievement;
import repository.impl.AchievementsDaoImpl;

public class AchievementService {
    private final AchievementsDaoImpl achievementsDao;

    public AchievementService(AchievementsDaoImpl achievementsDao) {
        this.achievementsDao = achievementsDao;
    }

    public void createAchievement(Achievement item){
       achievementsDao.insert(item);
    }

    public void deleteAchievementById(Achievement item){
        achievementsDao.delete(item);
    }

    public void findAchievementById(Achievement item){
        achievementsDao.select(item.getId());
    }

}
