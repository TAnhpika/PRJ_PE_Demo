package model;

public class Product {
    private int productID;
    private String productName;
    private String unit;
    private double price;
    private int categoryID;
    private String categoryName;

    public Product() {
    }

    public Product(int productID, String productName, String unit, double price, int categoryID, String categoryName) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Product(int productID, String productName, String unit, double price, int categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.categoryID = categoryID;
    }

    // Constructor phục vụ việc thêm mới Product (vì ID tự tăng)
    public Product(String productName, String unit, double price, int categoryID) {
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
