package com.service.mongodb.dao;

//import org.bson.Document;

import com.mongodb.DB;
import com.mongodb.Mongo;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;

public class MongoSingletonConnection {

	private static final String HOST = "localhost";
    private static final int PORT = 27017;
    private static final String DB_NAME = "local";

    private static MongoSingletonConnection uniqInstance;
    private static int mongoInstance = 1;

    private Mongo mongo;
    private DB db;
	
    private MongoSingletonConnection() {    	
    }
    
    //retorna sempre uma unica instancia
	public static synchronized MongoSingletonConnection getInstance() {
	    if (uniqInstance == null) {
	        uniqInstance = new MongoSingletonConnection();
	    }
	    return uniqInstance;
	}
	
	//garante um unico objeto mongo
    public DB getDB() {
        if (mongo == null) {
            try {
                mongo = new Mongo(HOST, PORT);
                db = mongo.getDB(DB_NAME);
                System.out.println("Mongo instance equals => " + mongoInstance++);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return db;
    }
    
    /*public MongoCollection<Document> iniciar() {
    	MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mongo1");
        MongoCollection<Document> collection = database.getCollection("local");
        
        return collection;
    }*/
}
