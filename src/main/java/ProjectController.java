import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import spark.template.jade.JadeTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class ProjectController {

    public List<Project> projects;

    public ProjectController(List<Project> projects) {
        this.projects = projects;
    }


    public static ModelAndView getProjects (Request req, Response res, User user) {

        Map<String, Object> model = new HashMap<>();
        model.put("projects", user.projects);
        ModelAndView modelAndView = new ModelAndView(model, "myprojects");

        return modelAndView;
    }

    /**
     * @return template with List of projects
     */
    public ModelAndView local() {

        Map<String, Object> model = new HashMap<>();
        List<Project> available = this.projects;
        model.put("projects", available);
        ModelAndView modelAndView = new ModelAndView(model, "projectList");
        return modelAndView;
    }



    public void add(Project a) {
        projects.add(a);
    }

    public int numOfProjects(){
        return this.projects.size();
    }

    public Project getProject(int id){
        return this.projects.get(id);
    }

    /*
    public TemplateViewRoute saveProject = (Request req, Response res) -> {

        Project projectToSave = new Project(123, "hansistadt", null);
        projects.add(null);

        Map<String, Object> model = new HashMap<>();
        model.put("projects", projects);
        ModelAndView modelAndView = new ModelAndView(model, "save");

        return modelAndView;
    };
    */

}
