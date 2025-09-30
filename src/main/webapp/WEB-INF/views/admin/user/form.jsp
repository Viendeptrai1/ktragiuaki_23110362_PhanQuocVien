<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="vi">
<head><title>User Form</title></head>
<body>
<h2>User Form</h2>
<form method="post" action="/admin/users/save">
    <input type="hidden" name="userId" value="${u.userId}"/>
    <div>Username: <input type="text" name="username" value="${u.username}" required/></div>
    <div>Fullname: <input type="text" name="fullname" value="${u.fullname}"/></div>
    <div>Email: <input type="email" name="email" value="${u.email}"/></div>
    <div>Password: <input type="text" name="password" value="${u.password}"/></div>
    <div>Phone: <input type="text" name="phone" value="${u.phone}"/></div>
    <div>Status: <input type="number" name="status" value="${u.status}"/></div>
    <button type="submit">Lưu</button>
    <a href="/admin/users">Hủy</a>
    
</form>
</body>
</html>


