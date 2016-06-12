package ts.tracking.models;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Collections;
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

    private BrowserModel(Builder builder) {
        this.isOpera = builder.isOpera;
        this.isFirefox = builder.isFirefox;
        this.isSafari = builder.isSafari;
        this.isIE = builder.isIE;
        this.isEdge = builder.isEdge;
        this.isChrome = builder.isChrome;
        this.isBlink = builder.isBlink;
        this.addons = builder.addons;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private boolean isOpera;
        private boolean isFirefox;
        private boolean isSafari;
        private boolean isIE;
        private boolean isEdge;
        private boolean isChrome;
        private boolean isBlink;
        private List<String> addons = new ArrayList<>();

        public Builder withIsOpera(boolean newIsOpera) {
            isOpera = newIsOpera;
            return this;
        }

        public Builder withIsFirefox(boolean newIsFirefox) {
            isFirefox = newIsFirefox;
            return this;
        }

        public Builder withIsSafari(boolean newIsSafari) {
            isSafari = newIsSafari;
            return this;
        }

        public Builder withIsIE(boolean newIsIE) {
            isIE = newIsIE;
            return this;
        }

        public Builder withIsEdge(boolean newIsEdge) {
            isEdge = newIsEdge;
            return this;
        }

        public Builder withIsChrome(boolean newIsChrome) {
            isChrome = newIsChrome;
            return this;
        }

        public Builder withIsBlink(boolean newIsBlink) {
            isBlink = newIsBlink;
            return this;
        }

        public Builder withAddons(List<String> newAddons) {
            addons = newAddons;
            return this;
        }

        public BrowserModel build() {
            return new BrowserModel(this);
        }
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
