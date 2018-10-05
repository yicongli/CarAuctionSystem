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
 * Servlet implementation class AuctionManagementControllerSevlet
 */
@WebServlet("/auctionmanagement")
public class AuctionManagementControllerSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuctionManagementControllerSevlet() {
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
				// load all bidding cars and show in auction management page
				AuctionManagementService instance = AuctionManagementService.getInstance();
				List<BiddingCar> cars =  instance.getBiddingCars();
				
				RequestDispatcher req = request.getRequestDispatcher("/views/auctionmanagement.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if has logged in
		if (AppSession.isAuthenticated()) {
			// if the role is correct
            if (AppSession.hasRole(AppSession.SELLER_ROLE)) {
            	// do operation according to the different flag
            	String sOpertationFlag = request.getParameter("operation_flag");
        		int operationflag = Integer.parseInt(sOpertationFlag);
        		
        		switch (operationflag) {
        		case 0:
        			addNewCar(request, response);
        			break;
        		case 1:
        			updateCar(request, response);
        			break;
        		case 2:
        			deleteCar(request, response);
        			break;
        		default:
        			return;
        		}
        		
        		doGet(request, response);
            } 
            else {
                response.sendError(403);
            }
        } else {
            response.sendError(401);
        }
	}
	
	// Add new car opertation TODO: add logic
	private void addNewCar(HttpServletRequest request, HttpServletResponse response) {
//		int registerNumber = Integer.parseInt(sRegisterNumber);
//		double biddingPrice = Double.parseDouble(sBiddingPrice);
//		
//		// update specific car's bidding price
//		if (sRegisterNumber != null) {
//			AuctionManagementService instance = AuctionManagementService.getInstance();
//			if (instance.updateBiddingCarPrice(registerNumber, biddingPrice)) {
//				request.setAttribute("bidFlag", "1");
//			}
//			else {
//				request.setAttribute("bidFlag", "2");
//			}
//			
//			RequestDispatcher req = request.getRequestDispatcher("/views/auction.jsp");
//			req.include(request, response);
//		}
	}
	
	// update specific car opertation TODO: add logic
    private void updateCar(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
    // delete specific car opertation TODO: add logic
	private void deleteCar(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
