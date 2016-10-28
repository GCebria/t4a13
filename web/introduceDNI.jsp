<%-- 
    Document   : introduceDNI
    Created on : 28-oct-2016, 8:51:43
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="ServletAlumnos.jsp" method="POST">
        <h1>Introduce DNI a buscar</h1><br>
        <br>
        <input type="text" name="dni" value="" />
        <button type="submit" value="Enviar">Enviar</button>
        </form>
    </body>
</html>
