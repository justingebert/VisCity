import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.*;
import java.util.Map;

import static spark.Spark.*;


public class App {

    public static ProjectController projects;

    /**
     * @param array projectlist
     * @return num of projects
     */
    public int getLength(ArrayList<Project> array) {
        return array.size();
    }
    /**
     * This function return the number of projects that have been created by a user
     *
     * @param user user to count the projects of
     * @return number of created projects from user
     */
    public int numOfProjects(User user) {
        return 0;
    }


    //endregion
    public static void main(String[] args) {
        staticFileLocation("/public");

        //region manual data
        projects = new ProjectController(new ArrayList<>());

        Structure s1 = new Structure(50,500,475, 50,"black");
        Structure s2 = new Structure(900,50,50,350,"black");

        Structure b1 = new Structure(250,300,22, 420,"blue");
        Structure b10 = new Structure(250,300,700, 420,"blue");


        Structure b2 = new Structure(150,150,22, 20,"blue");
        Structure b3 = new Structure(150,150,180, 20,"blue");
        Structure b4 = new Structure(310,150,22, 180,"blue");
        Structure b5 = new Structure(120,310,345, 20,"blue");

        Structure b6 = new Structure(120,310,540, 20,"blue");
        Structure b7 = new Structure(150,50,680, 20,"blue");
        Structure b8 = new Structure(150,50,680, 290,"blue");
        Structure b9 = new Structure(120,310,850, 20,"blue");




        Structure g1 = new Structure(200,400,265,420,"green");
        Structure g2 = new Structure(200,400,535,420,"green");
        Structure g3 = new Structure(300,150,325,600,"green");
        //Structure g4 = new Structure(150,180,680,90,"green");


        Project First = new Project(0,"Berlin", new ArrayList<>());
        First.projectStructures.add(s1);
        First.projectStructures.add(s2);
        First.projectStructures.add(b1);
        First.projectStructures.add(b2);
        First.projectStructures.add(b3);
        First.projectStructures.add(b4);
        First.projectStructures.add(b5);
        First.projectStructures.add(b6);
        First.projectStructures.add(b7);
        First.projectStructures.add(b8);
        First.projectStructures.add(b9);
        First.projectStructures.add(b10);
        First.projectStructures.add(g1);
        First.projectStructures.add(g2);
        First.projectStructures.add(g3);
        //First.projectStructures.add(g4);


        Project Second = new Project(1,"Paris", new ArrayList<>());

        projects.add(First);
        projects.add(Second);

        StructureController controller = new StructureController(new ArrayList<>());
        //endregion


        //* Routes
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

        get("/project/:projectid/create", (req, res) -> {
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
            List<Structure> structures = project.projectStructures;
            Map<String, Object> model = new HashMap<>();
            model.put("structures", structures);
            model.put("project", project);
            ModelAndView modelAndView = new ModelAndView(model, "editmode");

            return modelAndView;

        }, new JadeTemplateEngine());

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

        //! future features
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

