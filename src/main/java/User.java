import java.util.ArrayList;

public class User {

    private String email;
    //maybe shoudlnt be here rather in db
    private String password;

    public ArrayList<Project> projects = new ArrayList();

    public User(String email,String password){

    }
}
