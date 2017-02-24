function valida_servicio(form){ 
	//campos completos
	var program = document.getElementById('programa').value;
	var tipo = document.getElementById('tipoT').checked;
	var tipoV = document.getElementById('tipoV').checked;
	var nombre = document.getElementById('nombre').value;
	var dia = document.getElementById('datepicker').value;
	var horaI = document.getElementById('horaI').value;
	var calleI = document.getElementById('calleI').value;
	var calleF = document.getElementById('calleF').value;
	var cp1 = document.getElementById('cp1').value;
	var cp2 = document.getElementById('cp2').value;
	
	if (program == null || program == "" || tipo == null || tipo == "" || nombre == null || nombre == "" 
		|| dia == null || dia == "" || horaI == null || horaI == "" || calleI == null || calleI == "" 
		|| calleF == null || calleF == "" || cp1 == null || cp1 == "" || cp2 == null || cp2 == "" 
		|| tipoV == null || tipoV == "") {
        alert("Todos los campos son obligatorios");
        return false;
    }	
	
	return true;

	
   	} 


