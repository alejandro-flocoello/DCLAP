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
							<li><a href="/main">HOME</a>
							<li>
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
				<div>
					<img src="/img/images.jpg" width="800" height="800" align="center">
				</div>
			</div>
		</div>
	</section>

	<script>
		alert("${error}");
		history.back();
	</script>

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