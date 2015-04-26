<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Gestor</title>
    
    <%
	String usuario = "";
	HttpSession sesionOk = request.getSession();
	if (sesionOk.getAttribute("gestor") == null) {
%>
<jsp:forward page="interfazInicio.jsp">
	<jsp:param name="error" value="Esobligatorio identificarse" />
</jsp:forward>
<%
	} else {
		usuario = (String) sesionOk.getAttribute("gestor");
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
                        <button type="button" class="btn btn-navbar"> </button>
                         <a class="brand"><img src="/img/logo@2.jpg" width="60" height="60"> GESTIÓN DE TARJETAS UNIVERSITARIAS - GESTOR</a>
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

				<div class="col-md-4 column">
					<h3>Solicitudes en curso</h3>

					
					<table class="table table-hover" id="solicitudesAeliminar">
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
								<c:if test="${solicitud.estado != 'ELIMINADA'}">
										<tr class="success">
										<td><c:out value="${solicitud.nombre}" /></td>
										<td><c:out value="${solicitud.apellido1}" /></td>
										<td><c:out value="${solicitud.apellido2}" /></td>
										<td><c:out value="${solicitud.estado}" /></td>
										<td><a class="gestionar" href="<c:url value="/gestionG?correoUniv=${solicitud.correoUniv}"/>">ELIMINAR</a></td>
										</tr>
								</c:if>
								</c:forEach>
							</tr>	
						</tbody>
					</table>
				</div>


				<div class="col-md-4 column">
					<h3>Solicitudes eliminadas</h3>

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
										<tr class="warning">
										<td><c:out value="${solicitud.nombre}" /></td>
										<td><c:out value="${solicitud.apellido1}" /></td>
										<td><c:out value="${solicitud.apellido2}" /></td>
										<td><c:out value="${solicitud.estado}" /></td>
										<td><a class="gestionar" href="<c:url value="/gestionG?correoUniv=${solicitud.correoUniv}"/>">REINICIAR</a></td>
										</tr>
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