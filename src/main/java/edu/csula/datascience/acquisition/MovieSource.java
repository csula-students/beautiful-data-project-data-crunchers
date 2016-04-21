package edu.csula.datascience.acquisition;

import java.util.Collection;

public class MovieSource implements Source<Movie>{
	String date;
	
	public MovieSource(String date) {
		this.date = date;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Collection<Movie> next() {
		return null;
	}

}
