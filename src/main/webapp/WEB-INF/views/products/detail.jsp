<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head>
    <title>Chi tiết sản phẩm</title>
    <style>
        img { max-width: 200px; height: auto; }
        .row { margin: 6px 0; }
        b { display:inline-block; width: 140px; }
    </style>
</head>
<body>
<h2>Chi tiết sản phẩm</h2>
<div>
    <div class="row"><img src="${p.images}" alt="${p.productName}"/></div>
    <div class="row"><b>Tên sản phẩm:</b> ${p.productName}</div>
    <div class="row"><b>Mã sản phẩm:</b> ${p.productCode}</div>
    <div class="row"><b>Danh mục:</b> <c:out value="${p.category != null ? p.category.categoryName : 'N/A'}"/></div>
    <div class="row"><b>Giá:</b> ${p.price}</div>
    <div class="row"><b>Amount:</b> ${p.amount}</div>
    <div class="row"><b>Description:</b> ${p.description}</div>
</div>

<p><a href="/products">Quay lại danh sách</a></p>
<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>


