package com.myservices.form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/AddService")
public class AddService<JSONObject> extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	
	
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// get request parameters for registrer a service
		String program = request.getParameter("programa").trim();
		String type = request.getParameter("tipo").trim();
		String typeV = request.getParameter("tipoV").trim();
		String name = request.getParameter("nombre").trim();
		String day = request.getParameter("datepicker").trim();
		String hourI = request.getParameter("horaI").trim();
		//String hourF = request.getParameter("horaF").trim();
		String streetI = request.getParameter("calleI").trim();
		String streetF = request.getParameter("calleF").trim();
		String km = request.getParameter("km").trim();
		String cpIni = request.getParameter("cp1").trim();
		String cpFin = request.getParameter("cp2").trim();
		
		HttpSession sesion = request.getSession();		
		
		Conexion c = new Conexion();
        Connection conn = c.getConnection();
        if(conn != null){
        	
	        PreparedStatement pst = null;
	        Boolean rs = null;      
	        
	        day = day + " 00:00:00.000000000";	        
	        Timestamp dia = Timestamp.valueOf(day);	        

	        Timestamp timestamp = new Timestamp(new Date().getTime());
	        
	        try {
	        	
	        	String producer = Conexion.getProducer(program);	        	
	        	LocalTime hourIni = LocalTime.parse(hourI);	        	
	        	double p = Service.calculate_price(cpIni, cpFin, producer,hourIni);	        	
	            
	            pst = conn
	                    .prepareStatement("insert into tblservicio (usuario,programa,productora,tipo_servicio,tipo_vehiculo,nombre,dia,hora_inicio,calle_inicio,calle_fin,kilometros,importe,fecha_alta,usuario_alta) " +
	                    		"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            pst.setString(1, (String) sesion.getAttribute("usuario"));
	            pst.setString(2, program);
	            pst.setString(3, producer);
	            pst.setString(4, type);
	            pst.setString(5, typeV);
	            pst.setString(6, name);
	            pst.setTimestamp(7, dia);
	            pst.setString(8, hourI);
	            pst.setString(9, streetI);
	            pst.setString(10, streetF);
	            pst.setString(11, km);
	            pst.setDouble(12, p);
	            pst.setTimestamp(13, timestamp);
	            pst.setString(14, (String) sesion.getAttribute("usuario"));
	            
	            rs = pst.execute();
	            
	            RequestDispatcher rd=request.getRequestDispatcher("ListMyServices.jsp");  
		        rd.forward(request,response); 
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            RequestDispatcher rd=request.getRequestDispatcher("MyServices.jsp");  
		        rd.forward(request,response);
	        }
		}
	}
        
}
