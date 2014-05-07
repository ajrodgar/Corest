package SortMethods;

import TwitterSearch.Tweet;
import java.util.Comparator;

public class SortByNumTweetsDay implements Comparator<Tweet> {
    @Override
    public int compare(Tweet t1, Tweet t2) {
        return Integer.parseInt(t2.getNumTweetsDay()) - Integer.parseInt(t1.getNumTweetsDay());
    }
}
