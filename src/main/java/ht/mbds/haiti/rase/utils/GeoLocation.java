/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.mbds.haiti.rase.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

/**
 *
 * @author MyPC
 */
public class GeoLocation {
    //longitude, 
    private double x;
   // latitude 
    private double y;

    public GeoLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    
    public GeoLocation (List<Double> locationPoint){
        if (locationPoint.size() == 2)
        {
            x = locationPoint.get(0);
            y = locationPoint.get(1);
        }
        else
        {
            x =0.0;
            y=0.0;
        }
        
    }
    
     public GeoLocation (GeoJsonPoint location){
        List<Double> locationPoint= location.getCoordinates();
          if (locationPoint.size() == 2)
        {
            x = locationPoint.get(0);
            y = locationPoint.get(1);
        }
        else
        {
            x =0.0;
            y=0.0;
        }
     }
     
      public GeoLocation (Point location){
      
            x = location.getX();
            y = location.getY();
     
        
     }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
      
   public List<Double> getGeoCoordonatePoint (){
       List<Double> point = new ArrayList<>();
       point.add(x);
       point.add(y);
       
       return point;
   } 
   
   public Point getGeoPoint (){
       return new Point(x,y);
   }
   
   public GeoJsonPoint getGeoJsonPoint(){
       return new GeoJsonPoint(getGeoPoint ());
   }
   
      
     public  static List<Double> getGeoCoordonatePointFromGeoJsonPoint ( GeoJsonPoint GJPoint){

       return GJPoint.getCoordinates();
       
       
   } 
     
     public static List<Double> getGeoCoordonatePointFromGeoPoint (Point GPoint){
       List<Double> point = new ArrayList<>();
       point.add(GPoint.getX());
       point.add(GPoint.getY());
       
       return point;
   }  
     
      public static List<Double> getGeoCoordonatePointFromXY (double x, double y){
       List<Double> point = new ArrayList<>();
       point.add(x);
       point.add(y);
       
       return point;
   }  
    
    public static GeoJsonPoint getGeoJsonPointFromXY (double x, double y){
       
       
       return new GeoJsonPoint(new Point(x,y));
   }  
   
     public static Point getGeoPointFromXY (double x, double y){
       
       
       return new Point(x,y);
   }  
     
     
}
