package ts.tracking;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class SaveDataServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(SaveDataServlet.class.getName());

    private DataCollector dataCollector;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dataCollector = new DataCollector();
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Some data arrived!");

        String oldCookie = req.getParameter("oldCookie");
        LOG.info("Old hash: " + oldCookie);

        String id = dataCollector.collectData(req);
        dataCollector.visit(id, oldCookie);

        LOG.info("New hash: " + id);
        resp.sendRedirect("savecookie?cookie=" + id);
    }

}