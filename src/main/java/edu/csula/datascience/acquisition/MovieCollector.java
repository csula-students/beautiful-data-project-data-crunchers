package edu.csula.datascience.acquisition;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MovieCollector implements Collector<Daily, Daily>{

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
    	
    }
	@Override
	public Collection<Movie> mungee(Collection<Daily> src) {
		//get the jsoup dom and convert to movie
		
		return null;
	}

}
