package ts.tracking.models;

import org.bson.Document;

/**
 * Created by styqq on 26.01.16.
 */
public class WindowResolutionModel implements Model {
    private String windowScreenHeight;
    private String windowScreenWidth;
    private String windowScreenAvailableHeight;
    private String windowScreenAvailableWidth;
    private String windowInnerHeight;
    private String windowInnerWidth;
    private String windowScreenLeft;
    private String windowScreenTop;

    public WindowResolutionModel(String windowScreenHeight,
                                 String windowScreenWidth,
                                 String windowScreenAvailableHeight,
                                 String windowScreenAvailableWidth,
                                 String windowInnerHeight,
                                 String windowInnerWidth,
                                 String windowScreenLeft,
                                 String windowScreenTop) {
        this.windowScreenHeight = windowScreenHeight;
        this.windowScreenWidth = windowScreenWidth;
        this.windowScreenAvailableHeight = windowScreenAvailableHeight;
        this.windowScreenAvailableWidth = windowScreenAvailableWidth;
        this.windowInnerHeight = windowInnerHeight;
        this.windowInnerWidth = windowInnerWidth;
        this.windowScreenLeft = windowScreenLeft;
        this.windowScreenTop = windowScreenTop;
    }

    public Document getAsDocument() {
        return new Document()
                .append("windowScreenHeight", windowScreenHeight)
                .append("windowScreenWidth", windowScreenWidth)
                .append("windowScreenAvailableHeight", windowScreenAvailableHeight)
                .append("windowScreenAvailableWidth", windowScreenAvailableWidth)
                .append("windowInnerHeight", windowInnerHeight)
                .append("windowInnerWidth", windowInnerWidth)
                .append("windowScreenLeft", windowScreenLeft)
                .append("windowScreenTop", windowScreenTop);
    }
}
