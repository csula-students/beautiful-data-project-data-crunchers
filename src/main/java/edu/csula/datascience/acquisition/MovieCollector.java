package edu.csula.datascience.acquisition;

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
    	//save the movie into database
    	
    	FindIterable<Document> iterable = database.getCollection("movies").find(
    	        new Document("date", date));
    	System.out.println("before");
    	if(iterable.first() == null) {
    		System.out.println("inside");
	        List<Document> documents = data.stream()
	                .map(item -> new Document()
	                    .append("name", item.getName())
	                    .append("distributor", item.getDistributor())
	                    .append("dailyGross", item.getDailyGross())
	                    .append("daysAftRels", item.getDaysAftRelease())
	                    .append("totalGross",item.getTotalGross()))
	                .collect(Collectors.toList());
	        Document doc = new Document().append("date", date).append("movies", documents);
	        collection.insertOne(doc);  
    	}
    	System.out.println("after");
    }
    
	public Collection<Movie> mungee(Collection<Element> src) {
		List<Movie> documents = src.stream()
				.map(element -> new Movie(
						element.childNode(2).childNode(0).childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(3).childNode(0).childNode(0).childNode(0).toString(),
						Long.parseLong(element.childNode(4).childNode(0).childNode(0).childNode(0).toString().replaceAll("[^0-9]", "")),
						Long.parseLong(element.childNode(9).childNode(0).childNode(0).toString().replaceAll("[^0-9]", "")),
						Integer.parseInt(element.childNode(10).childNode(0).childNode(0).toString())
				))
	            .collect(Collectors.toList());
		return documents;
	}

}
