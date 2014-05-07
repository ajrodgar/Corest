package TwitterSearch;

import com.maruti.otterapi.search.Response;
import java.util.ArrayList;
import java.util.List;
import trends.ApiTopsy;

public class ClassFrequency {
    
    public List getNumTweetsOfClasses(){
        List<String> listWords = new ArrayList<>(); //Here I will use a method to get the keywords.
        List<Tweet> wordsFrequency = new ArrayList<>();
         ApiTopsy instance = new ApiTopsy();
        
        for (String words : listWords) {
            Response response = instance.searchCount(words);;
            Tweet tweets = new Tweet(words, response.getH(), response.getD(), response.getW(), response.getM(), response.getA());
            wordsFrequency.add(tweets);
        }
        return wordsFrequency;
    }
}
