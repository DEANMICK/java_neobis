<!DOCTYPE html>
<html lang="en">
<head>
    <title>Детальная информация</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
              integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <#if dto??>
        <h1>Ваши учетные данные!</h1>
        <p>${(dto.get().name)!'-- missing --'} - ${(dto.get().email)!'-- email missing --'}</p>
        <a type="button" class="btn btn-danger" href="/logout">Log out</a>
    <#else>
        <h1>Пользователь не найден!</h1>
    </#if>

    <div class="bottom-box">
        <a type="button" class="btn btn-primary" href="/">На главную страницу</a>
    </div>
</body>
</html>