package trends;

import SortMethods.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import trend.relevantNames.ClassFrequencyTwitter;
import trend.relevantNames.QueryStat;

public class ClassFrequencyTwitterTest {
   @Test
    public void testTwitterClassCountSearch() {
        List<String> wordList = Arrays.asList("ULPGC", "Curry", "Gran Canaria", "Gato");
        ClassFrequencyTwitter frequecyTwitter = new ClassFrequencyTwitter();
        List<QueryStat> wordsFrequency = frequecyTwitter.getNumTweetsOfClasses(wordList);
        
        Collections.sort(wordsFrequency, new SortByNumTweetsYear());
        
        for (QueryStat tweet : wordsFrequency) {
            System.out.println("Word:" + tweet.getWord());
            System.out.println("FrequencyHour: " + tweet.getNumTweetsHour());
            System.out.println("FrequencyDay: " + tweet.getNumTweetsDay());
            System.out.println("FrequencyWeek: " + tweet.getNumTweetsWeek());
            System.out.println("FrequencyMonth: " + tweet.getNumTweetsMonth());
            System.out.println("FrequencyYear: " + tweet.getNumTweetsYear()+"\n");
        }
    }
}
