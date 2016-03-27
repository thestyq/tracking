package ts.tracking;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ts.tracking.models.TrackingModel;

import java.util.logging.Logger;

public class TrackingDB {
    private static final Logger LOG = Logger.getLogger(TrackingDB.class.getName());
    private static final String dbName = "tracking";
    private static final String collectionName = "data";
    private MongoCollection<Document> collection;

    public TrackingDB() {
        LOG.info("Connecting to database...");
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase(dbName);
        collection = db.getCollection(collectionName);
        LOG.info("Connected! Collection: " + collection.getNamespace());
    }

    public void put(TrackingModel trackingModel) {
        collection.insertOne(trackingModel.getAsDocument());
    }

    public long getNumber() {
        return collection.count();
    }
}
