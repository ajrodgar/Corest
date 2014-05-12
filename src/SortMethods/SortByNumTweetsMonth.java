package SortMethods;

import trend.relevantNames.QueryStat;
import java.util.Comparator;

public class SortByNumTweetsMonth implements Comparator<QueryStat> {
    @Override
    public int compare(QueryStat t1, QueryStat t2) {
        return Integer.parseInt(t2.getNumTweetsMonth()) - Integer.parseInt(t1.getNumTweetsMonth());
    }
}
