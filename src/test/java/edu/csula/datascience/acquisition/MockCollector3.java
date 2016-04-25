package edu.csula.datascience.acquisition;

import java.util.Collection;
import java.util.stream.Collectors;

public class MockCollector3 implements Collector<SimpleModel3, MockData3>{
	
	@Override
	public Collection<SimpleModel3> mungee(Collection<MockData3> src) {
		// TODO Auto-generated method stub
		return src.stream()
				.filter(data -> data.getMovieName()!=null && data.getMovieYr()!=null && data.getReleaseDate()!= null
				&& data.getDirector()!=null && data.getMetascore()!=null && data.getImdbRating()!=null)
				.map(SimpleModel3::build)
				.collect(Collectors.toList());
	}

	@Override
	public void save(Collection<SimpleModel3> data) {
		// TODO Auto-generated method stub
		
	}


}
