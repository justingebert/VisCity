/**
 * Hello world!
 *
 */
import org.junit.jupiter.api.Test;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App 
{

    public static String test(){
        return "test";
    };


    public static String createBranch(){
        return "created";
    }

    public int getLength(ArrayList<Project> array){
        return  array.size();
    }

    /**
     * This function return the number of projects that have been created by a user
     *
     * @param user
     * @return number of created projects
     */
    public int numOfProjects(User user){
        return getLength(user.getProjects());
    }



    public static void main( String[] args )
    {
        port(20002);
        staticFileLocation("/public");
        /*staticFileLocation("/resources/public/css");
        staticFileLocation("/resources/public/img");*/

        get("/", (request, response) -> {
            long time = System.currentTimeMillis();
            Map<String, Object> model = new HashMap<>();
            model.put("mainpage", time);
            ModelAndView modelAndView = new ModelAndView(model, "mainpage");
            return modelAndView;
        }, new JadeTemplateEngine());

        get("/:user",(req,res) -> {
            String user = req.params(":user");
            Map<String, Object> model = new HashMap<>();
            model.put("mainpage", user);
            ModelAndView modelAndView = new ModelAndView(model, "mainpage");
            return modelAndView;
        },new JadeTemplateEngine());

    }
}

