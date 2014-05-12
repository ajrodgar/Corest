
package trends;

import trend.relevantNames.ApiGoogleTrends;
import java.util.List;
import org.junit.Test;

public class ApiGoogleTrendsTest {
    
    @Test
    public void testGetTopCities() throws Exception {
        System.out.println("getTopCities");
        String query = "Action games";
        ApiGoogleTrends instance = new ApiGoogleTrends();
        List <String[]> list = instance.getTopCities(query);
        
        for (String[] l : list) {
            System.out.println(l[0] + ": " + l[1]);
        }
        
    }
    
}
