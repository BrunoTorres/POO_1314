
import java.util.GregorianCalendar;


public class Group extends Distance
{
    private int myScore;
    private int opScore;
    
    public Group() {
        super();
    }
    
    public Group(String sportName, String name, GregorianCalendar date, GregorianCalendar timeSpent, String weather, float distance, int myScore, int opScore){
        super(sportName, name, date, timeSpent, weather, distance);
        this.myScore = myScore;
        this.opScore = opScore;
    }
    
    public Group(Group a){
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
    
    public void setCalories(){}
    
    public void setPerformance(){}
    
    public boolean equals(Object a){
        if(this == a)
			return true;
		if(a == null || this.getClass() != a.getClass())
			return false;
        Group act = (Group) a;
        
        return ( (super.equals(act)) && (this.myScore == act.getMyScore()) && (this.opScore == act.getOpScore()) );
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
	sb.append(super.toString());
        sb.append("Resultado: ");
        sb.append(this.getMyScore());
	sb.append(" - "); // Aqui acho que pode ficar assim, porque todos os desportos que tem duas distancias, esta é distancia vertical
	sb.append(this.getOpScore()).append("\n");
        
        return sb.toString();
    }
    
    public Group clone(){
        return new Group(this);
    }
}
