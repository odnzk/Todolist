package services;

import model.ProjectItem;
import model.User;

import java.util.List;
import java.util.Optional;

public class UserAchievementServiceHelper {
    private static final long ACH_ID_PROJECT_FINISHED = 6;
    private static final long ACH_ID_TEN_PROJECT_ITEMS = 5;
    private static final long ACH_ID_FIRST_PROJECT_ITEM = 8;
    private static final long ACH_ID_FIRST_PROJECT = 2;
    private static final long ACH_ID_CLEAR_ALL = 9;
    private static final long ACH_ID_REMOVE_PROJECT = 10;
    private static final long ACH_ID_LOGIN = 1;


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
                userAchievementService.unlockAchievement(user.getId(), ACH_ID_PROJECT_FINISHED);
            }
        }
    }

    public void unlockTenProjectItemCreated(User user) {
        if (projectItemService.countAll().isPresent() || projectItemService.countAll().get() >= 5L) {
            userAchievementService.unlockAchievement(user.getId(), ACH_ID_TEN_PROJECT_ITEMS);
        }
    }

    public void unlockFirstProjectItemCreated(User user) {
        userAchievementService.unlockAchievement(user.getId(), ACH_ID_FIRST_PROJECT_ITEM);
    }

    public void unlockFirstProject(User user) {
        userAchievementService.unlockAchievement(user.getId(), ACH_ID_FIRST_PROJECT);
    }

    public void unlockClearAll(User user) {
        userAchievementService.unlockAchievement(user.getId(), ACH_ID_CLEAR_ALL);
    }

    public void unlockDeleteProject(User user) {
        userAchievementService.unlockAchievement(user.getId(), ACH_ID_REMOVE_PROJECT);
    }

    public void unlockLogin(Optional<User> user) {
        userAchievementService.unlockAchievement(user.get().getId(), ACH_ID_LOGIN);
    }
}
