<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h2>Setting</h2>
    <form:form method="post" modelAttribute="email">
        <table>
            <c:if test="${isUpdate == true}">
                <form:hidden path="id" />
            </c:if>
            <tr>
                <td>Languages:</td>
                <td>
                    <form:select path="language">
                        <form:options items="${languages}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>Page Size:</td>
                <td>
                    <span>Show </span>
                    <span>
                        <form:select path="pageSize">
                            <form:options items="${sizes}" />
                        </form:select>
                        </span>
                    <span>emails per page</span>
                </td>
            </tr>
            <tr>
                <td>Spams filter:</td>
                <td>
                    <span><form:checkbox path="filter"/></span><span>Enable spam filter</span>
                </td>
            </tr>
            <tr>
                <td>Signature:</td>
                <td><form:textarea path="signature" name="" cols="30" rows="5"/></td>
            </tr>
        </table>
        <div>
            <c:choose>
                <c:when test="${isUpdate == true}">
                    <button formaction="/edit">Update</button>
                </c:when>
                <c:otherwise>
                    <button formaction="/add">Add</button>
                </c:otherwise>
            </c:choose>

            <button>Cancel</button>
        </div>
    </form:form>
</div>
<div>
    <h2>Danh sách email:</h2>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Ngôn ngữ</th>
            <th>Kích thước</th>
            <th>Chế độ lọc spam</th>
            <th>Chữ ký</th>
        </tr>
        <c:forEach var="item" items="${emails}" varStatus="index">
            <tr>
                <td>${index.count}</td>
                <td>${item.id}</td>
                <td><a href="/email/${item.id}">${item.language}</a></td>
                <td>${item.pageSize}</td>
                <td>${item.filter}</td>
                <td>${item.signature}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
