package SortMethods;

import trend.relevantNames.QueryStat;
import java.util.Comparator;

public class SortByNumTweetsHour implements Comparator<QueryStat> {
    @Override
    public int compare(QueryStat t1, QueryStat t2) {
        return Integer.parseInt(t2.getNumTweetsHour()) - Integer.parseInt(t1.getNumTweetsHour());
    }
}
