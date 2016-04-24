package edu.csula.datascience.acquisition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.jsoup.nodes.Element;

public class MovieCollectorApp {

	public static void main(String[] args) throws ParseException {
		
		MovieCollector collector = new MovieCollector();
		List<String> dates = getDates("2016-04-14", "2016-04-15");
		for(String date: dates){
			MovieSource source = new MovieSource(date);
			Collection<Element> elements = source.getSource();
			if(elements != null){
				Collection<Movie> movies = collector.mungee(elements);
				collector.save(movies, date);
			}
		}
		
		MovieCollector2 collector2 = new MovieCollector2();
		for(String movie : Movie.getMoviesNames()){
			MovieSource2 source = new MovieSource2(movie);
			collector2.save(source.getSource());
		}
		
		MovieCollector3 collector3 = new MovieCollector3();
		for(String movie : Movie.getMoviesNames()){
			MovieSource3 source = new MovieSource3(movie);
			collector3.save(source.getTweets(movie), movie);
		}
		
		
	}
	
	private static List<String> getDates(String datefrom, String dateto) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date dateFrom = format.parse(datefrom);
		Date dateTo = format.parse(dateto);
		List<String> dates = new ArrayList<String>();
		for(long date = dateFrom.getTime(); date < dateTo.getTime(); date+=86400000){
			dates.add(format.format(new Date(date)));
		}
		return dates;
	}
	
}
