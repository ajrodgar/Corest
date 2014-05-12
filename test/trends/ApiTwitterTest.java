
package trends;

import trend.relevantNames.ApiTwitter;
import org.junit.Test;

public class ApiTwitterTest {
    
    @Test
    public void testNumTweets() throws Exception {
        System.out.print("numTweets: ");
        String q = "Search";
        ApiTwitter instance = new ApiTwitter();
        System.out.println(instance.numTweets(q));
    }
    
}
