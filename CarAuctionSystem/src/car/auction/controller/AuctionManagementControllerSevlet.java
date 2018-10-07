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
	
	// Add new car opertation
	private void addNewCar(HttpServletRequest request, HttpServletResponse response) {
		String registerNumber = request.getParameter("register_number");
		String make  		  = request.getParameter("make");
		String model  		  = request.getParameter("model");
		String variant  	  = request.getParameter("variant");
		String year  		  = request.getParameter("year");
		String timeLeft  	  = request.getParameter("time_left");
		String currentBid     = request.getParameter("current_bid");
		
		float fCurrentBid = Float.parseFloat(currentBid);
		String[]timelist = timeLeft.split(":");
		long lTimeLeft = 0;
		for (int i = 1; i < timelist.length; i++) {
			lTimeLeft += Integer.parseInt(timelist[i]) * Math.pow(60, 3-i);
		}
		
		lTimeLeft += Integer.parseInt(timelist[0]) * 24 * 60 * 60;
		
		// add bidding car
		if(!registerNumber.isEmpty() && !make.isEmpty() && !model.isEmpty() 
				&& !variant.isEmpty() && !year.isEmpty() && !timeLeft.isEmpty() 
				&& !currentBid.isEmpty())
		{
			// check if the generating operation success
			AuctionManagementService instance = AuctionManagementService.getInstance();
			if (instance.AddBiddingCar(registerNumber, make, model, variant, year, fCurrentBid, lTimeLeft)) {
				request.setAttribute("addCarFlag", "1");	
				return;
			}
		}
		
		request.setAttribute("addCarFlag", "2");
	}
	
	// update specific car opertation
    private void updateCar(HttpServletRequest request, HttpServletResponse response) {
    	String carID		  = request.getParameter("carID");
    	String registerNumber = request.getParameter("register_number");
		String make  		  = request.getParameter("make");
		String model  		  = request.getParameter("model");
		String variant  	  = request.getParameter("variant");
		String year  		  = request.getParameter("year");
		
		int iCarID = Integer.parseInt(carID);
		
		// update specific car's bidding price
		if(!registerNumber.isEmpty() && !make.isEmpty() && !model.isEmpty() 
				&& !variant.isEmpty() && !year.isEmpty())
		{
			// check if the generating operation success
			AuctionManagementService instance = AuctionManagementService.getInstance();
			if (instance.updateBiddingCar(iCarID, registerNumber, make, model, variant, year)) {
				request.setAttribute("updateCarFlag", "1");	
				return;
			}
		}
		
		request.setAttribute("updateCarFlag", "2");
	}
	
    // delete specific car opertation
	private void deleteCar(HttpServletRequest request, HttpServletResponse response) {
		String carID = request.getParameter("carID");
		int iCarID = Integer.parseInt(carID);
		
		AuctionManagementService instance = AuctionManagementService.getInstance();
		if (instance.deleteBiddingCar(iCarID)) {
			request.setAttribute("deleteCarFlag", "1");	
			return;
		}
		
		request.setAttribute("deleteCarFlag", "2");
	}

}
