package ts.tracking;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import ts.tracking.models.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

public class DataCollector {
    private TrackingDB db;

    public DataCollector(TrackingDB db) {
        this.db = db;
    }

    public String collectData(HttpServletRequest req) {
        TrackingModelWrapper trackingModelWrapper = new TrackingModelWrapper(
                new TrackingModel()
                        .withWindowResolutionModel(createWindowResolutionModel(req))
                        .withHeaderModel(createHeaderModel(req))
                        .withBrowserModel(createBrowserModel(req))
                        .withAddonsModel(createAddonModel(req))
                        .withFontsModel(createFontsModel(req))
                        .withLocalisationModel(createLocalisationModel(req))
                        .withPluginModel(createPluginModel(req)));
        db.putData(trackingModelWrapper);
        return trackingModelWrapper.getId();
    }

    public void visit(String id, String cookie) {
        VisitModel visitModel;
        Document visit = db.getVisit(id);
        if (visit == null) {
            visitModel = new VisitModel(id);
        } else {
            visitModel = new VisitModel(visit);
        }
        if (!StringUtils.equals(id, cookie) & !StringUtils.isBlank(cookie)) {
            visitModel.addAlternativeId(cookie);
        }
        visitModel.recordVisit(System.currentTimeMillis());
        db.putVisit(visitModel);
    }

    private WindowResolutionModel createWindowResolutionModel(HttpServletRequest req) {
        return new Gson().fromJson(req.getParameter("resolution"), WindowResolutionModel.class);
    }

    private BrowserModel createBrowserModel(HttpServletRequest req) {
        return new Gson().fromJson(req.getParameter("browserData"), BrowserModel.class);
    }

    private FontsModel createFontsModel(HttpServletRequest req) {
        return new Gson().fromJson(req.getParameter("fonts"), FontsModel.class);
    }

    private LocalisationModel createLocalisationModel(HttpServletRequest req) {
        return new Gson().fromJson(req.getParameter("localisation"), LocalisationModel.class);
    }

    private PluginModel createPluginModel(HttpServletRequest req) {
        return new Gson().fromJson(req.getParameter("plugins"), PluginModel.class);
    }

    private HeaderModel createHeaderModel(HttpServletRequest req) {
        HeaderModel headerModel = new HeaderModel();
        for (Header header : Header.values()) {
            String headerName = header.getHeader();
            headerModel.addEntry(headerName, req.getHeader(headerName));
        }
        return headerModel;
    }

    private AddonsModel createAddonModel(HttpServletRequest req) {
        return new Gson().fromJson(req.getParameter("addons"), AddonsModel.class);
    }

    void setDb(TrackingDB db) {
        this.db = db;
    }
}
