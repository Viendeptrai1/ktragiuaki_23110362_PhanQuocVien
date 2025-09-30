<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sitemesh" uri="http://www.sitemesh.org/sitemesh3" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8"/>
    <title><sitemesh:write property='title'/></title>
    <sitemesh:write property='head'/>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body { font-family: 'Inter', system-ui, -apple-system, Segoe UI, Roboto, Helvetica, Arial, 'Noto Sans', 'Liberation Sans', sans-serif; }
        nav a { margin-right: 12px; }
    </style>
</head>
<body>
<header>
    <nav>
        <a href="/home">Trang Chủ</a>
        <a href="/products">Sản phẩm</a>
        <c:choose>
            <c:when test="${not empty sessionScope.CURRENT_USER}">
                <a href="/logout">Đăng xuất</a>
                <c:if test="${sessionScope.CURRENT_USER.role.roleName == 'ADMIN'}">
                    <a href="/admin">Trang quản trị</a>
                </c:if>
            </c:when>
            <c:otherwise>
                <a href="/login">Đăng nhập</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>

<main>
    <sitemesh:write property='body'/>
    
</main>

<footer>
    <div>Họ tên: Phan Quốc Viện | MSSV: 23110362 | Mã đề: ktragiuaki</div>
    <div>&copy; StarShop</div>

</footer>
</body>
</html>


