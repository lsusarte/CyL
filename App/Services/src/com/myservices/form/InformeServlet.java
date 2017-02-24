package com.myservices.form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class InformeServlet
 */
@WebServlet("/InformeServlet")
public class InformeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Conexion c = new Conexion();
        Connection conn = c.getConnection();
        if(conn != null){
        	
	        PreparedStatement pst = null;
	        ResultSet rs = null; 
	        
	        LinkedList<Service> listaservicios=new LinkedList<Service>();
	        
	        try {
	        	pst = conn
	                    .prepareStatement("select usuario,programa,Productora,Tipo_servicio,Nombre,dia,kilometros,importe from tblservicio where programa = 1");
	            
	            rs = pst.executeQuery();
		        
	            while (rs.next())
	            {
	            	Service service = new Service();
	            	service.setUser(rs.getString("usuario"));
	            	listaservicios.add(service);
	            }
	          //colocamos los resultados de la búsqueda como atributo del request
	            //request.setAttribute("resultados", listaservicios);
	            //realizamos un forward a la página JSP donde mostraremos los resultados
	            //request.getRequestDispatcher("Informes.jsp").forward(request, response);
	            /*RequestDispatcher rd=request.getRequestDispatcher("Informes.jsp");  
		        rd.forward(request,response); */
	            System.out.println(listaservicios.isEmpty());
	            System.out.println(listaservicios.size());
	            System.out.println(listaservicios.get(0).user);
	            request.setAttribute("servletName", listaservicios); //categorylist is an arraylist      contains object of class category  
	            getServletConfig().getServletContext().getRequestDispatcher("Informes.jsp").forward(request,response);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            RequestDispatcher rd=request.getRequestDispatcher("MyServices.jsp");  
		        rd.forward(request,response);
	        }
		}
	}

}
