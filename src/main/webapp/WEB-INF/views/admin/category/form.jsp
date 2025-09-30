<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="vi">
<head><title>Category Form</title></head>
<body>
<h2>Category Form</h2>
<form method="post" action="/admin/categories/save">
    <input type="hidden" name="categoryId" value="${c.categoryId}"/>
    <div>Tên: <input type="text" name="categoryName" value="${c.categoryName}" required/></div>
    <div>Ảnh: <input type="text" name="images" value="${c.images}"/></div>
    <div>Status: <input type="number" name="status" value="${c.status}"/></div>
    <button type="submit">Lưu</button>
    <a href="/admin/categories">Hủy</a>
    
</form>
</body>
</html>


