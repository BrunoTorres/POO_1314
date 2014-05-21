
import java.util.GregorianCalendar;


public class Indoor extends Activity
{
    public Indoor(){
        super();
    }

    public Indoor(String sportName, String name, GregorianCalendar date, double timeSpent, String weather){
        super(sportName, name, date, timeSpent, weather);
    }

    public Indoor(Indoor o){
        super(o);
    }

    /**
     *
     * @return
     */
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
        Indoor act = (Indoor) a;
        return  ( super.equals(act) );
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        return sb.toString();      
    }

    @Override
    public Indoor clone() {
        return new Indoor(this);
    }
    
}
