<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String cPath = request.getContextPath()+ "/css/styleLogin.css"; 

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<%=cPath%>" type="text/css" media="all" />
<script type="text/javascript" src="./javascript/validateLogin.js"></script> 


<title>Index</title>
</head>
<body>
 
 <div class="login-form">
     <h1>Login</h1>
     
     <form id="login" name="login" action="LoginServlet" method="post">
     
	     <div class="form-group ">
	     	
	       <input type="text" class="form-control" name="Username" id="UserName" value="Administrador" >
	       <i class="fa fa-user"></i>
	     </div>
	     <div class="form-group log-status">
	     	
	       <input type="password" class="form-control" name="Password" id="Passwod" value="admin" >
	       <i class="fa fa-lock"></i>
	     </div>
	      
	      <a class="link" >Lost your password?</a>
	      
	      <button type=submit class="log-btn" onClick="return valida_login(this.form)">Log in</button>
     
    </form>
    
   </div>

</body>
</html>