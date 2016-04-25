package edu.csula.datascience.acquisition;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class CollecterTest3 {
	
	private Collector<SimpleModel3, MockData3> collector;
    private Source<MockData3> source;

    @Before
    public void setup() {
        collector = new MockCollector3();
        source = new MockSource3();
    }

    @Test
    public void mungee() throws Exception {
        List<SimpleModel3> list = (List<SimpleModel3>) collector.mungee(source.next());
        List<SimpleModel3> expectedList = Lists.newArrayList(
            new SimpleModel3("The Jungle Book","2016","15 Apr 2016","Jon Favreau","78","8.1"),
            new SimpleModel3("Zootopia","2016","04 Mar 2016","Byron Howard, Rich Moore, Jared Bush","78","8.4")
        );

        Assert.assertEquals(list.size(), 2);

        for (int i = 0; i < 2; i ++) {
            Assert.assertEquals(list.get(i).getMovieName(), expectedList.get(i).getMovieName());
            Assert.assertEquals(list.get(i).getMovieYr(), expectedList.get(i).getMovieYr());
            Assert.assertEquals(list.get(i).getReleaseDate(), expectedList.get(i).getReleaseDate());
            Assert.assertEquals(list.get(i).getDirector(), expectedList.get(i).getDirector());
            Assert.assertEquals(list.get(i).getMetascore(), expectedList.get(i).getMetascore());
            Assert.assertEquals(list.get(i).getImdbRating(), expectedList.get(i).getImdbRating());
        }
    }


}
