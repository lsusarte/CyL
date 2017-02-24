<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./css/styleServices.css" type="text/css" media="all" />
<%@ page import="com.myservices.form.*" %> 
<%@ page import ="java.util.*" %>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="./javascript/validateService.js"></script> 
<script>
$(document).ready(function() {
    $("#datepicker").datepicker({
    dateFormat: "yy-mm-dd"});
  });

</script>


<title>Añadir servicio</title>

</head>
<body>
<div class="cabecera" >
	<h1>Servicio</h1>
		
</div>
 <!-- <p>Bienvenido ${sessionScope.usuario}</p> <p>Salir</p>-->
 
 <div class="service-form">
        
    <form  id="service" name="service" action="AddService" method="post">
    <br>
    <table cellpadding="2" cellspacing="1" border="0" align="center">
        	
	    <tr>
	    	<td WIDTH="270"> Programa</td>
	    	<td WIDTH="270"> <u>Tipo de servicio</u></td>
	    </tr>
	    <tr>
	        <td><select name="programa" id="programa" >
	    	<option value="" selected>Selecciona un programa</option>
	    	<%
	    		List<String> programas; 
		    	programas = InicializarFormulario.getProgramas();	    		   
	    	%>
	    	    	
	    	<%for(int i=0;i<programas.size();i++){
	    		String option = (String)programas.get(i);
	    	%>
	    	<option value="<%= option %>"><%= option %></option>	
	    	<%}%>	    	
	    </select></td>
	    	<td> 
		    	<input onclick="document.getElementById('km').disabled=false;document.getElementById('horaF').disabled=true" type="radio" name="tipo" id="tipoT" value="Transfer" checked="checked"/> Transfer
    			<input onclick="document.getElementById('km').disabled=true;document.getElementById('horaF').disabled=false" type="radio" name="tipo" id="tipoD" value="Disposicion" /> Disposición</td>
    	</tr>
    	<tr>
	    	<td> Dia</td>
	    	<td> </td>
	    </tr>
	    <tr>
	        <td> <input name="datepicker" id="datepicker" size="10" /></td>
	        <td> </td>
	    </tr>	    
	    <tr>
	    	<td> Invitado</td>
	    	<td> <u>Vehículo</u></td>
	    </tr>
	    <tr>
	        <td> <input name="nombre" id="nombre" type="text" value="" size="30"/></td>
	        <td> <input type="radio" name="tipoV" id="tipoTurismo" value="Turismo" checked="checked"/> Turismo
    			<input type="radio" name="tipoV" id="tipoMinivan" value="Minivan" /> Minivan</td></td>
	    </tr>
	    
	    <tr>
	    	<td> Inicio</td>
	    	<td> Fin</td>
	    </tr>
	    <tr>
	        <td> <input name="horaI" id="horaI" type="text" value="09:00" size="10"/></td>
	        <td> <input name="horaF" id="horaF" type="text" value="09:00" size="10" disabled="true"/></td>
	    </tr>
	    <tr>
	        <td> Origen</td>
	        <td>CP</td>
	    </tr>
	    <tr>
	        <td> <input name="calleI" id="calleI" type="text" value="" size="30"/></td>
	        <td><input name="cp1" id="cp1" type="text" value="" size="5"/></td>
	    </tr>
	    <tr>
	        <td> Destino</td>
	        <td>CP</td>
	    </tr>
	    <tr>
	        <td> <input name="calleF" id="calleF" type="text" value="" size="30"/></td>
	        <td><input name="cp2" id="cp2" type="text" value="" size="5"/></td>
	    </tr>
	    <tr>
	    	<td></td>
	        <td>km</td>
	    </tr>
	    <tr>
	    	<td></td>
	        <td><input name="km" id="km" type="text" size="5" disabled="false"/></td>
	    </tr>
	    
	</table>   
	<table cellpadding="2" cellspacing="1" border="0" align="center">
	 <tr> 
		<td>Observaciones</td>
		<td WIDTH="220"></td>
	</tr>
	<tr> 
	    <td><textarea rows="4" cols="50"></textarea></td>
	    </tr>
	 </table>   
    <br><br>
    <button  type=submit class="log-btn" onClick="return valida_servicio(this.form)">Añadir</button>
    <input type="reset" class="log-btn" value="Limpiar" >
    <br><br>
    </form>
    
   </div>
   
   <!-- si transfer no hora de fin
   si es dispo km -->

</body>
</html>


