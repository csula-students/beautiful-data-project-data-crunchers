package edu.csula.datascience.acquisition;

import java.util.Collection;

import org.json.JSONObject;

import com.google.common.collect.Lists;

public class MockSource3 implements Source<MockData3>{
	
	int index = 0;

	@Override
	public boolean hasNext() {
		
		return index < 1;
	}

	@Override
	public Collection<MockData3> next() {

		String jsonStr = "{'Title':'The Jungle Book','Year':'2016','Released':'15 Apr 2016','Director':'Jon Favreau','Metascore':'78','imdbRating':'8.1'}";
		String jsonStr2 = "{'Title':'Zootopia','Year':'2016','Released':'04 Mar 2016','Director':'Byron Howard, Rich Moore, Jared Bush','Metascore':'78','imdbRating':'8.4'}";
		
		return Lists.newArrayList(
				new MockData3(new JSONObject(jsonStr)),
				new MockData3(new JSONObject(jsonStr2)));
	}


}
