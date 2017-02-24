package com.myservices.form;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.time.LocalTime;


public class pruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	/*	Calendar calendar = Calendar.getInstance();  
		calendar.set(2017, Calendar.FEBRUARY, 7, 20,43,00);  
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    //dateFormat.format(calendar);
	   // System.out.println(dateFormat);
	    
	    LocalTime b = LocalTime.of (20, 45, 0);
	    
	    Service v = new Service();
	   // double a = v.calculate_price("28023","28023",); 
	    
	    
	    
	    LocalTime timeI = LocalTime.of(20, 45, 30);
	    LocalTime timeF = LocalTime.of(23,00,00);
	    
	    if(timeI.isBefore(timeF))System.out.println("Despues");
*/
       /* int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        System.out.println("hour = " + hour);
        System.out.println("minute = " + minute);
        System.out.println("second = " + second);*/
		
		
		String time = "2017-02-07 07:02:00";
	    DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    System.out.println(LocalTime.parse("10:15:30"));
    
	    
	    
	}

}
