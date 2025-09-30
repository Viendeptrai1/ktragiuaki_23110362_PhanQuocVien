<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head><title>Categories</title></head>
<body>
<h2>Categories</h2>
<p><a href="/admin/categories/create">Tạo mới</a></p>
<table border="1" cellpadding="6" cellspacing="0">
    <tr>
        <th>ID</th><th>Tên</th><th>Ảnh</th><th>Status</th><th>Action</th>
    </tr>
    <c:forEach var="c" items="${page.content}">
        <tr>
            <td>${c.categoryId}</td>
            <td>${c.categoryName}</td>
            <td>${c.images}</td>
            <td>${c.status}</td>
            <td>
                <a href="/admin/categories/edit/${c.categoryId}">Sửa</a>
                <a href="/admin/categories/delete/${c.categoryId}" onclick="return confirm('Xóa?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<div>
    <c:if test="${!page.first}"><a href="?page=${page.number - 1}">Prev</a></c:if>
    Trang ${page.number + 1}/${page.totalPages}
    <c:if test="${!page.last}"><a href="?page=${page.number + 1}">Next</a></c:if>
</div>
</body>
</html>


