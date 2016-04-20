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
        // establish database connection to MongoDB
        mongoClient = new MongoClient();
        // select `bd-example` as testing database
        database = mongoClient.getDatabase("big-data");

        // select collection by name `tweets`
        collection = database.getCollection("movies");
    }

    @Override
    public void save(Collection<Daily> data) {
       
    }
	@Override
	public Collection<Daily> mungee(Collection<Daily> src) {
		return src;
	}

}
