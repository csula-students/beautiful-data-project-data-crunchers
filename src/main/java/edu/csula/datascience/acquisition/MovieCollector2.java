package edu.csula.datascience.acquisition;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MovieCollector2 {
	MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;
    public MovieCollector2() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("big-data");
        collection = database.getCollection("movieNames");
    }
    
    public void save(JSONObject json){
    	if(json == null || json.getString("Response").equals("False")) return;
    	FindIterable<Document> iterable = collection.find(
    	        new Document("Title", json.getString("Title")));
    	if(iterable.first() == null){
    		collection.insertOne(Document.parse(json.toString()));
    	}
    }
}
