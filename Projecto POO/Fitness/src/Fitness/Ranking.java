package Fitness;

import java.io.Serializable;

/**
 *
 * @author Bruno
 */
public class Ranking implements Serializable
{

    public double time;
    public int km;
    public User athlete;
    
    /**
     * Construtor vazio.
     */
    public Ranking(){
        this.time=0;
        this.km=0;
        this.athlete=new User();
    }
    
    /**
     *
     * @param u - Utilizador.
     * @param time - Tempo registado em minutos.
     */
    public Ranking(User u,double time){
        this.athlete=u.clone();
        this.time=time;
        this.km=0;
    }
    
    /**
     * Construtor parametrizado.
     * @param u - Utilizador.
     * @param km - kilometro em que utilizador desistiu.
     */
    public Ranking(User u,int km){
        this.athlete=u.clone();
        this.km=km;
        this.time=0;
    }

    /**
     * Construtor de copia
     * @param r
     */
    public Ranking(Ranking r){
        this.athlete=r.getAthlete();
        this.km=r.getKm();
        this.time=r.getTime();
    }

    /**
     * @return the time
     */
    public double getTime() {
        return this.time;
    }

    /**
     * @return the km
     */
    public int getKm() {
        return this.km;
    }

    /**
     * @return the athlete
     */
    public User getAthlete() {
        return this.athlete.clone();
    }

    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * @param km the km to set
     */
    public void setKm(int km) {
        this.km = km;
    }
    
   
    
    //equals,toString,clone
    
    @Override
    public boolean equals(Object o){
        if(this==o)
            return true;
        if(o==null || this.getClass() != o.getClass())
            return false;
        Ranking r=(Ranking)o;
        return(this.athlete.equals(r.getAthlete()) && this.km==r.getKm() && this.time==r.getTime());       
    }
    
    public Ranking clone(){
        return new Ranking(this);
    }
    
    /**
     *
     * @return
     */
    public String toStringTime(){
        StringBuilder sb= new StringBuilder();
         int h,m;
         double s;
         h=(int)this.time/60;
         m=(int)this.time%60;
         
         s=this.time-((int)this.time);
         s=s*60;
         
        sb.append("Nome do atleta: ").append(this.athlete.getName()).append("\n");
        sb.append("\t Tempo: ").append(h).append("(h):");
        sb.append(m).append("(min): ");
        sb.append((int)s).append("(seg)\n");
        
        return sb.toString();
      
        
    }
    
    /**
     *
     * @return
     */
    public String toStringDesiste(){
        StringBuilder sb= new StringBuilder();
                
        sb.append("Nome do atleta: ").append(this.athlete.getName()).append("\n");
        sb.append("\t Desistiu ao km: ").append(this.km);
        return sb.toString();
      
        
    }
    
}
