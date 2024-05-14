<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>
</head>
<body>
<table border="1">
<thead>
<tr>
<th>Esto es un c:out en el index</th>
<th>ID</th>
<th>Nombre</th>
<th>Apellido</th>
<th>Correo</th>
<th>Contraseña</th>
<th>Saldo</th>
</tr>
</thead>
<tbody>
<c:if test="${not empty lista}">
    <c:forEach var="usuario" items="${lista}">
        <tr>
            <td>Esto es un c:out en el index</td>
            <td><c:out value="${usuario.id}" /></td>
            <td><c:out value="${usuario.nombre}" /></td>
            <td><c:out value="${usuario.apellido}" /></td>
            <td><c:out value="${usuario.correo}" /></td>
            <td><c:out value="${usuario.contrasena}" /></td>
            <td><c:out value="${usuario.saldo}" /></td>
        </tr>
    </c:forEach>
</c:if>
</tbody>
</table>
</body>
</html>