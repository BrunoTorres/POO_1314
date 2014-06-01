package Fitness;


import java.util.GregorianCalendar;


public abstract class Indoor extends Activity implements Serializable
{
    
    public Indoor(){
        super();
    }

    public Indoor(String name, GregorianCalendar date, double timeSpent){
        super(name, date, timeSpent);
    }

    public Indoor(Indoor o){
        super(o);
    }

    
/*
    @Override
    public void setPerformance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/

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
