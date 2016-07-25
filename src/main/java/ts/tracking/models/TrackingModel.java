package ts.tracking.models;

import org.bson.Document;

public class TrackingModel implements Model {
    private WindowResolutionModel windowResolutionModel;
    private HeaderModel headerModel;
    private BrowserModel browserModel;
    private FontsModel fontsModel;
    private AddonsModel addonsModel;
    private LocalisationModel localisationModel;
    private PluginModel pluginModel;

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

    public TrackingModel withAddonsModel(AddonsModel addonsModel) {
        this.addonsModel = addonsModel;
        return this;
    }

    public TrackingModel withLocalisationModel(LocalisationModel localisationModel) {
        this.localisationModel = localisationModel;
        return this;
    }

    public TrackingModel withPluginModel(PluginModel pluginModel) {
        this.pluginModel = pluginModel;
        return this;
    }

    public Document getAsDocument() {
        return new Document()
                .append("windowResolutionModel", windowResolutionModel.getAsDocument())
                .append("browserModel", browserModel.getAsDocument())
                .append("headerModel", headerModel.getAsDocument())
                .append("fontsModel", fontsModel.getAsDocument())
                .append("addonsModel", addonsModel.getAsDocument())
                .append("localisationModel", localisationModel.getAsDocument())
                .append("pluginModel", pluginModel.getAsDocument());
    }


}
