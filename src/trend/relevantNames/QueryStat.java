package trend.relevantNames;

public class QueryStat {

    private String word;
    private String numTweetsHour;
    private String numTweetsDay;
    private String numTweetsWeek;
    private String numTweetsMonth;
    private String numTweetsYear;

    public QueryStat(String Word, String NumTweetsHour, String NumTweetsDay, String NumTweetsWeek, String NumTweetsMonth, String NumTweetsYear) {
        this.word = Word;
        this.numTweetsHour = NumTweetsHour;
        this.numTweetsDay = NumTweetsDay;
        this.numTweetsWeek = NumTweetsWeek;
        this.numTweetsMonth = NumTweetsMonth;
        this.numTweetsYear = NumTweetsYear;
    }

    public String getWord() {
        return word;
    }

    public String getNumTweetsHour() {
        return numTweetsHour;
    }

    public String getNumTweetsDay() {
        return numTweetsDay;
    }

    public String getNumTweetsWeek() {
        return numTweetsWeek;
    }

    public String getNumTweetsMonth() {
        return numTweetsMonth;
    }

    public String getNumTweetsYear() {
        return numTweetsYear;
    }

    public void setWord(String Word) {
        this.word = Word;
    }

    public void setNumTweetsHour(String NumTweetsHour) {
        this.numTweetsHour = NumTweetsHour;
    }

    public void setNumTweetsDay(String NumTweetsDay) {
        this.numTweetsDay = NumTweetsDay;
    }

    public void setNumTweetsWeek(String NumTweetsWeek) {
        this.numTweetsWeek = NumTweetsWeek;
    }

    public void setNumTweetsMonth(String NumTweetsMonth) {
        this.numTweetsMonth = NumTweetsMonth;
    }

    public void setNumTweetsYear(String NumTweetsYear) {
        this.numTweetsYear = NumTweetsYear;
    }

}
