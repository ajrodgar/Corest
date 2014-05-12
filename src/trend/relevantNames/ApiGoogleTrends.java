
package trend.relevantNames;

import java.io.IOException;
import java.util.List;
import javax.naming.ConfigurationException;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.NTCredentials;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.client.DefaultHttpClient;
import org.freaknet.gtrends.api.GoogleAuthenticator;
import org.freaknet.gtrends.api.GoogleTrendsClient;
import org.freaknet.gtrends.api.GoogleTrendsCsvParser;
import org.freaknet.gtrends.api.GoogleTrendsRequest;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsClientException;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException;

public class ApiGoogleTrends {
    public List<String[]> getTopCities(String query) throws GoogleTrendsClientException, GoogleTrendsRequestException, ConfigurationException, org.apache.commons.configuration.ConfigurationException, IOException {
        String u = "codestproject@gmail.com";
        String p = "proyectogs2";

        /* OPTIONAL: setup a proxy with NTLM authentication */
        HttpHost proxy = new HttpHost("222.124.198.136", 3129, "http");
        Credentials credentials = new NTCredentials("", "", "", "DOMAIN");
        DefaultHttpClient httpClient = new DefaultHttpClient();
        httpClient.getCredentialsProvider().setCredentials(new AuthScope(proxy.getHostName(), proxy.getPort()), credentials);
        httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

        /* Creates a new authenticator */
        GoogleAuthenticator authenticator = new GoogleAuthenticator(u, p, httpClient);

        /* Creates a new Google Trends Client */
        GoogleTrendsClient client = new GoogleTrendsClient(authenticator, httpClient);
        GoogleTrendsRequest request = new GoogleTrendsRequest(query);

        /* Here the default request params can be modified with getter/setter methods */
        String content = client.execute(request);

        /* The default request downloads a CSV available in content */
        GoogleTrendsCsvParser csvParser = new GoogleTrendsCsvParser(content);
        /* Get a specific section of the CSV */
//        String section = csvParser.getSectionAsString("Top cities for", true);
        
        return csvParser.getSectionAsStringArrayList("Top cities for", true, ",");
    }
}
