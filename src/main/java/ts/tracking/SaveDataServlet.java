package ts.tracking;

import ts.tracking.models.TrackingModel;
import ts.tracking.models.WindowResolutionModel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by styqq on 04.01.16.
 */
public class SaveDataServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(SaveDataServlet.class.getName());
    private TrackingDB db;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        db = new TrackingDB();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Some data arrived!");

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

        TrackingModel trackingModel = TrackingModel.createTrackingModel(windowResolutionModel);
        db.put(trackingModel);
    }

}