/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import static javax.enterprise.deploy.shared.ModuleType.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.BookFacadeLocal;
import za.ac.tut.entities.Book;
import javax.ejb.EJB;

/**
 *
 * @author Zoey
 */

public class ViewBooksServlet extends HttpServlet {

    @EJB
    private BookFacadeLocal bookFacade;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = bookFacade.findAll();
        request.setAttribute("books", books);

        String role = (String) request.getSession().getAttribute("role");
        if ("admin".equals(role)) {
            request.getRequestDispatcher("admin-view-books.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("view-books.jsp").forward(request, response);
        }
    }
}





