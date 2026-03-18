<%-- 
    Document   : index
    Author     : Anhpika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Chuyển hướng người dùng đến servlet load dữ liệu
    response.sendRedirect("product?service=loadAdd");
%>
