<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>
<%@ page session="true"%>


<!DOCTYPE html>

<html lang="en">

<head>
<meta charset="utf-8">
<title>FormularioBanco</title>

<%
	String usuario = "";
	HttpSession sesionOk = request.getSession();
	if (sesionOk.getAttribute("banco") == null) {
%>
<jsp:forward page="interfazInicio.jsp">
	<jsp:param name="error" value="Es obligatorio identificarse" />
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
						height="60"> GESTIÓN DE TARJETAS UNIVERSITARIAS</a>
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
				<div class="col-md-6 column">

					<h3 class="text-center">Banco</h3>


					<form role="form" method="get" action="/changeState">
						<div class="form-group">
							<label for="inputNom">Nombre</label> 
							<input type="text" class="form-control" value="${solicitud.nombre}" disabled>
						</div>

						<div class="form-group">
							<label for="inputAp1">Apellido1</label> 
							<input type="text" class="form-control" value="${solicitud.apellido1}" disabled>
						</div>

						<div class="form-group">
							<label for="inputAp2">Apellido2</label> 
							<input type="text" class="form-control" value="${solicitud.apellido2}" disabled>
						</div>

						<div class="form-group">
							<label for="inputTipodoc">Tipo de Documento</label> 
							<input type="text" class="form-control" value="${solicitud.tipoDoc}" disabled>
						</div>

						<div class="form-group">
							<label for="inputCodigo">Código identificación</label> 
							<input type="text" class="form-control" value="${solicitud.codDoc}" disabled>
						</div>

						<div class="form-group">
							<label for="inputNacionalidad">Nacionalidad</label> 
							<input type="text" class="form-control" value="${solicitud.nacionalidad}" disabled>
						</div>

						<div class="form-group">
							<label for="inputDom">Domicilio</label> 
							<input type="text" class="form-control" value="${solicitud.domicilio}" disabled>
						</div>
						
						<div class="form-group">
							<label for="inputAp1">Email</label> 
							<input type="text" class="form-control" name=correoUniv value="${solicitud.correoUniv}">
						</div>

						<div class="form-group">
							<label for="inputCuenta">Cuenta Bancaria</label> 
							<input type="text" class="form-control" name="Cuenta" value="">
						</div>

						<div class="form-group">
							<label for="inputPin">PIN</label> 
							<input type="password" class="form-control" name="Pin" value="">
						</div>

						<div class="form-group">
							<label for="inputCV2">CV2</label> 
							<input type="text" class="form-control" name="CV2" value="">
						</div>		
						
						<input type="submit" class="btn btn-success" value="Validar">
						<input type="button" class="btn btn-danger" value="Rechazar" onClick="location.href = '/logout' ">											 -->
					</form>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
