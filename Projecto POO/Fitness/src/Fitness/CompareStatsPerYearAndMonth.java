package Fitness;


import java.io.Serializable;
import java.util.Comparator;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
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
