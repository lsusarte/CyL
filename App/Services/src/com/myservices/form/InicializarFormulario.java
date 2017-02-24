package com.myservices.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InicializarFormulario {
	
	public static List<String> getProgramas()
	   {
		ArrayList<String> programas = new ArrayList<String>();
	      Connection conexion = null;
	      java.sql.Statement s = null;
	      
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
			  conexion = DriverManager.getConnection("jdbc:mysql://localhost/servicios", "admin", "Veronica21");		
			  s = conexion.createStatement();
			  ResultSet rs = (ResultSet) s.executeQuery ("select Programa from tblprogramas where Baja = 0");
			  
	         while (rs.next())
	         {
	        	programas.add(rs.getString("Programa"));	
	         }
	         rs.close();	         
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	         e.printStackTrace();
	      }
	      return programas;
	   }
	
	
}
