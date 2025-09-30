-- Create schema objects for starshop
\connect starshop

-- Bảng vai trò người dùng
CREATE TABLE IF NOT EXISTS UserRoles (
    roleId SERIAL PRIMARY KEY,
    roleName VARCHAR(50) NOT NULL
);

-- Bảng danh mục
CREATE TABLE IF NOT EXISTS Category (
    categoryId SERIAL PRIMARY KEY,
    categoryName VARCHAR(200) NOT NULL,
    images VARCHAR(500),
    status INT
);

-- Bảng người bán
CREATE TABLE IF NOT EXISTS Seller (
    sellerId SERIAL PRIMARY KEY,
    sellerName VARCHAR(50) NOT NULL,
    images VARCHAR(500),
    status INT
);

-- Bảng người dùng
CREATE TABLE IF NOT EXISTS Users (
    userId SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    fullname VARCHAR(50),
    password VARCHAR(50),
    images VARCHAR(500),
    phone VARCHAR(20),
    status INT,
    code VARCHAR(50),
    roleId INT REFERENCES UserRoles(roleId),
    sellerId INT REFERENCES Seller(sellerId)
);

-- Bảng sản phẩm
CREATE TABLE IF NOT EXISTS Product (
    productId SERIAL PRIMARY KEY,
    productName VARCHAR(200) NOT NULL,
    productCode BIGINT,
    categoryId INT REFERENCES Category(categoryId),
    description VARCHAR(500),
    price FLOAT,
    amount INT,
    stock INT,
    images VARCHAR(500),
    wishlist INT,
    status INT,
    createDate DATE,
    sellerId INT REFERENCES Seller(sellerId)
);

-- Bảng giỏ hàng
CREATE TABLE IF NOT EXISTS Cart (
    cartId SERIAL PRIMARY KEY,
    userId INT REFERENCES Users(userId),
    buyDate TIMESTAMP,
    status INT
);

-- Bảng chi tiết giỏ hàng
CREATE TABLE IF NOT EXISTS CartItem (
    cartItemId SERIAL PRIMARY KEY,
    quantity INT,
    unitPrice FLOAT,
    productId INT REFERENCES Product(productId),
    cartId INT REFERENCES Cart(cartId)
);

-- Seed roles cơ bản
INSERT INTO UserRoles(roleName) VALUES ('USER') ON CONFLICT DO NOTHING;
INSERT INTO UserRoles(roleName) VALUES ('ADMIN') ON CONFLICT DO NOTHING;

-- Seed sellers
INSERT INTO Seller(sellerName, images, status) VALUES ('Shop A', NULL, 1);
INSERT INTO Seller(sellerName, images, status) VALUES ('Shop B', NULL, 1);

-- Seed categories
INSERT INTO Category(categoryName, images, status) VALUES ('Điện thoại', NULL, 1);
INSERT INTO Category(categoryName, images, status) VALUES ('Laptop', NULL, 1);

-- Seed products
INSERT INTO Product(productName, productCode, categoryId, description, price, amount, stock, images, wishlist, status, createDate, sellerId)
VALUES
('iPhone 14', 14001, 1, 'New iPhone', 19990000, 10, 10, 'https://via.placeholder.com/150', 0, 1, CURRENT_DATE, 1),
('Galaxy S23', 23001, 1, 'Samsung flagship', 15990000, 8, 8, 'https://via.placeholder.com/150', 0, 1, CURRENT_DATE, 1),
('MacBook Air M2', 52001, 2, 'Apple laptop', 28990000, 5, 5, 'https://via.placeholder.com/150', 0, 1, CURRENT_DATE, 2);

-- ==========================================
-- SEED DỮ LIỆU CHO DATABASE STARSHOP
-- ==========================================

-- 1. Vai trò người dùng
INSERT INTO UserRoles(roleName) VALUES ('USER') ON CONFLICT DO NOTHING;
INSERT INTO UserRoles(roleName) VALUES ('ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO UserRoles(roleName) VALUES ('SELLER') ON CONFLICT DO NOTHING;

-- 2. Danh mục sản phẩm
INSERT INTO Category(categoryName, images, status) VALUES
                                                       ('Hoa hồng', 'rose.jpg', 1),
                                                       ('Hoa lan', 'orchid.jpg', 1),
                                                       ('Hoa tulip', 'tulip.jpg', 1),
                                                       ('Hoa cưới', 'wedding.jpg', 1);

-- 3. Người bán
INSERT INTO Seller(sellerName, images, status) VALUES
                                                   ('Shop Hoa Tươi Viễn Đông', 'vien_dong.png', 1),
                                                   ('Cửa Hàng Lan Hồ Điệp', 'lan_hodiep.png', 1),
                                                   ('Tiệm Hoa Yêu Thương', 'yeu_thuong.png', 1);

-- 4. Người dùng
INSERT INTO Users(username, email, fullname, password, images, phone, status, code, roleId, sellerId) VALUES
                                                                                                          ('admin01', 'admin@starshop.com', 'Quản trị viên', '123456', NULL, '0909000111', 1, 'A01', 2, NULL),
                                                                                                          ('vien123', 'vien@gmail.com', 'Phan Quốc Viễn', '123456', NULL, '0909333444', 1, 'U01', 1, NULL),
                                                                                                          ('seller01', 'seller@lanhodiep.com', 'Nguyễn Văn Bán', '123456', NULL, '0909555666', 1, 'S01', 3, 2);

-- 5. Sản phẩm
INSERT INTO Product(productName, productCode, categoryId, description, price, amount, stock, images, wishlist, status, createDate, sellerId) VALUES
                                                                                                                                                 ('Bó hoa hồng đỏ 20 bông', 10001, 1, 'Hoa hồng đỏ tươi, thích hợp tặng sinh nhật', 350000, 1, 50, 'rose20.jpg', 0, 1, CURRENT_DATE, 1),
                                                                                                                                                 ('Chậu lan hồ điệp trắng', 10002, 2, 'Lan hồ điệp sang trọng, trang trí Tết', 1200000, 1, 20, 'orchid_white.jpg', 0, 1, CURRENT_DATE, 2),
                                                                                                                                                 ('Bó hoa tulip Hà Lan', 10003, 3, 'Tulip nhập khẩu, màu hồng phấn', 900000, 1, 15, 'tulip.jpg', 0, 1, CURRENT_DATE, 3),
                                                                                                                                                 ('Bó hoa cưới tone trắng - xanh', 10004, 4, 'Hoa cưới cao cấp, phong cách châu Âu', 1500000, 1, 10, 'wedding.jpg', 0, 1, CURRENT_DATE, 1);

-- 6. Giỏ hàng
INSERT INTO Cart(userId, buyDate, status) VALUES
                                              (2, CURRENT_TIMESTAMP, 1), -- user Viễn
                                              (2, NULL, 0);              -- giỏ hàng đang mở

-- 7. Chi tiết giỏ hàng
INSERT INTO CartItem(quantity, unitPrice, productId, cartId) VALUES
                                                                 (2, 350000, 1, 1), -- 2 bó hoa hồng đỏ trong giỏ 1
                                                                 (1, 1200000, 2, 1), -- 1 chậu lan hồ điệp trong giỏ 1
                                                                 (1, 900000, 3, 2);  -- 1 bó tulip trong giỏ đang mở

