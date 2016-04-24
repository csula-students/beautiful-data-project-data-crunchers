package edu.csula.datascience.acquisition;

import java.util.List;

import me.jhenrique.manager.TweetManager;
import me.jhenrique.manager.TwitterCriteria;
import me.jhenrique.model.Tweet;


public class MovieSource3{
	
	private String movie;
	
	public MovieSource3(String movie) {
		this.movie = movie;
	}
	
//	public static void main(String[] args) {
	public List<Tweet> getTweets(String movie) {
		TwitterCriteria criteria = TwitterCriteria.create()
	            .setQuerySearch(movie)
	            .setMaxTweets(25);
		List<Tweet> t = TweetManager.getTweets(criteria);
		return t;
	}

}
