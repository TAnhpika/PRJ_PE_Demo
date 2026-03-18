<%-- 
    Document   : AddCategory
    Author     : Anhpika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <body>
        <h1>Add Category!</h1>
        <form action="category" method="post">
            <input type="hidden" name="service" value="add" />
            Category Name: <input type="text" name="name" required /> <br><br>
            Description: <input type="text" name="description" /> <br><br>
            <input type="submit" value="Add" />
            <a href="category?service=list"><input type="button" value="Return to Category List" /></a>
        </form>
    </body>
</html>
