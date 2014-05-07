package SortMethods;

import TwitterSearch.Tweet;
import java.util.Comparator;

public class SortByNumTweetsHour implements Comparator<Tweet> {
    @Override
    public int compare(Tweet t1, Tweet t2) {
        return Integer.parseInt(t2.getNumTweetsHour()) - Integer.parseInt(t1.getNumTweetsHour());
    }
}
