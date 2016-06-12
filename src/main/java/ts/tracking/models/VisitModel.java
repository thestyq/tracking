package ts.tracking.models;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class VisitModel implements Model {
    private String id;
    private List<Long> visits = new ArrayList<>();
    private List<String> alternativeIds = new ArrayList<>();

    public VisitModel(String id) {
        this.id = id;
    }

    public VisitModel(Document visitDocument) {
        this.id = (String) visitDocument.get("_id");
        this.alternativeIds = (List<String>) visitDocument.get("alternativeIds");
        this.visits = (List<Long>) visitDocument.get("visits");
    }

    public void recordVisit(long visit) {
        visits.add(visit);
    }
    public void addAlternativeId(String id) { alternativeIds.add(id); }

    public String getId() {
        return id;
    }

    @Override
    public Document getAsDocument() {
        return new Document().append("_id", id).append("visits", visits).append("alternativeIds", alternativeIds);
    }
}
