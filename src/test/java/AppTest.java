import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void getLength() {
        App app = new App();
        User u1 = new User("test@test.com","bernd","1234");
        Project p1 = new Project(u1,new Date());
        Project p2 = new Project(u1,new Date());
        u1.addProject(p1);
        u1.addProject(p2);
        assertEquals(2,app.getLength(u1.projects));
    }
}