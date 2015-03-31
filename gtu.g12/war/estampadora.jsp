<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Empresa Estampadora</title>
<%
	String usuario = "";
	HttpSession sesionOk = request.getSession();
	if (sesionOk.getAttribute("estampadora") == null) {
%>
<jsp:forward page="interfazInicio.jsp">
	<jsp:param name="error" value="Esobligatorio identificarse" />
</jsp:forward>
<%
	} else {
		usuario = (String) sesionOk.getAttribute("estampadora");
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
						height="60"> GESTIÓN DE TARJETAS UNIVERSITARIAS - EMPRESA ESTAMPADORA</a>
					<div class="nav-collapse collapse pull-right">
						<ul class="nav">
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
			<div class="row clearfix">

				<div class="col-md-4 column">
					<h3>Solicitudes pendientes de aprobar:</h3>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Apellido1</th>
								<th>Apellido2</th>
								<th>Estado</th>
							</tr>
						</thead>

						<tbody>

							<tr class="success">
								<c:forEach items="${solicitudes}" var="solicitud">
									<td><c:out value="${solicitud.nombre}" /></td>
									<td><c:out value="${solicitud.apellido1}" /></td>
									<td><c:out value="${solicitud.apellido2}" /></td>
									<td><c:out value="${solicitud.estado}" /></td>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>


				<div class="col-md-4 column">
					<h3>Tarjetas pendientes de entregar:</h3>

					<table class="table table-hover">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Apellido1</th>
								<th>Apellido2</th>
								<th>Estado</th>
							</tr>
						</thead>
						<tbody>
							<tr class="warning">
								<c:forEach items="${solicitudes2}" var="solicitud">
									<td><c:out value="${solicitud.nombre}" /></td>
									<td><c:out value="${solicitud.apellido1}" /></td>
									<td><c:out value="${solicitud.apellido2}" /></td>
									<td><c:out value="${solicitud.estado}" /></td>
								</c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>


	<footer class="footer-2 bg-midnight-blue">
		<div class="container">
			<nav class="pull-left">
				<ul>
					<li class="active"><a href="/info">Home</a></li>
					<li><a href="#">Contactar</a></li>
				</ul>
			</nav>
	</footer>

</body>
</html>