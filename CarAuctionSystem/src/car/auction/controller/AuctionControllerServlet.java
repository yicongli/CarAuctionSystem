package car.auction.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null 
			|| session.getAttribute("userinfo") == null
			|| session.getAttribute("sellerflag") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		else {
			AuctionManagementService instance = AuctionManagementService.getInstance();
			List<BiddingCar> cars =  instance.getBiddingCars();
			
			RequestDispatcher req = request.getRequestDispatcher("/views/auction.jsp");
			request.setAttribute("bidding_car", cars);
			req.include(request, response);
		}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null 
			|| session.getAttribute("userinfo") == null
			|| session.getAttribute("sellerflag") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		String sRegisterNumber = request.getParameter("register_number");
		String sBiddingPrice = request.getParameter("bidding_price");
		int registerNumber = Integer.parseInt(sRegisterNumber);
		double biddingPrice = Double.parseDouble(sBiddingPrice);
		
		// update specific car's bidding price
		if (sRegisterNumber != null) {
			AuctionManagementService instance = AuctionManagementService.getInstance();
			if (instance.updateBiddingCarPrice(registerNumber, biddingPrice)) {
				request.setAttribute("bidFlag", "1");
			}
			else {
				request.setAttribute("bidFlag", "2");
			}
			
			RequestDispatcher req = request.getRequestDispatcher("/views/auction.jsp");
			req.include(request, response);
		}
	}

}
