import spark.ModelAndView;

import java.util.List;
import java.util.Map;

public class StructureController {
    public List<Structure> structures;

    public StructureController(List<Structure> structures) {
        this.structures = structures;
    }

    /**
     * pass the structure variables to the jade template
     * @param model hashmap of variables
     * @return jade template with variables
     */
    public ModelAndView loadStructures(Map<String, Object> model){
        Map<String, Object> modelput = model;
        ModelAndView modelAndView = new ModelAndView(modelput, "editmode");
        return modelAndView;
    };

}
