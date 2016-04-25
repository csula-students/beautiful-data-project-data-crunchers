package edu.csula.datascience.acquisition;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class CollectorTest2 {
	
	private Collector<SimpleModel2, MockData2> collector;
    private Source<MockData2> source;

    @Before
    public void setup() {
        collector = new MockCollector2();
        source = new MockSource2();
    }

    @Test
    public void mungee() throws Exception {
        List<SimpleModel2> list = (List<SimpleModel2>) collector.mungee(source.next());
        List<SimpleModel2> expectedList = Lists.newArrayList(
            new SimpleModel2("pirates of carribean","walt disney","300000","1000000"),
            new SimpleModel2("deadpool","marvel","400000","2000000")
        );

        Assert.assertEquals(list.size(), 2);

        for (int i = 0; i < 2; i ++) {
            Assert.assertEquals(list.get(i).getMovieName(), expectedList.get(i).getMovieName());
            Assert.assertEquals(list.get(i).getDistributor(), expectedList.get(i).getDistributor());
            Assert.assertEquals(list.get(i).getDailyGross(), expectedList.get(i).getDailyGross());
            Assert.assertEquals(list.get(i).getTotalGross(), expectedList.get(i).getTotalGross());
        }
    }


}
