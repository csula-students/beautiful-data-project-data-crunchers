package edu.csula.datascience.acquisition;

import org.bson.Document;
import org.json.JSONObject;

import com.mongodb.MongoClient;
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
    	if(json == null || json.getString("Response") == "false") return;
    	System.out.println("{");
    	for(String key : json.keySet()){
    		System.out.println(key+": "+json.getString(key));
    	}
    	System.out.println("}");
    }
}
