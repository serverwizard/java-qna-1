package codesquad.util;

import javax.servlet.http.HttpSession;

public class SessionUtils {
    private static final String SESSIONED_USER = "sessionedUser";

    public static Object getSessionedUser(HttpSession session) {
        if(isEmpty(session)) {
            return null;
        }
        return session.getAttribute(SESSIONED_USER);
    }

    private static boolean isEmpty(HttpSession session) {
        return session.getAttribute(SESSIONED_USER) == null;
    }
}
