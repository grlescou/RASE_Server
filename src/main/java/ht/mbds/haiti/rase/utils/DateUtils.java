/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author gaetan
 */
public class DateUtils {
    
     public static final String DB_FORMAT_DATETIME = "yyyy-M-d HH:mm:ss"; 
      public static final String DB_FORMAT_ISO_DATETIME = "yyyy-MM-dd'T'HH:mm:ss'Z'";  
     public static final String DB_FORMAT_DATE = "yyyy-MM-dd";       

    private DateUtils() {
        // not publicly instantiable
    }       

    public static Date getDate(String dateStr, String format) {
        final DateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {                
            return null;
        }
    }
    
     public static String getDateFormater(String dateStr, String fromformat,String toformat) {
        final DateFormat formatter = new SimpleDateFormat(toformat);
        try {
            
            Date date = getDate(dateStr,fromformat);
            
            return formatter.format(date);
        } catch (Exception e) {                
            return null;
        }
    }

    
  
     
     
public static Date addDays(Date date, int nb) {

    SimpleDateFormat sdf = new SimpleDateFormat(DB_FORMAT_DATE);
    Calendar c = Calendar.getInstance();
    c.setTime(date); // Now use today date.
    c.add(Calendar.DATE, nb); // Adding 5 days
    String output = sdf.format(c.getTime());
    System.out.println(output);


  return c.getTime();
     
     
}



public static String addDaysToString(Date date, int nb) {

    final DateFormat formatter = new SimpleDateFormat(DB_FORMAT_ISO_DATETIME);
    
    SimpleDateFormat sdf = new SimpleDateFormat(DB_FORMAT_DATE);
    Calendar c = Calendar.getInstance();
    c.setTime(date); // Now use today date.
    c.add(Calendar.DATE, nb); // Adding 5 days
    String output = sdf.format(c.getTime());
    //System.out.println(output);

   return formatter.format(c.getTime());
  
     
     
}



public static String dateToString(Date date) {

    final DateFormat formatter = new SimpleDateFormat(DB_FORMAT_ISO_DATETIME);
    
    

   return formatter.format(date);
  
     
     
}
     
     
     
}
