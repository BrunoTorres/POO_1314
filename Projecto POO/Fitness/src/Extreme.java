
import java.util.GregorianCalendar;


public class Extreme extends Activity
{
    private double points;

    public Extreme() {
        super();
        this.points = 0.0;
    }

    public Extreme(String sportName, String name, GregorianCalendar date, double timeSpent, String weather, double points){
        super(sportName, name, date, timeSpent, weather);
        this.points = points;
    }

    public Extreme(Extreme e){
        super(e);
        this.points = e.getPoints();
    }
    
    public double getPoints(){
        return this.points;
    }

    @Override
    public void setCalories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPerformance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;

        Extreme act = (Extreme) a;

        return  ( super.equals(act) && (this.points ==act.getPoints()) );
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Pontuaçao: ");
        sb.append(this.points).append("\n");
        return sb.toString();
    }

    @Override
    public Extreme clone() {
        return new Extreme(this);
    }
}
