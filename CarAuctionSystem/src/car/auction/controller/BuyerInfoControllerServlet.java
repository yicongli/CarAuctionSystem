package car.auction.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.auction.domain.Buyer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * Servlet implementation class UserInfoControllerServlet
 */
@WebServlet("/buyers")
public class BuyerInfoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerInfoControllerServlet() {
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

        if (buyer != null) {
        	// TODO delete the buyer information.
//            int customerId = Session.getUser().getId();
//            ShoppingCart cart = ShoppingCart.getCartOf(customerId);
//            cart.addBook(book, 1, customerId);
        }

        String view = "/views/viewbuyers.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(view);
        requestDispatcher.forward(request, response);
    }

}
