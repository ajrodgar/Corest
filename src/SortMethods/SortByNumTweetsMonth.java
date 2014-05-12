package SortMethods;

import TwitterSearch.QueryStats;
import java.util.Comparator;

public class SortByNumTweetsMonth implements Comparator<QueryStats> {
    @Override
    public int compare(QueryStats t1, QueryStats t2) {
        return Integer.parseInt(t2.getNumTweetsMonth()) - Integer.parseInt(t1.getNumTweetsMonth());
    }
}
