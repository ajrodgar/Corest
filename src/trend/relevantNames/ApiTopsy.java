package trend.relevantNames;

import com.maruti.otterapi.Otter4JavaException;
import com.maruti.otterapi.TopsyConfig;
import com.maruti.otterapi.search.Response;
import com.maruti.otterapi.search.SearchCount;
import com.maruti.otterapi.search.SearchResponse;
import com.maruti.otterapi.searchhistogram.SearchHistogram;
import com.maruti.otterapi.searchhistogram.SearchHistogramResponse;

public class ApiTopsy {

    private final TopsyConfig config = new TopsyConfig();

    public ApiTopsy() {
        config.setApiKey("09C43A9B270A470B8EB8F2946A9369F3");
        config.setSetProxy(false);
        config.setProxyHost("hydproxy.igate.com");
        config.setProxyPort("8080");
    }

    public com.maruti.otterapi.search.Response searchCount(String q) {
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

    public com.maruti.otterapi.searchhistogram.Response searchHistogram(String q) {
        SearchHistogram searchHistogram = new SearchHistogram();
        searchHistogram.setTopsyConfig(config);
        SearchHistogramResponse response = null;

        try {
            response = searchHistogram.searchHistogram(q);
        } catch (Otter4JavaException e) {
            e.printStackTrace();
        }
        
        String countMethod = response.getResponse().getCount_method();
        int[] histogram = response.getResponse().getHistogram();
        
        return response.getResponse();
    }

}
