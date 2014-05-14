package SortMethods;

import java.util.Comparator;
import trend.relevantNames.QueryHistogram;
import trend.relevantNames.QueryHistogramLinearRegression;

public class SortByTrend implements Comparator<QueryHistogram> {
    @Override
    public int compare(QueryHistogram t1, QueryHistogram t2) {
        QueryHistogramLinearRegression linearRegression = new QueryHistogramLinearRegression();
        return (int) (linearRegression.getSlope(t2) - linearRegression.getSlope(t1));
    }
}
