<%-- 
    Document   : ListProduct
    Author     : Anhpika
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Of Products</title>
        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
                padding: 5px;
            }
        </style>
    </head>
    <body>
        <h1>List Of Products!</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Unit</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Operations</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listP}" var="p">
                    <tr>
                        <td>${p.productID}</td>
                        <td>${p.productName}</td>
                        <td>${p.unit}</td>
                        <td>${p.categoryName}</td>
                        <td>${p.price}</td>
                        <td>
                            <a href="product?service=remove&id=${p.productID}">Remove</a>
                            <a href="product?service=edit&id=${p.productID}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>Number of Products: ${listP.size()}</p>
        
        <br>
        <a href="product?service=loadAdd"><button>Add Product</button></a>
        <a href="ListCategory.jsp"><button>List Category</button></a>
    </body>
</html>
