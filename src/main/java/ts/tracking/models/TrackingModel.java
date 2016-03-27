package ts.tracking.models;

import org.bson.Document;

/**
 * Created by styqq on 26.01.16.
 */
public class TrackingModel implements Model {
    private long timestamp;
    private WindowResolutionModel windowResolutionModel;
    private HeaderModel headerModel;
    private BrowserModel browserModel;
    private FontsModel fontsModel;

    public TrackingModel() {
        timestamp = System.currentTimeMillis();
    }

    public TrackingModel withWindowResolutionModel(WindowResolutionModel windowResolutionModel) {
        this.windowResolutionModel = windowResolutionModel;
        return this;
    }

    public TrackingModel withBrowserModel(BrowserModel browserModel) {
        this.browserModel = browserModel;
        return this;
    }

    public TrackingModel withFontsModel(FontsModel fontsModel) {
        this.fontsModel = fontsModel;
        return this;
    }

    public TrackingModel withHeaderModel(HeaderModel headerModel) {
        this.headerModel = headerModel;
        return this;
    }

    public Document getAsDocument() {
        return new Document()
                .append("timestamp", timestamp)
                .append("windowResolutionModel", windowResolutionModel.getAsDocument())
                .append("browserModel", browserModel.getAsDocument())
                .append("headerModel", headerModel.getAsDocument())
                .append("fontsModel", fontsModel.getAsDocument());
    }


}
