package edu.csula.datascience.acquisition;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Element;

import com.mongodb.MongoClient;
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
    
	public Collection<Movie> mungee(Collection<Element> src) {
		List<Movie> documents = src.stream()
				.map(element -> new Movie(
						element.childNode(2).childNode(0).childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(3).childNode(0).childNode(0).childNode(0).toString(),
						Long.parseLong(element.childNode(4).childNode(0).childNode(0).childNode(0).toString()),
						Long.parseLong(element.childNode(9).childNode(0).childNode(0).toString()),
						Integer.parseInt(element.childNode(10).childNode(0).childNode(0).toString())
				))
	            .collect(Collectors.toList());
		return documents;
	}

}
