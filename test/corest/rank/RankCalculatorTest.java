package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RankCalculatorTest {

    @Test
    public void calculateValueWhenClassHasNoDependencies() {
        RankCalculator calculator = new RankCalculator();
        assertEquals(0.15, calculator.calculate("AnotherTestClass", dictionary), 0.001);
    }

    @Test
    public void calculateValueWhenClassDependsOnOneClassWithNoDependencies() {
        RankCalculator calculator = new RankCalculator();
        assertEquals(0.2775, calculator.calculate("TestClass", dictionary), 0.001);
    }

    private DependencyDictionary dictionary = new DependencyDictionary() {

        @Override
        public HashMap<String, ArrayList<String>> getDependentClasses() {
            HashMap<String, ArrayList<String>> dependencies = new HashMap<>();
            final ArrayList<String> list = new ArrayList<>();
            list.add("AnotherTestClass");
            dependencies.put("AnotherTestClass", new ArrayList<>());
            dependencies.put("TestClass", list);
            return dependencies;
        }
    };
}
