<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Cabecera del proyecto</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary shadow">
	  <div class="container">
	    <a class="navbar-brand" href="index.jsp" style="color: white;">Inicio</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarResponsive">
	      <ul class="navbar-nav ms-auto">
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Idioma
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#" onclick="createCookie('idioma', 'español', 1)">Español</a></li>
	            <li><a class="dropdown-item" href="#" onclick="createCookie('idioma', 'ingles', 1)">Inglés</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
</body>
</html>