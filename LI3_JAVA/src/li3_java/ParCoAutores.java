/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package li3_java;

import java.io.Serializable;
import java.util.Objects;

public class ParCoAutores implements Serializable {

	private String autor1;
	private String autor2;
	private int numPubs;
	private int ultimoAno;

	public ParCoAutores() {
		this.autor1 = "";
		this.autor2 = "";
		this.numPubs = 0;
		this.ultimoAno = 0;
	}

	public ParCoAutores(String a1, String a2, int x, int ultAno) {
		this.autor1 = a1;
		this.autor2 = a2;
		this.numPubs = x;
		this.ultimoAno = ultAno;
	}

	public ParCoAutores(ParCoAutores par) {
		this.autor1 = par.getNome1();
		this.autor2 = par.getNome2();
		this.numPubs = par.getNumPubs();
		this.ultimoAno = par.getUltimoAno();
	}

	public String getNome1() {
		return this.autor1;
	}

	public String getNome2() {
		return this.autor2;
	}

	public int getNumPubs() {
		return this.numPubs;
	}
	
	public int getUltimoAno(){
		return this.ultimoAno;
	}
	
	public void setUltimoAno(int ultAno){
		this.ultimoAno = ultAno;
	}

	public void addPubs(int x) {
		this.numPubs += x;
	}

	@Override
	public ParCoAutores clone() {
		return new ParCoAutores(this);
	}

	@Override
	public boolean equals(Object par) {
		if (this == par) {
			return true;
		}
		if ((par == null) || (this.getClass() != par.getClass())) {
			return false;
		}

		ParCoAutores p = (ParCoAutores) par;
		return ((this.getNome1().equals(p.getNome1()) && this.getNome2().equals(p.getNome2())) || (this.getNome1().equals(p.getNome2()) && this.getNome2().equals(p.getNome1())));
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 97 * hash + Objects.hashCode(this.autor1);
		hash = 97 * hash + Objects.hashCode(this.autor2);
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("\tNome dos Autor 1: ").append(this.getNome1()).append("\n\tNome do Autor 2: ").append(this.getNome2()).append("\n\tNúmero de publicações em comum: ").append(this.getNumPubs()).append("\n");
		return s.toString();
	}

}
