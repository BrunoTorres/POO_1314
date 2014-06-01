/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Fitness;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class Simulacao implements Serializable{
    
    public double tempoGeral;
    public double tempoMedio;
    public int kmDesiste;
    public User u;
    
    
    
    
    public Simulacao(){
        this.tempoGeral=0;
        this.tempoMedio=0;
        this.kmDesiste=0;
        this.u=new User();
    }
    public Simulacao(User user,double tempoMedio,int km){
        this.tempoGeral=0;
        this.tempoMedio=tempoMedio;
        this.kmDesiste=km;
        this.u=user.clone();
       
    }
       
    public Simulacao(Simulacao s){
        this.tempoGeral=s.getTempoGeral();
        this.tempoMedio=s.getTempoMedio();
        this.kmDesiste=s.getKmDesiste();
        this.u=s.getUser();
    }

    /**
     * @return the tempoGeral
     */
    public double getTempoGeral() {
        return tempoGeral;
    }

    /**
     * @return the tempoMedio
     */
    public double getTempoMedio() {
        return tempoMedio;
    }

    /**
     * @return the kmDesiste
     */
    public int getKmDesiste() {
        return kmDesiste;
    }

    /**
     * @return the u
     */
    public User getUser() {
        return u.clone();
    }
    
    public void actualiza(double intrevalo){
        double tempo=this.tempoMedio*(Math.random()+0.5);
        this.tempoGeral+=(intrevalo*tempo);
        
    }
    
    //toSting,equals,clone
    
    public Simulacao clone(){
        return new Simulacao(this);
    }
    
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null || this.getClass() != o.getClass())
            return false;
        Simulacao s=(Simulacao)o;
        return(this.kmDesiste==s.getKmDesiste()
                && this.tempoGeral==s.getTempoGeral()
                && this.tempoMedio==s.getTempoMedio()
                && this.u.equals(s.getUser()));
    } 
    
    public String toString(){
        StringBuilder sb= new StringBuilder();
        int h,m;
         double s;
         h=(int)this.tempoGeral/60;
         m=(int)this.tempoGeral%60;
         
         s=this.tempoGeral-((int)this.tempoGeral);
         s=s*60;
        sb.append("Nome: ").append(u.getName());
           
        sb.append(" || Tempo: ");
        if(h>0)
         sb.append(h).append("(h):");
        sb.append(m).append("(min): ");
        sb.append((int)s).append("(seg)\n");
        
        
        
        
        return sb.toString();
        
    }
   
}

