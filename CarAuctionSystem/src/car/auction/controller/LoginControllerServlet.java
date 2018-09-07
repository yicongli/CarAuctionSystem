package car.auction.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.auction.domain.Buyer;
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
		req.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// check if all fields were inputed
		if(!username.isEmpty() || password.isEmpty())
		{
			// check if can find the username in database and 
			// compare the found username's password with inputed one
			UserInfoManagementService instance = UserInfoManagementService.getInstance();
			Buyer buyer = instance.getBuyers(username);
			if (buyer != null && buyer.getPassword().equals(password)) {
				RequestDispatcher req = request.getRequestDispatcher("/views/homepage.jsp");
				request.setAttribute("loginFlag", "1");
				req.forward(request, response);
			}
		}
		
		RequestDispatcher req = request.getRequestDispatcher("/views/login.jsp");
		request.setAttribute("loginFlag", "2");
		req.include(request, response);
	}

}
