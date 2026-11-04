
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Iniciar sesión</title>
    </head>

    <body>

        <h1>Iniciar sesión</h1>

        <form action="LoginServlet" method="post">

            <label>Nombre de usuario:</label><br>
            <input type="text" name="usuario" required>
            <br><br>

            <label>Contraseña:</label><br>
            <input type="password" name="contraseña" required>
            <br><br>

            <button type="submit">Iniciar sesión</button>

        </form>

        <br>

        <a href="registro.jsp">Crear una cuenta</a>

    </body>
</html>
```