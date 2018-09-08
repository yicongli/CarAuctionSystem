package car.auction.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession(false);
		if(session == null 
			|| session.getAttribute("userinfo") == null
			|| session.getAttribute("sellerflag") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
		}
		else {
		
			RequestDispatcher req = request.getRequestDispatcher("/views/updateinfo.jsp");
			req.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			RequestDispatcher req = request.getRequestDispatcher("/views/updateinfo.jsp");
			req.include(request, response);
			return;
		}
		
		Boolean sellerFlag = (Boolean)session.getAttribute("sellerflag");
		
		UserInfoManagementService instance = UserInfoManagementService.getInstance();
		String username = request.getParameter("username");
		
		if (sellerFlag) {
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			Seller seller = (Seller)session.getAttribute("userinfo");
			instance.updateSellerInfo(username, password, address, seller);
			
			session.setAttribute("userinfo", seller);
		} else {
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String password = request.getParameter("password");
			String contact = request.getParameter("contact");
			
			Buyer buyer = (Buyer)session.getAttribute("userinfo");
			instance.updateBuyerInfo(buyer.getId(),username, password, first_name, last_name, contact);
		}
		
		session.setAttribute("userinfo", instance.getUser(username, sellerFlag));
		response.sendRedirect(request.getContextPath() + "/homepage");
	}

}