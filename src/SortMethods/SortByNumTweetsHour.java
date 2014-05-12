package SortMethods;

import TwitterSearch.QueryStats;
import java.util.Comparator;

public class SortByNumTweetsHour implements Comparator<QueryStats> {
    @Override
    public int compare(QueryStats t1, QueryStats t2) {
        return Integer.parseInt(t2.getNumTweetsHour()) - Integer.parseInt(t1.getNumTweetsHour());
    }
}
