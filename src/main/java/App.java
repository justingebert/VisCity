/**
 * Hello world!
 *
 */
//import org.junit.jupiter.api.Test;
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App 
{

    /**
     * @return a generic string to test the app tester
     */
    public static String test(){
        return "it works";
    };

    /**
     *
     * @param
     */
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

        User Frank = new User("Frank@aol.com", "Frank123", "LolaFr123");
    }
}

