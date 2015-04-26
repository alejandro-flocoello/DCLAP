<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Gestión de Tarjetas Universitarias</title>


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
				<div class="span5">
					<h4>Gestión de tarjetas Universitarias</h4>
					<p>Introduzca sus datos para acceder al sistema</p>
					<p>
					<div class="signup-form">
						
						<form method="post" action="/logout">

							<div class="controls controls-row">
								<input class="span4" type="text" placeholder="E-mail" name="usuario">
							</div>

							<div class="controls controls-row">
								<div>
									<input class="span4" type="password" placeholder="Contraseña" name="password">
								</div>
							</div>
							<div class="controls controls-row">
								<input type="submit" value="Acceder" class="btn btn-block btn-info">
							</div>
						</form>
					</div>

				</div>
				<div class="span6""offset10">
					<img src="/img/tarjetas.jpg" width="300" height="500" align="right">
				</div>
			</div>
		</div>
	</section>


	<footer class="footer-2 bg-midnight-blue">
		<div class="container">
			<nav class="pull-left">
				<ul>
					<li><a href="/info">Nuestro equipo</a></li>
					<li><a href="#">Contactar</a></li>
				</ul>
			</nav>
		</div>
	</footer>
</body>
</html>