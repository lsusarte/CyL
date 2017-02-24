<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/styleInformes.css" type="text/css" media="all" />
<%@ page import="com.myservices.form.*" %> 
<%@ page import ="java.util.*" %>
<title>Administrador</title>
</head>

<body>
<div class="cabecera" >
	<h1>Informes</h1>
		
</div>

<div class="informes-form">    
     
     <form id="informes" name="informes" action="InformeServlet" method="post">
     
	     <div class="form-group ">
	     	<u>Informe mensual</u>
	      	<!--<select name="informe" onchange="expandir_formulario()">
	      	<option value="0">Todo el mes</option>
			<option value="1">Programa</option>
			<option value="2">Conductor</option>
			</select>-->
			<br></br>
			
			
	      <button type=submit class="log-btn" >Generar</button>
     	</div>
    </form>
    
   </div>


<%--servicios por persona
serviios por programas
importe de servicios por persona--%>
</body>
</html>