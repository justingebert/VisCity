import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StructureController {
    public List<Structure> structures;

    public StructureController(List<Structure> structures) {
        this.structures = structures;
    }

    public TemplateViewRoute createStructure = (Request req, Response res) -> {

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
        structures.add(structure);

        Map<String, Object> model = new HashMap<>();
        model.put("structures", structures);
        ModelAndView modelAndView = new ModelAndView(model, "editmode");

        return modelAndView;
    };

}
