import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class ConexionBD {
	
	@SuppressWarnings("null")
	public static String[] getProgramas()
	   {
	      String[] programa = null;
	      Connection conexion = null;
	      java.sql.Statement s = null;
	      
	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver");
			  conexion = DriverManager.getConnection("jdbc:mysql://localhost/servicios", "admin", "Veronica21");		
			  s = conexion.createStatement();
			  ResultSet rs = (ResultSet) s.executeQuery ("select Programa from tblprogramas where Baja = 0");
			  int i = 0;
	         while (rs.next())
	         {
	        	programa[i] = rs.getString("Programa");	
	        	i++;
	        	
	         }
	         rs.close();	         
	         conexion.close();
	      }
	      catch (Exception e)
	      {
	    	  
	         e.printStackTrace();
	      }
	      return programa;
	   }
}
