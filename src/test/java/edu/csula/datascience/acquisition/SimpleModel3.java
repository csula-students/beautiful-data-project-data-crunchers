package edu.csula.datascience.acquisition;



public class SimpleModel3 {
	
	private final String movieName;
	private final String movieYr;
	private final String releaseDate;
	private final String director;
	private final String metascore;
	private final String imdbRating;
	
	public SimpleModel3(String movieName, String movieYr, String releaseDate,
			String director, String metascore, String imdbRating) {
		this.movieName = movieName;
		this.movieYr = movieYr;
		this.releaseDate = releaseDate;
		this.director = director;
		this.metascore = metascore;
		this.imdbRating = imdbRating;
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
	
	public static SimpleModel3 build(MockData3 data) {
        return new SimpleModel3(data.getMovieName(), data.getMovieYr(),data.getReleaseDate(),data.getDirector(),data.getMetascore(),data.getImdbRating());
    }	

}
