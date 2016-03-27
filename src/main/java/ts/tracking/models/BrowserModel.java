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

    public BrowserModel(boolean isOpera, boolean isFirefox, boolean isSafari,
                        boolean isIE, boolean isEdge, boolean isChrome, boolean isBlink) {
        this.isOpera = isOpera;
        this.isFirefox = isFirefox;
        this.isSafari = isSafari;
        this.isIE = isIE;
        this.isEdge = isEdge;
        this.isChrome = isChrome;
        this.isBlink = isBlink;
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
