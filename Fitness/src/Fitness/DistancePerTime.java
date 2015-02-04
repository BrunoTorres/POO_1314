package Fitness;

import java.io.Serializable;

/**
 * Classe que define os recordes de distancia por tempo.
 * 
 * @author Bruno Pereiras
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public final class DistancePerTime extends Record implements Serializable{

    private double recordTime;
    private double distance;

    /**
     * Construtor vazio.
     */
    public DistancePerTime(){
        super();
        this.recordTime = 0.0;
        this.distance = 0.0;
    }

    /**
     * Construtor parametrizado.
     * @param name - Nome do recorde.
     * @param recordTime - Tempo do recorde em minutos.
     * @param distance - Distancia do recorde em km.
     * @param time - Tempo feito em minutos.
     */
    public DistancePerTime(String name, double recordTime,double distance,double time){
        super(name);
        this.recordTime = recordTime;
        this.distance=this.setStatistic(time, distance);     
    }

    /**
     * Construtor de cópia
     * @param stat - instância de DistancePerTime
     */
    public DistancePerTime(DistancePerTime stat){
        super(stat.getName());
        this.recordTime = stat.getRecordTime();
        this.distance = stat.getDistance();
    }

    /**
     * Método que devolve a distancia em km.
     * @return double,distancia.
     */
    public double getDistance(){
        return this.distance;
    }

    /**
     * Método que devolve o tempo recorde em minutos.
     * @return double,recorde.
     */
    public double getRecordTime(){
        return this.recordTime;
    }

    
    @Override
    public boolean isEmpty(){
        return (this.distance == 0.0);
    }

    /**
     * Método que altera a distancia, caso o parâmetro recebido seja maior que a distancia da instancia.
     * @param act-Instancia Record.
     */
    @Override
    public void update(Record act){
        DistancePerTime a=(DistancePerTime)act;
        if (this.distance < a.distance)
            this.distance=a.getDistance();
    }

    private double setStatistic(double time, double distance){
        double div=0;
        if(!(time < this.recordTime)) {
            div = this.recordTime / time;
            div = div * distance;
        }
        return div;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if(this.distance > 0){             
             sb.append("Distancia registada: ");
             sb.append((float)this.distance).append(" km \n");
        }
        else
            sb.append("Sem recorde").append("\n");
        return sb.toString();      
    }

    @Override
    public DistancePerTime clone(){
        return new DistancePerTime(this);
    }
}