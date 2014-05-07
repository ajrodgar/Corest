package SortMethods;

import TwitterSearch.Tweet;
import java.util.Comparator;

public class SortByNumTweetsWeek implements Comparator<Tweet> {
    @Override
    public int compare(Tweet t1, Tweet t2) {
        return Integer.parseInt(t2.getNumTweetsWeek()) - Integer.parseInt(t1.getNumTweetsWeek());
    }
}
