<!DOCTYPE html>
<html lang="en">
<head>
    <title>Поиск</title>
</head>
<body>
        <table border="2px">
            <tr>
                <td>Имя</td>
                <td>Email</td>
            </tr>
            <#list foodByName as user>
                <tr>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                </tr>
            </#list>
        </table>

<a href="/">На главную</a>
</body>
</html>