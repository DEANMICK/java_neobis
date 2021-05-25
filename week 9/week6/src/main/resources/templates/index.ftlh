<!DOCTYPE html>
<html lang="en">
<head>
    <title>Food</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<#if user??>
    <div>
        <a type="button" class="btn btn-primary" href="/profile">Профиль</a>
    </div>
<#else>
    <a type="button" class="btn btn-primary" href="/register">Регистрация</a>
    <a type="button" class="btn btn-primary" href="/login">Логин</a>
</#if>

    <form action="/search" method="GET">
        <label>
            <input name="name" value="">
        </label>
        <button type="submit">Найти</button>
    </form>

<#if user??>
    <a type="button" class="btn btn-primary" href="/detail">Получить список пользователей</a>
</#if>
</body>
</html>