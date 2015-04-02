<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<title>Usuario2</title>

<%
	String usuario = "";
	String universidad="";
	String banco="";
	String estampadora="";
	
	HttpSession sesionOk = request.getSession();
	if ((sesionOk.getAttribute("usuario") == null) && 
		(sesionOk.getAttribute("universidad") == null) && 
		(sesionOk.getAttribute("banco") == null) &&
		(sesionOk.getAttribute("estampadora") == null)) {
%>
<jsp:forward page="interfazInicio.jsp">
	<jsp:param name="error" value="Esobligatorio identificarse" />
</jsp:forward>
<%
	} else {
		usuario = (String) sesionOk.getAttribute("usuario");
		universidad = (String) sesionOk.getAttribute("universidad");
		banco = (String) sesionOk.getAttribute("banco");
		estampadora = (String) sesionOk.getAttribute("estampadora");
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
							<li><a href="/info">INFO</a></li>
							<li><a href="/main">HOME</a></li>
							<li><a href="/logout">LOGOUT</a></li>
							<li><a href="/volver">VOLVER</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>


	<div class="container">
		<div class="row clearfix">


			<div class="col-md-6">
				<h3>
					Bienvenido usuario <c:out value="${rol}" />
				</h3>
				<h6>
					El estado de solicitud de <c:out value="${solicitud.nombre}" /> es <c:out value="${solicitud.estado}" />
				</h6>
			</div>
		</div>
	</div>
</body>
</html>