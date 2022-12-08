/**
 * Hello world!
 *
 */
import spark.ModelAndView;
import spark.template.jade.JadeTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App 
{
    public static void main( String[] args )
    {
        port(8080);
        get("/", (request, response) -> {
            long time = System.currentTimeMillis();
            Map<String, Object> model = new HashMap<>();
            model.put("mainpage", time);
            ModelAndView modelAndView = new ModelAndView(model, "mainpage");
            return modelAndView;
        }, new JadeTemplateEngine());


    }
}

