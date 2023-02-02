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

    /**
     * @return list of structures in project
     */
    public List<Structure> getProjectStructures() {
        return projectStructures;
    }

    /**
     * load new structures into project
     * @param projectStructures list of Structures
     */
    public void setProjectStructures(List<Structure> projectStructures) {
        this.projectStructures = projectStructures;
    }

}
