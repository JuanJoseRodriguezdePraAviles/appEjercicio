<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo UserAccount</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
	<%LocalDate fechaActual = LocalDate.now(); %>
	<%@ include file="cabecera.jsp"%>
	<h1>Nuevo usuario</h1>
	<form  method="post" action="userAccount">
		<div class="d-flex centerDiv">
			<div>
				<label for="nombre">Nombre:</label>
				<input type="text" class="form-control" id="nombre" name="nombre" required/>
			</div>
			<div>
				<label for="apellidos">Apellidos:</label>
				<input type="text" class="form-control" id="apellidos" name="apellidos" required/>
			</div>
			<div class="dateSelectSize">
				<label for="fecha">Fecha:</label>
				<input type="date" class="form-control" id="fechaNacimiento" value="<%=fechaActual%>" name="fechaNacimiento" required>
			</div>
			<div>
				<label for="nombre">Email:</label>
				<input type="text" class="form-control" id="email" name="email" required/>
			</div>
			<div class="g-recaptcha" data-sitekey="6Ld7K1gfAAAAAP633WOnS5NlMd-lNdocaWdKxmGx"></div>
			<span id="captcha" style="margin-left:100px;color:red" />
			
		</div>
		<input class="btn" type="submit" name="submit" value="Crear usuario">
	</form>
	<%@ include file="pieDePagina.jsp"%>
</body>
</html>