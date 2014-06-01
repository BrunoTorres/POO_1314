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
public class CompareRankingByTime implements Comparator<Ranking>,Serializable{

    @Override
    public int compare(Ranking o1, Ranking o2) {
        if(o1.getTime()>o2.getTime())
            return 1;
        if(o1.getTime()<o2.getTime())
            return -1;
        return (o1.getAthlete().getName().compareTo(o2.getAthlete().getName()));
    }

    
    
}
