package car.auction.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		RequestDispatcher req = request.getRequestDispatcher("/views/login.jsp");
		HttpSession session = request.getSession(false);
		session.removeAttribute("userinfo");
		session.removeAttribute("sellerflag");
		req.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sellerFlag = request.getParameter("sellerFlag");
		Boolean isSeller = Boolean.getBoolean(sellerFlag);
		
		// check if all fields were inputed
		if(!username.isEmpty() || password.isEmpty())
		{
			// check if can find the username in database and 
			// compare the found username's password with inputed one
			UserInfoManagementService instance = UserInfoManagementService.getInstance();
			User user = instance.getUser(username, isSeller);
			
			if (user != null && user.getPassword().equals(password)) {
				HttpSession session = request.getSession(false);
				session.setAttribute("userinfo", user);
				session.setAttribute("sellerflag", isSeller);
				response.sendRedirect(request.getContextPath() + "/homepage");
				
//				RequestDispatcher req = request.getRequestDispatcher("/homepage");
//				request.setAttribute("userinfo", user);
//				request.setAttribute("sellerflag", isSeller);
//
//				req.forward(request, response);
				
				return;
			}
		}
		
		RequestDispatcher req = request.getRequestDispatcher("/views/login.jsp");
		request.setAttribute("loginFlag", "2");
		req.include(request, response);
	}

}
