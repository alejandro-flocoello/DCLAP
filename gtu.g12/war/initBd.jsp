<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="utf-8">
    
    <title>Solicitud</title>
  </head>
  
  
<body>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="/css/style2.css">

    <header class="header-11">
            <div class="container">
                <div class="navbar span12">
                    <div class="navbar-inner">
                        <button type="button" class="btn btn-navbar"> </button>
                        <a class="brand"><img src="/img/logo@2.jpg" width="60" height="60"> GESTIÓN DE TARJETAS UNIVERSITARIAS</a>
                        <div class="nav-collapse collapse pull-right">
                            <ul class="nav">
                                <li><a href="/info">INFO</a></li>
                                <li><a href="/main">HOME</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>




        <section class="header-11-sub bg-azul-clarito">
            <div class="background">&nbsp;</div>
            <div class="container">
                <table class="table" style="width: 60%;" align="center">
		<tr>
			<th>Nombre</th>
			<th>Apellido1</th>
			<th>Apellido2</th>
			<th>Tipo Doc</th>
			<th>CodigoDoc</th>
			<th>Nacionalidad</th>
			<th>Universidad</th>
			<th>Centro</th>
			<th>Correo</th>
			<th>Categoria</th>
			<th>Expediente</th>
			<th>Monedero</th>
			<th>NumeroCuenta</th>
			<th>Pin</th>
			<th>CV2</th>
			<th>NumTarjeta</th>
			<th>Estado</th>
		</tr>
		<c:forEach items="${solicitudes}" var="solicitud">
			<tr>
				<td><c:out value="${solicitud.nombre}" /></td>
				<td><c:out value="${solicitud.apellido1}" /></td>
				<td><c:out value="${solicitud.apellido2}" /></td>
				<td><c:out value="${solicitud.tipoDoc}" /></td>
				<td><c:out value="${solicitud.codDoc}" /></td>
				<td><c:out value="${solicitud.nacionalidad}" /></td>
				<td><c:out value="${solicitud.domicilio}" /></td>
				<td><c:out value="${solicitud.nomUniv}" /></td>
				<td><c:out value="${solicitud.centroUniv}" /></td>
				<td><c:out value="${solicitud.correoUniv}" /></td>
				<td><c:out value="${solicitud.categoria}" /></td>
				<td><c:out value="${solicitud.expediente}" /></td>
				<td><c:out value="${solicitud.monedero}" /></td>
				<td><c:out value="${solicitud.cuentaBan}" /></td>
				<td><c:out value="${solicitud.pin}" /></td>
				<td><c:out value="${solicitud.cv2}" /></td>
				<td><c:out value="${solicitud.numTarjeta}" /></td>
				<td><c:out value="${solicitud.estado}" /></td>
			</tr>
		</c:forEach>
	</table>      
            </div>
        </section>
  </body>
</html>


