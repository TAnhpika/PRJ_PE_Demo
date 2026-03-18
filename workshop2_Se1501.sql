CREATE DATABASE workshop2_Se1501;
GO

USE workshop2_Se1501;
GO

-- 1. Tạo bảng Category (Danh mục)
CREATE TABLE Category (
    CategoryID INT PRIMARY KEY IDENTITY(1,1),   -- Mã danh mục
    CategoryName NVARCHAR(100) NOT NULL,  -- Tên danh mục
    Description NVARCHAR(255)             -- Mô tả (Thông tin bổ sung)
);

-- 2. Tạo bảng Product (Sản phẩm)
CREATE TABLE Product (
    ProductID INT PRIMARY KEY IDENTITY(1,1),
    ProductName NVARCHAR(255) NOT NULL,
    Unit NVARCHAR(50),
    Price FLOAT, 
    CategoryID INT,
    CONSTRAINT FK_Product_Category FOREIGN KEY (CategoryID) REFERENCES Category(CategoryID)
);

-- 3. Chèn dữ liệu vào bảng Category (Có thêm Description)
INSERT INTO Category (CategoryName, Description) VALUES
('Nokia', N'Hãng điện thoại'),
('Vinamilk', N'Hãng sữa'),
('Mazda', N'Hãng ô tô'),
('Toyota', N'Hãng xe hơi');

-- 4. Chèn dữ liệu vào bảng Product
INSERT INTO Product (ProductName, Unit, CategoryID, Price) VALUES
(N'Nokia 5.4', N'máy', 1, 2800000.0),
(N'Mazda 3 Luxury', N'chiếc', 3, 726000000.0),
(N'Sữa tiệt trùng', N'hộp', 2, 25000.0),
(N'Sữa chua', N'hộp', 2, 26000.0);

-- 5. Truy vấn để hiển thị bảng giống hệt trong ảnh (Sử dụng JOIN)
SELECT 
    p.ProductID AS [ID], 
    p.ProductName AS [Name], 
    p.Unit, 
    c.CategoryName AS [Category], 
    p.Price
FROM Product p
JOIN Category c ON p.CategoryID = c.CategoryID;

