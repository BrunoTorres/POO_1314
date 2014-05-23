package Fitness;

import java.util.GregorianCalendar;


/**
 * Write a description of class Running here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Running extends Outdoor implements Distance
{
    private double distance;
    private ListRecords recs;

    public Running(){
        super();
        this.distance=0;
        this.recs=new ListRecords();
    }
    public Running(String name, GregorianCalendar date, double timeSpent,double distance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        this.recs=createRecord();
        
    }
    public Running(Running tb){
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
    double mets=7;
      double calories=mets*peso*this.getTimeSpent();
      this.setActivityCalories(calories);    
    }
   
   private ListRecords createRecord() {
        ListRecords list=new ListRecords("Running");
        Records recCooper=new DistancePerTime()
        Records recCooper=new TimePerDistance()
        
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
        Running act = (Running) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance());
        
    }

    @Override
     public Running clone(){
        return new Running(this);
    }

    
}
