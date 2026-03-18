<%--
Document  : AddProduct
Created on : Mar 18, 2026, 5:07:16 PM
Author        : Anhpika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product!</h1>
        <form action="product" method="post">
            <!-- Sử dụng hidden input để gửi tham số service -->
            <input type="hidden" name="service" value="add" />
            Product name: <input type="text" name="name" value="" required/> <br><br>
            Unit:  <input type="text" name="unit" value="" required/><br><br>
            Category: <select name="category">
                <c:forEach items="${listC}" var="c">
                    <option value="${c.categoryID}">${c.categoryName} - ${c.description}</option>
                </c:forEach>
            </select><br><br>
            Price: <input type="number" name="price" value="" required/> <br><br>
            <input type="submit" value="Add" /> <a href="product?service=list"><input type="button" value="Return to Product List" /></a>
        </form>
    </body>
</html>
