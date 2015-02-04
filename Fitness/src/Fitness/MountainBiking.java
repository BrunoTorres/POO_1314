package Fitness;

import java.util.GregorianCalendar;
import java.io.Serializable;

/**
 * Actividade MountainBiking
 *
 * @author Bruno Pereira
 * @author João Mano
 * @author Miguel Guimarães
 * @version 2014
 */
public class MountainBiking extends Outdoor implements Distance, VerticalDistance, RecordsActivity, Serializable {

    private double distance;
    private double verticaldistance;
    private ListRecords recs;

    /**
     * Construtor vazio
     */
    public MountainBiking() {
        super();
        this.distance = 0;
        this.verticaldistance = 0;
        this.recs = new ListRecords();
    }

    /**
     * Construtor parametrizado.
     *
     * @param name - Nome da actividade.
     * @param date - Data da realização da actividade.
     * @param timeSpent - Tempo gasto em minutos.
     * @param distance - Distancia.
     * @param verticaldistance -Distancia vertical realizada na actividade.
     * @param weather - Clima.
     */
    public MountainBiking(String name, GregorianCalendar date, double timeSpent, double distance, double verticaldistance, String weather) {
        super(name, date, timeSpent, weather);
        this.distance = distance;
        this.verticaldistance = verticaldistance;
        this.recs = createRecord();
    }

    /**
     * Construtor de cópia.
     *
     * @param tb - instância de MountainBiking.
     */
    public MountainBiking(MountainBiking tb) {
        super(tb);
        this.distance = tb.getDistance();
        this.verticaldistance = tb.getVerticalDistance();
        this.recs = tb.getListRecords();
    }

    @Override
    public double getDistance() {
        return this.distance;
    }

    @Override
    public double getVerticalDistance() {
        return this.verticaldistance;
    }

    
    @Override
    public void setDistance(double distance) {
        this.distance = distance;
    }

   
    @Override
    public void setVerticalDistance(double verticaldistance) {
        this.verticaldistance = verticaldistance;
    }

    @Override
    public void setCalories(double peso) {
        double mets = 8.5;
        double calories = mets * peso * (this.getTimeSpent() / 60);
        this.setActivityCalories(calories);
    }

    @Override
    public ListRecords getListRecords() {
        return this.recs.clone();
    }

    private ListRecords createRecord() {
        ListRecords list = new ListRecords("Mountain Biking");

        Record recCooper = new DistancePerTime("One hour (km)", 60, this.distance, this.getTimeSpent());
        Record rec10miles = new TimePerDistance("10 miles", 16.09344, this.distance, this.getTimeSpent());
        Record rec3km = new TimePerDistance("20 km", 20, this.distance, this.getTimeSpent());
        Record rec10km = new TimePerDistance("50 km", 50, this.distance, this.getTimeSpent());
        Record rec50miles = new TimePerDistance("50 miles", 80.4672, this.distance, this.getTimeSpent());

        list.addRecord(recCooper);
        list.addRecord(rec10miles);
        list.addRecord(rec3km);
        list.addRecord(rec10km);
        list.addRecord(rec50miles);

        return list;
    }

     ////////////toString equals clone
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Distance horizontal").append("\n");
        sb.append(this.distance).append("\n");
        sb.append("Distance vertical").append("\n");
        sb.append(this.verticaldistance).append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) {
            return true;
        }
        if (a == null || this.getClass() != a.getClass()) {
            return false;
        }
        MountainBiking act = (MountainBiking) a;
        return (super.equals(act)
                && this.distance == act.getDistance()
                && this.verticaldistance == act.getVerticalDistance());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.distance) ^ (Double.doubleToLongBits(this.distance) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.verticaldistance) ^ (Double.doubleToLongBits(this.verticaldistance) >>> 32));
        return hash;
    }

    @Override
    public MountainBiking clone() {
        return new MountainBiking(this);
    }
}
