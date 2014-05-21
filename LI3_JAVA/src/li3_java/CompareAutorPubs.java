/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package li3_java;

import java.io.Serializable;
import java.util.Comparator;

public class CompareAutorPubs implements Comparator<Autor>, Serializable
{
   
   @Override
   public int compare(Autor a1, Autor a2){
	if((a2.getNumeroPubsSolo()+a2.getNumeroPubsCoAutores()) > (a1.getNumeroPubsSolo() + a1.getNumeroPubsCoAutores()))
		return 1;
	if((a1.getNumeroPubsSolo()+a1.getNumeroPubsCoAutores()) > (a2.getNumeroPubsSolo() + a2.getNumeroPubsCoAutores()))
		return -1;
	
	return 0;
	//return (a2.getNumeroPubsCoAutores() + a2.getNumeroPubsSolo()) - (a1.getNumeroPubsCoAutores() + a1.getNumeroPubsSolo());
   }
}
   
  
