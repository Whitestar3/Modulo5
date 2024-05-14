<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style>
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background-color: #5a005a;
    background-image: url('Imagenes/imagen fondo alkewallet.jpg');
    background-size: cover;
    background-position: center;
    height: 100vh;
    display: flex;
    border-radius: 5px;
    justify-content: center;
    align-items: center;
}

.container {
    text-align: center;
}

h1 {
    color: #ffffff;
}

.btn {
    display: inline-block;
    padding: 10px 20px;
    background-color: #800080;
    color: #ffffff;
    text-decoration: none;
    border-radius: 5px;
    margin: 10px;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #5a005a;
}
</style>
</head>
<body>
<div class="container">
        <h1>Bienvenido a ALKEWALLET</h1>
        <a href="login.jsp" class="btn">Iniciar Sesión</a>
        
        <a href="registrar.jsp" class="btn">Registrarse</a>
    </div>
</body>
</html>