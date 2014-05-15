/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package li3_java;

 

import java.io.Serializable;

public class ParCoAutores implements Serializable{
	private String autor1;
	private String autor2;
	private int numPubs;

	public ParCoAutores (){
		this.autor1 = "";
		this.autor2 = "";
		this.numPubs = 0;
	}

	public ParCoAutores (String a1, String a2, int x){
		this.autor1 = a1;
		this.autor2 = a2;
		this.numPubs = x;
	}

	public ParCoAutores (ParCoAutores par){
		this.autor1 = par.getNome1();
		this.autor2 = par.getNome2();
		this.numPubs = par.getNumPubs();
	}

	public String getNome1()   { return this.autor1; }
	public String getNome2()   { return this.autor2; }
	public int    getNumPubs() { return this.numPubs; }

	public void addPubs(int x){ this.numPubs += x; }

	@Override
	public ParCoAutores clone(){ return new ParCoAutores(this); }

	public boolean equals(ParCoAutores par){
		if(this == par) return true;
        if((par == null) || (this.getClass() != par.getClass()))
            return false;

        else {
        	ParCoAutores p = (ParCoAutores) par;
        	return ( (this.getNome1().equals(par.getNome1())) && (this.getNome2().equals(par.getNome2())) ) || ( (this.getNome1().equals(par.getNome2())) && (this.getNome2().equals(par.getNome1())) );
    	}
	}

	@Override
	public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("\tNome dos Autores: ").append(this.getNome1()).append(this.getNome2()).append("\tNúmero de publicações em comum: ").append(this.getNumPubs()).append("\n");
        return s.toString();
    }   
	
}