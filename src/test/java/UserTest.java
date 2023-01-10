import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getUserInfo() {
        ProjectController projectController = new ProjectController(new ArrayList<>());
        User user1 = new User("1","2","3",projectController);
        assertEquals("2, 1, 3",user1.getUserInfo());
    }

    @Test
    void addProject() {
    }

    @Test
    void removeProject() {
    }
}