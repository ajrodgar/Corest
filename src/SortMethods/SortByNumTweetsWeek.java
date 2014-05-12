package SortMethods;

import trend.relevantNames.QueryStat;
import java.util.Comparator;

public class SortByNumTweetsWeek implements Comparator<QueryStat> {
    @Override
    public int compare(QueryStat t1, QueryStat t2) {
        return Integer.parseInt(t2.getNumTweetsWeek()) - Integer.parseInt(t1.getNumTweetsWeek());
    }
}
