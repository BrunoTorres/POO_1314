package Fitness;

import java.util.GregorianCalendar;


/**
 * Write a description of class Aerobics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Aerobics extends Indoor
{
    public Aerobics(){
        super();
    }
    public Aerobics(String name, GregorianCalendar date, double timeSpent){
        super(name,date,timeSpent);
        
    }
    public Aerobics(Aerobics tb){
        super(tb);
        
    }
    
    
    @Override
    public void setCalories(double peso) {
      double mets=6.5;
      double calories=mets*peso*this.getTimeSpent();
      this.setActivityCalories(calories);    
    }
    
    ////////////toString equals clone
    
    
     public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        return sb.toString();      
    }
    
    
    
    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        Aerobics act = (Aerobics) a;
        return  ( super.equals(act));
        
    }

    @Override
     public Aerobics clone(){
        return new Aerobics(this);
    } 
}
