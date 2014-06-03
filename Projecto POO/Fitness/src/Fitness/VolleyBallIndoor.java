package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade VolleyBallIndoor.
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class VolleyBallIndoor extends Indoor implements UserVs, Serializable

{
    private int myScore;
    private int opScore;
    
    /**
     *
     */
    public VolleyBallIndoor(){
        super();
    }

    /**
     *
     * @param name
     * @param date
     * @param timeSpent
     * @param myScore
     * @param opScore
     */
    public VolleyBallIndoor(String name, GregorianCalendar date, double timeSpent,int myScore,int opScore){
        super(name,date,timeSpent);
        this.myScore=myScore;
        this.opScore=opScore;
    }

    /**
     *
     * @param tb
     */
    public VolleyBallIndoor(VolleyBallIndoor tb){
        super(tb);
        this.myScore=tb.getMyScore();
        this.opScore=tb.getOpScore();
    }

    /**
     *
     * @return
     */
    @Override
    public int getMyScore() {
      return this.myScore;
    }

    /**
     *
     * @return
     */
    @Override
    public int getOpScore() {
        return this.opScore;
    }
    
    @Override
    public void setCalories(double peso) {//MET=4
      double mets=4;
      double calories=mets*peso*this.getTimeSpent();
      this.setActivityCalories(calories);    
    }
    
    ////////////toString equals clone
    
    
     public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("My Score").append("\n");
        sb.append(this.myScore).append("\n");
        sb.append("Opponent Score").append("\n");
        sb.append(this.opScore).append("\n");
        return sb.toString();      
    }
    
    
    
    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        VolleyBallIndoor act = (VolleyBallIndoor) a;
        return  ( super.equals(act)
                && this.myScore==act.getMyScore()
                && this.opScore==act.getOpScore());
        
    }

    @Override
     public VolleyBallIndoor clone(){
        return new VolleyBallIndoor(this);
    } 
}
