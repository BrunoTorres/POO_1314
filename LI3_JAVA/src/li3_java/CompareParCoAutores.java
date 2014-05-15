/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package li3_java;

import java.io.Serializable;
import java.util.Comparator;

public class CompareParCoAutores implements Comparator<ParCoAutores>, Serializable
{

	@Override
	public int compare(ParCoAutores a1, ParCoAutores a2){
		if((a2.getNumPubs() > (a1.getNumPubs())))
			return -1;
		else if((a1.getNumPubs() > (a2.getNumPubs())))
			return 1;
			else 
				if ( a2.getNome1().compareTo(a1.getNome1()) == 0)
					return a2.getNome2().compareTo(a1.getNome2());
				else 
					return a2.getNome1().compareTo(a1.getNome1());
	}
}