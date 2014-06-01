package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Write a description of class Skiing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skiing extends Outdoor implements Distance, VerticalDistance, Serializable
{
    private double distance;
    private double verticaldistance;
    private ListRecords recs;
    
    public Skiing(){
        super();
    }
    public Skiing(String name, GregorianCalendar date, double timeSpent,double distance,
            double verticaldistance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        this.verticaldistance=verticaldistance;
        this.recs=createRecord();
        
    }
    public Skiing(Skiing tb){
        super(tb);
        this.distance=tb.getDistance();
        this.verticaldistance=tb.getVerticalDistance();
    }
     @Override
    public double getDistance() {
       return this.distance;
    }
     @Override
    public double getVerticalDistance() {
        return this.verticaldistance;
    }


    @Override
    public void setDistance(double distance) {
       this.distance=distance;
    }
    @Override
    public void setVerticalDistance(double verticaldistance) {
        this.verticaldistance=verticaldistance;
    }
    
    @Override
   public void setCalories(double peso) {
    double mets=8.5;
      double calories=mets*peso*this.getTimeSpent();
      this.setActivityCalories(calories);    
    }
   
   private ListRecords createRecord() {
        ListRecords list=new ListRecords("Walking");
        
        Record recCooper=new TimePerDistance("Cooper",12,this.distance,this.getTimeSpent());
        Record rec1km=new DistancePerTime("1 km",1,this.distance,this.getTimeSpent());
        Record rec1mile=new DistancePerTime("1 mile",1.609344,this.distance,this.getTimeSpent());
        Record rec3km=new DistancePerTime("3 km",3,this.distance,this.getTimeSpent());
        Record rec10km=new DistancePerTime("10 km",10,this.distance,this.getTimeSpent());
        Record rechalfMarathon=new DistancePerTime("Half Marathon km",21.097494,this.distance,this.getTimeSpent());
        
        list.addRecord(recCooper);
        list.addRecord(rec1km);
        list.addRecord(rec1mile);
        list.addRecord(rec3km);
        list.addRecord(rec10km);
        list.addRecord(rechalfMarathon);
        
        return list;
   
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
        Skiing act = (Skiing) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance()
                && this.verticaldistance==act.getVerticalDistance());
        
    }

    @Override
     public Skiing clone(){
        return new Skiing(this);
    }

   
}
