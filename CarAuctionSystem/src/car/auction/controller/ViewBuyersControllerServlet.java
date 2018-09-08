package car.auction.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import car.auction.domain.UserInfoManagementService;

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UserInfoControllerServlet
 */
@WebServlet("/buyers")
public class ViewBuyersControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBuyersControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null 
			|| session.getAttribute("userinfo") == null
			|| session.getAttribute("sellerflag") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		else {
			RequestDispatcher req = request.getRequestDispatcher("/views/viewbuyers.jsp");
			req.include(request, response);
		}
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	if(session == null 
    			|| session.getAttribute("userinfo") == null
    			|| session.getAttribute("sellerflag") == null) {
    		response.sendRedirect(request.getContextPath() + "/login");
    		return;
    	}
    	
    	String username = request.getParameter("username");

        // if delate failed then show the fail notification in View 
        if (username != null) {
        	UserInfoManagementService instance = UserInfoManagementService.getInstance();
        	instance.deleteBuyer(username);
        }

        request.setAttribute("deleteFlag", "1");
		RequestDispatcher req = request.getRequestDispatcher("/views/viewbuyers.jsp");
		req.include(request, response);
    }

}
