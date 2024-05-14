<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style>
body {
	background-image: url('Imagenes/imagen fondo alkewallet.jpg');
	position: center;
	}
</style>
</head>
<body>
<h1>Iniciar Sesión</h1>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<form action="login" method="post">
    <label for="correo">Correo:</label>
    <input type="email" id="correo" name="correo" placeholder="Pon tu Correo aquí" required>
    <label for="contrasena">Contraseña:</label>
    <input type="password" id="contrasena" name="contrasena" placeholder="******" required pattern=".{6,}" title="La contraseña debe tener al menos 6 caracteres">
    <input type="submit" value="Enviar">
</form>	
<script>
    function mostrarAlerta() {
        alert("Usuario o contraseña erroneo");
    }
</script>
<a href="registrar.jsp">Registrarse</a>
<a href="index.jsp">Home</a>

</body>
</html>