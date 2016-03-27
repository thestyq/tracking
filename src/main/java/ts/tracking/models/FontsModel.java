package ts.tracking.models;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class FontsModel implements Model {
    private List<String> fonts = new ArrayList<>();

    public FontsModel(List<String> fonts) {
        this.fonts = fonts;
    }

    @Override
    public Document getAsDocument() {
        return new Document().append("fonts", fonts);
    }
}
