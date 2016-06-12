package ts.tracking.models;

import org.bson.Document;

public class WindowResolutionModel implements Model {
    private String windowScreenHeight;
    private String windowScreenWidth;
    private String windowScreenAvailableHeight;
    private String windowScreenAvailableWidth;

    public WindowResolutionModel() {
    }

    public Document getAsDocument() {
        return new Document()
                .append("windowScreenHeight", windowScreenHeight)
                .append("windowScreenWidth", windowScreenWidth)
                .append("windowScreenAvailableHeight", windowScreenAvailableHeight)
                .append("windowScreenAvailableWidth", windowScreenAvailableWidth);
    }
}
