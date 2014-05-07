package TwitterSearch;

public class Tweet {
    private String Word;
    private String NumTweetsHour;
    private String NumTweetsDay;
    private String NumTweetsWeek;
    private String NumTweetsMonth;
    private String NumTweetsYear;

    public Tweet(String Word, String NumTweetsHour, String NumTweetsDay, String NumTweetsWeek, String NumTweetsMonth, String NumTweetsYear) {
        this.Word = Word;
        this.NumTweetsHour = NumTweetsHour;
        this.NumTweetsDay = NumTweetsDay;
        this.NumTweetsWeek = NumTweetsWeek;
        this.NumTweetsMonth = NumTweetsMonth;
        this.NumTweetsYear = NumTweetsYear;
    }

    public String getWord() {
        return Word;
    }

    public String getNumTweetsHour() {
        return NumTweetsHour;
    }

    public String getNumTweetsDay() {
        return NumTweetsDay;
    }

    public String getNumTweetsWeek() {
        return NumTweetsWeek;
    }

    public String getNumTweetsMonth() {
        return NumTweetsMonth;
    }

    public String getNumTweetsYear() {
        return NumTweetsYear;
    }

    public void setWord(String Word) {
        this.Word = Word;
    }

    public void setNumTweetsHour(String NumTweetsHour) {
        this.NumTweetsHour = NumTweetsHour;
    }

    public void setNumTweetsDay(String NumTweetsDay) {
        this.NumTweetsDay = NumTweetsDay;
    }

    public void setNumTweetsWeek(String NumTweetsWeek) {
        this.NumTweetsWeek = NumTweetsWeek;
    }

    public void setNumTweetsMonth(String NumTweetsMonth) {
        this.NumTweetsMonth = NumTweetsMonth;
    }

    public void setNumTweetsYear(String NumTweetsYear) {
        this.NumTweetsYear = NumTweetsYear;
    }


}
