import java.util.ArrayList;

public class User {

    private String email;
    private String username;
    //maybe shoudlnt be here rather in db
    private String password;

    public User(String email,String username,String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public ArrayList<Project> projects = new ArrayList();

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void addProject(Project project){
        projects.add(project);
    }

    public void removeProject(Project project){
        projects.remove(project);
    }


}
