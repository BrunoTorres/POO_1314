package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Write a description of class Snowboarding here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snowboarding extends Outdoor  implements Distance, VerticalDistance, Serializable
{
    private double distance;
    private double verticaldistance;

    /**
     *
     */
    public Snowboarding(){
        super();
    }

    /**
     *
     * @param name
     * @param date
     * @param timeSpent
     * @param distance
     * @param verticaldistance
     * @param weather
     */
    public Snowboarding(String name, GregorianCalendar date, double timeSpent,double distance,
            double verticaldistance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        this.verticaldistance=verticaldistance;
        
        
    }

    /**
     *
     * @param tb
     */
    public Snowboarding(Snowboarding tb){
        super(tb);
        this.distance=tb.getDistance();
        this.verticaldistance=tb.getVerticalDistance();
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
     * @return
     */
    @Override
    public double getVerticalDistance() {
        return this.verticaldistance;
    }

    /**
     *
     * @param distance
     */
    @Override
    public void setDistance(double distance) {
       this.distance=distance;
    }

    /**
     *
     * @param verticaldistance
     */
    @Override
    public void setVerticalDistance(double verticaldistance) {
        this.verticaldistance=verticaldistance;
    }
    
    @Override
   public void setCalories(double peso) {
    double mets=8.5;
      double calories=mets*peso*(this.getTimeSpent()/60);
      this.setActivityCalories(calories);    
    }
   
   
   
   
     ////////////toString equals clone
    
    
     public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance horizontal").append("\n");
        sb.append(this.distance).append("\n");
        sb.append("Distance vertical").append("\n");
        sb.append(this.verticaldistance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        Snowboarding act = (Snowboarding) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance()
                && this.verticaldistance==act.getVerticalDistance());
        
    }

    @Override
     public Snowboarding clone(){
        return new Snowboarding(this);
    }

}
