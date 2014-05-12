package corest.projectanalyzer.javaprojectanalyzer.classdependency;



import java.util.HashMap;

public class ProjectPackagesInformation {

    public ProjectPackagesInformation() {
    }

    public HashMap<String, String> loadClasses() {
        HashMap<String, String> projectClasses = new HashMap<>();
        projectClasses.put("parser.NewClass", "parser");
        projectClasses.put("parser.ExpressionFactory", "parser");
        projectClasses.put("parser.TestClass", "parser");
        projectClasses.put("parser.AnotherTestClass", "parser");
        projectClasses.put("evaluator.Factory", "evaluator");
        projectClasses.put("evaluator.Dictionary", "evaluator");
        return projectClasses;
    }
    
}
