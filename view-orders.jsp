<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Orders</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color: #f8f9fa;">
<div class="container py-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h4><i class="bi bi-box"></i> Your Orders</h4>
        </div>
        <div class="card-body">
            <c:forEach var="order" items="${requestScope.orders}">
                <div class="mb-4">
                    <h5>Order ID: ${order.id}</h5>
                    <p><strong>Order Date:</strong> ${order.orderDate}</p>

                    <h6>Order Items:</h6>
                    <ul class="list-group">
                        <c:forEach var="item" items="${order.items}">
                            <li class="list-group-item">
                                <strong>Book:</strong> ${item.book.title} <br>
                                <strong>Quantity:</strong> ${item.quantity}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>

           
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
