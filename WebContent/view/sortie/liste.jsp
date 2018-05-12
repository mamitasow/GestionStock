<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="panel panel-primary">
	<div class="panel-heading"><h1>Gestion des produits</h1></div>
	<div class="panel-body">
	 	
<div class="row">

<div class="col-sm-12">
					<div class="panel">
						<div class="panel-heading">
							
						</div>
						<table class="table">
							<thead>
								<tr>
									<th>#</th>
									<th>DATE</th>
									<th>PRIX UNITAIRE</th>
									<th>QANTITE</th>
									<th>STOCK</th>
									<th>MODIFIER</th>
									<th>SUPRIMER</th>
								</tr>
							</thead>
							<tbody>
									<c:forEach items="${sortie}" var="sortie">
								
								<tr>
									<td>${sortie.idS}</td>
									<td>${sortie.dateS}</td>
									<td>${sortie.qtS}</td>
									<td>${sortie.puS}</td>
									<td>${sortie.stock}</td>
									
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="Sortie?page=add" class="btn btn-primary">ajouter une entree></a>
					</div>
				</div>
</div> 	 	


	</div>
	</div>
</div>

</body>
</html>