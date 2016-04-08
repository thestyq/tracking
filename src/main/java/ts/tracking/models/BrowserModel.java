package ts.tracking.models;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class BrowserModel implements Model {
    private boolean isOpera;
    private boolean isFirefox;
    private boolean isSafari;
    private boolean isIE;
    private boolean isEdge;
    private boolean isChrome;
    private boolean isBlink;
    private List<String> addons = new ArrayList<>();

    public BrowserModel(boolean isOpera, boolean isFirefox, boolean isSafari,
                        boolean isIE, boolean isEdge, boolean isChrome, boolean isBlink, List<String> addons) {
        this.isOpera = isOpera;
        this.isFirefox = isFirefox;
        this.isSafari = isSafari;
        this.isIE = isIE;
        this.isEdge = isEdge;
        this.isChrome = isChrome;
        this.isBlink = isBlink;
        this.addons = addons;
    }

    public Document getAsDocument() {
        return new Document()
                .append("isOpera", isOpera)
                .append("isFirefox", isFirefox)
                .append("isSafari", isSafari)
                .append("isIE", isIE)
                .append("isEdge", isEdge)
                .append("isChrome", isChrome)
                .append("isBlink", isBlink)
                .append("addons", addons);
    }
}
