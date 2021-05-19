<table border="2px">
    <tr>
        <td>Имя</td>
        <td>Email</td>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </#list>
</table>

<a href="/">На главную</a>