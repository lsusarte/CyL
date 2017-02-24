package com.myservices.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "servicios";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "admin";
	private static String password = "Veronica21";
    
	private static Connection con;
	

	//Conectar
	public Conexion() {
		        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + dbName, userName, password);
            
        }catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            } 
		
	}
	
	//Devuelve conexion
	public static Connection getConnection(){
		return con;
	}
	
	//Recupera productora a partir del programa
	public static String getProducer(String program) {
		
		Connection conn = getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null; 
		String producer = null;
	
		try {
			pst = conn
	                .prepareStatement("select tblproductoras.productora from tblprogramas join tblproductoras on tblproductoras.id=tblprogramas.productora where programa =?");
	        pst.setString(1, program); 
	        
	        rs = pst.executeQuery();
	        
	        if(rs.next())
	        producer = rs.getString("productora");
	        
		} catch (Exception e) {
            System.out.println(e);
        }
		return producer;
        
	}
	
	//Recupera precio
	public static double getPrice(String cp, String producer) {
			
			Connection conn = getConnection();
			PreparedStatement pst = null;
			ResultSet rs = null; 
			double precio = 0.0;
		
			try {
				pst = conn
		                .prepareStatement("select Mandarina,Cuarzo from tblprecios where CP =?");
		        pst.setString(1, cp); 
		        
		        rs = pst.executeQuery();
		        
		        if(rs.next())
		        	precio = rs.getDouble(producer);
		        
			} catch (Exception e) {
	            System.out.println(e);
	        }
			return precio;
	        
		}
}
	
