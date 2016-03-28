package ts.tracking.models;

import org.bson.Document;

public class WindowResolutionModel implements Model {
    private String windowScreenHeight;
    private String windowScreenWidth;
    private String windowScreenAvailableHeight;
    private String windowScreenAvailableWidth;

    public WindowResolutionModel(String windowScreenHeight, String windowScreenWidth, String windowScreenAvailableHeight,
                                 String windowScreenAvailableWidth) {
        this.windowScreenHeight = windowScreenHeight;
        this.windowScreenWidth = windowScreenWidth;
        this.windowScreenAvailableHeight = windowScreenAvailableHeight;
        this.windowScreenAvailableWidth = windowScreenAvailableWidth;

    }

    public Document getAsDocument() {
        return new Document()
                .append("windowScreenHeight", windowScreenHeight)
                .append("windowScreenWidth", windowScreenWidth)
                .append("windowScreenAvailableHeight", windowScreenAvailableHeight)
                .append("windowScreenAvailableWidth", windowScreenAvailableWidth);
    }
}
