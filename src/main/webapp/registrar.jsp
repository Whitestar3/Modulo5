<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar Usuario</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style>
body {
	background-image: url('Imagenes/imagen fondo alkewallet.jpg');
	}
</style>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
<h1>Registrate</h1>
<form action="inicio.jsp" method="post" onsubmit="mostrarAlerta()">
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" placeholder="Tu nombre" required>
    <label for="apellido">Apellido:</label>
    <input type="text" id="apellido" name="apellido" placeholder="Tu apellido" required>
    <label for="correo">Correo:</label>
    <input type="email" id="correo" name="correo" placeholder="ejemplo@gmail.com" required>
    <label for="contrasena">Contraseña:</label>
    <input type="password" id="contrasena" name="contrasena" placeholder="******" minlength="6" required pattern=".{6,}" title="La contraseña debe tener al menos 6 caracteres">
    <input type="submit" value="Enviar">
</form>
<script>
    function mostrarAlerta() {
        alert("Usuario creado exitosamente");
    }
</script>
<a href="login">Iniciar Sesión</a>
<a href="index.jsp">Home</a>
</body>
</html>