package edu.csula.datascience.acquisition;

import java.util.Collection;

public class MovieSource implements Source<Daily>{

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Collection<Daily> next() {
		return null;
	}

}
