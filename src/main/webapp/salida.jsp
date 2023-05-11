<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="INC/metas.inc" />
        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}">
    </head>
    <body>
       
        <div id="contenedor">

            <p>Id usuario: <c:out value="${requestScope.usuario.idUsuario}"/></p>
            <p>Nombre: <c:out value="${requestScope.usuario.nombre}"/></p>

            <p>Fecha: <fmt:formatDate pattern = "dd-MM-yyyy" value = "${requestScope.usuario.fecha}" /></p>
            
            <p>Tipo: <c:out value="${requestScope.usuario.tipo}"/></p>
            <p>Identificador: <c:out value="${requestScope.usuario.identificador}"/></p>



        </div>
    </body>
</html>
