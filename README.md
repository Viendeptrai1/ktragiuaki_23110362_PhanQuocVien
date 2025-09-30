# StarShop - Spring Boot + JPA + JSP (MSSV 23110362)

Sinh viên: Phan Quốc Viễn (MSSV: 23110362)

## 1) Công nghệ & môi trường
- JDK: 11
- Spring Boot: 2.7.18 (Tomcat 9, javax.servlet)
- View: JSP + JSTL (header/footer include). Có cấu hình Sitemesh 3.0.1 (có thể bật/tắt nhanh nếu cần)
- ORM: Spring Data JPA (Hibernate)
- CSDL: PostgreSQL (Docker Compose)

## 2) Khởi chạy nhanh
1) Database (Docker)
```
docker compose up -d
```
2) Ứng dụng (Windows PowerShell)
```
rm -Recurse -Force target
./mvnw.cmd clean spring-boot:run
```
3) Đường dẫn kiểm thử
- Home: http://localhost:8080/home
- Products: http://localhost:8080/products
- Login: http://localhost:8080/login
- Admin: http://localhost:8080/admin
- CRUD Users: http://localhost:8080/admin/users
- CRUD Categories: http://localhost:8080/admin/categories

Ghi chú: `db/init.sql` tạo bảng đúng theo đề và có seed demo (Seller, Category, Product). Nếu container DB đã tồn tại, dùng `docker compose down -v` rồi `docker compose up -d` để seed chạy lại.

## 3) Cấu trúc 3 tầng
- Presentation (MVC): controller + JSP views
- Business: service
- Data Access: repository (Spring Data JPA)
- Quy tắc đặt tên: `Class_MSSV.java` (ví dụ: `User_23110362`)

## 4) Đối chiếu yêu cầu đề bài
- Câu 1 (2.0đ)
  - Đã xây dựng mô hình 3 tầng; DB PostgreSQL theo đúng cấu trúc đề.
  - Sitemesh 3.0.1 (javax) cấu hình 2 decorator User/Admin (có thể bật/tắt). Khi tắt Sitemesh, dùng layout include `partials/header.jsp` và `partials/footer.jsp`.
  - Header: Trang Chủ, Sản phẩm, Đăng nhập/Đăng xuất, Trang quản trị (chỉ hiện nếu ADMIN). Footer: Họ tên, MSSV, Mã đề.
- Câu 2 (1.0đ)
  - Đăng ký/Đăng nhập/Đăng xuất sử dụng Session; điều hướng theo vai trò: ADMIN → `/admin`, USER → `/home`.
- Câu 3 (2.0đ)
  - `/products`: hiển thị tất cả sản phẩm, gom theo `SellerID` với ảnh, tên (link chi tiết), mã sản phẩm, danh mục, giá, amount.
- Câu 4 (2.0đ)
  - `/products/{id}`: trang chi tiết gồm ảnh, tên, mã sản phẩm, danh mục, giá, amount, description.
- Câu 5 (3.0đ)
  - CRUD + phân trang 5 cho User và Category: `/admin/users`, `/admin/categories`.

## 5) Tự đánh giá
- Câu 1: 1.0/2
- Câu 2: 1.0/1
- Câu 3: 2.0/2
- Câu 4: 2.0/2
- Câu 5: 3.0/3
- Tổng: 9/10
