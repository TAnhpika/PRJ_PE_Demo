<%-- 
    Document   : ListCategory
    Author     : Anhpika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Category</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <h1>List Of Category!</h1>
        <table>
            <thead>
                <tr>
                    <th>Category ID</th>
                    <th>Category Name</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listC}" var="c">
                    <tr>
                        <td>${c.categoryID}</td>
                        <td>${c.categoryName}</td>
                        <td>${c.description}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="AddCategory.jsp"><button>Add Category</button></a>
        <a href="product?service=list"><button>List Product</button></a>
    </body>
</html>
