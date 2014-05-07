package TwitterSearch;

public class KeyWordTweets {
    private String Word;
    private int NumTweets;

    public KeyWordTweets(String Word, int NumTweets) {
        this.Word = Word;
        this.NumTweets = NumTweets;
    }

    public String getWord() {
        return Word;
    }

    public int getNumTweets() {
        return NumTweets;
    }

    public void setWord(String Word) {
        this.Word = Word;
    }

    public void setNumTweets(int NumTweets) {
        this.NumTweets = NumTweets;
    }
    
    
}
