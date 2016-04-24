package edu.csula.datascience.acquisition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.jsoup.nodes.Element;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MovieCollector{

	MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    public MovieCollector() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("big-data");
        collection = database.getCollection("movies");
    }

    public void save(Collection<Movie> data, String date) {
    	
    	FindIterable<Document> iterable = collection.find(
    	        new Document("date", date));
    	if(iterable.first() == null) {
	        List<Document> documents = data.stream()
	                .map(item -> new Document()
	                    .append("name", item.getName())
	                    .append("distributor", item.getDistributor())
	                    .append("dailyGross", item.getDailyGross())
	                    .append("daysAftRels", item.getDaysAftRelease())
	                    .append("totalGross",item.getTotalGross())
	                    .append("theaterCnt",item.getTheaterCnt())
	                    .append("theaterPrice",item.getTheaterPrice())
	                    .append("todayRank",item.getTodayRank())
	                    .append("yesterdayRank",item.getYesterdayRank()))
	                .collect(Collectors.toList());
	        Document doc = new Document().append("date", date).append("movies", documents);
	        collection.insertOne(doc);  
    	}
    }
    
	public Collection<Movie> mungee(Collection<Element> src) {
		if(src == null) return (new ArrayList<Movie>());
		List<Movie> documents = src.stream()
				.map(element -> new Movie(
						element.childNode(2).childNode(0).childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(3).childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(4).childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(9).childNode(0).childNode(0).toString(),
						element.childNode(10).childNode(0).childNode(0).toString(),
						element.childNode(7).childNode(0).childNode(0).toString(),
						element.childNode(8).childNode(0).childNode(0).toString(),
						element.childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(1).childNode(0).childNode(0).toString()
				))
	            .collect(Collectors.toList());
		return documents;
	}

}
