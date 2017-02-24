package com.myservices.form;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// get request parameters for Username and password
		String user = request.getParameter("Username").trim();
		String pwd = request.getParameter("Password").trim();
		
		PrintWriter out = response.getWriter(); 		
        
        HttpSession sesion = request.getSession();
        if(LoginDAO.validate(user,pwd)){ 
        	sesion.setAttribute("usuario", user);
        	if(user.equalsIgnoreCase("belen")){
        		RequestDispatcher rd=request.getRequestDispatcher("Administrador.jsp");  
	            rd.forward(request,response);
        	}else{
	            RequestDispatcher rd=request.getRequestDispatcher("MyServices.jsp");  
	            rd.forward(request,response); 
        	}
        }  
        else{  
        	out.print("<p style=\"color:red\">Sorry username or password error</p>"); 
        	out.print("<p style=\"color:red\">" + request.getContextPath() + "/css/styleLogin.css' />");
        	//out.print("<p style=\"color:red\">" + request.getContextPath() );

        	RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");             
            rd.include(request,response);
        }  

        out.close();
		

	}

}