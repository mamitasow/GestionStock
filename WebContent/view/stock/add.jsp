<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	 	<form method="POST" action="Stock">
	 	<div class="form-goup">
			<label class="control-label">reference du produit</label>
			<input class="form-control" type="text" name="refp"/>	 	
	 	</div>
	 	<div class="form-goup">
			<label class="control-label">libelle produit</label>
			<input class="form-control" type="text" name="libp"/>	 	
	 	</div>
	<div class="form-goup">
			<label class="control-label">quantite stock</label>
			<input class="form-control" type="text" name="qtstock"/>	 	
	 	</div>
	 	<div class="form-goup">
			<input  type="submit" name="valider" class="btn btn-success" value="valider"/>	
			<input  type="reset" name="annuler" class="btn btn-danger" value="annuler"/>	 	
	 	</div>
	</form>
	</div>
</div>
</div>
</body>
</html>