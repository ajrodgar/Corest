package corest.rank;

import corest.classdependenciesevaluator.ClassDependenciesEvaluator;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class RankCalculatorTest {

    private static ClassDependenciesEvaluator evaluator;
    private final String anotherTestClass = "package corest.rank;\n"
            + "\n"
            + "public class AnotherTestClass {\n"
            + "}\n"
            + "";
    private final String testClass = "package corest.rank;\n"
            + "\n"
            + "public class Trim {\n"
            + "    \n"
            + "    private AnotherTestClass object;\n"
            + "}\n"
            + "";
    
    @BeforeClass
    public static void setUpClass() {
        HashMap<String, String> map = new HashMap<>();
        map.put("corest.rank.AnotherTestClass", "corest.rank");
        map.put("corest.rank.Trim", "corest.rank");
        evaluator = new ClassDependenciesEvaluator(map);
    }

    @Test
    public void calculateValueWhenClassHasNoDependencies() {
        RankCalculator calculator = new RankCalculator(fakeProject(), evaluator);
        assertEquals(0.15, calculator.calculate("corest.rank.AnotherTestClass"), 0.001);
    }

    @Test
    public void calculateValueWhenClassDependsOnOneClassWithNoDependencies() {
        RankCalculator calculator = new RankCalculator(fakeProject(), evaluator);
        assertEquals(0.2775, calculator.calculate("corest.rank.Trim"), 0.001);
    }
    
    private HashMap<String, String> fakeProject() {
        HashMap<String, String> project = new HashMap<>();
        project.put("corest.rank.AnotherTestClass", anotherTestClass);
        project.put("corest.rank.Trim", testClass);
        return project;
    }
}
