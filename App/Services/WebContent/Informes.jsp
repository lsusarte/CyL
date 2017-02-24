<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="com.myservices.form.*" %> 
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.ArrayList"%>
<title>Insert title here</title>
</head>
<body>

<% Service service = new Service();
//creating arraylist object of type category class
LinkedList<Service> listaservicios=new LinkedList<Service>();
//storing passed value from jsp
listaservicios = (LinkedList<Service>)request.getAttribute("servletName");

for(int i = 0; i < listaservicios.size(); i++) {

	service = listaservicios.get(i);

out.println( service.getUser());
}
%>


</body>
</html>