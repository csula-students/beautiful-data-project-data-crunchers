package edu.csula.datascience.acquisition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import me.jhenrique.model.Tweet;

import org.bson.Document;


import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MovieCollector3 {

		MongoClient mongoClient;
	    MongoDatabase database;
	    MongoCollection<Document> collection;
	    public MovieCollector3() {
	        mongoClient = new MongoClient();
	        database = mongoClient.getDatabase("big-data");
	        collection = database.getCollection("movieTweets");
	    }
	    
	    public Collection<Tweet> mungee(Collection<Tweet> src) {
	    	if(src == null) return new ArrayList<Tweet>();
	        return src;
	    }
	    
	    
	    public void save(Collection<Tweet> tweets, String movie){
	    	if(tweets == null) return;
	    	List<Document> documents = tweets.stream()
	    	               .map(item -> new Document()
	    	               .append("Tweet", item.getText()))
	    	                .collect(Collectors.toList());
	    	        Document doc = new Document().append("Movie", movie).append("tweets", documents);
	    	        collection.insertOne(doc);
	    }
	    
}
