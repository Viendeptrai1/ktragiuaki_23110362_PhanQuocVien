<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header style="padding:12px;border-bottom:1px solid #eee;display:flex;align-items:center;justify-content:space-between;">
  <div style="font-weight:700;">StarShop</div>
  <nav>
    <a href="/home" style="margin-right:12px;">Trang Chủ</a>
    <a href="/products" style="margin-right:12px;">Sản phẩm</a>
    <c:choose>
      <c:when test="${not empty sessionScope.CURRENT_USER}">
        <c:if test="${sessionScope.CURRENT_USER.role != null && sessionScope.CURRENT_USER.role.roleName == 'ADMIN'}">
          <a href="/admin" style="margin-right:12px;">Trang quản trị</a>
        </c:if>
        <a href="/logout">Đăng xuất</a>
      </c:when>
      <c:otherwise>
        <a href="/login">Đăng nhập</a>
      </c:otherwise>
    </c:choose>
  </nav>
</header>


