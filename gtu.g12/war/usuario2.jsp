<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<title>FormularioVerificaciónUsuario</title>

<%
	String usuario = "";
	HttpSession sesionOk = request.getSession();
	if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="interfazInicio.jsp">
	<jsp:param name="error" value="Esobligatorio identificarse" />
</jsp:forward>
<%
	} else {
		usuario = (String) sesionOk.getAttribute("usuario");
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
					<a class="brand"><img src="/img/logo@2.jpg" width="80"
						height="80"> GESTIÓN DE TARJETAS UNIVERSITARIAS</a>
					<div class="nav-collapse collapse pull-right">
						<ul class="nav">
							<li><a href="/main">HOME</a></li>
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
				<div class="col-md-6">
					<h3>Valide sus datos para continuar con el proceso</h3>
					<h6>Si algun dato no es correcto póngase en contacto con bbdd@taruni.upm</h6>
				</div>

				<div class="col-md-3"></div>
			</div>

			<div class="row clearfix">
				<div class="col-md-3"></div>
				<div class="col-md-6 column">


					<form method="post" action="/changeState" enctype="multipart/form-data">

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
									<td>Domicilio</td>
									<td><c:out value="${solicitud.domicilio}" /></td>
								</tr>

								<tr>
									<td>Escuela</td>
									<td><c:out value="${solicitud.centroUniv}" /></td>
								</tr>

								<tr>
									<td>Tipo Solicitud</td>
									<td><c:out value="${solicitud.categoria}" /></td>
								</tr>

								<tr>
									<td>Número Expediente</td>
									<td><c:out value="${solicitud.expediente}" /></td>
								</tr>
								
								<tr>
									<td>Adjunte una foto actual por favor:</td>
									<td><input type='file' class="form-control" name="foto" value=""></td>
								</tr>		
							</tbody>
						</table>
						
						<input type="submit" value="Validar" class="btn btn-block btn-success">
					
					</form>
					<form method="get" action="/main" class="controls controls-row">
						<input type="submit" value="Cancelar" class="btn btn-block btn-danger">
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>