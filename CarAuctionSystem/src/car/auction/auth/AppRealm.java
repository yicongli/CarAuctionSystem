package car.auction.auth;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import car.auction.domain.Buyer;
import car.auction.domain.Seller;
import car.auction.domain.User;
import car.auction.domain.UserInfoManagementService;

import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // identify account 
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        final String username = userPassToken.getUsername();

        final User user = UserInfoManagementService.getInstance().getUser(username);
        if (user == null) {
            System.out.println("No account found for user with username " + username);
            return null;
        }

        return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), user.getUsername());
    }

    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roles = new HashSet<>();
        if (principals.isEmpty()) {
            System.out.println("Given principals to authorize are empty.");
            return null;
        }

        Integer username = (Integer) principals.getPrimaryPrincipal();
       final User user = UserInfoManagementService.getInstance().getBuyerById(username);

        if (user == null) {
            System.out.println("No account found for user with username " + username);
            return null;
        }

        // add roles of the user according to its type
        if (user instanceof Seller) {
            roles.add(AppSession.SELLER_ROLE);
        } else if (user instanceof Buyer) {
            roles.add(AppSession.BUYER_ROLE);
        }

        return new SimpleAuthorizationInfo(roles);
    }
}
