<%--
  Created by IntelliJ IDEA.
  User: chuon
  Date: 6/8/2022
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="row form-group" action="products">
    <input type="text" class=" col-4 form-control" name="key">
    <button class="col-1 btn btn-danger">Tìm kiếm</button>
</form>
<form class="row form-group" action="products" method="post">
    <input type="hidden" name="action" value="search-price">
    <input type="text" placeholder="gia dau"  name="key1">
    <input type="text" placeholder="gia sau" name="key2">
    <input type="submit" value="tim kiem">
<%--    <button class="col-1 btn btn-danger">Tìm kiếm</button>--%>
</form>
<c:forEach items="${products}" var="pro">
    <h1>${pro.name},${pro.price}
       <c:if test="${pro.price > 200}">
        <h5>Khuyễn mãi 10%</h5>
        </c:if>
        <c:if test="${pro.price < 200}">
            <h5>Khuyễn mãi 20%</h5>
        </c:if>
    </h1>
</c:forEach>
</body>
</html>
