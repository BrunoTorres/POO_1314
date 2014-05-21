/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package li3_java;

/**
 * Write a description of class Autor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.Serializable;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Autor implements Serializable {

	private String nome;
	private int numeroPubsSolo;
	private int numeroPubsCoAutores;
	private TreeMap<String, CoAutor> coAutores;
	//private long start;
	//private long end;

	public Autor() {
		this.nome = "";
		this.numeroPubsSolo = 0;
		this.numeroPubsCoAutores = 0;
		this.coAutores = new TreeMap<>();
	}

	public Autor(String nome) {
		this.nome = nome;
		this.numeroPubsSolo = 1;
		this.numeroPubsCoAutores = 0;
		this.coAutores = new TreeMap<>();
	}

	public Autor(String nome, List<String> auts) {
		this.nome = nome;
		if (auts.size() > 1) {
			this.numeroPubsSolo = 0;
			this.numeroPubsCoAutores = 1;
		} else {
			this.numeroPubsSolo = 1;
			this.numeroPubsCoAutores = 0;
		}

		this.coAutores = new TreeMap<>();
		for (String s : auts) {
			if (!s.equals(nome)) {
				CoAutor coAut = new CoAutor(s);
				this.coAutores.put(s, coAut);
				//this.coAutores.get(s).adicionaPub();
			}
		}
	}

	public Autor(Autor aut) {
		this.nome = aut.getNome();
		this.numeroPubsSolo = aut.getNumeroPubsSolo();
		this.numeroPubsCoAutores = aut.getNumeroPubsCoAutores();
		this.coAutores = new TreeMap<>();

		for (CoAutor coAut : aut.getCoAutores().values()) {
			this.coAutores.put(coAut.getNome(), coAut.clone());
		}
	}

	public String getNome() {
		return this.nome;
	}

	public int getNumeroPubsSolo() {
		return this.numeroPubsSolo;
	}

	public int getNumeroPubsCoAutores() {
		return this.numeroPubsCoAutores;
	}

	public Map<String, CoAutor> getCoAutores() {
		TreeMap<String, CoAutor> aux = new TreeMap<>();

		for (CoAutor coAut : this.coAutores.values()) {
			aux.put(coAut.getNome(), coAut.clone());
		}

		return aux;
	}

	public void adicionaCoAutores(List<String> autores) {
		this.adicionaPub(autores);

		for (String s : autores) {
			if (!s.equals(this.nome)) {
				if (this.coAutores.containsKey(s)) {
					this.coAutores.get(s).adicionaPub();
				} else {
					CoAutor coAut = new CoAutor(s);
					this.coAutores.put(s, coAut);
					//this.coAutores.get(s).adicionaPub();
				}
			}
		}
	}

	public void adicionaPub(List<String> autores) {
		if (autores.size() > 1) {
			this.numeroPubsCoAutores++;
		} else {
			this.numeroPubsSolo++;
		}
	}

	public void incrementaPubs(int nPubsSolo, int nPubsCoAutor) {
		this.numeroPubsSolo += nPubsSolo;
		this.numeroPubsCoAutores += nPubsCoAutor;
	}

	@Override
	public boolean equals(Object a) {
		if (this == a) {
			return true;
		}

		if (a == null || this.getClass() != a.getClass()) {
			return false;
		}

		Autor aut = (Autor) a;
		return this.getNome().equals(aut.getNome());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.nome);
		//hash = 97 * hash + this.numeroPubsSolo;
		//hash = 97 * hash + this.numeroPubsCoAutores;
		//hash = 97 * hash + Objects.hashCode(this.coAutores);
		return hash;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Nome do Autor: ");
		s.append(this.getNome());
		s.append("\n");
		s.append("Número de publicações a solo: ");
		s.append(this.getNumeroPubsSolo());
		s.append("\nNúmero de publicações com co-autores: ");
		s.append(this.getNumeroPubsCoAutores());
		s.append("\nLista de Co-Autores:\n");
		for (CoAutor coAut : this.coAutores.values()) {
			s.append(coAut.toString()).append("\n");
		}
		return s.toString();
	}

	@Override
	public Autor clone() {
		return new Autor(this);
	}
}
