import java.util.List;

public class User {

    private String email;
    private String username;
    private String password;
    public ProjectController projectsController;


    /**
     * @param email    (String)
     * @param username (String)
     * @param password (String)
     */
    public User(String email, String username, String password, ProjectController projectController) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.projectsController = projectController;
    }

    public String getUserInfo(){
        //String s = this.username + ", " + this.email + ", " + this.password;
        return null;
    }   

    public List<Project> getProjects() {
        return projectsController.projects;
    }

    public void addProject(Project project) {
        projectsController.add(project);
    }

    public void removeProject(Project project) {
        projectsController.projects.remove(project);
    }
}
