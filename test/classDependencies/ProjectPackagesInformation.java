package classDependencies;

import java.util.HashMap;

class ProjectPackagesInformation {

    public ProjectPackagesInformation() {
    }

    public HashMap<String, String> loadClasses() {
        HashMap<String, String> projectClasses = new HashMap<>();
        projectClasses.put("parser.NewClass", "parser");
        projectClasses.put("parser.ExpressionFactory", "parser");
        projectClasses.put("evaluator.Factory", "evaluator");
        projectClasses.put("evaluator.Dictionary", "evaluator");
        return projectClasses;
    }
    
}
