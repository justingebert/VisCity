import java.util.ArrayList;

public class User {

    private int id;
    private String email;
    private String username;
    //maybe shoudlnt be here rather in db
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String email, String username, String password){
        setEmail(email);
        setUsername(username);
        setPassword(password);
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
