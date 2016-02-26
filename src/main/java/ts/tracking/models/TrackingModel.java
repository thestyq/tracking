package ts.tracking.models;

import org.bson.Document;

/**
 * Created by styqq on 26.01.16.
 */
public class TrackingModel implements Model {
    private long timestamp;
    private WindowResolutionModel windowResolution;

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setWindowResolution(WindowResolutionModel windowResolution) {
        this.windowResolution = windowResolution;
    }

    public static TrackingModel createTrackingModel(WindowResolutionModel windowResolutionModel) {
        TrackingModel tm = new TrackingModel();
        tm.setTimestamp(System.currentTimeMillis());
        tm.setWindowResolution(windowResolutionModel);
        return tm;
    }

    public Document getAsDocument() {
        return new Document()
                .append("timestamp", timestamp)
                .append("windowResolution", windowResolution.getAsDocument());
    }
}
