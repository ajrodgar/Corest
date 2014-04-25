package classDependencies;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class classDependenciesTest {
    
    public classDependenciesTest() {
    }
    
    @Test
    public void oneClassDependenciesTest(){
        String file = "package parser;\n" +
                        "\n" +
                        "import evaluator.Expression;\n" +
                        "\n" +
                        "public interface ExpressionFactory {\n" +
                        "    public Expression build(Token token);\n" +
                        "}";
        ProjectPackagesInformation packageInformationLoader = new ProjectPackagesInformation();
        ClassDependenciesEvaluator classDependencyEvaluator;
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses(), "ExpressionFactory.java");
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file);
        assertEquals(new ArrayList<String>(){{add("evaluator.Expression");}}, dependencies);       
    }
    
    @Test
    public void anotherClassDependenciesTest(){
        String file = "package parser;\n" +
                        "\n" +
                        "import evaluator.Factory;\n" +
                        "\n" +
                        "public interface ExpressionFactory {\n" +
                        "    public Factory build(Token token);\n" +
                        "}";
        ProjectPackagesInformation packageInformationLoader = new ProjectPackagesInformation();
        ClassDependenciesEvaluator classDependencyEvaluator;
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses(), "ExpressionFactory.java");
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file);
        assertEquals(new ArrayList<String>(){{add("evaluator.Factory");}}, dependencies);       
    }
    
    @Test
    public void dependenciesWithClassesInSamePackageTest(){
        String file = "package parser;\n" +
                        "\n" +
                        "public interface ExpressionFactory {\n" +
                        "    return new NewClass();"+
                        "}";
        ProjectPackagesInformation packageInformationLoader = new ProjectPackagesInformation();
        ClassDependenciesEvaluator classDependencyEvaluator;
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses(), "ExpressionFactory.java");
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file);
        assertEquals(new ArrayList<String>(){{add("parser.NewClass");}}, dependencies);
    }

    private class ProjectPackagesInformation {
        public ProjectPackagesInformation() {
            
        }
        
        public HashMap<String,String> loadClasses(){
            HashMap<String,String> projectClasses = new HashMap<>();
            projectClasses.put("parser.NewClass","parser");
            projectClasses.put("parser.ExpressionFactory","parser");
            return projectClasses;
        }
    }
}
