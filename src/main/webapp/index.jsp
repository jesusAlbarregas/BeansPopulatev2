<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application" />
<c:url var="estilo" value="/CSS/estilo.css" scope="application" />
<!DOCTYPE html>
<html lang="es">
    <head>
        <jsp:include page="INC/metas.inc" />
        <title>Inicio</title>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}">
    </head>
    <body>
        <div id="contenedor">



            <form name="formulario" method="post" action="${applicationScope.contexto}/Entrada">

                <p>
                    <label for="id">Id usuario: </label>
                    <input type="text" name="idUsuario" minlength="1"  maxlength="4" required>
                </p>
                <p>
                    <label for="nombre">Nombre: </label>
                    <input type="text" name="nombre" required="required">
                </p>
                <p>
                    <label for="fecha">Fecha: </label>
                    <input type="date" name="fecha" required="required">
                </p>
                <p>
                    <label for="tipo">Tipo:</label>
                    <select name="tipo" required="required">
                        <option value="NIF" selected="selected">NIF</option>
                        <option value="NIE">NIE</option>
                        <option value="Pasaporte">Pasaporte</option>
                    </select>
                </p>
                <p>
                    <label for="identificador">Identificador: </label>
                    <input type="text" name="identificador" required="required">
                </p>
                <p><input type="submit" name="enviar" value="enviar" class="boton"></p>
            </form>


        </div>
    </body>
</html>
