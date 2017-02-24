package com.myservices.form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Service {
	
	String user;
	String program;
	String producer;
	String service_type;
	String name;
	String day;
	String hourI;
	String hourF;
	String streetI;
	String streetF;
	double km;
	double price;
	Date created_date;
	Date created_user;
	Date deleted_date;
	Date deleted_user;
	boolean baja;
	
	
	public Service(String program, String service_type, String name, String day,String hourI, String hourF,String streetI,String streetF) {
		program = this.program;
		service_type = this.service_type;
		name = this.name;
		day = this.day;
		hourI = this.hourI;
		hourF = this.hourF;
		streetI = this.streetI;
		streetF = this.streetF;
	}
	
	
	public Service() {
		// TODO Auto-generated constructor stub
	}


	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getHourI() {
		return hourI;
	}
	public void setHourI(String hourI) {
		this.hourI = hourI;
	}
	public String getHourF() {
		return hourF;
	}
	public void setHourF(String hourF) {
		this.hourF = hourF;
	}
	public String getStreetI() {
		return streetI;
	}
	public void setStreetI(String streetI) {
		this.streetI = streetI;
	}
	public String getStreetF() {
		return streetF;
	}
	public void setStreetF(String streetF) {
		this.streetF = streetF;
	}
	public double getKm() {
		return km;
	}
	public void setKm(double km) {
		this.km = km;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getCreated_user() {
		return created_user;
	}
	public void setCreated_user(Date created_user) {
		this.created_user = created_user;
	}
	public Date getDeleted_date() {
		return deleted_date;
	}
	public void setDeleted_date(Date deleted_date) {
		this.deleted_date = deleted_date;
	}
	public Date getDeleted_user() {
		return deleted_user;
	}
	public void setDeleted_user(Date deleted_user) {
		this.deleted_user = deleted_user;
	}
	public boolean isBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
	//Metodo para calcular el importe del servicio	
	public static double calculate_price(String cpIni, String cpFin, String producer, LocalTime hourI){
		double price = 0.0;
		/*
		 * Por cp para transfer con turismo:
		 * cp inicio y fin distintos coger el mayor
		 * cp 280 empieza y termina entonces 20 excepto el 28023 (si esta en el inicio o fin son 23)
		 * horario:
		 * 23:00-06:00 la tarifa se incrementa para mandarina 10% y resto 15%
		 *  
		 * */
		//Si es el 28023 consulta directa a la base de datos
		if(cpIni.equals("28023") || cpFin.equals("28023")){
			//Consulta base de datos
			price = 23.00;
		}else{
			if(cpIni.equals(cpFin)){
				//Consulta base de datos
				price = Conexion.getPrice(cpIni,producer);
				System.out.println("Mismo cp coger precio");
			}else{
				//Consulta el mayor
				double a = Conexion.getPrice(cpIni,producer);
				double b = Conexion.getPrice(cpFin,producer);
				if (a>=b)price = a;
				else price = b;
				System.out.println("Coger el mayor");
			}
		}
		
		//Incremento de la tarifa
		LocalTime timeI = LocalTime.of(23,00,00);
		LocalTime timeF = LocalTime.of(06,00,00);
		if(hourI.isAfter(timeI) && hourI.isBefore(timeI)){
			if(producer.equals("Mandarina")){
				price = price + (price*0.10);
			}else{
				System.out.println("entra");
				price = price + (price*0.15);
			}
		}
		System.out.println(price);		
		return price;
	}
	
	//Metodo para calcular la distancia en km
	public void calculate_KM(){
		URL url;
		HttpURLConnection conne = null;
		try {
			url = new URL("http://maps.googleapis.com/maps/api/distancematrix/json?origins=$28945&destinations=$28922&mode=driving&language=es-EN&sensor=false");
		
			conne = (HttpURLConnection) url.openConnection();		
		
			String output;
			BufferedReader br = new BufferedReader(new InputStreamReader((conne.getInputStream())));
		
			while ((output = br.readLine()) != null) {
				//System.out.println(output);
			}	
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		conne.disconnect();
	}
	
	
	

}
