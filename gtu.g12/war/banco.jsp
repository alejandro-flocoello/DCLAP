<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Banco</title>
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
                                <li><a href="/main">HOME</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <section class="header-11-sub bg-midnight-blue">
            <div class="background">&nbsp;</div>
            <div class="container">
                <div class="row">
                    <div class="span4">
                        <h1>Banco</h1>
                        <table class="table" style="width: 60%;" align="center">
  						<p> Solicitudes pendientes de aprobar: </p>
							<tr>
								<th>Nombre</th>
								<th>Apellido1</th>
								<th>Apellido2</th>
								<th>Estado</th>
							</tr>
							<c:forEach items="${solicitudes}" var="solicitud">
							<tr>
								<td><c:out value="${solicitud.nombre}" /></td>
								<td><c:out value="${solicitud.apellido1}" /></td>
								<td><c:out value="${solicitud.apellido2}" /></td>
								<td><c:out value="${solicitud.estado}" /></td>
							</tr>
							</c:forEach>
						</table>  
						<table class="table" style="width: 60%;" align="center">
						<p> Tarjetas pendientes de entregar: </p>
      						<tr>
								<th>Nombre</th>
								<th>Apellido1</th>
								<th>Apellido2</th>
								<th>Estado</th>
							</tr>
						</table>
                        
                      
                    </div>
                        <div class="span6" "offset10" href='#' >
                        <img src="/img/equipo.png" width="400" height="1000" align="right">
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