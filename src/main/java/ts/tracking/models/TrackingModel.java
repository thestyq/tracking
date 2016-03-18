package ts.tracking.models;

import org.bson.Document;

/**
 * Created by styqq on 26.01.16.
 */
public class TrackingModel implements Model {
    private long timestamp;
    private WindowResolutionModel windowResolution;
    private HeaderModel headerModel;

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setWindowResolution(WindowResolutionModel windowResolution) {
        this.windowResolution = windowResolution;
    }

    public void setHeaderModel(HeaderModel headerModel) {
        this.headerModel = headerModel;
    }

    public TrackingModel() {
        setTimestamp(System.currentTimeMillis());
    }

    public TrackingModel withWindowResolutionModel(WindowResolutionModel windowResolutionModel) {
        setWindowResolution(windowResolutionModel);
        return this;
    }

    public TrackingModel withHeaderModel(HeaderModel headerModel) {
        setHeaderModel(headerModel);
        return this;
    }

    public Document getAsDocument() {
        return new Document()
                .append("timestamp", timestamp)
                .append("windowResolution", windowResolution.getAsDocument())
                .append("headers", headerModel.getAsDocument());
    }
}
