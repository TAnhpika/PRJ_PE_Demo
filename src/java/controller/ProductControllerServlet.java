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
                listProduct(request, response);
                break;
            case "remove":
                removeProduct(request, response);
                break;
            case "edit":
                loadEditPage(request, response);
                break;
            default:
                break;
        }
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO pDao = new ProductDAO();
        pDao.deleteProduct(id);
        response.sendRedirect("product?service=list");
    }

    private void loadEditPage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO pDao = new ProductDAO();
        CategoryDAO cDao = new CategoryDAO();

        Product p = pDao.getProductByID(id);
        List<Category> listC = cDao.getAllCategories();

        request.setAttribute("p", p);
        request.setAttribute("listC", listC);
        request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO pDao = new ProductDAO();
        List<Product> listP = pDao.getAllProduct();
        request.setAttribute("listP", listP);
        request.getRequestDispatcher("ListProduct.jsp").forward(request, response);
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
            response.sendRedirect("product?service=list");
        } else if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String unit = request.getParameter("unit");
            double price = Double.parseDouble(request.getParameter("price"));
            int categoryId = Integer.parseInt(request.getParameter("category"));

            Product p = new Product(id, name, unit, price, categoryId);
            ProductDAO pDao = new ProductDAO();
            pDao.updateProduct(p);
            response.sendRedirect("product?service=list");
        }
    }
}
