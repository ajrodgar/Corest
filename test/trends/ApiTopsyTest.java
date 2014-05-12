package trends;

import trend.relevantNames.ApiTopsy;
import com.maruti.otterapi.search.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApiTopsyTest {

    @Test
    public void testSearchCount() {
        ApiTopsy instance = new ApiTopsy();

        String query = "Gran Canaria";
        Response response = instance.searchCount(query);

        System.out.println("Number of tweets about \"" + query + "\" in the last:");
        System.out.println("Hour: " + response.getH());
        System.out.println("Day: " + response.getD());
        System.out.println("Week: " + response.getW());
        System.out.println("Month: " + response.getM());
        System.out.println("Year: " + response.getA());

    }

}
