/**
 * Hello world!
 *
 */

import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

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
            int g = 2;
            ModelAndView modelAndView = new ModelAndView(model, "mainpage");
            return modelAndView;
        },new JadeTemplateEngine());

    }
}

