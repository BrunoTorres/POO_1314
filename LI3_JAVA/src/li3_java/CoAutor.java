/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package li3_java;

import java.io.Serializable;


/**
 * Write a description of class CoAutor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CoAutor implements Serializable
{
    private String nome;
    private int numeroPubsComAutor;

    public CoAutor(){
    	this.nome = "";
    	this.numeroPubsComAutor = 0;
    }

    public CoAutor(String nome){
    	this.nome = nome;
    	this.numeroPubsComAutor = 1;
    }

    public CoAutor(CoAutor coAut){
    	this.nome = coAut.getNome();
    	this.numeroPubsComAutor = coAut.getNumeroPubsComAutor();
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getNumeroPubsComAutor(){
        return this.numeroPubsComAutor;
    }

    public void adicionaPub(){
    	this.numeroPubsComAutor++;
    }

    public CoAutor clone(){
    	return new CoAutor(this);
    }
    
                     
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("\tNome do Co-Autor: " + this.getNome() + "\n" + "\tNúmero de publicações em comum: " + this.getNumeroPubsComAutor() + "\n");
        return s.toString();
    }   

}
