<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.time.LocalDate"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="com.sinensia.model.UserAccount"%>
<%@ page import="com.sinensia.controllers.UserAccountController"%>
<%@page import="com.sinensia.services.UserAccountService"%>

<head>
<title>AppEjercicio</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="css/ResumenIndexCSS.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="cabecera.jsp"%>
	
	<%UserAccountService userAccountService = new UserAccountService();%>
	<%List<UserAccount> userAccounts = userAccountService.get();%>
	
	<h1 class="fechaCompleta">Usuarios registrados</h1>
	<div class="mx-auto" style="width: 75%">
		<table class="table" id="tabla">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Apellidos</th>
					<th scope="col">Fecha Nacimiento</th>
					<th scope="col">Email</th>
				</tr>
			</thead>
				<tbody>
				<%for(UserAccount userAccount : userAccounts) {%>
					<tr>
						<td scope="row"><%= userAccount.getNombre()%></td>
						<td><%=userAccount.getApellidos()%></td>
						<td><%=userAccount.getFechaNacimiento()%></td>
						<td><%=userAccount.getEmail() %></td>
						<td><a href="userAccount?action=eliminar&id=<%=userAccount.getUserAccountId() %>">Eliminar</a></td>
					</tr>
				<%} %>
			</tbody>
		</table>
	</div>
	<div class="mx-auto bg-primary boton" style="width: 10%">
		<a class="btn fw-bold text-white" href="nuevoUserAccount.jsp" role="button">Nuevo usuario</a>
	</div>
	<%@ include file="pieDePagina.jsp"%>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	
</body>