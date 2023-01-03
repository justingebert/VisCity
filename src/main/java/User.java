import java.util.ArrayList;
import java.util.List;

public class User {

    private String email;
    private String username;
    private String password;
    public List<Project> projects;


    /**
     * @param email    (String)
     * @param username (String)
     * @param password (String)
     */
    public User(String email, String username, String password, List<Project> projects) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }
}
