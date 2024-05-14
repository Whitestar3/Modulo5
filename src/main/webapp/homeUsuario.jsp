<%@ page import="Modelo.Usuario" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style>
body {
	background-image: url('Imagenes/imagen fondo alkewallet inicio Sesion.jpg');
	}
</style>
</head>
<body>
<c:set var="usuario" value="${session.getAttribute('usuario')}" />
<c:set var="status" value="${session.getAttribute('status')}" />
<h1> Hola, <c:out value="${usuario.nombre}" /></h1>
<h3> Tienes un saldo de <c:out value="${usuario.saldo}" /></h3>
<form action="operacion" method="post">
    <h4>Escoge la operación a realizar:</h4>
    <label for="operacion">Operación:</label>
    <select id="operacion" name="operacion">
        <option value="depositar">Depositar</option>
        <option value="retirar">Retirar</option>
    </select>
    <label for="monto">Ingrese Monto:</label>
    <input type="number" id="monto" name="monto">
    <input type="submit" value="Enviar">
</form>
<button id="logout"><a href="logout">Cerrar Sesión</a></button>
<c:if test="${status != null}">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <c:choose>
        <c:when test="${status eq 'success'}">
            <script>
                swal.fire("Felicitaciones", "Operación exitosa", "success");
            </script>
        </c:when>
        <c:when test="${status eq 'failed'}">
            <script>
                swal.fire("Error", "Operación no se pudo realizar", "error");
            </script>
        </c:when>
    </c:choose>
</c:if>
</body>
</html>