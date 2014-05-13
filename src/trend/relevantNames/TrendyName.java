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

    private static List<String> tokenize(List<String> classNames) {
        ApiClassNameTokenizer tokenizer = new ApiClassNameTokenizer();
        return tokenizer.getTokens(classNames);
    }

    public static String getList(List<String> classNames) {
        ClassFrequencyTwitter frequecyTwitter = new ClassFrequencyTwitter();
        List<QueryStat> tokensFrequency = frequecyTwitter.getNumTweetsOfClasses(tokenize(classNames));

        Collections.sort(tokensFrequency, new SortByNumTweetsMonth());

        return TrendyName.listFormatted(tokensFrequency);
    }

    private static void getHistogram(List<String> classNames) {
        List<String> tokens = tokenize(classNames);
    }
}
