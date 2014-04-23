package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostUsedClassesRanking {

    public static HashMap<String, Integer> getRanking(DependencyDictionary dictionary) {
        HashMap<String, Integer> ranking = new HashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : dictionary.getDependentClasses().entrySet()) {
            ranking.put(entry.getKey(), entry.getValue().size());
        }
        return ranking;
    }
}
