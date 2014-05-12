package TwitterSearch;

import com.maruti.otterapi.search.Response;
import java.util.ArrayList;
import java.util.List;
import trends.ApiTopsy;

public class ClassFrequencyTwitter {
    
    public List getNumTweetsOfClasses(List<String> listWords){
        List<QueryStats> wordsFrequency = new ArrayList<>();
        ApiTopsy instance = new ApiTopsy();
        
        for (String word : listWords) {
            Response response = instance.searchCount(word);
            QueryStats queryStats = new QueryStats(word, response.getH(), response.getD(), response.getW(), response.getM(), response.getA());
            wordsFrequency.add(queryStats);
        }
        return wordsFrequency;
    }
}
