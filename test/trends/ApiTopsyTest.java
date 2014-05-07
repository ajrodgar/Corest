package trends;

import com.maruti.otterapi.TopsyConfig;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApiTopsyTest {
    
    @Test
    public void testSearchCount() {
        TopsyConfig config = new TopsyConfig();
        config.setApiKey("09C43A9B270A470B8EB8F2946A9369F3");
        config.setSetProxy(false);
        config.setProxyHost("hydproxy.igate.com");
        config.setProxyPort("8080");
        
        String q1 = "Gran Canaria";
        String q2 = "Tenerife";
        ApiTopsy instance = new ApiTopsy();
        instance.searchCount(config, q1);
        instance.searchCount(config, q2);
    }

}
