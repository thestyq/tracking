package ts.tracking;

import org.apache.commons.lang3.StringUtils;
import org.bson.Document;
import ts.tracking.models.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

public class DataCollector {
    private TrackingDB db;

    public DataCollector() {
        db = new TrackingDB();
    }

    public String collectData(HttpServletRequest req) {
        TrackingModelWrapper trackingModelWrapper = new TrackingModelWrapper(
                new TrackingModel()
                .withWindowResolutionModel(createWindowResolutionModel(req))
                .withHeaderModel(createHeaderModel(req))
                .withBrowserModel(createBrowserModel(req))
                .withFontsModel(createFontsModel(req)));
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
        return new WindowResolutionModel(
                req.getParameter("window_screen_height"),
                req.getParameter("window_screen_width"),
                req.getParameter("window_screen_availHeight"),
                req.getParameter("window_screen_availWidth")
        );
    }

    private BrowserModel createBrowserModel(HttpServletRequest req) {
        return new BrowserModel(
                Boolean.parseBoolean(req.getParameter("isOpera")),
                Boolean.parseBoolean(req.getParameter("isFirefox")),
                Boolean.parseBoolean(req.getParameter("isSafari")),
                Boolean.parseBoolean(req.getParameter("isIE")),
                Boolean.parseBoolean(req.getParameter("isEdge")),
                Boolean.parseBoolean(req.getParameter("isChrome")),
                Boolean.parseBoolean(req.getParameter("isBlink")),
                Arrays.asList(req.getParameter("addons").split(","))
        );
    }

    private FontsModel createFontsModel(HttpServletRequest req) {
        return new FontsModel(Arrays.asList(req.getParameter("fonts").split(",")));
    }

    private HeaderModel createHeaderModel(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        HeaderModel headerModel = new HeaderModel();
        while (headerNames.hasMoreElements()) {
            String nextHeader = headerNames.nextElement();
            if (!StringUtils.equals(nextHeader, "cookie")) {
                headerModel.addEntry(nextHeader, req.getHeader(nextHeader));
            }
        }
        return headerModel;
    }

    void setDb(TrackingDB db) {
        this.db = db;
    }
}
