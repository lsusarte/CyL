function valida_login(form){ 
	//campos completos
	var username = document.forms["login"].elements[0].value;
	var password = document.forms["login"].elements[1].value;
	
	alert(username);
	alert(password);
	
	    if (username == null || username == "" || password == null || password == "") {
	        alert("Todos los campos son obligatorios");
	        return false;
	    }	
	
	return true;
   	} 