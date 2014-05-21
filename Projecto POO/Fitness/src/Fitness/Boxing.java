package Fitness;

import java.util.GregorianCalendar;



public class Boxing extends Indoor implements UserVs
{
     
    private int myScore;
    private int opScore;
    
    
    public Boxing(){
        super();
    }
    public Boxing(String name, GregorianCalendar date, double timeSpent,int myScore,int opScore){
        super(name,date,timeSpent);
        this.myScore=myScore;
        this.opScore=opScore;
    }
    public Boxing(Boxing tb){
        super(tb);
        this.myScore=tb.getMyScore();
        this.opScore=tb.getOpScore();
    }
    @Override
    public int getMyScore() {
      return this.myScore;
    }

    @Override
    public int getOpScore() {
        return this.opScore;
    }
    @Override
    public void setCalories(double peso) {   //METS=12
      double mets=12;
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
        Boxing act = (Boxing) a;
        return  ( super.equals(act)
                && this.myScore==act.getMyScore()
                && this.opScore==act.getOpScore());
        
    }

     @Override
    public Boxing clone(){
        return new Boxing(this);
    }
    
    
}
