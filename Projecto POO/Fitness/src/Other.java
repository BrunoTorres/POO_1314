
import java.util.GregorianCalendar;


public class Other extends Activity
{

    public Other(){
        super();
    }

    public Other(String sportName, String name, GregorianCalendar date, double timeSpent,int calories, String weather){
        super(sportName, name, date, timeSpent, calories,weather);
    }

    public Other(Other o){
        super(o.getSportName(), o.getName(), o.getDate(), o.getTimeSpent(),o.getCalories(), o.getWeather());
    }


    @Override
    public void setCalories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setRecords() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Other clone() {
        return new Other(this);
    }

   
   // apenas redefine cálculo das calorias queimadas

    @Override
    public void setPerfomance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
