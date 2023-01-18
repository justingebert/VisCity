import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ProjectControllerTest {

    @Test
    void add() {
        ProjectController projects = new ProjectController(new ArrayList<>());
        Project project1 = new Project(0,"test1",new ArrayList<>());
        Project project2 = new Project(0,"test1",new ArrayList<>());
        projects.add(project1);
        projects.add(project2);
        assertEquals(2,projects.numOfProjects());
    }

    //@Test
    /*void getProjectByName() {
        ProjectController projects = new ProjectController(new ArrayList<>());
        Project project1 = new Project(0,"test1",new ArrayList<>());
        Project project2 = new Project(0,"tes21",new ArrayList<>());

        projects.add(project1);
        projects.add(project2);


        Structure a = new Structure(223,12,333, 123,"black");
        Structure b = new Structure(12,124,22, 553,"blue");


        Project First = new Project(0,"test", new ArrayList<>());
        First.projectStructures.add(a);
        First.projectStructures.add(b);

        Project Second = new Project(0,"test2", new ArrayList<>());

        projects.add(First);
        projects.add(Second);

        assertEquals("test1",projects.getProjectByName("test1").projectname);
    }*/
}