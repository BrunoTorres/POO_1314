package Fitness;

import java.util.GregorianCalendar;


/**
 * Write a description of class Cycling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cycling extends Outdoor implements Distance
{
    private double distance;
    private ListRecords recs;
    public Cycling(){
        super();
    }
    public Cycling(String name, GregorianCalendar date, double timeSpent,double distance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        this.createRecord();
        
    }
    public Cycling(Cycling tb){
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
        
        Records recCooper=new TimePerDistance("One hour (km)",60,this.distance,this.getTimeSpent());
        Records rec10miles=new DistancePerTime("10 miles",16.09344,this.distance,this.getTimeSpent());
        Records rec3km=new DistancePerTime("20 km",20,this.distance,this.getTimeSpent());
        Records rec10km=new DistancePerTime("50 km",50,this.distance,this.getTimeSpent());
        Records rec50miles=new DistancePerTime("50 miles",80.4672,this.distance,this.getTimeSpent());
       
        list.addRecord(recCooper);
        list.addRecord(rec10miles);
        list.addRecord(rec3km);
        list.addRecord(rec10km);
        list.addRecord(rec50miles);
        
        return list;
   
    }
   
   
     ////////////toString equals clone
    
    
     public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Distancia: ").append("\n");
        sb.append(this.distance).append(" (km)\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        Cycling act = (Cycling) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance());
        
    }

    @Override
     public Cycling clone(){
        return new Cycling(this);
    }
}
