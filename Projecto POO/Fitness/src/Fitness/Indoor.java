package Fitness;


import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public abstract class Indoor extends Activity implements Serializable
{
    
    /**
     *
     */
    public Indoor(){
        super();
    }

    /**
     *
     * @param name
     * @param date
     * @param timeSpent
     */
    public Indoor(String name, GregorianCalendar date, double timeSpent){
        super(name, date, timeSpent);
    }

    /**
     *
     * @param o
     */
    public Indoor(Indoor o){
        super(o);
    }

    

    /**
     *
     * @param a
     * @return
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
    public abstract Indoor clone();
    
    
    
}
