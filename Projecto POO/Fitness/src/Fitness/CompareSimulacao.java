/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitness;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Bruno
 */
public class CompareSimulacao implements Comparator<Simulacao>,Serializable {

    @Override
    public int compare(Simulacao o1, Simulacao o2) {
         if(o1.getTempoGeral()>o2.getTempoGeral())
            return 1;
        if(o1.getTempoGeral()<o2.getTempoGeral())
            return -1;
        return (o1.getUser().getName().compareTo(o2.getUser().getName()));
    }
    
}
