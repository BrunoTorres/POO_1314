package Fitness;


import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Classe abstracta para todas as actividades que não tenham o clima como variável de instancia. 
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public abstract class Indoor extends Activity implements Serializable
{
    
    /**
     *Construtor vazio
     */
    public Indoor(){
        super();
    }

    /**
     *
     *  Construtor parametrizado.
     * @param name- Nome da actividade.
     * @param date-  Data da realização da actividade.
     * @param timeSpent- Tempo gasto em minutos.
     */
    public Indoor(String name, GregorianCalendar date, double timeSpent){
        super(name, date, timeSpent);
    }

    /**
     *  Construtor de cópia.
     * @param o- objecto do tipo Indoor.
     */
    public Indoor(Indoor o){
        super(o);
    }

    
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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    
    
}
