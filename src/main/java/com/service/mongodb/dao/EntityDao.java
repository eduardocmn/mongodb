package com.service.mongodb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class EntityDao<T> implements InterfaceDao {

	private Class<T> persistentClass;
    private DBCollection dbCollection;
    
    public EntityDao(Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        this.dbCollection = MongoSingletonConnection.getInstance().getDB().getCollection("pessoa");
    }

    protected DBCollection getDbCollection() {
        return dbCollection;
    }
	
	@Override
	public void save(Map<String, Object> mapEntity) {
		
		BasicDBObject document = new BasicDBObject(mapEntity);

        dbCollection.save(document);

        System.out.println("Save => " + document);

        System.out.println("Collection => " + dbCollection.getName());
	}

	@Override
	public void update(Map<String, Object> mapQuery, Map<String, Object> mapEntity) {
		
		BasicDBObject query = new BasicDBObject(mapQuery);

        BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.update(query, entity);
        
        System.out.println("Update old => " + query);
        System.out.println("Update new => " + entity);
	}

	@Override
	public void delete(Map<String, Object> mapEntity) {
		
		BasicDBObject entity = new BasicDBObject(mapEntity);

        dbCollection.remove(entity);
        
        System.out.println("Delete => " + entity);
	}

	@Override
	public DBObject findOne(Map<String, Object> mapEntity) {
				
		BasicDBObject query = new BasicDBObject(mapEntity);

		System.out.println("Find one => " + query);
		
        return dbCollection.findOne(query);
	}

	@Override
	public List<DBObject> findAll() {
		
		List<DBObject> list = new ArrayList<DBObject>();

        DBCursor cursor = dbCollection.find();

        while (cursor.hasNext()) {
            list.add(cursor.next());
        }

        System.out.println("Find all => " + list.toString());
        
        return list;
	}

}
