package za.ac.tut.web;

import za.ac.tut.bl.OrderFacadeLocal;
import za.ac.tut.entities.Order;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewAllOrdersServlet extends HttpServlet {

    @EJB
    private OrderFacadeLocal orderFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orders = orderFacade.findAll();
        request.setAttribute("orders", orders);

        request.getRequestDispatcher("viewOrders.jsp").forward(request, response);
    }
}
