package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Write a description of class Skating here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skating extends Outdoor implements Distance, Serializable
{
     private double distance;

    /**
     *
     */
    public Skating(){
        super();
    }

    /**
     *
     * @param name
     * @param date
     * @param timeSpent
     * @param distance
     * @param weather
     */
    public Skating(String name, GregorianCalendar date, double timeSpent,double distance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        
    }

    /**
     *
     * @param tb
     */
    public Skating(Skating tb){
        super(tb);
        this.distance=tb.getDistance();
        
    }

    /**
     *
     * @return
     */
    @Override
    public double getDistance() {
       return this.distance;
    }

    /**
     *
     * @param distance
     */
    @Override
    public void setDistance(double distance) {
       this.distance=distance;
    }
    @Override
   public void setCalories(double peso) {
    double mets=7;
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
        Skating act = (Skating) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance());
        
    }

    @Override
     public Skating clone(){
        return new Skating(this);
    }
}
