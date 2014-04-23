package classDependencies;

import java.util.ArrayList;
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
        ClassDependenciesEvaluator classDependencyEvaluator = new ClassDependenciesEvaluator();
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
                        "    public Expression build(Token token);\n" +
                        "}";
        ClassDependenciesEvaluator classDependencyEvaluator = new ClassDependenciesEvaluator();
        ArrayList<String> dependencies = classDependencyEvaluator.getDependencies(file);
        assertEquals(new ArrayList<String>(){{add("evaluator.Factory");}}, dependencies);       
    }
    
}
