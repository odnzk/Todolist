package services;

import model.ProjectItem;
import model.User;

import java.util.List;
import java.util.Optional;

public class UserAchievementServiceHelper {
    private final ProjectItemService projectItemService;
    private final UserAchievementService userAchievementService;

    public UserAchievementServiceHelper(ProjectItemService projectItemService, UserAchievementService userAchievementService) {
        this.projectItemService = projectItemService;
        this.userAchievementService = userAchievementService;
    }

    public void unlockProjectFinished(User user, Long projectItemId) {
        // if all linked projectItem if completed -> update project
        Optional<List<ProjectItem>> list = projectItemService.findProjectLinkedToProject(projectItemId);
        if (list.isPresent()) {
            if (list.get().stream().allMatch(ProjectItem::isDone)) {
                userAchievementService.unlockAchievement(user.getId(), 6L);
            }
        }
    }

    public void unlockTenProjectItemCreated(User user) {
        if (projectItemService.countAll().isPresent() || projectItemService.countAll().get() >= 5L) {
            userAchievementService.unlockAchievement(user.getId(), 10L);
        }
    }

    public void unlockFirstProjectItemCreated(User user) {
        userAchievementService.unlockAchievement(user.getId(), 8L);
    }

    public void unlockFirstProject(User user) {
        userAchievementService.unlockAchievement(user.getId(), 2L);
    }

    public void unlockClearAll(User user) {
        userAchievementService.unlockAchievement(user.getId(), 9L);
    }

    public void unlockDeleteProject(User user) {
        userAchievementService.unlockAchievement(user.getId(), 9L);
    }

    public void unlockLogin(Optional<User> user) {
        userAchievementService.unlockAchievement(user.get().getId(), 1L);
    }
}
