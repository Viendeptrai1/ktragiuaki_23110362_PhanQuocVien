<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="vi">
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký</h2>
<form method="post" action="/register">
    <label>Tên đăng nhập</label>
    <input type="text" name="username" required/>
    <label>Mật khẩu</label>
    <input type="password" name="password" required/>
    <label>Họ tên</label>
    <input type="text" name="fullname" required/>
    <label>Email</label>
    <input type="email" name="email"/>
    <label>Là Seller/Admin?</label>
    <input type="checkbox" name="seller"/>
    <button type="submit">Đăng ký</button>
    
</form>
</body>
</html>


