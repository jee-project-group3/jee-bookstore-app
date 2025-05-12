<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h2 class="mt-4">Book Details</h2>

        <!-- Check if the book object exists -->
        <c:if test="${not empty book}">
            <div class="card mt-4">
                <div class="card-header">
                    <h3>${book.title}</h3>
                </div>
                <div class="card-body">
                    <p><strong>Author:</strong> ${book.author}</p>
                    <p><strong>Price:</strong> ${book.price}</p>
                    <p><strong>Stock:</strong> ${book.stock}</p>
                </div>
            </div>

            <!-- Back to book list -->
            <a href="ViewBooksServlet" class="btn btn-primary mt-3">Back to Book List</a>
        </c:if>
        
        <!-- Error message if no book found -->
        <c:if test="${empty book}">
            <p class="text-danger">Book not found.</p>
        </c:if>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>
