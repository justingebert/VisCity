import java.util.List;

public class Project {
    public int id;

    public String projectname;
    public List<Structure> projectStructures;

    public Project(int id,String projectname, List<Structure> projectStructures) {
        this.id = id;
        this.projectname = projectname;
        this.projectStructures = projectStructures;
    }

    public List<Structure> getProjectStructures() {
        return projectStructures;
    }

    public void setProjectStructures(List<Structure> projectStructures) {
        this.projectStructures = projectStructures;
    }


    /*public User user;
    public Date dateCreated;
    public Date lastEdited;

    public Project (User user, Date datenow){
        this.user = user;
        this.dateCreated = datenow;
        this.lastEdited = datenow;
    }*/

}
