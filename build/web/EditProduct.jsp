<%-- 
    Document   : EditProduct
    Author     : Anhpika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Product</title>
    </head>
    <body>
        <h1>Edit Product!</h1>
        <form action="product" method="post">
            <input type="hidden" name="service" value="edit" />
            
            ID Product: <input type="text" name="id" value="${p.productID}" readonly /> <br><br>
            Product Name: <input type="text" name="name" value="${p.productName}" required /> <br><br>
            Unit: <input type="text" name="unit" value="${p.unit}" /> <br><br>
            Category: 
            <select name="category">
                <c:forEach items="${listC}" var="c">
                    <option value="${c.categoryID}" ${c.categoryID == p.categoryID ? 'selected' : ''}>
                        ${c.categoryName} - ${c.description}
                    </option>
                </c:forEach>
            </select><br><br>
            Price: <input type="number" step="any" name="price" value="${p.price}" required /> <br><br>
            
            <input type="submit" value="Edit" />
            <a href="product?service=list"><input type="button" value="Return to Product List" /></a>
        </form>
    </body>
</html>
