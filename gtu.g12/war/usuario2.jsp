<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">


<head>
<meta charset="utf-8">
<title>FormularioVerificaciónUsuario</title>
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
						</ul>
					</div>
				</div>
			</div>
		</div>
	</header>



	<div class="container">
		<div class="row clearfix">
			<div class="col-md-3"></div>
			<div class="col-md-6">
				<h3>Valide sus datos para continuar con el proceso</h3>
				<h6>Si algun dato no es correcto póngase en contacto con
					bbdd@taruni.upm</h6>
			</div>

			<div class="col-md-3"></div>
		</div>

		<div class="row clearfix">
			<div class="col-md-3"></div>
			<div class="col-md-6 column">

				<table class="table table-hover">

					<tbody>
						<tr>
							<td>Nombre</td>
							<td>Nombre UsuarioX</td>

						</tr>

						<tr>
							<td>Apellido 1:</td>
							<td>Apellido 1 Usuario X</td>

						</tr>

						<tr>
							<td>Apellido 2:</td>
							<td>Apellido 2 Usuario X</td>
						</tr>

						<tr>
							<td>Nombre</td>
							<td>UsuarioX</td>

						</tr>

						<tr>
							<td>Tipo de Documento:</td>
							<td>{DNI,Passaporte}</td>

						</tr>

						<tr>
							<td>Código:</td>
							<td>########-X</td>
						</tr>

						<tr>
							<td>Domicilio</td>
							<td>Avenida Complutense 30, Madrid</td>
						</tr>

						<tr>
							<td>Foto</td>
							<td>Foto UsuarioX</td>
						</tr>

						<tr>
							<td>Escuela</td>
							<td>Escuela UsuarioX</td>

						</tr>

						<tr>
							<td>Tipo Solicitud</td>
							<td>{Alumno,profesor,PAS}</td>
						</tr>

						<tr>
							<td>Número Expediente</td>
							<td>Número Expediente UsuarioX</td>
						</tr>
					</tbody>
				</table>

				<div class="controls controls-row">
					<input type="button" value="Validar"
						class="btn btn-block btn-success"
						onClick=" window.location.href='/Users/clara/Desktop/HTML/Usuario/usuario3.html' ">
				</div>

				<div class="controls controls-row">
					<input type="button" value="Cancelar"
						class="btn btn-block btn-danger"
						onClick=" window.location.href='/Users/clara/Desktop/HTML/Usuario/usuarioInicio.html' ">
				</div>
			</div>
</body>
</html>