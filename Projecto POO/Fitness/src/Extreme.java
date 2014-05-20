
import java.util.GregorianCalendar;


public class Extreme extends Activity
{

    public Extreme() {
        super();
    }

    public Extreme(String sportName, String name, GregorianCalendar date, double timeSpent, String weather){
        super(sportName, name, date, timeSpent, weather);
    }

    public Extreme(Extreme e){
        super(e);
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

        return  ( super.equals(act) );
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }

    @Override
    public Extreme clone() {
        return new Extreme(this);
    }
}
