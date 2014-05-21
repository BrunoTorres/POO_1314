/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package li3_java;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RedeAnualAutores implements Serializable {

	private int ano;
	private int numAutores;
	private int numPubs;
	private TreeMap<String, Autor> redeAnualAutores;

	public RedeAnualAutores() {
		this.ano = 0;
		this.numAutores = 0;
		this.numPubs = 0;
		this.redeAnualAutores = new TreeMap<>();
	}

	public RedeAnualAutores(int ano, List<String> listaAutores) {
		this.ano = ano;
		this.numAutores = listaAutores.size();
		this.numPubs = 1;
		this.redeAnualAutores = new TreeMap<>();
		for (String autor : listaAutores) {
			Autor aut = new Autor(autor, listaAutores);
			this.redeAnualAutores.put(autor, aut);
		}
	}

	public RedeAnualAutores(RedeAnualAutores umaRedeAnualAutores) {
		this.ano = umaRedeAnualAutores.getAno();
		this.numAutores = umaRedeAnualAutores.getNumAutores();
		this.numPubs = umaRedeAnualAutores.getNumPubs();
		this.redeAnualAutores = (TreeMap<String, Autor>) umaRedeAnualAutores.getRedeAnualAutores();
	}

	public int getAno() {
		return this.ano;
	}

	public int getNumAutores() {
		return this.numAutores;
	}

	public int getNumPubs() {
		return this.numPubs;
	}

	public Map<String, Autor> getRedeAnualAutores() {
		Map<String, Autor> aux = new TreeMap<>();

		for (Autor aut : this.redeAnualAutores.values()) {
			aux.put(aut.getNome(), aut.clone());
		}

		return aux;
	}

	public void insereAutores(List<String> autores) {
		for (String s : autores) {
			if (!this.redeAnualAutores.containsKey(s)) {
				this.numAutores++;
				Autor aut = new Autor(s, autores);
				this.redeAnualAutores.put(s, aut);
				//this.redeAnualAutores.get(s).adicionaCoAutores(autores, this.ano);
			} else {
				this.redeAnualAutores.get(s).adicionaCoAutores(autores);
			}

		}
		this.numPubs++;
	}

	public int numPubsAutor(String nomeAutor) {
		return this.redeAnualAutores.get(nomeAutor).getNumeroPubsCoAutores() + this.redeAnualAutores.get(nomeAutor).getNumeroPubsSolo();
	}

	@Override
	public RedeAnualAutores clone() {
		return new RedeAnualAutores(this);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ano: ");
		sb.append(this.getAno());
		sb.append("\nNum Autores: ");
		sb.append(this.getNumAutores());
		sb.append("\nNum Publicações: ");
		sb.append(this.getNumPubs());
		sb.append("\n\n");
		for (Autor aut : this.redeAnualAutores.values()) {
			//sb.append("\t");
			sb.append(aut.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}
