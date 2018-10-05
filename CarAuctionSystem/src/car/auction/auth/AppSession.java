package car.auction.auth;

import org.apache.shiro.SecurityUtils;

import car.auction.domain.User;

/**
 * record the application session using shiro mechanism
 */
public class AppSession {

    public static final String USER_ATTRIBUTE_NAME = "user"; // the identity of user
    public static final String BUYER_ROLE = "buyer";		 // the role identifier of buyer
    public static final String SELLER_ROLE = "seller";		 // the role identifier of seller

    // check if current logged in user belong to specific role
    public static boolean hasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }

    // check if current access is authenticated
    public static boolean isAuthenticated() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    // initiate user information of specific
    public static void init(User user) {
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
    }

    // get user information
    public static User getUser() {
        return (User) SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }
}

