package ts.tracking;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * Created by styqq on 28.03.16.
 */
public class CookieHandler {
    private static final String COOKIE_NAME = "tracking";
    private static final int COOKIE_EXPIRY_TIME = 60 * 60 * 24 * 365 * 10;

    public String getCookieValue(HttpServletRequest req) {
        List<Cookie> cookies = Arrays.asList(req.getCookies());
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIE_NAME)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public void addCookie(HttpServletResponse resp, String id) {
        Cookie cookie = new Cookie(COOKIE_NAME, id);
        cookie.setMaxAge(COOKIE_EXPIRY_TIME);
        resp.addCookie(cookie);
    }
}
