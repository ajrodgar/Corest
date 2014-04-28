package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RankCalculatorTest {

    private final String anotherTestClass = "package corest.rank;\n"
            + "\n"
            + "public class AnotherTestClass {\n"
            + "}\n"
            + "";
    private final String testClass = "package corest.rank;\n"
            + "\n"
            + "public class TestClass {\n"
            + "    \n"
            + "    private AnotherTestClass object;\n"
            + "}\n"
            + "";

    @Test
    public void calculateValueWhenClassHasNoDependencies() {
        RankCalculator calculator = new RankCalculator(fakeProject(), mockDictionary());
        assertEquals(0.15, calculator.calculate("corest.rank.AnotherTestClass"), 0.001);
    }

    @Test
    public void calculateValueWhenClassDependsOnOneClassWithNoDependencies() {
        RankCalculator calculator = new RankCalculator(fakeProject(), mockDictionary());
        assertEquals(0.2775, calculator.calculate("corest.rank.TestClass"), 0.001);
    }
    
    private HashMap<String, String> fakeProject() {
        HashMap<String, String> project = new HashMap<>();
        project.put("corest.rank.AnotherTestClass", anotherTestClass);
        project.put("corest.rank.TestClass", testClass);
        return project;
    }

    private DependencyDictionary mockDictionary() {
        DependencyDictionary dictionary = mock(DependencyDictionary.class);
        when(dictionary.getDependentClasses(anotherTestClass, "corest.rank.AnotherTestClass")).thenReturn(new ArrayList<>());
        when(dictionary.getDependentClasses(testClass, "corest.rank.TestClass")).thenReturn(dependencies());
        return dictionary;
    }

    private ArrayList<String> dependencies() {
        ArrayList<String> list = new ArrayList<>();
        list.add("AnotherTestClass");
        return list;
    }
}
