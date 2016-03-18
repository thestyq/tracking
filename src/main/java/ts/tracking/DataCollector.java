package ts.tracking;

import ts.tracking.models.HeaderModel;
import ts.tracking.models.TrackingModel;
import ts.tracking.models.WindowResolutionModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by styqq on 18.03.16.
 */
public class DataCollector {
    private TrackingDB db;

    public DataCollector() {
        db = new TrackingDB();
    }

    public void collectData(HttpServletRequest req) {
        TrackingModel trackingModel = new TrackingModel()
                .withWindowResolutionModel(createWindowResolutionModel(req))
                .withHeaderModel(createHeaderModel(req));


        db.put(trackingModel);
    }

    private WindowResolutionModel createWindowResolutionModel(HttpServletRequest req){
        WindowResolutionModel windowResolutionModel = new WindowResolutionModel(
                req.getParameter("window_screen_height"),
                req.getParameter("window_screen_width"),
                req.getParameter("window_screen_availHeight"),
                req.getParameter("window_screen_availWidth"),
                req.getParameter("window_innerHeight"),
                req.getParameter("window_innerWidth"),
                req.getParameter("window_screenLeft"),
                req.getParameter("window_screenTop")
        );
        return windowResolutionModel;
    }

    private HeaderModel createHeaderModel(HttpServletRequest req) {
        Enumeration<String> headerNames = req.getHeaderNames();
        HeaderModel headerModel = new HeaderModel();
        while (headerNames.hasMoreElements()) {
            String nextHeader = headerNames.nextElement();
            headerModel.addEntry(nextHeader, req.getHeader(nextHeader));
        }
        return headerModel;
    }
}