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

    /**
     * add project to projectlist
     * @param a project to add
     */
    public void add(Project a) {
        projects.add(a);
    }

    /**
     * @return number of projects
     */
    public int numOfProjects(){
        return this.projects.size();
    }

    /**
     * @param id takes the project id
     * @return returns the project of the given id
     */
    public Project getProject(int id){
        return this.projects.get(id);
    }

}
