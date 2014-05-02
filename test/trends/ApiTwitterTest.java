
package trends;

import org.junit.Test;
import twitter4j.GeoLocation;

public class ApiTwitterTest {
    
    public ApiTwitterTest() {
    }
    
    @Test
    public void testNumTweets() throws Exception {
        System.out.print("numTweets: ");
        String q = "#HalaMadrid";
        String since = "2014-04-20";
        String until = "2014-05-02";
        GeoLocation geoLocation = new GeoLocation(28.113155, -15.440883);
        int radio = 50;
        ApiTwitter instance = new ApiTwitter();
        System.out.println(instance.numTweets(q, since, until, geoLocation, radio));
    }
    
}
