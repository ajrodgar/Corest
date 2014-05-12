
package trend.relevantNames;

import SortMethods.SortByNumTweetsMonth;
import java.util.Collections;
import java.util.List;

public class TrendyName {
    
    private static String listFormatted(List<QueryStat> list) {
        String listFormatted = "";
        
        for (QueryStat queryStats : list) {
            listFormatted += queryStats.getWord() + ":" + queryStats.getNumTweetsMonth() + ",";
        }
        
        return listFormatted.substring(0, listFormatted.length() - 1);
    }
    
    public static String getList(List<String> classNames) {
        ApiClassNameTokenizer tokenizer = new ApiClassNameTokenizer();
        List<String> tokens = tokenizer.getTokens(classNames);
        
        ClassFrequencyTwitter frequecyTwitter = new ClassFrequencyTwitter();
        List<QueryStat> tokensFrequency = frequecyTwitter.getNumTweetsOfClasses(tokens);
        
        Collections.sort(tokensFrequency, new SortByNumTweetsMonth());
        
        return TrendyName.listFormatted(tokensFrequency);
    }
}