package Fitness;


import java.io.Serializable;
import java.util.Comparator;



/**
 * Classe comparador.
 * Compara Actividades por data, por ordem decrescente.
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class CompareActivity implements Comparator<Activity>,Serializable
{
    @Override
    public int compare(Activity o1, Activity o2) {
        if(o1.getDate().after(o2.getDate()))
            return -1;
        if(o1.getDate().before(o2.getDate()))
            return 1;
        if(o1.getTimeSpent()>o2.getTimeSpent())
            return -1;
       else
            return 1;
          
           
           
 
    }
    
}
