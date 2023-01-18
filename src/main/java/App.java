import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.*;
import java.util.Map;

import static spark.Spark.*;

//HALLO TEST TEST
//test for updateing branches when master is changed
public class App {

    public static ProjectController projects;

    //region useless
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
    //endregion
    public static void main(String[] args) {
        staticFileLocation("/public");

        //region manual data
        projects = new ProjectController(new ArrayList<>());

        Structure a = new Structure(223,12,333, 123,"black");
        Structure b = new Structure(12,124,22, 553,"blue");

        Project First = new Project(0,"Berlin", new ArrayList<>());
        First.projectStructures.add(a);
        First.projectStructures.add(b);

        Project Second = new Project(1,"Paris", new ArrayList<>());

        projects.add(First);
        projects.add(Second);

        StructureController controller = new StructureController(new ArrayList<>());
        //endregion

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "index");
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/myprojects", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Project> available = projects.projects;
            model.put("projects", available);
            ModelAndView modelAndView = new ModelAndView(model, "myprojects");
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/project/:projectid/editmode", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int projectid = Integer.parseInt(request.params(":projectid"));
            Project project = projects.getProject(projectid);
            List <Structure> structurelist = project.projectStructures;
            model.put("structures", structurelist);
            model.put("project",project);
            //System.out.println(structurelist.get(0).xCoordinate);
            return controller.loadStructures(model);
        }, new JadeTemplateEngine());

        get("/projectlist", (request, response) -> {
            ModelAndView modelAndView = projects.local();
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/project/:projectid/create", (req, res) ->{
            int projectid = Integer.parseInt(req.params(":projectid"));
            int width = Integer.parseInt(req.queryParams("width"));
            int height = Integer.parseInt(req.queryParams("height"));
            int xCoordinate = Integer.parseInt(req.queryParams("xCoordinate"));
            int yCoordinate = Integer.parseInt(req.queryParams("yCoordinate"));
            String type = req.queryParams("type");
            String backgroundColor = "";

            if (type.equals("building")) {
                backgroundColor = "blue";
            } else if (type.equals("greenSpace")) {
                backgroundColor = "green";
            } else if (type.equals("street")) {
                backgroundColor = "black";
            }

            Structure structure = new Structure(width, height, xCoordinate, yCoordinate, backgroundColor);
            Project project = projects.getProject(projectid);
            project.projectStructures.add(structure);
            List <Structure> structures = project.projectStructures;
            Map<String, Object> model = new HashMap<>();
            model.put("structures", structures);
            model.put("project", project);
            ModelAndView modelAndView = new ModelAndView(model, "editmode");

            return modelAndView;
        }, new JadeTemplateEngine());

        // speichert dann die structures liste, die aus dem structures controller in einem projekt ab
        //get("/save", projects.saveProject, new JadeTemplateEngine());

        //TODO use post?? res.redirrect -> /project/queryparameter:
        get("/createproject", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ModelAndView modelAndView = new ModelAndView(model, "createproject");
            return modelAndView;
        }, new JadeTemplateEngine());

        post("/createproject", (request, response) -> {
            String projectname = request.queryParams("projectname");
            int projectID = Integer.parseInt(request.queryParams("projectid"));
            Project project = new Project(projectID,projectname,new ArrayList<>());
            projects.add(project);
            response.redirect("project/"+projectID+"/editmode");
            return null;
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

