package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RankCalculatorTest {
    
    @Test
    public void testValueRankCalculator() {
        RankCalculator calculator = new RankCalculator();
        assertEquals(0.15, calculator.calculate("AnotherTestClass", mockDictionary()), 0.001);
    }
    
    private DependencyDictionary mockDictionary() {
        DependencyDictionary dictionary = mock(DependencyDictionary.class);
        when(dictionary.getDependentClasses()).thenReturn(dependencies());
        return dictionary;
    }

    private HashMap<String, ArrayList<String>> dependencies() {
        HashMap<String, ArrayList<String>> dependencies = new HashMap<>();
        dependencies.put("AnotherTestClass", new ArrayList<>());
        dependencies.put("TestClass", list());
        return dependencies;
    }

    private static ArrayList<String> list() {
        final ArrayList<String> list = new ArrayList<>();
        list.add("AnotherTestClass");
        return list;
    }
}