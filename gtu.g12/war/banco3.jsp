<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>FormularioUniversidad</title>

<%
	String usuario = "";
	HttpSession sesionOk = request.getSession();
	if (sesionOk.getAttribute("banco") == null) {
%>
<jsp:forward page="interfazInicio.jsp">
	<jsp:param name="error" value="Esobligatorio identificarse" />
</jsp:forward>
<%
	} else {
		usuario = (String) sesionOk.getAttribute("banco");
	}
%>
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
					<button type="button" class="btn btn-navbar"></button>
					<a class="brand"><img src="/img/logo@2.jpg" width="60"
						height="60"> GESTIÓN DE TARJETAS UNIVERSITARIAS - BANCO</a>
					<div class="nav-collapse collapse pull-right">
						<ul class="nav">
							<li><a href="/universidad">VOLVER</a></li>
							<li><a href="/logout">LOGOUT</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>


	<section class="header-11-sub bg-azul-clarito">
		<div class="background">&nbsp;</div>
		<div class="container">

			<div class="row clearfix">

				<div class="col-md-3"></div>
				<div class="col-md-6 column">

					<h3>Solicitud de Usuario</h3>
					<h4>Valide los datos para avanzar en el proceso</h4>

					<form method="post" action="/changeState">
					<table class="table table-hover">

						<tbody>
							<tr>
								<td>Nombre</td>
								<td><c:out value="${solicitud.nombre}" /></td>
							</tr>

							<tr>
								<td>Apellido 1:</td>
								<td><c:out value="${solicitud.apellido1}" /></td>
							</tr>

							<tr>
								<td>Apellido 2:</td>
								<td><c:out value="${solicitud.apellido2}" /></td>
							</tr>

							<tr>
								<td>Tipo de Documento:</td>
								<td><c:out value="${solicitud.tipoDoc}" /></td>
							</tr>

							<tr>
								<td>Código:</td>
								<td><c:out value="${solicitud.codDoc}" /></td>
							</tr>

							<tr>
								<td>Domicilio:</td>
								<td><c:out value="${solicitud.domicilio}" /></td>
							</tr>
							
							<tr>
								<td>Email:</td>
								<input type="hidden" name="correoUniv" value="${solicitud.correoUniv}" />
								<td><c:out value="${solicitud.correoUniv}" /></td>
							</tr>

							<tr>
								<td>Escuela:</td>
								<td><c:out value="${solicitud.centroUniv}" /></td>
							</tr>

							<tr>
								<td>Tipo Solicitud:</td>
								<td><c:out value="${solicitud.categoria}" /></td>
							</tr>

							<tr>
								<td>Número Expediente:</td>
								<td><c:out value="${solicitud.expediente}" /></td>
							</tr>
							
							<tr>
								<td>Cuenta bancaria:</td>
								<td><c:out value="${solicitud.cuentaBan}" /></td>
							</tr>
							
							<tr>
								<td>Número de tarjeta:</td>
								<td><c:out value="${solicitud.numTarjeta}" /></td>
							</tr>
									
						</tbody>
					</table>
					<input type="button" class="btn btn-success" value="Notificar Universidad" onClick="location.href = '<c:url value="/not?correoUniv=${solicitud.correoUniv}"/>' ">
					</form>
					
				</div>
			</div>
		</div>
	</section>
</body>
</html>
