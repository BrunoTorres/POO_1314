package Fitness;


import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Classe comparador.
 * Compara Simulacao por data, do mais recente, para o mais antigo.
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class CompareStatsPerYearAndMonth implements Comparator<GregorianCalendar>,Serializable
{

    @Override
    public int compare(GregorianCalendar o1, GregorianCalendar o2) {
        if(o1.after(02))
            return -1;
        if(o1.before(o2))
            return 1;
        return 0;
    }
    
}
