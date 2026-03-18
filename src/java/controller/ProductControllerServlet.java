package controller;

import dal.CategoryDAO;
import model.Category;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dal.ProductDAO;
import model.Product;

@WebServlet(name = "ProductControllerServlet", urlPatterns = {"/product"})
public class ProductControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("service");
        if (action == null) {
            action = "list"; // default action
        }

        switch (action) {
            case "loadAdd":
                loadAddPage(request, response);
                break;
            case "list":
                // Handle list logic here
                break;
            default:
                break;
        }
    }

    private void loadAddPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO cDao = new CategoryDAO();
        List<Category> listC = cDao.getAllCategories();
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("service");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String unit = request.getParameter("unit");
            double price = Double.parseDouble(request.getParameter("price"));
            int categoryId = Integer.parseInt(request.getParameter("category"));

            Product p = new Product(name, unit, price, categoryId);
            ProductDAO pDao = new ProductDAO();
            pDao.addProduct(p);
            response.sendRedirect("product?service=loadAdd");
        }
    }
}
