package taskHelperController;

import model.User;

import javax.servlet.http.HttpSession;

public class Session {
	
	//private static final String PERMISSION = "permission";
	//private static final String USERID = "userid";
	private static final String USER_ATTRIBUTE_NAME = "user";

	private HttpSession httpSession;
	
	/**
	 * Get the instance of a session.
	 */
	private Session (HttpSession httpSession) {
			this.httpSession = httpSession;
	}
	
	public static Session refreshSession(HttpSession httpSession) {
		if(httpSession.getAttribute(USER_ATTRIBUTE_NAME)==null) {
			User user=User.getUser(1);
			httpSession.setAttribute(USER_ATTRIBUTE_NAME, user);
			httpSession.setMaxInactiveInterval(24*60*60);
		}
		return new Session(httpSession);
	}
	
	public User getUser() {
		return (User) httpSession.getAttribute(USER_ATTRIBUTE_NAME);
	}
	

}
