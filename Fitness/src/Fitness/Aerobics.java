package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade Aerobics
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class Aerobics extends Indoor implements Serializable
{

    /**
     * Construtor vazio
     */
    public Aerobics(){
        super();
    }

    /**
     * Construtor parametrizado 
     * @param name Nome da actividade
     * @param date  Data da realização da actividade
     * @param timeSpent Tempo gasto em minutos
     */
    public Aerobics(String name, GregorianCalendar date, double timeSpent){
        super(name,date,timeSpent);
        
    }

    /**
     *
     * Construtor de cópia
     * @param tb-instância de Aerobics
     */
    public Aerobics(Aerobics tb){
        super(tb);
        
    }
    
    
    @Override
    public void setCalories(double peso) {
      double mets=6.5;
      double calories=mets*peso*(this.getTimeSpent()/60);
      this.setActivityCalories(calories);    
    }
    
    ////////////toString equals clone
    
    
    @Override
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
}
