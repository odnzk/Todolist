package model.ui;

import model.Achievement;

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
}
