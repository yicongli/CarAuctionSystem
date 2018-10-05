package car.auction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.auction.auth.AppSession;
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
		// if has logged in
		if(AppSession.isAuthenticated()) {
			// if the role is correct
			if (AppSession.hasRole(AppSession.SELLER_ROLE)) {
				RequestDispatcher req = request.getRequestDispatcher("/views/viewbuyers.jsp");
				req.include(request, response);
			} 
			else {
				response.sendError(403);
			}
		}
		else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
		
		// if has logged in
		if (AppSession.isAuthenticated()) {
			// if the role is correct
            if (AppSession.hasRole(AppSession.SELLER_ROLE)) {
            	String username = request.getParameter("username");

                // delete specific user
                if (username != null) {
                	UserInfoManagementService instance = UserInfoManagementService.getInstance();
                	instance.deleteBuyer(username);
                }

                // show delete seccess message
                request.setAttribute("deleteFlag", "1");
        		RequestDispatcher req = request.getRequestDispatcher("/views/viewbuyers.jsp");
        		req.include(request, response);
            } 
            else {
                response.sendError(403);
            }
        } else {
            response.sendError(401);
        }
    }

}
