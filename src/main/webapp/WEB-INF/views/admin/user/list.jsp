<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head><title>Users</title></head>
<body>
<h2>Users</h2>
<p><a href="/admin/users/create">Tạo mới</a></p>
<table border="1" cellpadding="6" cellspacing="0">
    <tr>
        <th>ID</th><th>Username</th><th>Fullname</th><th>Email</th><th>Role</th><th>Action</th>
    </tr>
    <c:forEach var="u" items="${page.content}">
        <tr>
            <td>${u.userId}</td>
            <td>${u.username}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td><c:out value="${u.role != null ? u.role.roleName : 'USER'}"/></td>
            <td>
                <a href="/admin/users/edit/${u.userId}">Sửa</a>
                <a href="/admin/users/delete/${u.userId}" onclick="return confirm('Xóa?')">Xóa</a>
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


