<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Usuario</title>

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
					<a class="brand"><img src="/img/logo@2.jpg" width="60"
						height="60"> GESTIÓN DE TARJETAS UNIVERSITARIAS -
						SOLICITANTE</a>
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
				<div class="span15">

					<h1 class="text-center">Bienvenido Usuario</h1>

					<p>No existe solicitud en proceso</p>


					<div class="signup-form">
						<form method="post" action="/usuario">
						
							<p><h5>Marque la casilla si quiere asociar su tarjeta universitaria a una cuenta bancaria</h5>

							<div class="checkbox">
								<label><input type="checkbox" onclick="bancos.disabled = !this.checked" name="checkbox" checked value="Solicitud" style="font-weight: bold" /> Quiero asociar mi tarjeta universitaria con una cuenta bancaria</label>
							</div> </p>
				
							<p><h5>Indique el banco al que quiere asociar la cuenta bancaria</h5>

							<select name="bancos" class="selectpicker" data-style="btn-primary">
								<option selected>--- Elija banco ---</option>
								<option value="santander@banco.com">Santander</option>
								<option value="bbva@banco.com">BBVA</option>
								<option value="caixa@banco.com">La Caixa</option>
							</select>
							</p> 
							
							<div class="controls controls-row">
								<input type="submit" value="Solicitar" class="btn btn-block btn-primary">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>