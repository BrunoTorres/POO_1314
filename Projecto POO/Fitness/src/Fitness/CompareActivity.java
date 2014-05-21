package Fitness;


import java.io.Serializable;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bruno
 */
public class CompareActivity implements Comparator<Activity>,Serializable
{

    @Override
    public int compare(Activity o1, Activity o2) {
        if(o1.getDate().after(o2.getDate()))
            return -1;
        if(o1.getDate().before(o2.getDate()))
            return 1;
        return 0;
          
           
           
 
    }
    
}
