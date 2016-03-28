package ts.tracking;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ts.tracking.models.TrackingModelWrapper;
import ts.tracking.models.VisitModel;

import java.util.logging.Logger;

import static com.mongodb.client.model.Filters.eq;

public class TrackingDB {
    private static final Logger LOG = Logger.getLogger(TrackingDB.class.getName());
    private static final String dbName = "tracking";
    private static final String dataCollectionName = "data";
    private static final String visitCollectionName = "visit";
    private MongoCollection<Document> dataCollection;
    private MongoCollection<Document> visitCollection;

    public TrackingDB() {
        LOG.info("Connecting to database...");
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase(dbName);
        dataCollection = db.getCollection(dataCollectionName);
        visitCollection = db.getCollection(visitCollectionName);
        LOG.info("Connected! Collection: " + dataCollection.getNamespace());
    }

    public void putData(TrackingModelWrapper trackingModelWrapper) {
        if (dataCollection.find(eq("_id", trackingModelWrapper.getId())).first() == null) {
            dataCollection.insertOne(trackingModelWrapper.getAsDocument());
        }
    }

    public void putVisit(VisitModel visitModel) {
        if (visitCollection.find(eq("_id", visitModel.getId())).first() == null) {
            visitCollection.insertOne(visitModel.getAsDocument());
        } else {
            visitCollection.replaceOne(eq("_id", visitModel.getId()), visitModel.getAsDocument());
        }
    }

    public Document getVisit(String id) {
        return visitCollection.find(eq("_id", id)).first();
    }

}
