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
import car.auction.domain.Buyer;
import car.auction.domain.CarHistory;

/**
 * Servlet implementation class HistoryControllerServlet
 */
@WebServlet("/history")
public class HistoryControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// if has logged in
		if(AppSession.isAuthenticated()) {
				
			Boolean isSeller = (Boolean) AppSession.isSellerRole();
			AuctionManagementService instance = AuctionManagementService.getInstance();
			List<CarHistory> history =  null;
			
			// get the history according to current user
			if (isSeller.booleanValue()) {
				history = instance.getSoldCarHistory();
			}
			else {
				Buyer buyer = (Buyer)AppSession.getUser();
				history = instance.getBoughtCarHistoryByBuyerID(buyer.getId());
			}
			
			RequestDispatcher req = request.getRequestDispatcher("/views/history.jsp");
			request.setAttribute("history", history);
			req.include(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath() + "/login");
		}
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }


}
