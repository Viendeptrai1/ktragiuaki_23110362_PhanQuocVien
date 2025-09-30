<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<html lang="vi">
<head>
    <title>Trang chủ</title>
    <style>
        .hero { padding:24px; }
        .hero h1 { margin:0 0 8px; }
        .grid { display:grid; grid-template-columns: repeat(auto-fit,minmax(220px,1fr)); gap:16px; padding: 0 24px 24px; }
        .card { border:1px solid #eee; border-radius:8px; padding:16px; }
    </style>
</head>
<body>
<div class="hero">
    <h1>Chào mừng đến StarShop</h1>
    <p>Mua sắm dễ dàng, giá tốt mỗi ngày.</p>
</div>

<div class="grid">
    <div class="card">
        <h3>Sản phẩm mới</h3>
        <p>Khám phá các sản phẩm mới nhất.</p>
        <a href="/products">Xem sản phẩm</a>
    </div>
    <div class="card">
        <h3>Quản trị</h3>
        <p>Dành cho Admin quản lý dữ liệu.</p>
        <a href="/admin">Vào trang quản trị</a>
    </div>
    <div class="card">
        <h3>Tài khoản</h3>
        <p>Đăng nhập/đăng ký để mua sắm.</p>
        <a href="/login">Đăng nhập</a>
    </div>
    
</div>

<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>


