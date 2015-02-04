
package Fitness;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe comparador.
 * Compara Rankings por km (Ordem decrescente).
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class CompareRankingByKm implements Comparator<Ranking>,Serializable{

    @Override
    public int compare(Ranking o1, Ranking o2) {
        if(o1.getKm()>o2.getKm())
            return -1;
        if(o1.getKm()<o2.getKm())
            return 1;
        return (o1.getAthlete().getName().compareTo(o2.getAthlete().getName()));
    }

}
