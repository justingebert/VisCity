import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
}