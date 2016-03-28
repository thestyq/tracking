package ts.tracking.models;

import org.bson.Document;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by styqq on 28.03.16.
 */
public class TrackingModelWrapper implements Model {
    private String id;
    private TrackingModel trackingModel;

    public TrackingModelWrapper(TrackingModel trackingModel) {
        this.trackingModel = trackingModel;
        this.id = getHex(trackingModel);
    }

    private String getHex(TrackingModel trackingModel) {
        String id = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(trackingModel.getAsDocument().toJson().getBytes());
            byte byteData[] = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte aByteData : byteData) {
                sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
            }
            id = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // not possible
        }
        return id;
    }

    public String getId() {
        return id;
    }

    @Override
    public Document getAsDocument() {
        return new Document().append("_id", id).append("data", trackingModel.getAsDocument());
    }
}
