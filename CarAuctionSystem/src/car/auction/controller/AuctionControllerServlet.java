package car.auction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.auction.auth.AppSession;
import car.auction.domain.AuctionManagementService;
import car.auction.domain.BiddingCar;

/**
 * Servlet implementation class AuctionControllerServlet
 */
@WebServlet("/auction")
public class AuctionControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionControllerServlet() {
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
			if (AppSession.hasRole(AppSession.BUYER_ROLE)) {
				// get all bidding cars and showing on the auction page
				AuctionManagementService instance = AuctionManagementService.getInstance();
				List<BiddingCar> cars =  instance.getBiddingCars();
				
				RequestDispatcher req = request.getRequestDispatcher("/views/auction.jsp");
				request.setAttribute("bidding_car", cars);
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
    protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
    	// if has logged in
    	if (AppSession.isAuthenticated()) {
    		// if the role is correct
            if (AppSession.hasRole(AppSession.BUYER_ROLE)) {
            	
            	String carID = request.getParameter("carID");
        		String sBiddingPrice = request.getParameter("bidding_price");
        		double biddingPrice = Double.parseDouble(sBiddingPrice);
        		int iCarID = Integer.parseInt(carID);
        		
        		// update specific car's bidding price
        		if (carID != null) {
        			AuctionManagementService instance = AuctionManagementService.getInstance();
        			if (instance.updateBiddingCarPrice(iCarID, biddingPrice, AppSession.getUser().getId())) {
        				request.setAttribute("bidFlag", "1");
        			}
        			else {
        				request.setAttribute("bidFlag", "2");
        			}
        			
        			// reload the auction page
        			doGet(request, response);
        		}
            } 
            else {
                response.sendError(403);
            }
        } else {
            response.sendError(401);
        }
	}

}
