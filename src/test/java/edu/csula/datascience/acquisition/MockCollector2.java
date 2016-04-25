package edu.csula.datascience.acquisition;

import java.util.Collection;
import java.util.stream.Collectors;

public class MockCollector2 implements Collector<SimpleModel2, MockData2>{

	@Override
	public Collection<SimpleModel2> mungee(Collection<MockData2> src) {
		// TODO Auto-generated method stub
		return src.stream()
				.filter(data -> (data.getMovieName() != null) && (data.getDistributor() != null) && (data.getDailyGross() != null))
				.map(SimpleModel2::build)
				.collect(Collectors.toList());
	}

	@Override
	public void save(Collection<SimpleModel2> data) {
		// TODO Auto-generated method stub
		
	}

}
