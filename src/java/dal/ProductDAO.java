package dal;

import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DBContext {

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT p.ProductID, p.ProductName, p.Unit, p.Price, p.CategoryID, c.CategoryName "
                   + "FROM Product p JOIN Category c ON p.CategoryID = c.CategoryID";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Unit"),
                        rs.getDouble("Price"),
                        rs.getInt("CategoryID"),
                        rs.getString("CategoryName")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int addProduct(Product p) {
        String sql = "INSERT INTO Product (ProductName, Unit, Price, CategoryID) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getUnit());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getCategoryID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteProduct(int pid) {
        String sql = "DELETE FROM Product WHERE ProductID = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, pid);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Product getProductByID(int pid) {
        String sql = "SELECT * FROM Product WHERE ProductID = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getString("Unit"),
                        rs.getDouble("Price"),
                        rs.getInt("CategoryID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int updateProduct(Product p) {
        String sql = "UPDATE Product SET ProductName = ?, Unit = ?, Price = ?, CategoryID = ? WHERE ProductID = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setString(2, p.getUnit());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getCategoryID());
            ps.setInt(5, p.getProductID());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
