/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitness;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Classe comparador
 * Compara User por Nome(minutos)
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class CompareUserByName implements Comparator<User>,Serializable {
    
    
    @Override
    public int compare(User p1,User p2){
        
        return (p1.getName().compareTo(p2.getName()));
    }
    
    
}
