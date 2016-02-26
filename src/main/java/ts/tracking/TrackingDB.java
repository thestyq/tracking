package ts.tracking;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ts.tracking.models.TrackingModel;

/**
 * Created by styqq on 26.01.16.
 */
public class TrackingDB {
    private static final String dbName = "tracking";
    private static final String collectionName = "data";
    private MongoCollection<Document> collection;

    public TrackingDB() {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase(dbName);
        collection = db.getCollection(collectionName);
    }

    public void put(TrackingModel trackingModel) {
        collection.insertOne(trackingModel.getAsDocument());
    }

    public long getNumber() {
        return collection.count();
    }
}
