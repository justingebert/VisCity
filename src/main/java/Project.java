import java.util.Date;

public class Project {

    public User user;
    public Date dateCreated;
    public Date lastEdited;
    public Map map;

    public Project (User user, Date datenow){
        this.user = user;
        this.dateCreated = datenow;
        this.lastEdited = datenow;
    }


}
