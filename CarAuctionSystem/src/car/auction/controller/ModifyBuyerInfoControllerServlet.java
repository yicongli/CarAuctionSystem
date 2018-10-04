package car.auction.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.auction.auth.AppSession;
import car.auction.domain.Buyer;
import car.auction.domain.UserInfoManagementService;

/**
 * Servlet implementation class ModifyBuyerInfoControllerServlet
 */
@WebServlet("/modifybuyer")
public class ModifyBuyerInfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBuyerInfoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if has logged in
		if(AppSession.isAuthenticated()) {
			// if the role is correct
			if (AppSession.hasRole(AppSession.SELLER_ROLE)) {
				// if get id from view_buyers page, then go to the modify page
				UserInfoManagementService instance = UserInfoManagementService.getInstance();
				int id = Integer.parseInt(request.getParameter("id"));
				Buyer buyer = (Buyer)instance.getBuyerById(id);
				
				request.setAttribute("buyerinfo", buyer);
				
				RequestDispatcher req = request.getRequestDispatcher("/views/modifybuyerinfo.jsp");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// if has logged in
    	if (AppSession.isAuthenticated()) {
    		// if the role is correct
            if (AppSession.hasRole(AppSession.SELLER_ROLE)) {
            	
        		// update the buyer's information
        		UserInfoManagementService instance = UserInfoManagementService.getInstance();
        		int id = Integer.parseInt(request.getParameter("id"));
        		String username = request.getParameter("username");
        		String first_name = request.getParameter("first_name");
        		String last_name = request.getParameter("last_name");
        		String password = request.getParameter("password");
        		String contact = request.getParameter("contact");
        		instance.updateBuyerInfo(id,username, password, first_name, last_name, contact);

        		response.sendRedirect(request.getContextPath() + "/buyers");
            } 
            else {
                response.sendError(403);
            }
        } else {
            response.sendError(401);
        }
	}

}
