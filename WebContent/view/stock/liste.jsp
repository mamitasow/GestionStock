<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD</title>
<link  rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"/>
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
									
									<th>REFERENCE</th>
									<th>LIBELLE</th>
									<th>QANTITE</th>
									<th>MODIFIER</th>
									<th>SUPRIMER</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${stock}" var="stock">
								
								<tr>
									<td>${stock.id}</td>
									<td>${stock.ref}</td>
									<td>${stock.lib}</td>
									<td>${stock.qtStock}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="Stock?page=add" class="btn btn-primary">ajouter une Stock</a>
					</div>
				</div>
</div> 	 	


	</div>
	</div>
</div>

</body>
</html>