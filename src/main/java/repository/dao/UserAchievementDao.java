package repository.dao;


import model.Achievement;

import java.util.List;
import java.util.Optional;


public interface UserAchievementDao {
    Optional<List<Achievement>> findAllUserAchievements(long userId);

    Optional<List<Achievement>> findAllAchievements();

    boolean isAchievementUnlocked(Long achivId);
}
