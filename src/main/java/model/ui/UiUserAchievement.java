package model.ui;

import model.Achievement;

import java.util.Objects;

public class UiUserAchievement {
    private Achievement achievement;
    private Boolean unlocked;

    public UiUserAchievement(Achievement achievement, Boolean isUnlocked) {
        this.achievement = achievement;
        this.unlocked = isUnlocked;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    public Boolean getUnlocked() {
        return unlocked;
    }

    public void setUnlocked(Boolean unlocked) {
        this.unlocked = unlocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UiUserAchievement that = (UiUserAchievement) o;
        return Objects.equals(achievement, that.achievement) && Objects.equals(unlocked, that.unlocked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(achievement, unlocked);
    }

    @Override
    public String toString() {
        return "UiUserAchievement{" +
                "achievement=" + achievement +
                ", unlocked=" + unlocked +
                '}';
    }
}
