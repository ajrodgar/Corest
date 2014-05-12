package SortMethods;

import TwitterSearch.QueryStats;
import java.util.Comparator;

public class SortByNumTweetsYear implements Comparator<QueryStats> {
    @Override
    public int compare(QueryStats t1, QueryStats t2) {
        return Integer.parseInt(t2.getNumTweetsYear()) - Integer.parseInt(t1.getNumTweetsYear());
    }
}
