package SortMethods;

import TwitterSearch.QueryStats;
import java.util.Comparator;

public class SortByNumTweetsWeek implements Comparator<QueryStats> {
    @Override
    public int compare(QueryStats t1, QueryStats t2) {
        return Integer.parseInt(t2.getNumTweetsWeek()) - Integer.parseInt(t1.getNumTweetsWeek());
    }
}
