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
import java.sql.SQLException;

public class ProductDAO extends DBContext {

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
