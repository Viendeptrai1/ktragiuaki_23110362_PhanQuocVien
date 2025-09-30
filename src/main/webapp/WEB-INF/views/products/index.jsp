<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/partials/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="vi">
<head>
    <title>Sản phẩm</title>
    <style>
        .seller { margin-bottom: 24px; }
        .item { padding: 8px 0; border-bottom: 1px solid #eee; }
        img { max-width: 100px; height: auto; }
        .name a { font-weight: 600; }
    </style>
    
</head>
<body>
<h2>Tất cả sản phẩm theo cửa hàng</h2>

<c:forEach var="entry" items="${grouped}">
    <div class="seller">
        <div><b>Mã cửa hàng:</b> <c:out value="${entry.key}"/></div>
        <c:forEach var="p" items="${entry.value}">
            <div class="item">
                <div>
                    <img src="${p.images}" alt="${p.productName}"/>
                </div>
                <div class="name">
                    <a href="/products/${p.productId}">${p.productName}</a>
                </div>
                <div>Mã sản phẩm: ${p.productCode}</div>
                <div>Danh mục: <c:out value="${p.category != null ? p.category.categoryName : 'N/A'}"/></div>
                <div>Giá: ${p.price}</div>
                <div>Amount: ${p.amount}</div>
            </div>
        </c:forEach>
    </div>
    
</c:forEach>

<%@ include file="/WEB-INF/views/partials/footer.jsp" %>
</body>
</html>


