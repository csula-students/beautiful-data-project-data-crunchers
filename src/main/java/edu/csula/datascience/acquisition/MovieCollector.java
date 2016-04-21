package edu.csula.datascience.acquisition;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.print.Doc;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Element;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MovieCollector implements Collector<Movie, Element>{

	MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    public MovieCollector() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("big-data");
        collection = database.getCollection("movies");
    }

    @Override
    public void save(Collection<Movie> data) {
    	//save the movie into database
        List<Document> documents = data.stream()
                .map(item -> new Document()
                    .append("name", item.getName())
                    .append("distributor", item.getDistributor())
                    .append("changePerc", item.getChangePercent())
                    .append("dailyGross", item.getDailyGross())
                    .append("daysAftRels", item.getDaysAftRelease())
                    .append("totalGross",item.getTotalGross()))
                .collect(Collectors.toList());

            collection.insertMany(documents);

    	
    }
	@Override
	public Collection<Movie> mungee(Collection<Element> src) {
		//get the jsoup dom and convert to movie
		return null;
	}

}
