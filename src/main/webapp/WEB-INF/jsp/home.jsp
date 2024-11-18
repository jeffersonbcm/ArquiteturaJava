<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>AppLocadoras: gestão de Locadoras</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active" href="/">AppLocadora</a></li>
				<li class="nav-item"><a class="nav-link" href="/locadora/listagem">Locadoras</a></li>
				<li class="nav-item"><a class="nav-link" href="/veiculo/listagem">Veiculos</a></li>
				<li class="nav-item"><a class="nav-link" href="/carro/listagem">Carros</a></li>
				<li class="nav-item"><a class="nav-link" href="/moto/listagem">Motos</a></li>
			</ul>
		</div>
	</nav>

	<div class="container mt-3">

		<span class="badge rounded-pill bg-primary">Locadora: ${qtdeLocadora}</span> 
		<span class="badge rounded-pill bg-secondary">Veiculo: ${qtdeVeiculo}</span> 
		<span class="badge rounded-pill bg-success">Carro: ${qtdeCarro}</span> 
		<span class="badge rounded-pill bg-danger">Moto: ${qtdeMoto}</span>
		
		<c:if test="${not empty listagem}">
			<h2>AppLocadora</h2>
			<p>Projeto Locadora de veiculos:</p>
			<table class="table">
				<thead class="table-dark">
					<tr>
						<th>${titulo}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${listagem}">
						<tr>
							<td>${item}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>	
	</div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.min.js"></script>
</body>
</html>