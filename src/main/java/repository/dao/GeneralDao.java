package repository.dao;

// USER_DAO find user by email when user is logging in ( email : String ): Optional<User>
// USER_DAO insert <- registration
// USER_DAO update <- update project's list, +/ username
// USER_DAO delete <- ON_CASCADE with projects

// PROJECT_DAO find projects by id ( userId : Long ) : Optional<List<Project>>
// PROJECT_DAO insert <- add new project button
// PROJECT_DAO update <- update isCompleted, +/ title
// PROJECT_DAO delete <- ON_CASCADE with project's items

// PROJECT_ITEM_DAO find project item id ( projectId : Long) :   Optional<List<ProjectItem>>
// PROJECT_ITEM_DAO insert <- add new project item button
// PROJECT_ITEM_DAO update <- update isCompleted, +/ title
// PROJECT_ITEM_DAO delete <- NO_CHILD delete

// ACHIEVEMENTS_DAO WITHOUT GENERAL : update isUnlocked

