
import java.util.GregorianCalendar;


public class IndoorSolo extends Activity
{
    public IndoorSolo(){
        super();
    }

    public IndoorSolo(String sportName, String name, GregorianCalendar date, double timeSpent, String weather){
        super(sportName, name, date, timeSpent, weather);
    }

    public IndoorSolo(IndoorSolo o){
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
        IndoorSolo act = (IndoorSolo) a;
        return  ( super.equals(act) );
    }

    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(super.toString());
        return sb.toString();      
    }

    @Override
    public IndoorSolo clone() {
        return new IndoorSolo(this);
    }
    
}
