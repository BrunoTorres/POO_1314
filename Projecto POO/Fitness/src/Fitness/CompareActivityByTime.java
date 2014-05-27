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