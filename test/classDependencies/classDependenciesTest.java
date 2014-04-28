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
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses());
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file, "parser.ExpressionFactory");
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
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses());
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file, "parser.ExpressionFactory");
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
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses());
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file, "parser.ExpressionFactory");
        assertEquals(new ArrayList<String>(){{add("parser.NewClass");}}, dependencies);
    }
    
    @Test
    public void allClassesInAPackageTest(){
        String file = "package parser;\n" +
                        "\n" +
                        "import evaluator.*;\n" +
                        "\n" +
                        "public interface ExpressionFactory {\n" +
                        "    public Factory build(Token token);\n" +
                        "}";
        ProjectPackagesInformation packageInformationLoader = new ProjectPackagesInformation();
        ClassDependenciesEvaluator classDependencyEvaluator;
        classDependencyEvaluator = new ClassDependenciesEvaluator(packageInformationLoader.loadClasses());
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file, "parser.ExpressionFactory");
        assertEquals(new ArrayList<String>(){{add("evaluator.Dictionary");add("evaluator.Factory");}}, dependencies);       
    }
    
}
