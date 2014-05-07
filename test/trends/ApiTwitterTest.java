
package trends;

import org.junit.Test;
import twitter4j.GeoLocation;

public class ApiTwitterTest {
    
    @Test
    public void testNumTweets() throws Exception {
        System.out.print("numTweets: ");
        String q = "Search";
        ApiTwitter instance = new ApiTwitter();
        System.out.println(instance.numTweets(q));
    }
    
}
