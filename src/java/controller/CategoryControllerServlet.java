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

@WebServlet(name = "CategoryControllerServlet", urlPatterns = {"/category"})
public class CategoryControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String service = request.getParameter("service");
        if (service == null) {
            service = "list";
        }

        if ("list".equals(service)) {
            CategoryDAO dao = new CategoryDAO();
            List<Category> listC = dao.getAllCategories();
            request.setAttribute("listC", listC);
            request.getRequestDispatcher("ListCategory.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle add category logic here later
    }
}
