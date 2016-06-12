package ts.tracking.models;

import org.bson.Document;

import java.util.List;

public class FontsModel implements Model {
    private List<String> fonts;

    public FontsModel() {
    }

    @Override
    public Document getAsDocument() {
        return new Document().append("fonts", fonts);
    }
}
