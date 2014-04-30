
package trends;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import twitter4j.GeoLocation;

public class ApiTwitterTest {
    
    public ApiTwitterTest() {
    }
    
    @Test
    public void testNumTweets() throws Exception {
        System.out.print("numTweets: ");
        String q = "ULPGC";
        String since = "2014-04-20";
        String until = "2014-04-30";
        GeoLocation geoLocation = new GeoLocation(28.113155, -15.440883);
        int radio = 50;
        ApiTwitter instance = new ApiTwitter();
        System.out.println(instance.numTweets(q, since, until, geoLocation, radio));
    }
    
}
