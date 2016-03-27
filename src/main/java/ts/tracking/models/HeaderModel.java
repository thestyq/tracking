package ts.tracking.models;

import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

public class HeaderModel implements Model {
    private Map<String, String> headers = new HashMap<>();

    public void addEntry (String key, String value) {
        headers.put(key, value);
    }

    @Override
    public Document getAsDocument() {
        Document document = new Document();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            document.append(entry.getKey(), entry.getValue());
        }
        return document;
    }
}
