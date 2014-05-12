
package trends;

import SortMethods.SortByNumTweetsMonth;
import SortMethods.SortByNumTweetsYear;
import TwitterSearch.ClassFrequencyTwitter;
import TwitterSearch.QueryStats;
import java.util.Collections;
import java.util.List;

public class TrendyNames {
    
    private static String listFormatted(List<QueryStats> list) {
        String listFormatted = null;
        
        for (QueryStats queryStats : list) {
            listFormatted += queryStats.getWord() + ':' + queryStats.getNumTweetsMonth() + ',';
        }
        
        return listFormatted.substring(0, listFormatted.length() - 1);
    }
    
    public static String getList(List<String> classNames) {
        ApiClassNameTokenizer tokenizer = new ApiClassNameTokenizer();
        List<String> tokens = tokenizer.getTokens(classNames);
        
        ClassFrequencyTwitter frequecyTwitter = new ClassFrequencyTwitter();
        List<QueryStats> tokensFrequency = frequecyTwitter.getNumTweetsOfClasses(tokens);
        
        Collections.sort(tokensFrequency, new SortByNumTweetsMonth());
        
        return TrendyNames.listFormatted(tokensFrequency);
    }
}