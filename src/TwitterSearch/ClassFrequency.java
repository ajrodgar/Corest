package TwitterSearch;

import java.util.ArrayList;
import java.util.List;

public class ClassFrequency {
    
    public List getNumTweetsOfClasses(){
        List<String> listWords = new ArrayList<>(); //Here I will use a method to get the keywords.
        List<KeyWordTweets> wordsFrequency = new ArrayList<>(); 
        
        for (String words : listWords) {
            int frequency = numTweets(words);
            KeyWordTweets WordTweets = new KeyWordTweets(words, frequency);
            for (int i = 0; i < wordsFrequency.size(); i++) {
                
            }
            wordsFrequency.add(WordTweets);
        }
        return wordsFrequency;
    }
}
