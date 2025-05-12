package za.ac.tut.web;

import za.ac.tut.entities.Book;
import za.ac.tut.bl.BookFacadeLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Define the URL pattern for the servlet
public class ViewBookDetailsServlet extends HttpServlet {

    // Injecting the BookFacadeLocal EJB
    @EJB
    private BookFacadeLocal bookFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the book ID from the request
        String bookIdParam = request.getParameter("id");

        if (bookIdParam != null && !bookIdParam.isEmpty()) {
            try {
                Long bookId = Long.valueOf(bookIdParam);

                // Fetch the book details using the facade
                Book book = bookFacade.find(bookId);

                if (book != null) {
                    // Set the book as a request attribute
                    request.setAttribute("book", book);
                    // Forward the request to the JSP page to display the book details
                    request.getRequestDispatcher("/viewBookDetails.jsp").forward(request, response);
                } else {
                    response.getWriter().write("Book not found.");
                }
            } catch (NumberFormatException e) {
                response.getWriter().write("Invalid book ID.");
            }
        } else {
            response.getWriter().write("Book ID is missing.");
        }
    }
}
