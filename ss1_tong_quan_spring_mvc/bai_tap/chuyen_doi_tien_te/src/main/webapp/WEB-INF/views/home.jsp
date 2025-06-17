<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <th>USD</th>
            <th></th>
            <th>VND</th>
        </tr>
        <tr>
            <td><input type="number" name="usd" value="${usd}"></td>
            <td><p>=></p></td>
            <td><input type="number" name="vnd" value="${vnd}" readonly></td>
        </tr>
    </table>
    <button>Chuyển đổi</button>
</form>

</body>
</html>
