<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<jsp:include page="/privado/profesorcabecera.jsp">
	<jsp:param name="pagina" value="inicio" />
	<jsp:param name="title" value="Inicio" />
</jsp:include>



<h1>Sala de Profesores</h1>



	 	<table class="table">
		<h2>Usuario</h2><h4>${usuario_sesion.nombre}</h4>
		
	 	
<table class="tabla table table-striped">
		<thead>
			<tr>
				<td>Id</td>
				<td>Nombre</td>
				<td>Horas</td>
				<td>Identificador</td>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cursos}" var="c">
				<tr>
				
					<td>${c.id}</td> <% // no hace falta usar el getter p.id == p.getId() %>
					<td>${c.nombre}</td>
					<td>${c.horas}</td>
					<td>${c.identificador}</td>
				</tr>
				</c:forEach>
		</tbody>
					
			

				
			
				