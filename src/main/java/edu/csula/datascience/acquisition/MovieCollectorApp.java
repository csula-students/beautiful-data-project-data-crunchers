package edu.csula.datascience.acquisition;

import java.text.ParseException;
import java.util.Collection;

import org.jsoup.nodes.Element;

public class MovieCollectorApp {

	public static void main(String[] args) throws ParseException {
		
		MovieCollector collector = new MovieCollector();
		MovieSource source = new MovieSource("2016-04-15");
		Collection<Element> elements = source.getSource();
		Collection<Movie> movies = collector.mungee(elements);
		
	}
}
