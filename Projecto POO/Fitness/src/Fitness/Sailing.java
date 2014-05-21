package Fitness;

import java.util.GregorianCalendar;


/**
 * Write a description of class Sailing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sailing extends Outdoor implements Distance
{
   private double distance;

    public Sailing(){
        super();
    }
    public Sailing(String name, GregorianCalendar date, double timeSpent,double distance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        
    }
    public Sailing(Sailing tb){
        super(tb);
        this.distance=tb.getDistance();
        
    }
     @Override
    public double getDistance() {
       return this.distance;
    }

    @Override
    public void setDistance(double distance) {
       this.distance=distance;
    }
    @Override
   public void setCalories(double peso) {
    double mets=3;
      double calories=mets*peso*this.getTimeSpent();
      this.setActivityCalories(calories);    
    }
   
   
   
   
     ////////////toString equals clone
    
    
     public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance").append("\n");
        sb.append(this.distance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        Sailing act = (Sailing) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance());
        
    }

    @Override
     public Sailing clone(){
        return new Sailing(this);
    }
}
