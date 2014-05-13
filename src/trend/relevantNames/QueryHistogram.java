
package trend.relevantNames;

public class QueryHistogram {
    
    private String word;
    private int[] histogram;

    public QueryHistogram(String word, int[] histogram) {
        this.word = word;
        this.histogram = histogram;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int[] getHistogram() {
        return histogram;
    }

    public void setHistogram(int[] histogram) {
        this.histogram = histogram;
    }
    
}
