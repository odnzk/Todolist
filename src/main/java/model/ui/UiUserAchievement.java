package model.ui;

public class UiUserAchievement {
    private Long id;
    private String title;
    private Boolean isUnlocked;

    public UiUserAchievement(Long id, String title, Boolean isUnlocked) {
        this.id = id;
        this.title = title;
        this.isUnlocked = isUnlocked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(Boolean unlocked) {
        isUnlocked = unlocked;
    }
}
