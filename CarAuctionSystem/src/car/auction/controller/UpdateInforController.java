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
import car.auction.domain.Seller;
import car.auction.domain.UserInfoManagementService;

/**
 * Servlet implementation class UpdateInforController
 */
@WebServlet("/update")
public class UpdateInforController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInforController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if has logged in
		if(AppSession.isAuthenticated()) {
			if (AppSession.hasRole(AppSession.SELLER_ROLE) || AppSession.hasRole(AppSession.BUYER_ROLE)) {
				RequestDispatcher req = request.getRequestDispatcher("/views/updateinfo.jsp");
				req.include(request, response);
			}
			else {
				response.sendError(403);
			}
		}
		else {
			response.sendRedirect(request.getContextPath() + "/logout");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if has logged in
    	if (AppSession.isAuthenticated()) {
    		
    		UserInfoManagementService instance = UserInfoManagementService.getInstance();
    		String username = request.getParameter("username");
    		
    		// if the role is correct
            if (AppSession.hasRole(AppSession.SELLER_ROLE)) {
            	// update seller information
            	String password = request.getParameter("password");
    			String address = request.getParameter("address");

    			Seller seller = (Seller)AppSession.getUser();
    			instance.updateSellerInfo(username, password, address, seller);
    			
    			response.sendRedirect(request.getContextPath() + "/homepage");
            } 
            else if (AppSession.hasRole(AppSession.BUYER_ROLE)){
            	// update buyer information
                String first_name = request.getParameter("first_name");
    			String last_name = request.getParameter("last_name");
    			String password = request.getParameter("password");
    			String contact = request.getParameter("contact");
    			
    			Buyer buyer = (Buyer)AppSession.getUser();
    			instance.updateBuyerInfo(buyer.getId(),username, password, first_name, last_name, contact);
    			response.sendRedirect(request.getContextPath() + "/homepage");
            }
            else {
            	response.sendError(403);
			}
            
        } else {
            response.sendError(401);
        }
	}

}
