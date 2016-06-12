package ts.tracking.models;

import org.bson.Document;

public class BrowserModel implements Model {
    private boolean isOpera;
    private boolean isFirefox;
    private boolean isSafari;
    private boolean isIE;
    private boolean isEdge;
    private boolean isChrome;
    private boolean isBlink;

    private BrowserModel() {

    }

    public Document getAsDocument() {
        return new Document()
                .append("isOpera", isOpera)
                .append("isFirefox", isFirefox)
                .append("isSafari", isSafari)
                .append("isIE", isIE)
                .append("isEdge", isEdge)
                .append("isChrome", isChrome)
                .append("isBlink", isBlink);
    }
}
