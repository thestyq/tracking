package ts.tracking;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import ts.tracking.models.TrackingModel;
import ts.tracking.models.WindowResolutionModel;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by styqq on 04.01.16.
 */
public class SaveDataServlet extends HttpServlet {
    private TrackingDB db;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        db = new TrackingDB();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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