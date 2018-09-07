package car.auction.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.auction.domain.UserInfoManagementService;

/**
 * Servlet implementation class RegisterControllerServlet
 */
@WebServlet("/register")
public class RegisterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher req = request.getRequestDispatcher("/views/register.jsp");
		req.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		
		// check the if all info filled
		if(!first_name.isEmpty() && !last_name.isEmpty() && !username.isEmpty() && 
				!password.isEmpty() && !contact.isEmpty())
		{
			// check if the generating operation success
			UserInfoManagementService instance = UserInfoManagementService.getInstance();
			if (instance.generateNewBuyers(username, password, first_name, last_name, contact)) {
//				RequestDispatcher req = request.getRequestDispatcher("/login");
//				request.setAttribute("registerFlag", "1");
//				req.forward(request, response);
				
				HttpSession session = request.getSession(false);
				session.setAttribute("registerFlag", "1");
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}
		
		RequestDispatcher req = request.getRequestDispatcher("/views/register.jsp");
		request.setAttribute("registerFlag", "2");
		req.include(request, response);
	}
}
