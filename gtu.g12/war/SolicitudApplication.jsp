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
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="css/style2.css">
    
    <header class="header-11">
            <div class="container">
                <div class="navbar span12">
                    <div class="navbar-inner">
                        <button type="button" class="btn btn-navbar"> </button>
                        <a class="brand"><img src="img/logo@2.jpg" width="75" height="75"> GESTIÓN DE TARJETAS UNIVERSITARIAS</a>
                        <div class="nav-collapse collapse pull-right">
                            <ul class="nav">
                                <li><a href="usuarioInicio.jsp">ALUMNO</a></li>
                                <li><a href="universidadInicio.jsp">UNIVERSIDAD</a></li>
                                <li><a href="bancoInicio.jsp">BANCO</a></li>
                               
                                <li><a href="estampadoraInicio.jsp">EMPRESA</a></li>
                                <li><a href="interfazInfo.jsp">INFORMACIÓN</a></li>
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
                        <h1>¡Bienvenido!</h1>
                        <p>
                            Si es alumno o personal de la universidad, y quiere solicitar la tarjeta universitaria con opción de función monedero:</p>
                        <p>
                            Por favor, pulse el botón ALUMNO de la barra de navegación.
                        </p>
                        <p>
                            Si por el contrario quiere gestionar la solicitud,  pulse los botones correspondientes de la barra de navegación.
                        </p>
                      
                    </div>
                        <div class="span6" "offset10">
                        <img src="img/tarjetas.jpg" width="350" height="500" align="right">
                        </div>
                    </div>
            </div>
        </section>


        <footer class="footer-2 bg-midnight-blue">
            <div class="container">
                <nav class="pull-left">
                    <ul>
                        <li><a href="SolicitudApplication.jsp">Home</a></li>
                        <li><a href="interfazInfo.jsp">Nuestro equipo</a></li>
                        <li><a href="#">Contactar</a></li>
                    </ul>
                </nav>
            </div>
        </footer>
  </body>
</html>