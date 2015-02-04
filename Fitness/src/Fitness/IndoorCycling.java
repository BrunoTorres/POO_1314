package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade IndoorCycling
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class IndoorCycling extends Indoor implements Distance, Serializable
{
    private double distance;

    /**
     *Construtor vazio
     */
    public IndoorCycling(){
        super();
    }

    /**
     *
     * @param name Nome da actividade.
     * @param date Data da realização da actividade.
     * @param timeSpent Tempo gasto em minutos.
     * @param distance Distancia feita.
     * 
     */
    public IndoorCycling(String name, GregorianCalendar date, double timeSpent,double distance){
        super(name,date,timeSpent);
        this.distance=distance;
        
    }

    /**
     *Construtor de cópia.
     * @param tb instância de IndoorCycling.
     */
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
   public void setCalories(double peso) {
    double mets=7;
      double calories=mets*peso*this.getTimeSpent();
      this.setActivityCalories(calories);    
    }
   
   
   
   
   
     ////////////toString equals clone
    
    
    @Override
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
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        return hash;
    }

    @Override
     public IndoorCycling clone(){
        return new IndoorCycling(this);
    }
   
}
