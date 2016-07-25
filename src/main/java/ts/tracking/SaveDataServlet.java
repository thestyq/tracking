package ts.tracking;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class SaveDataServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(SaveDataServlet.class.getName());

    private DataCollector dataCollector;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        LOG.info("Initialization...");

        try (InputStream input = new FileInputStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String host = properties.getProperty("mongoHost");
            int port = Integer.parseInt(properties.getProperty("mongoPort"));
            String username = properties.getProperty("mongoUserName");
            String password = properties.getProperty("mongoUserPassword");

            TrackingDB db = new TrackingDB(host, port, username, password);
            dataCollector = new DataCollector(db);

            LOG.info("Initialization completed!");
        } catch (Exception e) {
            LOG.severe("Initialization failed! ");
        }

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