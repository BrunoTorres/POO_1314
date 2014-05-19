
import java.util.GregorianCalendar;


public class Other extends Activity
{

    public Other(){
        super();
    }

    public Other(String sportName, String name, GregorianCalendar date, GregorianCalendar timeSpent, String weather){
        super(sportName, name, date, timeSpent, weather);
    }

    public Other(Other o){
        super(o);
    }


    @Override
    public void setCalories() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPerformance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean equals(Object a){
        if(this == a)
            return true;
        if(a == null || this.getClass() != a.getClass())
            return false;

        Other act = (Other) a;

        return  ( super.equals(act) );
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        return sb.toString();
    }
            
            
    @Override
    public Other clone() {
        return new Other(this);
    }

   
   // apenas redefine cálculo das calorias queimadas

    
}
