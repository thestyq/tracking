package ts.tracking.models;

import org.bson.Document;

import java.util.List;

public class AddonsModel implements Model {
    private List<String> addons;

    public AddonsModel() {

    }

    @Override
    public Document getAsDocument() {
        return new Document().append("addons", addons);
    }
}
