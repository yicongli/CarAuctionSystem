package car.auction.auth;

import org.apache.shiro.SecurityUtils;

import car.auction.domain.User;

public class AppSession {

    public static final String USER_ATTRIBUTE_NAME = "user";
    public static final String BUYER_ROLE = "buyer";
    public static final String SELLER_ROLE = "seller";

    public static boolean hasRole(String role) {
        return SecurityUtils.getSubject().hasRole(role);
    }
    
    public static boolean isSellerRole () {
    	return SecurityUtils.getSubject().hasRole(SELLER_ROLE);
    }

    public static boolean isAuthenticated() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    public static void init(User user) {
        SecurityUtils.getSubject().getSession().setAttribute(USER_ATTRIBUTE_NAME, user);
    }

    public static User getUser() {
        return (User) SecurityUtils.getSubject().getSession().getAttribute(USER_ATTRIBUTE_NAME);
    }
}

