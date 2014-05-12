package trends;

import trend.relevantNames.TrendyName;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrendyNamesTest {
    
    public TrendyNamesTest() {
    }
    
    @Test
    public void testGetList() {
        List<String> listClass = new ArrayList();
        listClass.add("SortByNumTweetsDay");
        listClass.add("SortByNumTweetsHour");
        listClass.add("SortByNumTweetsMonth");
        listClass.add("SortByNumTweetsWeek");
        listClass.add("SortByNumTweetsYear");
        listClass.add("ClassFrequencyTwitter");
        listClass.add("QueryStats");
        
        String result = TrendyName.getList(listClass);
        System.out.println(result);
    }
    
}
