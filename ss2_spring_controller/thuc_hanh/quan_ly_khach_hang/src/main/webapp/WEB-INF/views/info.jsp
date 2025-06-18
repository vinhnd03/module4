<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset style="width: 500px">
    <legend>Customer Information</legend>
    <form action="/customer" method="post">
        <table>
            <tr>
                <td>Id</td>
                <td><input type="text" name="id" value="${customer.id}" readonly></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="${customer.name}"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="${customer.email}"></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><input type="text" name="address" value="${customer.address}"></td>
            </tr>
            <tr>
                <td>
                    <button type="submit">Update</button>
                </td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
