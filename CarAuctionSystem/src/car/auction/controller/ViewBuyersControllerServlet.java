package car.auction.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.auction.domain.Buyer;
import car.auction.domain.UserInfoManagementService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

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
        String view = "/views/viewbuyers.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String buyerID = request.getParameter("buyerID");
        Buyer buyer = Buyer.getBuyer(Integer.parseInt(buyerID));

        // if delate failed then show the fail notification in View 
        if (buyer != null) {
        	UserInfoManagementService instance = UserInfoManagementService.getInstance();
        	if (!instance.deleteBuyer(Integer.parseInt(buyerID))) {
        		request.setAttribute("deleteFlag", "2");
        	}
        	
        }

        String view = "/views/viewbuyers.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

}
