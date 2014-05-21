package Fitness;


import java.util.GregorianCalendar;


public class IndoorAdversarialLixo
{
    private int myScore;
    private int opScore;
        
    public IndoorAdversarial (){
        super();
        this.myScore = 0;
        this.opScore = 0;
    }
    
    public IndoorAdversarial(String sportName, String name, GregorianCalendar date, double timeSpent, String weather, int myScore, int opScore){
        super(sportName, name, date, timeSpent, weather);
        this.myScore = myScore;
        this.opScore = opScore;
    }
    
    public IndoorAdversarial(IndoorAdversarial a){
        super(a);
        this.myScore = a.getMyScore();
        this.opScore = a.getOpScore();
    }
    
    public int getMyScore(){
        return this.myScore;
    }
    
    public int getOpScore(){
        return this.opScore;
    }
    
    @Override
    public void  setCalories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // redefine cálculo das calorias queimadas
/*
    @Override
    public void setPerformance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;
        IndoorAdversarial act = (IndoorAdversarial) a;
        return  ( super.equals(act) && (this.getMyScore() == act.getMyScore()) && (this.getOpScore() == act.getOpScore()) );
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        sb.append("Resultado: ");
        sb.append(this.getMyScore());
	sb.append(" - "); 
	sb.append(this.getOpScore()).append("\n");
        return sb.toString();      
    }

    @Override
    public IndoorSolo clone() {
        return new IndoorAdversarial(this);
    }
}
