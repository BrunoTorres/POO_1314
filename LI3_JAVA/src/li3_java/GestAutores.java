/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package li3_java;

/**
 *
 * @author jmano
 */

import static java.lang.System.out;
import java.util.Scanner;


public class GestAutores {
	
	public GestAutores(){}
	
	public String showMenu(RedeGlobalAutores redeGlobal){
		String op;
		Scanner ler = new Scanner(System.in);
		
		out.println("GESTÃO DE AUTORES:\n");
		out.println("1 - Dados referentes ao último ficheiro lido\n");
		out.println("2 - Estatísticas gerais respeitantes ao atual estado da aplicação\n");
		out.println("3 - Número de publicações em cada ano presente\n");
		out.println("12 - Gravar estado da aplicação para um ficheiro\n");
		out.println("13 - Carregar dados de um ficheiro\n");
		out.println("0 - Sair\n\n");
		
		op = ler.next();
		
		switch(op){
			case "1": out.println(redeGlobal.statsString());
				break;
			case "2": break;
			
			default: break;
		}
		
		return op;			
	}
	
	public void lerFicheiro(String fileName, RedeGlobalAutores redeGlobal){
		redeGlobal.leFicheiro(fileName);	
	}
	
	
	
}
