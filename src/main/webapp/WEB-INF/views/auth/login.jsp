<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<c:if test="${not empty error}"><div style="color:red">${error}</div></c:if>
<form method="post" action="/login">
    <label>Tên đăng nhập</label>
    <input type="text" name="username" required/>
    <label>Mật khẩu</label>
    <input type="password" name="password" required/>
    <button type="submit">Đăng nhập</button>
</form>
<p>Chưa có tài khoản? <a href="/register">Đăng ký</a></p>
</body>
</html>


