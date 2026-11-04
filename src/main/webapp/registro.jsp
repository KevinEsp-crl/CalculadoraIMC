
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de usuario</title>
    </head>

    <body>

        <h1>Registro de usuario</h1>

        <form action="RegistroServlet" method="post">

            <label>Nombre completo:</label><br>
            <input type="text" name="nombre" required>
            <br><br>

            <label>Nombre de usuario:</label><br>
            <input type="text" name="usuario" required>
            <br><br>

            <label>Contraseña:</label><br>
            <input type="password" name="contraseña" required>
            <br><br>

            <label>Edad:</label><br>
            <input type="number" name="edad" min="15" required>
            <br><br>

            <label>Sexo:</label><br>
            <select name="sexo" required>
                <option value="">Selecciona una opción</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
            </select>
            <br><br>

            <label>Estatura (metros):</label><br>
            <input type="number" name="estatura"
                   min="1" max="2.5" step="0.01" required>
            <br><br>

            <button type="submit">Registrarse</button>

        </form>

    </body>
</html>
```