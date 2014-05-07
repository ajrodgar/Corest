package trends;

import com.maruti.otterapi.ListParameters;
import com.maruti.otterapi.Otter4JavaException;
import com.maruti.otterapi.TopsyConfig;
import com.maruti.otterapi.authorinfo.AuthorInfo;
import com.maruti.otterapi.authorinfo.AuthorInfoResponse;
import com.maruti.otterapi.experts.Experts;
import com.maruti.otterapi.experts.ExpertsResponse;
import com.maruti.otterapi.linkposts.Linkposts;
import com.maruti.otterapi.linkposts.LinkpostsRequest;
import com.maruti.otterapi.linkposts.LinkpostsResponse;
import com.maruti.otterapi.populartrackbacks.Populartrackbacks;
import com.maruti.otterapi.populartrackbacks.PopulartrackbacksResponse;
import com.maruti.otterapi.search.Search;
import com.maruti.otterapi.search.SearchCount;
import com.maruti.otterapi.search.SearchCriteria;
import com.maruti.otterapi.search.SearchResponse;
import com.maruti.otterapi.searchhistogram.SearchHistogram;
import com.maruti.otterapi.searchhistogram.SearchHistogramResponse;
import com.maruti.otterapi.stats.Stats;
import com.maruti.otterapi.stats.StatsResponse;
import com.maruti.otterapi.top.Top;
import com.maruti.otterapi.top.TopRequest;
import com.maruti.otterapi.top.TopResponse;
import com.maruti.otterapi.trackbacks.TrackbackRequest;
import com.maruti.otterapi.trackbacks.Trackbacks;
import com.maruti.otterapi.trackbacks.TrackbacksResponse;
import com.maruti.otterapi.urlinfo.URLInfo;
import com.maruti.otterapi.urlinfo.URLInfoResponse;

public class ApiTopsy {

	public void search(TopsyConfig config) {
		Search searchTopsy = new Search();
		searchTopsy.setTopsyConfig(config);
		SearchResponse results = null;
		try {
			SearchCriteria criteria = new SearchCriteria();
			criteria.setQuery("barack obama");

			results = searchTopsy.search(criteria);
			System.out.println(results.getResult().getList().size());
			System.out.println(results.getResult().getTotal());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}

		// Use Crawler to retrieve the contents of search results
		// new BasicCrawlController("D:/data/crawler/out",
		// "D:/data/topsy").crawl(results);
	}

	public void searchCount(TopsyConfig config, String q) {
		SearchCount searchCount = new SearchCount();
		searchCount.setTopsyConfig(config);
		SearchResponse response = null;
		try {
			response = searchCount.searchCount(q);
                        System.out.println("Number of tweets about \"" + q + "\" in the last:");
			System.out.println("Hour: " + response.getResult().getH());
			System.out.println("Day: " + response.getResult().getD());
                        System.out.println("Week: " + response.getResult().getW());
			System.out.println("Month: " + response.getResult().getM());
			System.out.println("Year: " + response.getResult().getA());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}

	}

	public void searchdate(TopsyConfig config) {
		Search searchTopsy = new Search();
		searchTopsy.setTopsyConfig(config);
		SearchResponse results = null;
		try {
			SearchCriteria criteria = new SearchCriteria();
			criteria.setQuery("barack obama");

			results = searchTopsy.searchdate(criteria);
			System.out.println(results.getResult().getList().size());
			System.out.println(results.getResult().getTotal());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}

		// Use Crawler to retrieve the contents of search results
		// new BasicCrawlController("D:/data/crawler/out",
		// "D:/data/topsy").crawl(results);
	}

	public void authorInfo(TopsyConfig config) {
		AuthorInfo authorInfo = new AuthorInfo();
		authorInfo.setTopsyConfig(config);
		AuthorInfoResponse response = null;
		try {
			response = authorInfo.authorInfo("http://twitter.com/barackobama");
			System.out.println(response.getResponse().getName());
			System.out.println(response.getResponse().getInfluence_level());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}

	public void experts(TopsyConfig config){
		Experts experts = new Experts();
		experts.setTopsyConfig(config);
		ExpertsResponse response = null;

		try{
			ListParameters listParams = new ListParameters();
			listParams.setPage("1");

			response = experts.experts("nosql");
			System.out.println(response.getResponse().getList().size());
			System.out.println(response.getResponse().getTotal());
			System.out.println(response.getResponse().getList().get(0).getName());
		} catch (Otter4JavaException e){
			e.printStackTrace();
		}
	}

	public void searchHistogram(TopsyConfig config){
		SearchHistogram searchHistogram = new SearchHistogram();
		searchHistogram.setTopsyConfig(config);
		SearchHistogramResponse response = null;

		try {
			response = searchHistogram.searchHistogram("kindle");
		} catch (Otter4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.getResponse().getCount_method());
	}

	public void urlInfo(TopsyConfig config){
		URLInfo urlInfo = new URLInfo();
		urlInfo.setTopsyConfig(config);
		URLInfoResponse response = null;

		try {
			response = urlInfo.urlInfo("http://twitter.com/");
		} catch (Otter4JavaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.getResponse().getDescription());
	}

	public void trackbacks(TopsyConfig config) {
		Trackbacks trackbacks = new Trackbacks();
		trackbacks.setTopsyConfig(config);
		TrackbacksResponse results = null;
		try {

			TrackbackRequest request = new TrackbackRequest();
			request.setUrl("http://topsy.com/");

			results = trackbacks.trackbacks(request);
			System.out.println(results.getResponse().getList().size());
			System.out.println(results.getResponse().getTotal());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}

	public void top(TopsyConfig config) {
		Top top = new Top();
		top.setTopsyConfig(config);
		TopResponse results = null;
		try {

			TopRequest request = new TopRequest();
			request.setThresh("top100");

			results = top.top(request);
			System.out.println(results.getResponse().getList().size());
			System.out.println(results.getResponse().getTotal());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}

	public void stats(TopsyConfig config) {
		Stats stats = new Stats();
		stats.setTopsyConfig(config);
		StatsResponse results = null;
		try {
			results = stats.stats("http://topsy.com");
			System.out.println(results.getResponse().getInfluential());
			System.out.println(results.getResponse().getAll());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}

	public void populartrackbacks(TopsyConfig config) {
		Populartrackbacks populartrackbacks = new Populartrackbacks();
		populartrackbacks.setTopsyConfig(config);
		PopulartrackbacksResponse results = null;
		try {
			results = populartrackbacks.populartrackbacks("http://www.google.com/");
			System.out.println(results.getResponse().getTrackback_total());
			System.out.println(results.getResponse().getTopsy_trackback_url());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}

	public void linkposts(TopsyConfig config) {
		Linkposts linkposts = new Linkposts();
		linkposts.setTopsyConfig(config);
		LinkpostsResponse results = null;
		try {
			LinkpostsRequest request = new LinkpostsRequest();
			request.setUrl("http://twitter.com/topsy");
			results = linkposts.linkposts(request);
			System.out.println(results.getResponse().getTotal());
			System.out.println(results.getResponse().getList().size());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}

	public void linkpostsCount(TopsyConfig config) {
		Linkposts linkposts = new Linkposts();
		linkposts.setTopsyConfig(config);
		LinkpostsResponse results = null;
		try {
			LinkpostsRequest request = new LinkpostsRequest();
			request.setUrl("http://twitter.com/topsy");
			results = linkposts.linkpostsCount(request);
			System.out.println(results.getResponse().getAll());
			System.out.println(results.getResponse().getContains());
		} catch (Otter4JavaException e) {
			e.printStackTrace();
		}
	}
}
