
import java.util.GregorianCalendar;


public class Extreme extends Activity
{

    public Extreme() {
        super();
    }

    public Extreme(String sportName, String name, GregorianCalendar date, double timeSpent,int calories, String weather){
        super(sportName, name, date, timeSpent,calories, weather);
    }

    public Extreme(Extreme e){
        super(e.getSportName(), e.getName(), e.getDate(), e.getTimeSpent(),e.getCalories(), e.getWeather());
    }
    // apenas redefine cálculo das calorias queimadas

    @Override
    public void setCalories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRecords() {
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



    @Override
    public Extreme clone() {
        return new Extreme(this);
    }

    @Override
    public void setPerfomance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
