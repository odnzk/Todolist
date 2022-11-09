package repository.dao;


import model.Achievement;

public interface AchievementDao {
    void insert(Achievement item);

    void delete(Long itemId);

    void update(Achievement item);
}
