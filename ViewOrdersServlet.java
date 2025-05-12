package za.ac.tut.web;

import za.ac.tut.bl.OrderFacadeLocal;
import za.ac.tut.bl.AppUserFacadeLocal;
import za.ac.tut.entities.AppUser;
import za.ac.tut.entities.Order;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewOrdersServlet extends HttpServlet {

    @EJB
    private OrderFacadeLocal orderFacade;

    @EJB
    private AppUserFacadeLocal appUserFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        AppUser user = appUserFacade.findByUsername(username);

        List<Order> orders = orderFacade.findByUser(user);
        request.setAttribute("orders", orders);

        request.getRequestDispatcher("view-orders.jsp").forward(request, response);
    }
}
