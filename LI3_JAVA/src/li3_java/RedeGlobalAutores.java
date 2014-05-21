/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package li3_java;

/**
 * Write a description of class RedeGlobalAutores here.
 *
 * @author jmano
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JOptionPane;

public class RedeGlobalAutores implements Serializable {

	private TreeMap<Integer, RedeAnualAutores> redeGlobalAutores;
	private String ficheiroLido;
	private int artigosLidos;
	private int nomesLidos;
	private int nomesDistintos;
	private int menorAno;
	private int maiorAno;
	private int numPubsUmAutor;

	public RedeGlobalAutores() {
		this.redeGlobalAutores = new TreeMap<>();
		this.ficheiroLido = "";
		this.artigosLidos = 0;
		this.nomesLidos = 0;
		this.nomesDistintos = 0;
		this.menorAno = 20000;
		this.maiorAno = 0;
	}

	public RedeGlobalAutores(RedeGlobalAutores rede) {
		this.redeGlobalAutores = (TreeMap<Integer, RedeAnualAutores>) rede.getRedeGlobalAutores();
		this.ficheiroLido = rede.getFIcheiroLido();
		this.artigosLidos = rede.getArtigosLidos();
		this.nomesLidos = rede.getNomesLidos();
		this.nomesDistintos = rede.getNomesDistintos();
		this.menorAno = rede.getMenorAno();
		this.maiorAno = rede.getMaiorAno();
	}

	public void leFicheiro(String fileName) throws IOException, ClassNotFoundException {
		String endName = fileName.substring(fileName.length() - 4);
		switch (endName) {
			case ".obj":
				this.leFicheiroObj(fileName);
				break;
			case ".txt":
				this.leFicheiroTxt(fileName);
				break;

			default:
				throw new IOException("File error...");

		}
	}
	// Getters

	public Map<Integer, RedeAnualAutores> getRedeGlobalAutores() {
		TreeMap<Integer, RedeAnualAutores> aux = new TreeMap<>();
		for (RedeAnualAutores redeAnual : this.redeGlobalAutores.values()) {
			aux.put(redeAnual.getAno(), redeAnual.clone());
		}
		return aux;
	}

	private String getFIcheiroLido() {
		return this.ficheiroLido;
	}

	private int getArtigosLidos() {
		return this.artigosLidos;
	}

	private int getNomesLidos() {
		return this.nomesLidos;
	}

	private int getNomesDistintos() {
		return this.nomesDistintos;
	}

	private int getMenorAno() {
		return this.menorAno;
	}

	private int getMaiorAno() {
		return this.maiorAno;
	}

	public int getNumPubsUmAutor() {
		return this.numPubsUmAutor;
	}

	public void leFicheiroObj(String fileName) throws IOException, ClassNotFoundException, ClassCastException {
		ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(fileName));
		RedeGlobalAutores redeGlobal = new RedeGlobalAutores((RedeGlobalAutores) objInput.readObject());
		this.redeGlobalAutores = (TreeMap<Integer, RedeAnualAutores>) redeGlobal.getRedeGlobalAutores();
		this.ficheiroLido = redeGlobal.getFIcheiroLido();
		this.artigosLidos = redeGlobal.getArtigosLidos();
		this.maiorAno = redeGlobal.getMaiorAno();
		this.menorAno = redeGlobal.getMenorAno();
		this.nomesDistintos = redeGlobal.getNomesDistintos();
		this.nomesLidos = redeGlobal.getNomesLidos();
		this.numPubsUmAutor = redeGlobal.getNumPubsUmAutor();
	}

	public void leFicheiroTxt(String fileName) throws FileNotFoundException {
		String linha;
		ArrayList<String> linhaTok = new ArrayList<>();
		int ano;
		Scanner fichScan;
		StringTokenizer sTok;
		HashSet<String> autDist = new HashSet<>();
		this.ficheiroLido = fileName;

		fichScan = new Scanner(new FileReader(fileName));
		fichScan.useDelimiter(System.getProperty("line.separator"));

		while (fichScan.hasNext()) {
			linha = fichScan.next();
			sTok = new StringTokenizer(linha, ",");

			while (sTok.hasMoreTokens()) {
				linhaTok.add(sTok.nextToken().trim());
			}

			if (linhaTok.size() > 1) {
				this.artigosLidos++;
			}

			if (linhaTok.size() == 2) {
				this.numPubsUmAutor++;
			}

			ano = Integer.valueOf(linhaTok.get(linhaTok.size() - 1));
			if (ano < this.menorAno) {
				this.menorAno = ano;
			}

			if (ano > this.maiorAno) {
				this.maiorAno = ano;
			}

			linhaTok.remove(linhaTok.size() - 1);

			autDist.addAll(linhaTok);
			this.nomesLidos += linhaTok.size();
			this.adicionaPublicacao(ano, linhaTok);

			linhaTok.clear();

		}
		this.nomesDistintos = autDist.size();
	}

	public void guardaDados(String fileName) throws SecurityException, IOException {

		FileOutputStream out = new FileOutputStream(fileName + ".obj");
		ObjectOutputStream oout = new ObjectOutputStream(out);

		oout.writeObject(this);
		oout.flush();

	}

	public void adicionaPublicacao(int ano, List<String> autores) {
		if (this.redeGlobalAutores.containsKey(ano)) {
			this.redeGlobalAutores.get(ano).insereAutores(autores);
		} else {
			RedeAnualAutores novoAno = new RedeAnualAutores(ano, autores);
			this.redeGlobalAutores.put(ano, novoAno);
		}
	}

	public RedeAnualAutores getPubsAno(int ano) throws RedeAnualNotFoundException {
		if (!this.redeGlobalAutores.containsKey(ano)) {
			throw new RedeAnualNotFoundException("Ano não existente. Ano: " + ano);
		}

		return this.redeGlobalAutores.get(ano).clone();
	}

	public String statsString() {
		StringBuilder s = new StringBuilder(".......... ESTATÍSTICAS ..........\n\n");
		s.append("Rede de Autores: ").append(this.getFIcheiroLido());
		s.append("\nAnos: [").append(this.getMenorAno()).append(", ").append(this.getMaiorAno()).append("]");
		s.append("\nPublicações: ").append(this.getArtigosLidos());
		s.append("\nAutores lidos: ").append(this.getNomesLidos());
		s.append("\nAutores distintos: ").append(this.getNomesDistintos()).append("\n\n");
		//for (RedeAnualAutores ano : this.redeGlobalAutores.values()) {
		//	s.append("\n\t").append(ano.toString()).append("\n");
		//}
		return s.toString();
	}

	public String consulta12() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nº de autores: ").append(this.getNomesDistintos()).append("\n");
		sb.append("Nº de artigos com apenas um autor: ").append(this.getNumPubsUmAutor()).append("\n");
		sb.append("Nº de autores que apenas publicaram a solo: ").append(this.getNumAutoresSolo()).append("\n");
		sb.append("Nº de autores que nunca publicaram a solo: ").append(this.getNumAutoresNoSolo()).append("\n");

		return sb.toString();
	}

	public int getNumPubsAutorAnos(String nome, int anoInicial, int anoFinal) {
		int count = 0;
		RedeAnualAutores redeAux;
		for (int i = anoInicial; i <= anoFinal; i++) {
			if (this.redeGlobalAutores.containsKey(i)) {
				redeAux = this.redeGlobalAutores.get(i).clone();
				count += redeAux.numPubsAutor(nome);
			}
		}
		return count;
	}

	public int getNumAutoresSolo() {
		HashSet<String> verificados = new HashSet<>();
		HashSet<String> solo = new HashSet<>();

		for (RedeAnualAutores redeAnual : this.redeGlobalAutores.values()) {
			for (Autor aut : redeAnual.getRedeAnualAutores().values()) {
				if (aut.getNumeroPubsCoAutores() == 0 && aut.getNumeroPubsSolo() != 0 && !verificados.contains(aut.getNome())) {
					solo.add(aut.getNome());
				} else {
					solo.remove(aut.getNome());
				}

				verificados.add(aut.getNome());
			}
		}
		return solo.size();
	}

	public int getNumAutoresNoSolo() {
		HashSet<String> verificados = new HashSet<>();
		HashSet<String> noSolo = new HashSet<>();

		for (RedeAnualAutores redeAnual : this.redeGlobalAutores.values()) {
			for (Autor aut : redeAnual.getRedeAnualAutores().values()) {
				if (aut.getNumeroPubsSolo() == 0 && aut.getNumeroPubsCoAutores() != 0 && !verificados.contains(aut.getNome())) {
					noSolo.add(aut.getNome());
				} else {
					noSolo.remove(aut.getNome());
				}

				verificados.add(aut.getNome());
			}
		}
		return noSolo.size();
	}

	public List<String> consulta21a(int anoInicial, int anoFinal, int topX) throws AnosForaDoIntervaloException, AnoInicialMaiorQueAnoFinalException, AnoInvalidoException {
		TreeSet<Autor> maxPubsAutores = new TreeSet<>(new CompareAutorPubs());
		//TreeSet<String> res = new TreeSet<String>();
		Iterator<Autor> it;
		Autor autAux, autAux2;
		boolean sair = false;
		boolean add = true;

		if (anoInicial < 0 || anoFinal < 0) {
			throw new AnoInvalidoException("Ano inválido. [" + anoInicial + ", " + anoFinal + "]");
		}
		if (anoInicial > anoFinal) {
			throw new AnoInicialMaiorQueAnoFinalException("Ano inicial maior que ano final. [" + anoInicial + ", " + anoFinal + "]");
		}
		if ((anoInicial < this.menorAno && anoFinal < this.menorAno) || (anoInicial > this.maiorAno)) {
			throw new AnosForaDoIntervaloException("Anos fora do intervalo do ficheiro. [" + anoInicial + ", " + anoFinal + "]");
		}

		for (int i = anoInicial; i <= anoFinal; i++) {
			if (this.redeGlobalAutores.containsKey(i)) {
				for (Autor aut : this.redeGlobalAutores.get(i).getRedeAnualAutores().values()) {
					it = maxPubsAutores.iterator();
					while (it.hasNext() && !sair) {
						autAux = it.next();
						if (autAux.getNome().equals(aut.getNome())) {
							maxPubsAutores.remove(autAux);
							autAux.incrementaPubs(aut.getNumeroPubsSolo(), aut.getNumeroPubsCoAutores());
							maxPubsAutores.add(autAux);
							sair = true;
							add = false;
						}
					}
					if (add) {
						maxPubsAutores.add(aut.clone());
					}
				}
			}
		}

		return this.consulta21aAux(maxPubsAutores, topX);
	}

	private List<String> consulta21aAux(TreeSet<Autor> auts, int topX) {
		ArrayList<String> res = new ArrayList<>();
		if (auts.size() < topX) {
			for (int i = 0; i < auts.size(); i++) {
				res.add(auts.pollFirst().getNome());
			}
		} else {
			for (int i = 0; i < topX; i++) {
				res.add(auts.pollFirst().getNome());
			}
		}

		return res;
	}

	public List<String> consulta21b(int topX, int anoInicial, int anoFinal) throws AnosForaDoIntervaloException, AnoInicialMaiorQueAnoFinalException, AnoInvalidoException {
		//TreeSet<ParCoAutores> paresAutores = new TreeSet<>(new CompareParCoAutores());
		TreeMap<ParCoAutores, ParCoAutores> paresAutores = new TreeMap<>(new CompareParCoAutores());
		//TreeMap<ParCoAutores, Integer> paresAutores = new TreeMap<>(new CompareParCoAutores());
		Iterator<ParCoAutores> it;
		ParCoAutores par, parAux;
		boolean sair = false;
		boolean add = true;
		double tempoAddPares = 0;
		double tempoCicloEquals = 0;

		if (anoInicial < 0 || anoFinal < 0) {
			throw new AnoInvalidoException("Ano inválido. [" + anoInicial + ", " + anoFinal + "]");
		}
		if (anoInicial > anoFinal) {
			throw new AnoInicialMaiorQueAnoFinalException("Ano inicial maior que ano final. [" + anoInicial + ", " + anoFinal + "]");
		}
		if ((anoInicial < this.menorAno && anoFinal < this.menorAno) || (anoInicial > this.maiorAno)) {
			throw new AnosForaDoIntervaloException("Anos fora do intervalo do ficheiro. [" + anoInicial + ", " + anoFinal + "]");
		}

		for (int i = anoInicial; i <= anoFinal; i++) {
			if (this.redeGlobalAutores.containsKey(i)) {
				for (Autor aut : this.redeGlobalAutores.get(i).getRedeAnualAutores().values()) {
					for (CoAutor coAut : aut.getCoAutores().values()) {
						//sair = false;
						add = true;
						par = new ParCoAutores(aut.getNome(), coAut.getNome(), coAut.getNumeroPubsComAutor(), i);
						Crono.start();
						if (paresAutores.containsKey(par) && paresAutores.get(par).getUltimoAno() != i) {
							//JOptionPane.showMessageDialog(null, "CONTEM: " + par.toString());
							paresAutores.get(par).setUltimoAno(i);
							paresAutores.get(par).addPubs(par.getNumPubs());
							//int pubs = paresAutores.get(par);
							//pubs += par.getNumPubs();
							//paresAutores.put(par, par);
							
							add = false;
						}
						tempoCicloEquals += Crono.stop();
						if (add) {
							Crono.start();
							//paresAutores.put(par, par.getNumPubs());
							paresAutores.put(par, par);
							tempoAddPares += Crono.stop();
						}
					}
				}

			}
		}

		TreeSet<ParCoAutores> novoPares = new TreeSet<>(new CompareParCoAutores());
		//it = paresAutores.keySet().iterator();
		it = paresAutores.values().iterator();
		Crono.start();
		while (it.hasNext()) {
			novoPares.add(it.next());
		}
		String tempo = Crono.print();
		JOptionPane.showMessageDialog(null, "ADD: " + tempoAddPares + "\nEQUALS: " + tempoCicloEquals + "\nSORT: " + tempo);
		return consulta21bAux(novoPares, topX);
	}

	public List<String> consulta21bAux(TreeSet<ParCoAutores> pares, int topX) {
		ArrayList<String> res = new ArrayList<>();

		if (pares.size() >= topX) {
			for (int i = 0; i < topX; i++) {
				res.add(pares.pollFirst().toString());
			}
		} else {
			for (int i = 0; i < pares.size(); i++) {
				res.add(pares.pollFirst().toString());
			}
		}

		return res;
	}
	
	public Set<String> consulta21c(int anoInicial, int anoFinal, ArrayList<String> listaAutores) throws AnosForaDoIntervaloException, AnoInicialMaiorQueAnoFinalException, AnoInvalidoException {
		ArrayList<String> autor1 = new ArrayList<>();
		ArrayList<String> autor2 = new ArrayList<>();
		TreeSet<String> autores = new TreeSet<>();

		if (anoInicial < 0 || anoFinal < 0) {
			throw new AnoInvalidoException("Ano inválido. [" + anoInicial + ", " + anoFinal + "]");
		}
		if (anoInicial > anoFinal) {
			throw new AnoInicialMaiorQueAnoFinalException("Ano inicial maior que ano final. [" + anoInicial + ", " + anoFinal + "]");
		}
		if ((anoInicial < this.menorAno && anoFinal < this.menorAno) || (anoInicial > this.maiorAno)) {
			throw new AnosForaDoIntervaloException("Anos fora do intervalo do ficheiro. [" + anoInicial + ", " + anoFinal + "]");
		}
		Autor aut;

		for (int i = anoInicial; i <= anoFinal; i++) {
			if (this.redeGlobalAutores.containsKey(i)) {
				if (this.redeGlobalAutores.get(i).getRedeAnualAutores().containsKey(listaAutores.get(0))) {
					aut = this.redeGlobalAutores.get(i).getRedeAnualAutores().get(listaAutores.get(0));
					for (CoAutor coaut : aut.getCoAutores().values()) {
						autor1.add(coaut.getNome());
					}
				}
				if (this.redeGlobalAutores.get(i).getRedeAnualAutores().containsKey(listaAutores.get(1))) {
					aut = this.redeGlobalAutores.get(i).getRedeAnualAutores().get(listaAutores.get(1));
					for (CoAutor coaut : aut.getCoAutores().values()) {
						autor2.add(coaut.getNome());
					}
				}
			}
		}

		for (String s : autor1) {
			if (autor2.contains(s)) {
				autores.add(s);
			}
		}
		
		if (listaAutores.size() == 3) {
			autor2.clear();
			for (int i = anoInicial; i <= anoFinal; i++) {
				if (this.redeGlobalAutores.get(i).getRedeAnualAutores().containsKey(listaAutores.get(2))) {
					aut = this.redeGlobalAutores.get(i).getRedeAnualAutores().get(listaAutores.get(2));
					for (CoAutor coaut : aut.getCoAutores().values()) {
						autor2.add(coaut.getNome());
					}
				}
			}
		}
		
		for (String s : autor2) {
			if (!autores.contains(s)) {
				autores.remove(s);
			}
		}
		return autores;
	}
	
	public Set<String> consulta21d(int anoInicial, int anoFinal) throws AnosForaDoIntervaloException, AnoInicialMaiorQueAnoFinalException, AnoInvalidoException {
		TreeSet<String> autores = new TreeSet<>();
		boolean add = true;

		if (anoInicial < 0 || anoFinal < 0) {
			throw new AnoInvalidoException("Ano inválido. [" + anoInicial + ", " + anoFinal + "]");
		}
		if (anoInicial > anoFinal) {
			throw new AnoInicialMaiorQueAnoFinalException("Ano inicial maior que ano final. [" + anoInicial + ", " + anoFinal + "]");
		}
		if ((anoInicial < this.menorAno && anoFinal < this.menorAno) || (anoInicial > this.maiorAno)) {
			throw new AnosForaDoIntervaloException("Anos fora do intervalo do ficheiro. [" + anoInicial + ", " + anoFinal + "]");
		}

		if (this.redeGlobalAutores.containsKey(anoInicial)) {

			for (Autor aut : this.redeGlobalAutores.get(anoInicial).getRedeAnualAutores().values()) {
				for (int i = anoInicial + 1; i <= anoFinal && add; i++) {
					if (!this.redeGlobalAutores.containsKey(i) || !this.redeGlobalAutores.get(i).getRedeAnualAutores().containsKey(aut.getNome())) {
						add = false;
					}
				}
				if (add) {
					autores.add(aut.getNome());
				} else {
					add = true;
				}
			}
		}

		return autores;
	}

	public int getLinhasDuplicado() {
		HashSet<String> linhas = new HashSet<>();
		int numLinhas = 0;
		Scanner fichScan;

		try {
			fichScan = new Scanner(new FileReader(this.ficheiroLido));
			fichScan.useDelimiter(System.getProperty("line.separator"));
			while (fichScan.hasNext()) {
				linhas.add(fichScan.next());
				numLinhas++;
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		return numLinhas - linhas.size();
	}

	public Set<String> consulta22b(char c) {
		TreeSet<String> autoresLetra = new TreeSet<>();
		for (RedeAnualAutores redeAnual : this.redeGlobalAutores.values()) {
			for (String nome : redeAnual.getRedeAnualAutores().keySet()) {
				if (nome.startsWith("" + c)) {
					autoresLetra.add(nome);
				}
			}
		}

		return autoresLetra;
	}

	public String consulta22c(String autor, int ano) throws AutorNotFoundException, AnoInvalidoException {
		RedeAnualAutores redeAnual;
		Autor aut;
		StringBuilder sb = new StringBuilder();
		if (this.redeGlobalAutores.containsKey(ano)) {
			redeAnual = this.redeGlobalAutores.get(ano).clone();
			if (redeAnual.getRedeAnualAutores().containsKey(autor)) {
				aut = redeAnual.getRedeAnualAutores().get(autor).clone();
				sb.append("Número de publicações com co-autores: ");
				sb.append(aut.getNumeroPubsCoAutores());
				sb.append("\n");
				for (CoAutor coAut : aut.getCoAutores().values()) {
					sb.append(coAut.getNome()).append(("\n"));
				}
			} else {
				throw new AutorNotFoundException("Autor não existente...");
			}
		} else {
			throw new AnoInvalidoException("Ano não existente no ficheiro...");
		}

		return sb.toString();
	}

	public Set<String> consulta22d(String autor) throws AutorNotFoundException {
		TreeSet<String> coAutores = new TreeSet<>();
		for (RedeAnualAutores redeAnual : this.getRedeGlobalAutores().values()) {
			if (redeAnual.getRedeAnualAutores().containsKey(autor)) {
				for (CoAutor coAut : redeAnual.getRedeAnualAutores().get(autor).getCoAutores().values()) {
					coAutores.add(coAut.getNome());
				}
			} else {
				throw new AutorNotFoundException("Autor não encontrado...");
			}
		}

		return coAutores;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("Rede de Autores: " + this.getFIcheiroLido());
		s.append("\nAnos: [").append(this.getMenorAno()).append(", ").append(this.getMaiorAno()).append("]");
		s.append("\nPublicações: ").append(this.getArtigosLidos());
		s.append("\nAutores lidos: ").append(this.getNomesLidos());
		s.append("\nAutores distintos: ").append(this.getNomesDistintos());
		for (RedeAnualAutores ano : this.redeGlobalAutores.values()) {
			s.append("\n\t").append(ano.toString()).append("\n");
		}
		return s.toString();
	}

}
