package Fitness;


import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe comparador.
 * Compara Pessoas por ordem alfabética do nome. 
 * 
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class ComparePersonByName implements Comparator<Person>,Serializable {
    
    @Override
    public int compare(Person p1,Person p2){
        
        return (p1.getName().compareTo(p2.getName()));
    }
    
    
}
