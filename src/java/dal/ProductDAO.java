/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author Anhpika
 */
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
}
