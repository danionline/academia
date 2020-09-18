<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>




<h1 align=center>Iniciar Session</h1>


	<form action="sesion" method="post">

	<div class=login>
		<label for="textlabel"	class="col-sm-3 col-form-label">Nombre</label>			
		<input class="form-control" name="nombre" type="text" placeholder="Nombre">
	
		<label for="textlabel" class="col-sm-3 col-form-label">Contraseña</label>			
		<input class="form-control" name="contrasena" type="text" placeholder="Contrasena"> 
		<br>	
		<button type="submit" class="btn btn-warning mb-2">Iniciar Sesion</button>
	
	</div>
	</form>	

${mensaje}
		