package za.ac.tut.web;

import za.ac.tut.bl.AppUserFacadeLocal;
import za.ac.tut.entities.AppUser;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ViewUsersServlet extends HttpServlet {

    @EJB
    private AppUserFacadeLocal appUserFacade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AppUser> users = appUserFacade.findAll(); // Assuming findAll() returns all users
        request.setAttribute("users", users);
        request.getRequestDispatcher("viewUsers.jsp").forward(request, response); // Forward to JSP
    }
}
