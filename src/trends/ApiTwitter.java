package trends;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class ApiTwitter {

    private static final int countMax = 100;

    public int numTweets(String q) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("R6pHmw0qdDWgXH7MEu40fskl4")
                .setOAuthConsumerSecret("gas9ZH9jzrVB2yM3Xhn6jtt1sdszIWhlc2MyZaQ96E9voCwdJ0")
                .setOAuthAccessToken("14117909-GE2XmU3Qi5fdip46OQQahuZGR53EZ3f11Q8m5Y0vQ")
                .setOAuthAccessTokenSecret("Gpmid7SrxxKTCZDHSkHiiGVi6S5ghdnvaoedGtij2Utcm");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        Query query = new Query(q);
        query.setResultType(Query.ResultType.recent);
        query.setCount(countMax);
        
        Calendar calendar = GregorianCalendar.getInstance();
        Date untilDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date sinceDate = calendar.getTime();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.format(sinceDate);
        
        query.setSince(dateFormat.format(sinceDate));
        query.setUntil(dateFormat.format(untilDate));
        
        QueryResult result = twitter.search(query);
        int nTweets = result.getTweets().size();
        while(result.hasNext()){
            result = twitter.search(result.nextQuery());
            nTweets += result.getTweets().size();
        }
        return nTweets;
    }
}
