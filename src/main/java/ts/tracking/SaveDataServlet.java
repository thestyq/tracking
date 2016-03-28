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
    private CookieHandler cookieHandler;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dataCollector = new DataCollector();
        cookieHandler = new CookieHandler();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Some data arrived!");

        String cookie = cookieHandler.getCookieValue(req);
        String id = dataCollector.collectData(req);
        dataCollector.visit(id, cookie);

        cookieHandler.addCookie(resp, id);
    }



}