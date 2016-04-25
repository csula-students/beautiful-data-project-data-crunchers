package edu.csula.datascience.acquisition;

import org.json.JSONObject;


public class MockData3 {
	
//	private String jsonStr;
//	
//	public MockData3(String jsonStr) {
//		super();
//		this.jsonStr = jsonStr;
//	}
//
//
//
//	public String getJsonStr() {
//		return jsonStr;
//	}
	
	
	
	private String movieName;
	private String movieYr;
	private String releaseDate;
	private String director;
	private String metascore;
	private String imdbRating;
	
	public MockData3(JSONObject movieObj) {
		
		this.movieName = movieObj.getString("Title");
		this.movieYr = movieObj.getString("Year");
		this.releaseDate = movieObj.getString("Released");
		this.director = movieObj.getString("Director");
		this.metascore = movieObj.getString("Metascore");
		this.imdbRating = movieObj.getString("imdbRating");
	}

	public String getMovieName() {
		return movieName;
	}

	public String getMovieYr() {
		return movieYr;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public String getDirector() {
		return director;
	}

	public String getMetascore() {
		return metascore;
	}

	public String getImdbRating() {
		return imdbRating;
	}
	
	

}
