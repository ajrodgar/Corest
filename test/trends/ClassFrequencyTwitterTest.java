package trends;

import SortMethods.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import trend.relevantNames.ClassFrequencyTwitter;
import trend.relevantNames.QueryHistogram;
import trend.relevantNames.QueryStat;

public class ClassFrequencyTwitterTest {
   @Test
    public void testGetNumTweetsOfClasses() {
        ClassFrequencyTwitter frequecyTwitter = new ClassFrequencyTwitter();
        List<QueryStat> wordsFrequency = frequecyTwitter
                .getNumTweetsOfClasses(Arrays.asList("ULPGC", "Curry", "Gran Canaria", "Gato"));
        
        Collections.sort(wordsFrequency, new SortByNumTweetsYear());
        
        for (QueryStat queryStat : wordsFrequency) {
            System.out.println("Word:" + queryStat.getWord());
            System.out.println("FrequencyHour: " + queryStat.getNumTweetsHour());
            System.out.println("FrequencyDay: " + queryStat.getNumTweetsDay());
            System.out.println("FrequencyWeek: " + queryStat.getNumTweetsWeek());
            System.out.println("FrequencyMonth: " + queryStat.getNumTweetsMonth());
            System.out.println("FrequencyYear: " + queryStat.getNumTweetsYear()+"\n");
        }
    }
   
    @Test
    public void testGetHistogramOfClasses() {
        ClassFrequencyTwitter frequecyTwitter = new ClassFrequencyTwitter();
        List<QueryHistogram> wordsFrequency = frequecyTwitter
                .getHistogramOfClasses(Arrays.asList("ULPGC", "Curry", "Gran Canaria", "Gato"));
        
        for (QueryHistogram queryHistogram : wordsFrequency) {
            System.out.println("Word:" + queryHistogram.getWord());
            System.out.println("Histogram: " + Arrays.toString(queryHistogram.getHistogram()));
        }
    }
}
