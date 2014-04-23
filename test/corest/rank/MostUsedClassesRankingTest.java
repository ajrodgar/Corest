package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MostUsedClassesRankingTest {
    
    @Test
    public void getMostUsedClassesRankingTest() {
        HashMap<String, Integer> ranking = MostUsedClassesRanking.getRanking(mockDictionary());
        Assert.assertEquals(new Integer(1), ranking.get("TestClass"));
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