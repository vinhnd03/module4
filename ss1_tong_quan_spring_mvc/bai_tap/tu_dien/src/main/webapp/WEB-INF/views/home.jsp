<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="" method="post">
    <table>
        <tr>
            <th>English</th>
            <th></th>
            <th>Vietnamese</th>
        </tr>
        <tr>
            <td><input type="text" name="eng" value="${eng}"></td>
            <td><p>=></p></td>
            <td><input type="text" name="viet" value="${viet}" readonly></td>
        </tr>
    </table>
    <button>Dịch</button>
    <h6>${message}</h6>
</form>

</body>
</html>
