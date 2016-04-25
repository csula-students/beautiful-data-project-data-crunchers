package edu.csula.datascience.acquisition;

import java.util.Collection;

import com.google.common.collect.Lists;

public class MockSource2 implements Source<MockData2>{
	int index = 0;

	@Override
	public boolean hasNext() {
		
		return index < 1;
	}

	@Override
	public Collection<MockData2> next() {
		  return Lists.newArrayList(
		            new MockData2(null, null,null,null),
		            new MockData2("pirates of carribean","walt disney","300000","1000000"),
		            new MockData2("deadpool","marvel","400000","2000000")
		        );
	}
	

}
