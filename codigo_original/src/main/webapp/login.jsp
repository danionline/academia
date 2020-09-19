<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<jsp:include page="include/cabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>




<h1 align=center>Iniciar Session</h1>
	
<div class="contenedor">
<span></span>
  <img src="img/digitilogo.jpg">

</div>


	<form action="sesion" method="post">

	<div class=login>
		<div class =txt>
		<br>
		<label for="textlabel"	class="col-sm-3 col-form-texto">Nombre</label>	
		
		<input class="form-control" name="nombre" type="text" placeholder="Nombre">
	
		<label for="textlabel" class="col-sm-3 col-form-label">Contraseña</label>			
		<input class="form-control" name="contrasena" type="text" placeholder="Contrasena"> 
		<br>
		<div class= boton>	
		<button type="submit" class="btn btn-warning mb-3">Iniciar Sesion</button>
		</div>
	</div>
	</div>
	</form>	

${mensaje}
		