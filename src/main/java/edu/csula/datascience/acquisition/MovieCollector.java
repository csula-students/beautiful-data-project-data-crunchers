package edu.csula.datascience.acquisition;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;
import org.elasticsearch.action.bulk.BackoffPolicy;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.ByteSizeUnit;
import org.elasticsearch.common.unit.ByteSizeValue;
import org.elasticsearch.common.unit.TimeValue;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/* 
 * 
 */


public class MovieCollector{
	private Client client;
	private Node node;
	private final static String indexName = "bd-movies";
    private final static String typeName = "movies";
	//MongoClient mongoClient;
    //MongoDatabase database;
    //MongoCollection<Document> collection;
    public MovieCollector() {
    	
    	node = nodeBuilder().settings(Settings.builder()
                .put("cluster.name", "crunchers")
                .put("path.home", "elasticsearch-data")).node();
        client = node.client();
    	
//        mongoClient = new MongoClient();
//        database = mongoClient.getDatabase("big-data");
//        collection = database.getCollection("movies");
    }

    public void save(Collection<Movie> data) {
    	
    	Gson gson = new Gson();
    	
    	   BulkProcessor bulkProcessor = BulkProcessor.builder(
    	            client,
    	            new BulkProcessor.Listener() {
    	                @Override
    	                public void beforeBulk(long executionId,
    	                                       BulkRequest request) {
    	                }

    	                @Override
    	                public void afterBulk(long executionId,
    	                                      BulkRequest request,
    	                                      BulkResponse response) {
    	                }

    	                @Override
    	                public void afterBulk(long executionId,
    	                                      BulkRequest request,
    	                                      Throwable failure) {
    	                    System.out.println("Facing error while importing data to elastic search");
    	                    failure.printStackTrace();
    	                }

						
    	            })
    	            .setBulkActions(10000)
    	            .setBulkSize(new ByteSizeValue(1, ByteSizeUnit.GB))
    	            .setFlushInterval(TimeValue.timeValueSeconds(5))
    	            .setConcurrentRequests(1)
    	            .setBackoffPolicy(
    	                BackoffPolicy.exponentialBackoff(TimeValue.timeValueMillis(100), 3))
    	            .build();
    	data.forEach(item -> bulkProcessor.add(new IndexRequest(indexName, typeName).source(gson.toJson(item)))); 
    	   
    	/*FindIterable<Document> iterable = collection.find(
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
    	}*/ 
    	   
    }
    
 
    
	public Collection<Movie> mungee(Collection<Element> src, String date) {
		if(src == null) return (new ArrayList<Movie>());
		List<Movie> documents = src.stream()
				.map(element -> new Movie(
						element.childNode(2).childNode(0).childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(3).childNode(0).childNode(0).childNode(0).toString(),
						Long.parseLong(element.childNode(4).childNode(0).childNode(0).childNode(0).toString().replaceAll("[^0-9]", "")),
						Long.parseLong(element.childNode(9).childNode(0).childNode(0).toString().replaceAll("[^0-9]", "")),
						Integer.parseInt(element.childNode(10).childNode(0).childNode(0).toString().replaceAll("[^0-9]", "")),
						Integer.parseInt(element.childNode(7).childNode(0).childNode(0).toString().replaceAll("[^0-9]", "")),
						element.childNode(0).childNode(0).childNode(0).toString(),
						element.childNode(1).childNode(0).childNode(0).toString(),
						date
				))
	            .collect(Collectors.toList());
		return documents;
	}

}
