<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<!doctype html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- fontawesome 5 -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<!-- datatables -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/estilo.css">

 
 
  </head>
  <header>
  


  
        
      

       
      
        <!-- lista enlaces -->
          
        
            
             	
           <!-- opciones cuando el usuario esta Logeado -->
            
                    
          
       
        
         <span class="form-inline">
         
         	 
         	<c:if test="${ empty sessionScope.usuario_sesion }">
         	
         	 <li class="nav-item"> 
         	 <nav class="navbar navbar-expand-md  fixed-top bg-primary bg-dark">
         	 <a class="nav-link  btn btn-outline-warning" href="login.jsp">Iniciar Sesión</a>
            	 <span class="badge badge-pill badge-light mr-3">${sessionScope.usuario_sesion.nombre}</span>
            	
			
		  <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'inicio' eq param.pagina ) ? 'active' : '' }" href="index.jsp">home</a>
            </li>
           </ul> 
            
                       
               	
         <ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'curso' eq param.pagina ) ? 'active' : '' }" href="curso">listado de cursos</a>
            </li>
          </ul>
            
           
           	 </c:if>	
            	 
            	 
            	 
            	 
            	 
        
        </span>
            
            <c:if test="${ not empty sessionScope.usuario_sesion }">
            	
 			
 			       <span class="form-inline">
         	<nav class="navbar navbar-expand-md  fixed-top bg-primary bg-dark">
         	
 			         
         	 <ul class="navbar-nav mr-auto">
         	
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'cursos' eq param.pagina ) ? 'active' : '' }" href="profesor">listado del profesor</a>
            </li>
          </ul>
   			<ul class="navbar-nav mr-auto">
            <li class="nav-item"  >
              <a class="nav-link ${ ( 'cursos' eq param.pagina ) ? 'active' : '' }" href="alumno">listado del alumno</a>
            </li>
          </ul>  
 		
              </c:if>	   
        
      

       
      
        <!-- lista enlaces -->
          
               
        

    
       

      	


    </header>
      
      
   			
      	

      