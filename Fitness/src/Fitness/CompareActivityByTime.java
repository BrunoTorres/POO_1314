package Fitness;


import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe comparador.
 * Compara Actividades por tempo gasto porordem decrescente.
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class CompareActivityByTime implements Comparator<Activity>,Serializable {
    
    @Override
    public int compare(Activity act1, Activity act2){
        
        if  (act1.getTimeSpent() < act2.getTimeSpent())
        	return 1;
        if (act1.getTimeSpent() > act2.getTimeSpent())
        	return -1;
        return (act1.getName().compareTo(act2.getName()));
    }
}