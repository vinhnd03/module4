<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Địa chỉ</th>
    </tr>
    <c:forEach var="item" items="${customerList}">
        <tr>
            <td>${item.id}</td>
            <td><a href="/customer/${item.id}">${item.name}</a></td>
            <td>${item.email}</td>
            <td>${item.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
