/**
 * Hello world!
 *
 */

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import static spark.Spark.*;

//HALLO TEST TEST
//test for updateing branches when master is changed
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
     * @param user user to count the projects of
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

        path("/",() ->{
            post();
        });

        get("/", (request, response) -> {

            String username =
            System.out.println(username);
            Map<String, Object> model = new HashMap<>();
            model.put("login", username);
            ModelAndView modelAndView = new ModelAndView(model, "login");
            return modelAndView;
        }, new JadeTemplateEngine());


        get("/user/:id",(req,res) -> {
            String user = req.params(":id");
            Map<String, Object> model = new HashMap<>();
            model.put("index", user);
            int g = 2;
            ModelAndView modelAndView = new ModelAndView(model, "index");
            return modelAndView;
        },new JadeTemplateEngine());

    }
}

