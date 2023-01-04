/**
 * Hello world!
 */

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.*;
import java.util.Map;

import static spark.Spark.*;

//HALLO TEST TEST
//test for updateing branches when master is changed
public class App {

    public static String test() {
        System.out.println("TTTTTT");
        return "test";
    }

    public static String createBranch() {
        return "created";
    }

    public int getLength(ArrayList<Project> array) {
        return array.size();
    }

    /**
     * This function return the number of projects that have been created by a user
     *
     * @param user user to count the projects of
     * @return number of created projects
     */
    public int numOfProjects(User user) {
        return 0;
    }


    public static void main(String[] args) {
        staticFileLocation("/public");

        //List<Project> projects = new LinkedList<>();
        ProjectController projects = new ProjectController(new LinkedList<>());

        Structure a = new Structure(223,12,333, 123,"black");
        Structure b = new Structure(12,124,22, 553,"blue");


        Project First = new Project(0,"test", new ArrayList<>());
        First.projectStructures.add(a);
        First.projectStructures.add(b);

        Project Second = new Project(0,"test2", new ArrayList<>());

        projects.add(First);
        projects.add(Second);

        //User user = new User("a.a@a.de", "username", "password", (List<Project>) projects);

        StructureController controller = new StructureController(new ArrayList<>());
        // ProjectController projects = new ProjectController(new ArrayList<>());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "index");
            return modelAndView;
        }, new JadeTemplateEngine());

        /*get("/projects", (request, response) -> {
            System.out.println("Get Projects called!");
            return ProjectController.getProjects(request, response, user);
        }, new JadeTemplateEngine());*/

        get("/myprojects", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Project> available = projects.projects;
            model.put("projects", available);
            ModelAndView modelAndView = new ModelAndView(model, "myprojects");
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/project/:projectid/editmode", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "editmode");
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/projectlist", (request, response) -> {
            ModelAndView modelAndView = projects.local();
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/create", controller.createStructure, new JadeTemplateEngine());

        // speichert dann die structures liste, die aus dem structures controller in einem projekt ab

        // get("/save", projects.saveProject, new JadeTemplateEngine());

        //use post??
        get("/createproject", (request, response) -> {
            Map<String, Object> model = new HashMap<>();

            String projectname = request.queryParams("projectname");
            Project project = new Project(1,projectname,new ArrayList<>());
            projects.add(project);
            ModelAndView modelAndView = new ModelAndView(model, "createproject");
            return modelAndView;
        }, new JadeTemplateEngine());


        get("/user/:user", (req, res) -> {
            String user2 = req.params(":user");
            Map<String, Object> model = new HashMap<>();
            model.put("index", user2);
            int g = 2;
            ModelAndView modelAndView = new ModelAndView(model, "landingpage");
            return modelAndView;
        }, new JadeTemplateEngine());
    }
}

