package trend.relevantNames;

import com.maruti.otterapi.Otter4JavaException;
import com.maruti.otterapi.TopsyConfig;
import com.maruti.otterapi.search.Response;
import com.maruti.otterapi.search.SearchCount;
import com.maruti.otterapi.search.SearchResponse;

public class ApiTopsy {

    private final TopsyConfig config = new TopsyConfig();

    public ApiTopsy() {
        config.setApiKey("09C43A9B270A470B8EB8F2946A9369F3");
        config.setSetProxy(false);
        config.setProxyHost("hydproxy.igate.com");
        config.setProxyPort("8080");
    }

    public Response searchCount(String q) {
        SearchCount searchCount = new SearchCount();
        searchCount.setTopsyConfig(config);
        SearchResponse response = null;
        try {
            response = searchCount.searchCount(q);
        } catch (Otter4JavaException e) {
            e.printStackTrace();
        }
        return response.getResult();
    }

}
