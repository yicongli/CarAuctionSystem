package car.auction.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import car.auction.domain.User;
import car.auction.domain.UserInfoManagementService;

/**
 * Servlet implementation class LoginControllerServlet
 */
@WebServlet("/login")
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/views/login.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sellerFlag = request.getParameter("sellerFlag");
        Boolean isSeller = Boolean.valueOf(sellerFlag);
        
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        token.setRememberMe(true);

        Subject currentUser = SecurityUtils.getSubject();

        try {
            //Authenticate the subject by passing the user name and password token into the login method
            currentUser.login(token);

            UserInfoManagementService instance = UserInfoManagementService.getInstance();
			User user = instance.getUser(username, isSeller);
            AppSession.init(user);
            
            response.sendRedirect(request.getContextPath() + "/homepage");
            
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
    		// if failed redirect to login page
    		RequestDispatcher req = request.getRequestDispatcher("/views/login.jsp");
    		request.setAttribute("loginFlag", "2");
    		req.include(request, response);
        }
	}

}
