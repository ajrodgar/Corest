package corest.rank;

import java.util.HashMap;

public class MostUsedClassesRanking {
    public static HashMap<String, Integer> getRanking(DependencyDictionary dictionary) {
        HashMap<String, Integer> ranking = new HashMap<>();
        ranking.put("TestClass", 1);
        return ranking;
    }
}
