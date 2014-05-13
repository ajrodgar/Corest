package trend.relevantNames;

import com.maruti.otterapi.search.Response;
import java.util.ArrayList;
import java.util.List;
import trend.relevantNames.ApiTopsy;

public class ClassFrequencyTwitter {
    
    public List getNumTweetsOfClasses(List<String> listWords){
        List<QueryStat> wordsFrequency = new ArrayList<>();
        ApiTopsy instance = new ApiTopsy();
        
        for (String word : listWords) {
            Response response = instance.searchCount(word);
            QueryStat queryStats = new QueryStat(word, response.getH(), response.getD(), response.getW(), response.getM(), response.getA());
            wordsFrequency.add(queryStats);
        }
        return wordsFrequency;
    }
    
    public List getHistogramOfClasses(List<String> listWords){
        List<QueryHistogram> wordsHistograms = new ArrayList<>();
        ApiTopsy instance = new ApiTopsy();
        
        for (String word : listWords) {
            com.maruti.otterapi.searchhistogram.Response response = instance.searchHistogram(word);
            QueryHistogram queryHistogram = new QueryHistogram(word, response.getHistogram());
            wordsHistograms.add(queryHistogram);
        }
        return wordsHistograms;
    }
}
