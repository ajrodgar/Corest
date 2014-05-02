package trends;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class ApiTwitter {

    private static final int countMax = 100;

    public int numTweets(String q, String since, String until, GeoLocation geoLocation, int radio) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("R6pHmw0qdDWgXH7MEu40fskl4")
                .setOAuthConsumerSecret("gas9ZH9jzrVB2yM3Xhn6jtt1sdszIWhlc2MyZaQ96E9voCwdJ0")
                .setOAuthAccessToken("14117909-GE2XmU3Qi5fdip46OQQahuZGR53EZ3f11Q8m5Y0vQ")
                .setOAuthAccessTokenSecret("Gpmid7SrxxKTCZDHSkHiiGVi6S5ghdnvaoedGtij2Utcm");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        // The factory instance is re-useable and thread safe.
        Query query = new Query(q);
        query.setResultType(Query.ResultType.recent);
        query.setCount(countMax);
        query.setSince(since);
        query.setUntil(until);
        query.geoCode(new GeoLocation(28.113155, -15.440883), radio, "km");

        QueryResult result = twitter.search(query);
        int nTweets = result.getTweets().size();
        while(result.hasNext()){
            result = twitter.search(result.nextQuery());
            nTweets += result.getTweets().size();
        }
        return nTweets;
    }
}
