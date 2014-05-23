package Fitness;

import java.util.GregorianCalendar;


/**
 * Write a description of class MountainBiking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MountainBiking extends Outdoor implements Distance,VerticalDistance
{
    private double distance;
    private double verticaldistance;
    private ListRecords recs;
    
    public MountainBiking(){
        super();
    }
    public MountainBiking(String name, GregorianCalendar date, double timeSpent,double distance,
            double verticaldistance,String weather){
        super(name,date,timeSpent,weather);
        this.distance=distance;
        this.verticaldistance=verticaldistance;
        this.recs=createRecord();
        
    }
    public MountainBiking(MountainBiking tb){
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
   
   public ListRecords getListRecords() {
       return this.recs.clone();
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
        MountainBiking act = (MountainBiking) a;
        return  ( super.equals(act)
                && this.distance==act.getDistance()
                && this.verticaldistance==act.getVerticalDistance());
        
    }

    @Override
     public MountainBiking clone(){
        return new MountainBiking(this);
    }

   
    

   }
