package Fitness;

import java.util.GregorianCalendar;


/**
 * Write a description of class IndoorCycling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IndoorCycling extends Indoor implements Distance
{
    private double distance;

    public IndoorCycling(){
        super();
    }
    public IndoorCycling(String name, GregorianCalendar date, double timeSpent,double distance){
        super(name,date,timeSpent);
        this.distance=distance;
        
    }
    public IndoorCycling(IndoorCycling tb){
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
   public void setCalories(int peso) {
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
        IndoorCycling act = (IndoorCycling) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance());
        
    }

    @Override
     public IndoorCycling clone(){
        return new IndoorCycling(this);
    }
   
}
